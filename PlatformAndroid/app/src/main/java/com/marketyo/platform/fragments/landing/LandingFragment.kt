package com.marketyo.platform.fragments.landing

import android.os.Bundle
import androidx.navigation.findNavController
import com.marketyo.platform.R
import com.marketyo.platform.base.fragment.BaseFragment
import com.marketyo.platform.databinding.FragmentLandingBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LandingFragment : BaseFragment<FragmentLandingBinding>(FragmentLandingBinding::inflate) {

    override fun initData() {
        super.initData()
        binding.tvDeneme.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_landingFragment_to_loginFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LandingFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}