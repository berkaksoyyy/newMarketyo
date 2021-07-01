package com.marketyo.platform.api


import com.marketyo.platform.model.reponses.RestResult
import com.marketyo.platform.model.request.LoginRequest
import retrofit2.http.*
import retrofit2.Response


interface MarketyoCoreWS {

    // region ACCOUNT
    @POST("Account/Login")
    fun login(@Body loginRequest: LoginRequest): Response<RestResult<String>>
//
//    @GET("Account")
//    fun getUserInfo(): Observable<RestResult<UserInfo>>
//
//    @POST("Account")
//    fun createUser(@Body user: User): Observable<RestResult<String>>
//
//    @PUT("Account")
//    fun updateUser(@Body user: User): Observable<RestResult<String>>
//
//    @PUT("Account/UpdatePassword")
//    fun updateUserPassword(@Body user: User): Observable<RestResult<String>>
//
//    @POST("Account/RequestVerificationCode")
//    fun requestVerificationCode(@Body user: User): Observable<RestResult<String>>
//
//    @POST("Account/VerifyPhoneConfirmation")
//    fun verifyPhoneConfirmation(@Body verificationCode: PhoneVerificationRequest): Observable<RestResult<String>>
//
//    @PUT("Account/UpdatePhoneNumber")
//    fun updatePhoneNumber(@Body upnRequest: UpdatePhoneNumberRequest): Observable<RestResult<UserInfo>>
//
//    @POST("Account/RequestForgotPasswordCode")
//    fun requestForgotPasswordCode(@Body forgotMyPasswordRequest: ForgotMyPasswordRequest): Observable<RestResult<String>>
//
//    @POST("Account/RequestResetPassword")
//    fun requestResetPassword(@Body forgotMyPasswordRequest: ForgotMyPasswordRequest): Observable<RestResult<String>>
//    // endregion
//
//    // region Shop
//
//    @GET("Shops/GetDeliveryTimeSlotsByGeoName/{geoId}")
//    fun getAvailableDeliveryTimeByGeoId(
//        @Path("geoId") geoId: String,
//        @Query(value = "dateTime", encoded = true) date: String/*2017-03-02*/
//    ): Observable<RestResult<List<Timeslot>>>
//
//    @GET("Shops/Configuration")
//    fun getShopConfiguration(): Observable<RestResult<ShopConfiguration>>
//
//    @GET("Shops/Register")
//    fun registerShops(): Observable<RestResult<String>>
//
//    @GET("Shops/Carriers")
//    fun getCarriers(): Observable<RestResult<List<Carrier>>>
//
//    @GET("Shops/DeliveryTimeSlots")
//    fun getAvailableDeliveryTime(
//        @Query("carrierId") carrierId: String,
//        @Query(value = "dateTime", encoded = true) date: String/*2017-03-02*/,
//        @Query("deliveryAddressId") deliveryAddressId: String
//    ): Observable<RestResult<List<Timeslot>>>
//
//    @GET("Shops/PaymentMethods")
//    fun paymentMethods(): Observable<RestResult<List<PaymentMethod>>>
//
//    @GET("Shops/PaymentProviders")
//    fun paymentProviders(): Observable<RestResult<PaymentData>>
//
//    @GET("Shops/Exist")
//    fun shopExists(): Observable<RestResult<Boolean>>
//    // endregion
//
//    // region ADDRESS
//    @DELETE("Addresses/{id}")
//    fun deleteAddress(@Path("id") id: String): Observable<RestResult<Boolean>>
//
//    @POST("Addresses")
//    fun createAddress(@Body address: CAddress): Observable<RestResult<CAddress>>
//
//    @PUT("Addresses/{id}")
//    fun saveAddress(@Path("id") id: String, @Body address: CAddress): Observable<RestResult<CAddress>>
//
//    @GET("Addresses")
//    fun getUserAddresses(@Query("shopId") shopId: String? = ""): Observable<RestResult<List<CAddress>>>
//
////    @GET("Addresses")
////    fun getUserAddresses(@Query("shopId") shopId: String = ""): Observable<RestResult<List<CAddress>>>
//
//    @GET("Addresses/{id}")
//    fun getSingleAddress(@Path("id") id: String): @NotNull Observable<RestResult<CAddress>>
//    // endregion
//
//    // region Application
//    @GET("App/ClientAddresses")
//    fun getClientAddresses(@Query("shopId") shopId: String?, @Query("geoId") geoId: String?): Observable<RestResult<List<CPlace>>>
//
//    @POST("App/ResolveShop")
//    fun getShopId(@Query("geoId") placeId: String): Observable<RestResult<String>>
//
//    @GET("App/ShopTypes")
//    fun ShopCategories(): Observable<RestResult<List<ShopCategory>>>
//
//    @GET("App/Shops")
//    fun getShops(@Query("geoNameId") geoNameId: String): Observable<RestResult<List<Shop>>>
//
//    @GET("App/Ad")
//    fun allAds(
//        @Query("platform") platform: Int = AdsEnum.Platform.Mobile
//    ): Observable<RestResult<AdsModel>>
//
//    @GET("App/Ads")
//    fun Ads(
//            @Query("platform") platform: Int = AdsEnum.Platform.Mobile, @Query("page") page: Int,
//            @Query("key") key: String
//    ): Observable<RestResult<AdsModel>>
//
//    @GET("App/Configuration")
//    fun getAppConfiguration(): Observable<RestResult<AppConfiguration>>
//
//    @GET("App/ContactInfo")
//    fun contactInfo(): Observable<RestResult<ContactInfo>>
//
//    @POST("App/RegisterDevice")
//    fun RegisterDevice(@Body registerUserDevice: RegisterUserDevice): Observable<RestResult<Boolean>>
//
//    @GET("App/RegistrationRules")
//    fun PolicyRegistrationRules(): Observable<RestResult<String>>
//
//    @GET("App/ServiceAgreement")
//    fun PolicyServiceAgreement(): Observable<RestResult<String>>
//
//    @GET("App/PersonalDataProtectionPolicy")
//    fun clarificationText(): Observable<RestResult<String>>
//
//    @GET("App/TermsOfUse")
//    fun policyTermsOfUse(): Observable<RestResult<String>>
//
//    @GET("App/ClearConsentText")
//    fun consentText(): Observable<RestResult<String>>
//
//    @GET("App/EtkContract")
//    fun campaignText(): Observable<RestResult<String>>
//
//
//    @GET("App/PrivacyAgreement")
//    fun policyPrivacyAgreement(): Observable<RestResult<String>>
//
//    @GET("App/PersonalDataProtectionPolicy")
//    fun policyPersonalDataProtection(): Observable<RestResult<String>>
//
//    @GET("App/FrequentlyAskedQuestions")
//    fun PolicyFaq(): Observable<RestResult<String>>
//
//    @GET("App/GeneralRules")
//    fun PolicyGeneralRules(): Observable<RestResult<String>>
//
//    @GET("App/SupportEmail")
//    fun PolicySupportEmail(): Observable<RestResult<String>>
//
//    @GET("App/SupportHeadlines")
//    fun SupportHeadlines(): Observable<RestResult<List<SupportHeadline>>>
//
//    @POST("App/SupportMessage")
//    fun SendSupportMessage(@Body supportMessage: SupportMessage): Observable<RestResult<Boolean>>
//    // endregion
//
//    // region CART
//    @GET("Cart")
//    fun getUserCart(): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateCarrier")
//    fun updateCarrier(@Query("carrierId") idCarrier: String?): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdatePaymentMethod")
//    fun UpdatePaymentMethod(@Query("paymentMethodId") paymentMethodId: String): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateDeliveryAddress")
//    fun UpdateDeliveryAddress(@Query("addressId") addressId: String): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateInvoiceAddress")
//    fun UpdateInvoiceAddress(@Query("addressId") addressId: String): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateDeliveryTimeSlot") // date=07-03-2017&id_time_slot=2
//    fun updateDeliveryTimeSlot(@Query("deliveryTimeSlotId") timeSlotId: String): Observable<RestResult<UserCart>>
//
//    @GET("checkout")
//    fun getDiscount(): Observable<RestResult<Checkout>>
//
//    @PUT("Cart/UpdateDeliveryAndInvoiceAddress")
//    fun updateDeliverInvoiceAddresses(
//        @Query("deliveryAddressId") deliveryAddressId: String,
//        @Query("invoiceAddressId") invoiceAddressId: String
//    ): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateBagCount")
//    fun UpdateBagCount(@Query("bagCount") bagCount: Int): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateProduct")
//    fun UpdateProduct(@Body updateProductRequest: UpdateProductRequest): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateCartNote")
//    fun UpdateCartMessage(@Body message: CartMessageRequest): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateProductNote")
//    fun updateProductNote(@Body productNoteRequest: JetProductNoteRequest): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/UpdateDeliveryTime")
//    fun UpdateDeliveryTime(@Body deliveryTimeRequest: DeliveryTimeRequest): Observable<RestResult<UserCart>>
//
//    @POST("Cart/Complete")
//    fun OrderComplete(): Observable<RestResult<Boolean>>
//
//    @PUT("Cart/Clear")
//    fun clearCart(): Observable<RestResult<UserCart>>
//
//    @GET("Loyalties/Coupons/Progress")
//    fun getLoyaltyCoupons(): Observable<RestResult<MutableList<LoyaltyCoupons>>>
//
//    @GET("Cart/PreliminaryInformationForm")
//    fun PreliminaryInformationForm(): Observable<RestResult<String>>
//
//    @GET("Cart/OnlineSellingContract")
//    fun OnlineSellingContract(): Observable<RestResult<String>>
//
//    // endregion
//
//    // region CATEGORY
//    @GET("Categories")
//    fun GetCategories(): Observable<RestResult<List<Category>>>
//
//    @GET("Categories/Tags?tag=campaign")
//    fun GetCampaigns(): Observable<RestResult<List<Category>>>
//
//    @GET("Promotions")
//    fun getPromotions(): Observable<RestResult<List<Promotion>>>
//
//    @GET("Opportunities/ad")
//    fun getGlobalOppurtuniesAds(@Query("geoNameId") geoId: String): Observable<RestResult<AdsModel>>
//
//    @GET("Opportunities/promotions")
//    fun getGlobalOppurtuniesPromotions(@Query("geoNameId") geoId: String): Observable<RestResultArr<GlobalPromotions>>
//
//    @GET("Promotions/{id}")
//    fun getPromotionDetails(@Path("id") promotionId: String): Observable<RestResult<Promotion>>
//
//    @GET("Promotions/{id}/Products")
//    fun getPromotionProducts(@Path("id") promotionId: String): Observable<RestResult<List<Product>>>
//    // endregion
//
//    //region Masterpass
//
//    @GET("MPPayment/Token")
//    fun getMPToken(@Query("process") process: Int): Observable<RestResult<MPToken>>
//
//    @GET("MPPayment/Config")
//    fun getMPConfig(): Observable<RestResult<MPConfig>>
//
//    @POST("MPPayment/CommitPurchase")
//    fun commitMPPurchase(@Query("orderId") orderId: String, @Body mpTokenResponse: MPTokenResponse): Observable<RestResult<MPToken>>
//
//    //endregion
//
//    // region Favorite
//    @POST("Favourites")
//    fun addToFavorite(@Query("productId") productId: String): Observable<RestResult<Boolean>>
//
//    @DELETE("Favourites")
//    fun deleteFromFavorite(@Query("productId") productId: String): Observable<RestResult<Boolean>>
//
//    @GET("Favourites")
//    fun getFavorite(): Observable<RestResult<List<Product>>>
//    // endregion
//
//    // region Products
//    @GET("Products")
//    fun GetProducts(@Query("categoryId") categoryId: String): Observable<RestResult<List<Product>>>
//
//    @GET("Products/{id}")
//    fun GetProductDetails(@Path("id") productId: String): Observable<RestResult<Product>>
//
//    @GET("Products/BestSellers")
//    fun GetBestSellerProducts(@Query("categoryId") categoryId: String? = null, @Query("timeInterval") timeInterval: String): Observable<RestResult<List<Product>>>
//
//    @POST("Products/Search")
//    fun Search(@Body searchRequest: SearchRequest): Observable<RestResult<CoreSearchResponse>>
//
//    @POST("search/global")
//    fun globalSearch(@Query("geoNameId") geoId: String, @Body searchRequest: SearchRequest): Observable<RestResultArr<GlobalCoreSearchResponse>>
//
//    @GET("Products/RelatedProducts")
//    fun relatedProducts(@Query("productId") productId: String): Observable<RestResult<List<Product>>>
//
//    @GET("Products/Discounted")
//    fun discountedProducts(): Observable<RestResult<List<Product>>>
//    // endregion
//
//    // region Orders
//    @GET("Orders")
//    fun getUserOrders(): Observable<RestResult<List<Order>>>
//
//    @GET("Orders/{id}")
//    fun getOrderDetails(@Path("id") id: String): Observable<RestResult<OrderDetails>>
//
//    @POST("Orders/{id}/Cancel")
//    fun cancelOrder(@Path("id") id: String,@Body cancelOrderRequest: OrderCancelRequest): Observable<RestResult<Order>>
//    // endregion
//
//    // region Payment
//
//    @POST("CoDPayment/CreateOrder")
//    fun CreateOrder(): Observable<RestResult<PaymentResult>>
//
//    @POST("CCPayment/PayWithThreeD")
//    fun PayWithThreeD(@Body creditCard: CreditCard): @NotNull Observable<RestResult<PaymentResult>>
//
//    @POST("MarketyoPayment/PayWithMarketyo")
//    fun PayWithMarketyoPay(@Body creditCard: CreditCard): @NotNull Observable<RestResult<PaymentResult>>
//
//    @POST("CCPayment/ThreeDCallback")
//    fun ThreeDCallBack()
//
//    @GET("CCPayment/ThreeDSuccess")
//    fun ThreeDSuccess()
//
//    @GET("CCPayment/ThreeDFail")
//    fun ThreeDFail()
//
//    // endregion
//
//    // region MealRecipes
//
//    @GET("MealRecipes")
//    fun MealRecipes(): Observable<RestResult<List<RecipeNew>>>
//
//    @GET("MealRecipes/{id}")
//    fun SingleMealRecipe(@Path("id") id: String): Observable<RestResult<RecipeNew>>
//
//    // endregion
//
//    @GET("App/Sliders")
//    fun Sliders(): Observable<RestResult<List<SliderItem>>>
//
//    @GET("Coupons")
//    fun getCoupons(): Observable<RestResult<List<CouponItem>>>
//
//    @GET("Coupons/UserCoupons")
//    fun getUserCoupons(): Observable<RestResult<List<CouponItem>>>
//
//    @POST("Coupons")
//    fun setCouponCode(@Query("couponCode") couponCode: String): Observable<RestResult<List<CouponItem>>>
//
//    @PUT("Cart/ApplyCoupon")
//    fun applyCoupon(@Query("couponId") couponId: String): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/ApplySubTotalDiscount")
//    fun applySubTotalDiscount(@Query("discountId") discountId: String): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/RevokeCoupon")
//    fun revokeCoupon(@Query("couponId") couponId: String): Observable<RestResult<UserCart>>
//
//    @PUT("Cart/RevokeSubTotalDiscount")
//    fun revokeSubTotalDiscount(@Query("discountId") discountId: String): Observable<RestResult<UserCart>>
//
//    //region new timeslot
//    @GET("Shops/AvailableTimeSlots")
//    fun getAvailableTimeSlots(@Query("carrierId") carrierId: String,@Query("deliveryAddressId") deliveryAddressId: String): Observable<RestResult<List<NewTimeslot>>>
//
//    @GET("Shops/AvailableTimeSlotsByGeoName/{geoNameId}")
//    fun getAvailableTimeSlotsByGeoName(@Path("geoNameId") geoNameId: String,@Query("carrierId") carrierId: String): Observable<RestResult<List<NewTimeslot>>>
//
//    @GET("Shops/AvailableTimeSlotsByOrder")
//    fun getAvailableTimeSlotsByOrder(@Query("orderId") orderId: String): Observable<RestResult<List<NewTimeslot>>>
//    //endregion
//
//    //region pickup
//    @GET("Shops/PickLocations")
//    fun getPickLocations(@Query("carrierId") carrierId: String,@Query("deliveryAddressId") deliveryAddressId: String): Observable<RestResult<List<PickUp>>>
//
//    @PUT("Cart/UpdatePickLocation")
//    fun updatePickLocation(@Query("pickLocationId") pickLocationId: String): Observable<RestResult<UserCart>>
//
//    //endregion
//
//    @GET("App/ClearConsentText")
//    fun clearConsentText(): Observable<RestResult<String>>
//
//    @POST("Orders/{id}/UpdateDeliveryTimeSlot")
//    fun updateTimeslotWithOrderId(@Path("id") id: String , @Query("deliveryTimeSlotId") deliveryTimeSlotId: String): Observable<RestResult<OrderDetails>>
//
//    @GET("App/SearchTags")
//    fun getSearchTags(): Observable<RestResult<List<String>>>
//
//    @GET("App/GeoNames")
//    fun getGeoNames( @Query("geoId") geoId: String?): Observable<RestResult<List<CPlace>>>
//
//    @PUT("Cart/UpdateAlternativeProductPreference")
//    fun updateAlternativeProductPreference(@Query("alternativeProductPreference") alternativeProductPreference: Int?): Observable<RestResult<UserCart>>
//
//    @POST("Orders/{id}/OrderRating")
//    fun setOrderRating(@Path("id") id: String, @Body orderRatings: List<OrderRatingsRequest?>): Observable<RestResult<Boolean>>
//
//    @GET("Orders/{id}/OrderRating")
//    fun getOrderRating(@Path("id") id: String): Observable<RestResult<List<OrderRatingsObj>>>
//
//    @PUT("Account/UpdateCommunicationPreferences")
//    fun updateCommunicationPreferences(@Body userIysUpdateRequest: UserPreferences): Observable<RestResult<UserInfo>>
//
//    @POST("Account/UpdateContractConfirmation")
//    fun updateContractInfo(@Body contractConfirmationRequest: UpdateContractObj): Observable<RestResult<String>>
//
//    @GET("App/Highlights")
//    fun getUserOrderInfo(): Observable<RestResult<UserOrdersInfo>>
//
//    @POST("Orders/{id}/OrderScore")
//    fun updateOrderRating(@Path("id") id: String, @Body orderRatingRequest: OrderScoreObj): Observable<RestResult<Boolean>>
//    @GET("MasterCatalog/Products/{id}")
//    fun getMCProductBrief(@Path("id") id: String): Observable<RestResult<MCProduct>>
//
//    @GET("Products/MasterCatalog/{id}")
//    fun getMCProduct(@Path("id") id: String): Observable<RestResult<Product>>

}
