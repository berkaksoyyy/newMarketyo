package com.marketyo.platform.repositories

import com.marketyo.platform.data.remote.LoginRemoteDataSource
import com.marketyo.platform.model.reponses.RestResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.marketyo.platform.model.Result
import com.marketyo.platform.model.request.LoginRequest
import kotlinx.coroutines.flow.flowOn

/**
 * Repository which fetches data from Remote or Local data sources
 */
class MovieRepository @Inject constructor(
    private val loginRemoteDataSource: LoginRemoteDataSource
) {

    suspend fun login(loginRequest: LoginRequest): Flow<Result<RestResult<String>>?> {
        return flow {
            emit(Result.loading())
            val result = loginRemoteDataSource.login(loginRequest)

            if (result.status == Result.Status.SUCCESS) {
                result.data?.data?.let {

                }
            }
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}