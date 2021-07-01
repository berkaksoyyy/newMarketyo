package com.marketyo.platform.fragments.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.marketyo.platform.base.fragment.BaseFragment
import com.marketyo.platform.databinding.FragmentLoginBinding
import com.marketyo.platform.model.request.LoginRequest
import com.marketyo.platform.vm.LoginVM
import timber.log.Timber


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

        private val listingVM by viewModels<LoginVM>()
//    private val listingVM: LoginVM by activityViewModels()

    override fun initVMListener() {
        super.initVMListener()

        listingVM.movieList.observe(this, { result ->
            Timber.i(result)
        })

    }

    override fun initData() {
        super.initData()
        binding.tvLogin.setOnClickListener {
            listingVM.login(LoginRequest("5343238815", "berk123456"))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}