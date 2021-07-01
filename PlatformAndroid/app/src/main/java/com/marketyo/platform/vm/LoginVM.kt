package com.marketyo.platform.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.marketyo.platform.base.vm.BaseVM
import com.marketyo.platform.model.request.LoginRequest
import com.marketyo.platform.repositories.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect
import com.marketyo.platform.model.Result
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(private val movieRepository: MovieRepository) :
    BaseVM() {

    val movieList = MutableLiveData<String>()

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            movieRepository.login(loginRequest).collect {
                when (it?.status) {
                    Result.Status.SUCCESS -> {
                        it.data?.data?.let { list ->
                            movieList.value = list
                        }
                        loadingHUD.value = false
                    }

                    Result.Status.ERROR -> {
                        it.data?.errors?.let { errorList ->
                            checkForErrWarMes.value = errorList.firstOrNull() ?: ""
                        } ?: run {
                            it.data?.messages?.let { errorList ->
                                checkForErrWarMes.value = errorList.firstOrNull() ?: ""
                            }
                        }
                        loadingHUD.value = false
                    }

                    Result.Status.LOADING -> {
                        loadingHUD.value = true
                    }
                }

            }
        }
    }

}