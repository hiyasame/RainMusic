package kim.bifrost.rain.rainmusic.view.fragment

import android.os.Bundle
import android.view.View
import kim.bifrost.rain.rainmusic.base.ui.BaseBindFragment
import kim.bifrost.rain.rainmusic.databinding.FragmentLoginPageBinding
import kim.bifrost.rain.rainmusic.view.viewmodel.LoginScreenState
import kim.bifrost.rain.rainmusic.view.viewmodel.LoginViewModel

/**
 * kim.bifrost.rain.rainmusic.view.fragment.LoginPageFragment
 * RainMusic
 *
 * @author 寒雨
 * @since 2022/3/28 11:43
 **/
class LoginPageFragment : BaseBindFragment<FragmentLoginPageBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            btnCancel.setOnClickListener {
                // 退出登录activity
                requireActivity().finish()
            }
            btnLoginNetease.setOnClickListener {
                LoginViewModel.loginState.value = LoginScreenState.NETEASE
            }
            btnLoginQq.setOnClickListener {
                LoginViewModel.loginState.value = LoginScreenState.QQ
            }
        }
    }
}