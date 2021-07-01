package com.marketyo.platform.model.user


class GlobalUser {
    companion object {
        @JvmStatic
        var user: UserInfo? = null

//        @JvmStatic
//        fun updateUserWS(
//            onUserFetched: ((UserInfo) -> Unit),
//            onFail: ((java.lang.Exception) -> Unit)?
//        ): Disposable {
//            return RxUtils.androidDefaults(App.getNetComponent().provideMarketyoCoreWS().getUserInfo())
//                .subscribe({ restResult ->
//                    if (restResult.isSuccess!!) {
//                        user = restResult.data
//                        onUserFetched(restResult.data)
//                    } else {
//                        onFail?.invoke(java.lang.Exception(restResult.errors.toString()))
//                    }
//                }, { e ->
//                    onFail?.invoke(e as? Exception ?: java.lang.Exception("Unknown Error"))
//                }
//                )
//        }
    }
}