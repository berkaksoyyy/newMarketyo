package com.marketyo.platform.model.masterpass

//import cardtek.masterpass.results.ValidateTransaction3DResult
//import cardtek.masterpass.results.ValidateTransactionResult
import java.io.Serializable

class MasterPassResult : Serializable {

    var is3DPay: Boolean = false

//    var validateTransactionResult: ValidateTransactionResult? = null
//
//    var validateTransaction3DResult: ValidateTransaction3DResult? = null
}