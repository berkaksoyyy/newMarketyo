package com.marketyo.platform.base.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseVM: ViewModel() {

    val loadingHUD = MutableLiveData<Boolean>()
    val checkForErrWarMes = MutableLiveData<String>()

}