package kim.bifrost.rain.rainmusic.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.animation.AlphaAnimation
import androidx.lifecycle.lifecycleScope
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kim.bifrost.rain.rainmusic.R
import kim.bifrost.rain.rainmusic.base.ui.mvvm.BaseVmBindActivity
import kim.bifrost.rain.rainmusic.databinding.ActivityLoginBinding
import kim.bifrost.rain.rainmusic.utils.extensions.*
import kim.bifrost.rain.rainmusic.view.fragment.LoginPageFragment
import kim.bifrost.rain.rainmusic.view.viewmodel.LoginScreenState
import kim.bifrost.rain.rainmusic.view.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

class LoginActivity :
    BaseVmBindActivity<LoginViewModel, ActivityLoginBinding>(isCancelStatusBar = true) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(R.id.container_login) {
            LoginPageFragment()
        }
        binding.apply {
            // toolbar
            toolbarLogin.apply {
                setSupportActionBar(this)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
            // 验证码
            btnSendVerifyCode.setOnClickListener {
                val text = etPhone.text.toString()
                if (text.isEmpty()) {
                    return@setOnClickListener
                }
                lifecycleScope.launch {
                    if (viewModel.loginState.value == LoginScreenState.NETEASE) {
                        val data = viewModel.neteaseSendCaptcha(text)
                        MaterialAlertDialogBuilder(this@LoginActivity).apply {
                            if (data.data) {
                                setTitle("发送成功")
                                setMessage("您可能需要一段时间才能收到验证码，请耐心等待，切勿重复按下按钮")
                            } else {
                                setTitle("发送失败")
                                setMessage(data.message)
                            }
                            setPositiveButton("确认") { _, _ -> }
                            show()
                        }
                    }
                }
            }
            // 登录操作
            btnLogin.setOnClickListener {
                val phoneText = etPhone.text.toString()
                val password = etPassOrVerifyCode.text.toString()
                if (phoneText.isEmpty() || password.isEmpty()) {
                    return@setOnClickListener
                }
                lifecycleScope.launch {
                    if (viewModel.loginState.value == LoginScreenState.NETEASE) {
                        val res = if (radioPassword.isChecked) {
                            // 密码登录
                            viewModel.neteaseLogin(phoneText, pass = password)
                        } else {
                            // 验证码登录
                            viewModel.neteaseLogin(phoneText, captcha = password)
                        }
                        val success = res.code == 200
                        if (!success) {
                            MaterialAlertDialogBuilder(this@LoginActivity).apply {
                                setTitle("登录失败")
                                setMessage(res.message)
                                setPositiveButton("确认") { _, _ -> }
                                show()
                            }
                        } else {
                            "登录成功".toast()
                            finish()
                        }
                    }
                }
            }
        }

        viewModel.loginState.apply {
            value = LoginScreenState.START
            observeNotNull {
                when (it) {
                    LoginScreenState.START -> {
                        // 淡入动画
                        binding.containerLogin.apply {
                            visible()
                            startAnimation(
                                AlphaAnimation(0F, 1F).apply {
                                    duration = 400
                                }
                            )
                        }
                        clearInput()
                    }
                    else -> {
                        // 淡出动画
                        binding.containerLogin.apply {
                            startAnimation(
                                AlphaAnimation(1F, 0F).apply {
                                    duration = 400
                                    setOnEnd {
                                        gone()
                                    }
                                }
                            )
                        }
                        supportActionBar?.title =  if (it == LoginScreenState.QQ) "QQ音乐登录" else "网易云音乐登录"
                    }
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                viewModel.loginState.value = LoginScreenState.START
            }
        }
        return true
    }

    override fun onBackPressed() {
        var state: LoginScreenState by viewModel.loginState
        if (state != LoginScreenState.START) {
            state = LoginScreenState.START
        } else {
            finish()
        }
    }

    private fun clearInput() {
        binding.apply {
            etPassOrVerifyCode.setText("")
            etPhone.setText("")
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
}