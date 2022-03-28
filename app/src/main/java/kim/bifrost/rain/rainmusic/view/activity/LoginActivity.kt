package kim.bifrost.rain.rainmusic.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import kim.bifrost.rain.rainmusic.R
import kim.bifrost.rain.rainmusic.base.ui.mvvm.BaseVmBindActivity
import kim.bifrost.rain.rainmusic.databinding.ActivityLoginBinding
import kim.bifrost.rain.rainmusic.utils.extensions.gone
import kim.bifrost.rain.rainmusic.utils.extensions.setOnEnd
import kim.bifrost.rain.rainmusic.utils.extensions.visible
import kim.bifrost.rain.rainmusic.view.fragment.LoginPageFragment
import kim.bifrost.rain.rainmusic.view.viewmodel.LoginScreenState
import kim.bifrost.rain.rainmusic.view.viewmodel.LoginViewModel

class LoginActivity : BaseVmBindActivity<LoginViewModel, ActivityLoginBinding>(isCancelStatusBar = true) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragment(R.id.container_login) {
            LoginPageFragment()
        }
        LoginViewModel.loginState.apply {
            value = LoginScreenState.START
            observeNotNull {
                when (it) {
                    LoginScreenState.START -> {
                        // 淡入动画
                        binding.containerLogin.apply {
                            alpha = 0F
                            visible()
                            startAnimation(
                                AlphaAnimation(0F, 1F).apply {
                                    duration = 400
                                }
                            )
                        }
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
                    }
                }
            }
        }
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }
}