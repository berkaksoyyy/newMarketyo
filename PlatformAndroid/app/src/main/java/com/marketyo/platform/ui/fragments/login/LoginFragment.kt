package com.marketyo.platform.ui.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.marketyo.platform.base.fragment.BaseFragment
import com.marketyo.platform.databinding.FragmentLoginBinding
import com.marketyo.platform.model.request.LoginRequest
import com.marketyo.platform.vm.LoginVM
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class LoginFragment : BaseFragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val listingVM by viewModels<LoginVM>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

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