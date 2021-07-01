package com.marketyo.platform.model.payment

//import cardtek.masterpass.results.GetCardsResult
import com.google.gson.annotations.SerializedName
data class PaymentProvider(
    @SerializedName("id") val id: String? = null,
    @SerializedName("type") val type: Int,
    @SerializedName("name") val name: String? = null,
    @SerializedName("shortDescription") val shortDescription: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("logo") val logo: String? = null,
    @SerializedName("priority") val priority: Int? = 0,
    @Transient var isSelected: Boolean = false,
    @Transient var mpState: Int = 0,
    @Transient var isUpdate: Boolean = false,
    @Transient var isUpdateError: Boolean = false,
//    @Transient var getCardsResult: GetCardsResult? = null,
    @Transient var isShake: Boolean = false){
//) : BaseRadioAdapter.RadioAdapterItem {
//    override fun getText(): String {
//        return name ?: ""
//    }
//
//    override fun getProviderType(): Int {
//        return type
//    }

    val isMasterPass: Boolean
        get() = type == TYPE_MP

    companion object {
        @JvmField
        val TYPE_CREDIT_CARD_MARKETYO_PAY = 6
        @JvmField
        val TYPE_CREDIT_CARD = 2
        @JvmField
        val TYPE_COD = 1
        @JvmField
        val TYPE_MP = 4

        @JvmStatic
        fun isOnlinePayment(type: Int): Boolean {
            return type == 2
        }

        @JvmStatic
        fun getMPItem(providers: List<PaymentProvider>): PaymentProvider?{
            providers.forEach {
                if(it.type == TYPE_MP){
                    return it
                }
            }
            return null
        }

        @JvmStatic
        fun isSupportedType(type: Int): Boolean {
            return type == TYPE_COD || type == TYPE_CREDIT_CARD || type == TYPE_CREDIT_CARD_MARKETYO_PAY /*||type == TYPE_MP*/
        }
        @JvmStatic
        fun isSupportedType(pprovider: PaymentProvider): Boolean {
            return isSupportedType(pprovider.type ?: -1)
        }
        @JvmStatic
        fun hasMasterpass(providers: List<PaymentProvider>): Boolean {
            providers.forEach {
                if(it.type == TYPE_MP){
                    return true
                }
            }
            return false
        }
    }
}