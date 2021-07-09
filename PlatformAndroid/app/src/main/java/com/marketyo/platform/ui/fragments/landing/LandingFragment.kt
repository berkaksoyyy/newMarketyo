package com.marketyo.platform.ui.fragments.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.marketyo.platform.R
import com.marketyo.platform.base.fragment.BaseFragment
import com.marketyo.platform.databinding.FragmentLandingBinding
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@AndroidEntryPoint
class LandingFragment : BaseFragment() {

    private var _binding: FragmentLandingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentLandingBinding.inflate(inflater, container, false)
        return binding.root
    }

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