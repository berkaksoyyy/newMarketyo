package com.marketyo.platform.data.remote

import com.marketyo.platform.api.MarketyoCoreWS
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import com.marketyo.platform.model.Result
import com.marketyo.platform.model.reponses.RestResult
import com.marketyo.platform.model.request.LoginRequest
import com.marketyo.platform.utils.errorUtils.ErrorUtils
import timber.log.Timber

/**
 * fetches data from remote source
 */
class LoginRemoteDataSource @Inject constructor(private val retrofit: Retrofit) {

    suspend fun login(loginRequest: LoginRequest): Result<RestResult<String>> {
        val movieService = retrofit.create(MarketyoCoreWS::class.java);
        return getResponse(
            request = { movieService.login(loginRequest) },
            defaultErrorMessage = "Error fetching Movie list")

    }

    private suspend fun <T> getResponse(request: suspend () -> Response<T>, defaultErrorMessage: String): Result<T> {
        return try {
            Timber.e("WORKING_THREAD  -- ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return Result.success(result.body())
            } else {
                val errorResponse = ErrorUtils.parseError(result, retrofit)
                Result.error(errorResponse?.status_message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Timber.e(e)
            Result.error("Unknown Error", null)
        }
    }
}