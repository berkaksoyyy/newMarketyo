package com.marketyo.platform.model.product

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.marketyo.platform.model.Brand
import com.marketyo.platform.model.Category
import com.marketyo.platform.model.MagicLink
import com.marketyo.platform.utils.MathUtils

class Product {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("brand")
    var brand: Brand? = null
    @SerializedName("descriptionShort")
    var descriptionShort: String? = null
    @SerializedName(value = "description")
    var description: String? = null
    @SerializedName("category")
    var category: String? = null
    @SerializedName("categories")
    var categories: List<Category>? = null
    @SerializedName("price")
    var price: Float? = 0.0f
        get() {
            if (field == null) {
                this.price = 0.0f
            }
            return MathUtils.roundTo2Digits(field!!)
        }
    @SerializedName(value = "priceWithoutReduction", alternate = ["generalPrice"])
    var priceWithoutReduction: Float? = null
        get() {
            if (field == null) {
                this.priceWithoutReduction = 0.0f
            }
            return MathUtils.roundTo2Digits(field!!)
        }
    @SerializedName("weight")
    var weight: Float? = null
        get() {
            return if (field == null) 0.0f else MathUtils.roundTo1Digit(field!!)
        }
    @SerializedName("quantity")
    private var _quantity: Float? = 0.0f
    @SerializedName("img")
    var img: String? = null
    @SerializedName("images")
    var images: List<String>? = null
    @SerializedName("subTotal")
    var subTotal: Float? = 0.0f
    @SerializedName("subTotalWithoutDiscount")
    var subTotalWithoutDiscount: Float? = 0.0f
    @SerializedName("customerNote")
    var customerNote: String? = ""
        get() = if (field == null) "" else field
    @SerializedName("isKg")
    var isKg: Boolean? = false
    @SerializedName("idCartProduct")
    var idCartProduct: String? = null
    @SerializedName("initialAmount")
    var initialAmount: Float? = 0f
    @SerializedName("stepAmount")
    var stepAmount: Float? = 0f
    @SerializedName("minimumAmount")
    var minimumAmount: Float? = 0f
    @SerializedName("maximumAmount")
    var maximumAmount: Float? = 0f
    @SerializedName("isFav")
    var isFav: Boolean? = false
    @SerializedName("attributes")
    var attributes: List<ProductAttributes>? = null
//    @SerializedName("campaignDetails")
//    var campaignDetails: List<CampaignDiscountDetail>? = null
    @SerializedName("badges")
    var badges: List<Badge>? = null
    @SerializedName("applicableDiscounts")
    var applicableDiscounts: List<ApplicableDiscount>? = null
    @SerializedName("nutritionFacts")
    var nutritionFacts: List<Nutrition>? = null

    data class Badge(
        @SerializedName("colorCode")
        var colorCode: String?,
        @SerializedName("type")
        var type: String?,
        @SerializedName("value")
        var value: String?
    )

    data class ApplicableDiscount(
        @SerializedName("discountId")
        var discountId: String?,
        @SerializedName("label")
        var name: String?,
        @SerializedName("hasPromotion")
        var hasPromotion: Boolean?,
        @SerializedName("promotionId")
        var promotionId: String?
    )

    data class Nutrition(
        @SerializedName("name")
        var name: String?,
        @SerializedName("value")
        var value: String?
    )

    @Transient
    private var currentPriceTotal = 0f
    @Transient
    var magicLink: MagicLink? = null

    //    public float getPriceBeforeDiscountTotal() {
    //        return MathUtils.roundTo2Digits(getPrice() * getQuantity());
    //    }

    val currentAmount: Float
        get() = getQuantity()

    val isCampaignProduct: Boolean
        get() = badges?.firstOrNull { it.type == "DISCOUNT" } != null

    val hasBadge: Boolean
        get() = badges?.isNotEmpty() ?: false

    val badge: Badge?
        get() = badges?.first()

    /**
     * Has Campaign
     */
    val discountBadge: Badge?
        get() = badges?.firstOrNull { it.type == "DISCOUNT" }
    /**
     * Discount on the price (General PRICE)
     */
    val generalDiscountBadge: Badge?
        get() = badges?.firstOrNull { it.type == "GENERAL_DISCOUNT" }

    val discountPercent: String?
        get() = (priceWithoutReduction?.let { priceWithoutReduction ->
            price?.let { price ->
                priceWithoutReduction.minus(
                    price
                ).div(priceWithoutReduction)
            }
        })?.times(100)?.toInt()?.toString()

    constructor(
        id: String?,
        name: String,
        price: Float?,
        priceWithoutReduction: Float?,
        weight: Float?,
        quantity: Float?,
        img: String,
        isKg: Boolean?,
        descriptionShort: String
    ) {
        this.id = id
        this.name = name
        this.price = price
        this.priceWithoutReduction = priceWithoutReduction
        this.weight = weight
        this._quantity = quantity
        this.img = img
        this.isKg = isKg
        this.descriptionShort = descriptionShort
    }

    constructor()

    fun getQuantity(): Float {
        if (_quantity == null) {
            _quantity = 0.0f
        }
        return MathUtils.roundTo2Digits(_quantity!!)
    }

    fun setQuantity(quantity: Float?) {
        var quantity1 = quantity
        if (quantity1 == null) {
            quantity1 = 0.0f
        }
        _quantity = MathUtils.roundTo2Digits(quantity1)
    }

    private fun setInitialQuantity() {
        val initAmount = initialAmount!! // Onur: Forced crash if null
        setQuantity(initAmount)
    }

    fun increaseQuantity(): Float {
        if (getQuantity() == 0f) {
            setInitialQuantity()
        } else {
            val step = stepAmount!! // Onur: Forced crash if null, that's why i put !!
            setQuantity(getQuantity() + step)
            val max = getMaxAmount()
            if (max > 0f) {
                if (getQuantity() > max) {
                    setQuantity(max)
                }
            }
        }
        return getQuantity()
    }

    fun decreaseQuantity(): Float {
        val step = stepAmount!! // Onur: Forced crash if null
        setQuantity(getQuantity() - step)
        val minAmount = getMinAmount()
        if (getQuantity() < minAmount) {
            setQuantity(0f)
        }
        return getQuantity()
    }

    fun getMinAmount(): Float {
        return minimumAmount!! // Onur: Forced crash if null
    }

    fun getMaxAmount(): Float {
        return maximumAmount ?: 0.0f
    }

    fun getCoverImage(): String {
        return if (this.images?.isEmpty() == true) "" else images?.get(0) ?: ""
    }

    fun getSlideImages(): List<String> {
        return images ?: emptyList()
    }

    fun getSlideImagesArray(): Array<String> {
        return images?.toTypedArray() ?: emptyArray()
    }

    fun getCurrentPriceTotal(): Float {
        currentPriceTotal = MathUtils.roundTo2Digits(price!! * getQuantity())
        return currentPriceTotal
    }

    fun getCartProductInfos(cartProduct: Product) {
        _quantity = cartProduct.getQuantity()
        weight = cartProduct.getQuantity()
        currentPriceTotal = getCurrentPriceTotal()
        idCartProduct = cartProduct.idCartProduct
        this.priceWithoutReduction = cartProduct.priceWithoutReduction
        this.price = cartProduct.price
    }

    fun toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    companion object {

        @JvmStatic
        fun totalProductsCurrentPrice(productList: List<Product>): Float {
            var total = 0f
            for (product in productList)
                total += product.getCurrentPriceTotal()
            return MathUtils.roundTo2Digits(total)
        }

        @JvmStatic
        fun cartContainesProduct(cartProducts: List<Product>, product: Product): Product? {
            val currentProductId = product.id!!
            for (cartProduct in cartProducts) {
                if (cartProduct.id == currentProductId) {
                    product.getCartProductInfos(cartProduct)
                    return product
                }
            }
            return null
        }

        @JvmStatic
        private fun findProduct(products: List<Product>, productId: String): Int {
            if (productId == "0") return -1
            for ((index, product) in products.withIndex()) {
                if (product.id == productId)
                    return index
            }
            return -1
        }

        @JvmStatic
        fun matchProductQuantity(product: Product, cartProducts: List<Product>?) {
            if (cartProducts != null) {
                for (prod in cartProducts) {
                    if (prod.id == product.id) {
                        product.getCartProductInfos(prod)
                        break
                    }
                }
            }
        }

        @JvmStatic
        fun matchProductFavorites(product: Product, favProducts: List<Product>?) {
            if (favProducts != null) {
                for (prod in favProducts) {
                    if (prod.id == product.id) {
                        product.isFav = true
                        return
                    }
                }
            }
            product.isFav = false
        }

        @JvmStatic
        fun findProduct(products: List<Product>, product: Product?): Int {
            return if (product?.id == null) -1 else findProduct(products, product.id!!)
        }

        @JvmStatic
        fun matchWithCartProducts(
            cartProducts: List<Product>?,
            products: List<Product>
        ): List<Product> {
            try {

                if (cartProducts == null || cartProducts.isEmpty())
                    return products
                for (product in products) {
                    val currentProductId = product.id!!
                    for (cartProduct in cartProducts) {
                        if (cartProduct.id == currentProductId) {
                            product.getCartProductInfos(cartProduct)
                            break
                        }
                    }
                }
                return products

            } catch (e: Exception){
                return products
            }
        }

        @JvmStatic
        fun matchWithFavProducts(
            favProducts: List<Product>?,
            products: List<Product>
        ): List<Product> {
            if (favProducts == null || favProducts.isEmpty())
                return products
            for (product in products) {
                val currentProductId = product.id!!
                for (favProduct in favProducts) {
                    if (favProduct.id == currentProductId) {
                        product.isFav = true
                        break
                    }

                }
            }
            return products
        }

        @JvmStatic
        fun copyProduct(toBeCopied: Product): Product {
            return fromJson(toBeCopied.toJson())
        }

        @JvmStatic
        fun fromJson(json: String): Product {
            val gson = Gson()
            return gson.fromJson(json, Product::class.java)
        }
    }
}
