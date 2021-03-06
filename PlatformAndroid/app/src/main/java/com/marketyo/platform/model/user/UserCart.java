/**
 * Marketyo Mobile Api
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 * <p>
 * OpenAPI spec version: 1.0.0
 * <p>
 * <p>
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.marketyo.platform.model.user;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.marketyo.platform.model.coupon.AppliedCoupon;
import com.marketyo.platform.model.product.Product;
import com.marketyo.platform.model.request.cart.Cart;
import com.marketyo.platform.model.user.SelectedDiscounts;
import com.marketyo.platform.model.MagicLink;
import com.marketyo.platform.model.core.c.CampaignDetail;
import com.marketyo.platform.model.order.ApplicableDiscount;

import java.util.ArrayList;
import java.util.List;

public class UserCart {

    @SerializedName("cart")
    private Cart cart = null;
    @SerializedName("totalRulesDiscount")
    private Float totalRulesDiscount = 0f;
    @SerializedName("totalFinalDiscount")
    private Float totalFinalDiscount = 0f;
    @SerializedName(value = "MinOrderLimit", alternate = {"minOrderLimit"})
    private Float minOrderLimit = 50f;
    @SerializedName("shippingTotal")
    private Float shippingFee = 0f;
    @SerializedName("freeShippingLimit")
    private Float freeShippingLimit = 100f;
    @SerializedName("shippingTotalWithoutDiscount")
    private Float shippingFeeWithoutDiscount = 0f;
    @SerializedName("productTotalWithoutDiscount")
    private Float productTotalWithoutDiscount = 0f;
    @SerializedName("products")
    private List<Product> products = null;
    @SerializedName("productTotal")
    private Float productTotal = 0f;
    @SerializedName("campaignDiscountTotal")
    private Float campaignDiscountTotal = 0f;
    @SerializedName("couponDiscountTotal")
    private Float couponDiscountTotal = 0f;
    @SerializedName("cartTotal")
    private Float cartTotal = 0f;
    @SerializedName("cartTotalWithoutDiscount")
    private Float cartTotalWithoutDiscount = 0f;
    @SerializedName("subTotal")
    private Float subTotal = 0f;
    @SerializedName("tillMinOrder")
    private Float tillMinOrder = 0f;
    @SerializedName("tillFreeShipping")
    private Float tillFreeShipping = 0f;
    @SerializedName("campaigns")
    private List<MagicLink> campaigns = null;
    @SerializedName("campaignDetails")
    private List<CampaignDetail> campaignDetails = null;
    @SerializedName("bagPriceTotal")
    private float bagPriceTotal = 0f;
    @SerializedName("applicableDiscounts")
    private List<ApplicableDiscount> applicableDiscounts = null;
    @SerializedName("appliedDiscounts")
    private List<ApplicableDiscount> appliedDiscounts = null;
    @SerializedName("selectedDiscounts")
    private List<SelectedDiscounts> selectedDiscounts = null;
    @SerializedName("appliedCoupon")
    private AppliedCoupon appliedCoupon = null;
    @SerializedName("totalGross")
    private Float totalGross = 0f;

    @SerializedName("productTotalDiscount")
    private Float productTotalDiscount = 0f;

    @SerializedName("cartTotalEndDiscount")
    private Float cartTotalEndDiscount = 0f;

    @SerializedName("shippingTotalDiscount")
    private Float shippingTotalDiscount = 0f;

    public Float getTotalFinalDiscount() {
        return totalFinalDiscount;
    }

    public void setTotalFinalDiscount(Float totalFinalDiscount) {
        this.totalFinalDiscount = totalFinalDiscount;
    }

    public float getBagPriceTotal() {
        return bagPriceTotal;
    }

    public Float getFreeShippingLimit() {
        return freeShippingLimit;
    }

    public void setFreeShippingLimit(Float freeShippingLimit) {
        this.freeShippingLimit = freeShippingLimit;
    }

    public List<MagicLink> getCampaigns() {
        return campaigns;
    }

    public void setCampaigns(List<MagicLink> campaigns) {
        this.campaigns = campaigns;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Float shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Float getTotalRulesDiscount() {
        return totalRulesDiscount;
    }

    public void setTotalRulesDiscount(Float totalRulesDiscount) {
        this.totalRulesDiscount = totalRulesDiscount;
    }



    public Float getMinOrderLimit() {
        return minOrderLimit;
    }

    public void setMinOrderLimit(Float minOrderLimit) {
        this.minOrderLimit = minOrderLimit;
    }

    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        int index = Product.Companion.findProduct(getProducts(), product);
        if (index != -1)
            products.remove(index);
    }

    public void removeProduct(int productIndex) {
        if (productIndex >= 0 && productIndex < products.size()) {
            products.remove(productIndex);
        }
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static UserCart fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, UserCart.class);
    }

    public UserCart clone() {
        return fromJson(toJson());
    }

    public Float getCartTotal() {
        return cartTotal == null ? 0f : cartTotal;
    }

    public void setCartTotal(Float cartTotal) {
        this.cartTotal = cartTotal;
    }

    public Float getCartTotalWithoutDiscount() {
        return cartTotalWithoutDiscount == null ? 0f : cartTotalWithoutDiscount;
    }

    public void setCartTotalWithoutDiscount(Float cartTotalWithoutDiscount) {
        this.cartTotalWithoutDiscount = cartTotalWithoutDiscount;
    }

    public Float getProductTotal() {
        return productTotal == null ? 0f : productTotal;
    }

    public void setProductTotal(Float productTotal) {
        this.productTotal = productTotal;
    }

    public Float getCampaignDiscountTotal() {
        return campaignDiscountTotal;
    }

    public void setCampaignDiscountTotal(Float campaignDiscountTotal) {
        this.campaignDiscountTotal = campaignDiscountTotal;
    }

    public Float getCouponDiscountTotal() {
        return couponDiscountTotal;
    }

    public void setCouponDiscountTotal(Float couponDiscountTotal) {
        this.couponDiscountTotal = couponDiscountTotal;
    }

    public List<CampaignDetail> getCampaignDetails() {
        return campaignDetails;
    }

    public void setCampaignDetails(List<CampaignDetail> campaignDetails) {
        this.campaignDetails = campaignDetails;
    }

    public Float getShippingFeeWithoutDiscount() {
        return shippingFeeWithoutDiscount;
    }

    public Float getProductTotalWithoutDiscount() {
        return productTotalWithoutDiscount == null ? 0f : productTotalWithoutDiscount;
    }

    public Float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Float subTotal) {
        this.subTotal = subTotal;
    }

    public Float getTillMinOrder() {
        return tillMinOrder;
    }

    public void setTillMinOrder(Float tillMinOrder) {
        this.tillMinOrder = tillMinOrder;
    }

    public Float getTillFreeShipping() {
        return tillFreeShipping;
    }

    public void setTillFreeShipping(Float tillFreeShipping) {
        this.tillFreeShipping = tillFreeShipping;
    }

    public List<ApplicableDiscount> getApplicableDiscount() {
        return applicableDiscounts;
    }

    public List<ApplicableDiscount> getAppliedDiscount() {
        return appliedDiscounts;
    }

    public List<SelectedDiscounts> getSelectedDiscounts() {
        return selectedDiscounts;
    }

    public void setSelectedDiscounts(List<SelectedDiscounts> selectedDiscounts) {
        this.selectedDiscounts = selectedDiscounts;
    }

    public AppliedCoupon getAppliedCoupon() {
        return appliedCoupon;
    }

    public void setAppliedCoupon(AppliedCoupon appliedCoupon) {
        this.appliedCoupon = appliedCoupon;
    }

    public void setShippingFeeWithoutDiscount(Float shippingFeeWithoutDiscount) {
        this.shippingFeeWithoutDiscount = shippingFeeWithoutDiscount;
    }

    public void setProductTotalWithoutDiscount(Float productTotalWithoutDiscount) {
        this.productTotalWithoutDiscount = productTotalWithoutDiscount;
    }

    public void setBagPriceTotal(float bagPriceTotal) {
        this.bagPriceTotal = bagPriceTotal;
    }

    public List<ApplicableDiscount> getApplicableDiscounts() {
        return applicableDiscounts;
    }

    public void setApplicableDiscounts(List<ApplicableDiscount> applicableDiscounts) {
        this.applicableDiscounts = applicableDiscounts;
    }

    public List<ApplicableDiscount> getAppliedDiscounts() {
        return appliedDiscounts;
    }

    public void setAppliedDiscounts(List<ApplicableDiscount> appliedDiscounts) {
        this.appliedDiscounts = appliedDiscounts;
    }

    public Float getTotalGross() {
        return totalGross;
    }

    public void setTotalGross(Float totalGross) {
        this.totalGross = totalGross;
    }

    public Float getProductTotalDiscount() {
        return productTotalDiscount;
    }

    public void setProductTotalDiscount(Float productTotalDiscount) {
        this.productTotalDiscount = productTotalDiscount;
    }

    public Float getCartTotalEndDiscount() {
        return cartTotalEndDiscount;
    }

    public void setCartTotalEndDiscount(Float cartTotalEndDiscount) {
        this.cartTotalEndDiscount = cartTotalEndDiscount;
    }

    public Float getShippingTotalDiscount() {
        return shippingTotalDiscount;
    }

    public void setShippingTotalDiscount(Float shippingTotalDiscount) {
        this.shippingTotalDiscount = shippingTotalDiscount;
    }

    //    public AppliedCoupon getAppliedCoupon() {
//        return appliedCoupon;
//    }

    //    public static UserCart fromCUserCart(CUserCart cuc) {
//        final UserCart uc = new UserCart();
//        uc.campaigns = new ArrayList<>();
//        uc.freeShippingLimit = cuc.getFreeShippingLimit();
//        uc.cart = cuc.getCart();
//        uc.minOrderLimit = cuc.getMinOrderLimit();
//        uc.shippingFee = cuc.getShippingFee();
//        uc.totalRulesDiscount = 0f;
//        final List<Product> products = new ArrayList<>();
//        if (cuc.getProducts() != null) {
//            for (CProduct cp : cuc.getProducts()) {
//                products.add(Product.fromCProduct(cp));
//            }
//        }
//        uc.setProducts(products);
//        return uc;
//    }
}
