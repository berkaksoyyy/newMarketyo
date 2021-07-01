package com.marketyo.platform.base.fragment


import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.BoolRes
import androidx.annotation.CallSuper
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.marketyo.platform.base.activity.BaseActivity

/**
 * Createdby MBH on 20/01/2017.
 */

abstract class BaseFragment<VB : ViewBinding>(val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> VB) :
    Fragment() {
    private var mHandler: Handler? = null

    private var _binding: VB? = null
    val binding get() = _binding!!

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHandler = Handler()
    }

    protected fun postDelayed(
        milliSeconds: Long,
        runnable: () -> Unit
    ) {
        mHandler!!.postDelayed(runnable, milliSeconds)
    }

    protected fun postDelayed(
        milliSeconds: Long,
        runnable: Runnable
    ) {
        mHandler!!.postDelayed(runnable, milliSeconds)
    }


    protected fun hasButterKnife(): Boolean {
        return false
    }

    protected fun post(runnable: Runnable) {
        mHandler!!.post(runnable)
    }

    protected fun runOnUI(runnable: Runnable) {
        post(runnable)
    }


    // @LayoutRes
    // protected abstract fun layoutID(): Int

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingFactory.invoke(inflater, container, false)
        return binding.root
        /*return inflater.inflate(layoutID(), container, false)*/
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initChangeFont()
        initReq()
        initVMListener()
        initChangeUI()
        initData()
    }

    @CallSuper
    protected open fun initChangeFont(){}

    @CallSuper
    protected open fun initReq(){}

    @CallSuper
    protected open fun initVMListener(){}

    @CallSuper
    protected open fun initChangeUI(){}

    @CallSuper
    protected open fun initData(){}

    private fun startActivityOnTop(
        cls: Class<*>,
        extra: Bundle?
    ) {
        val intent = Intent(requireContext(), cls)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        if (extra != null) intent.putExtras(extra)
        startActivity(intent)
    }

    private fun startActivityNormal(
        cls: Class<*>,
        extra: Bundle?
    ) {
        val intent = Intent(requireContext(), cls)
        if (extra != null) intent.putExtras(extra)
        startActivity(intent)
    }

    protected val compatActivity: AppCompatActivity?
        protected get() = if (activity is AppCompatActivity) {
            requireActivity() as AppCompatActivity?
        } else null

    protected val baseActivity: BaseActivity<VB>?
        protected get() = if (activity is BaseActivity<*>) {
            requireActivity() as BaseActivity<VB>?
        } else null

    fun getBoolById(@BoolRes boolResId: Int, defaultValue: Boolean): Boolean {
        return try {
            resources.getBoolean(boolResId)
        } catch (e: Resources.NotFoundException) {
            defaultValue
        }
    }

    fun getColorById(colorId: Int): Int {
        return ContextCompat.getColor(requireContext(), colorId)
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected fun shortToast(text: String?) {
        toast(text, Toast.LENGTH_SHORT)
    }

    protected fun shortToast(@StringRes text: Int) {
        toast(text, Toast.LENGTH_SHORT)
    }

    protected fun longToast(text: String?) {
        toast(text, Toast.LENGTH_LONG)
    }

    protected fun longToast(@StringRes text: Int) {
        toast(text, Toast.LENGTH_LONG)
    }

    protected fun toast(@StringRes text: Int) {
        toast(getString(text))
    }

    protected fun toast(@StringRes text: Int, duration: Int) {
        toast(getString(text), duration)
    }

    protected fun toast(
        text: String?,
        duration: Int = Toast.LENGTH_LONG
    ) {
        Toast.makeText(requireContext(), text, duration).show()
    }
}