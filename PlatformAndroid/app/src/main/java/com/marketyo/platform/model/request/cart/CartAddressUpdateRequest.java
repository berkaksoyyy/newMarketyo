package com.marketyo.platform.model.request.cart;

import com.google.gson.annotations.SerializedName;

public class CartAddressUpdateRequest {

    @SerializedName("id_address_delivery")
    private String mIdAddressDelivery;
    @SerializedName("id_address_invoice")
    private String mIdAddressInvoice;

    public CartAddressUpdateRequest(String idAddressDelivery, String idAddressInvoice) {
        mIdAddressDelivery = idAddressDelivery;
        mIdAddressInvoice = idAddressInvoice;
    }

    public static CartAddressUpdateRequest getRequest(String addressId) {
        return new CartAddressUpdateRequest(addressId, addressId);
    }

    public static CartAddressUpdateRequest getRequest(String deliveryAddressId, String invoiceAddressId) {
        return new CartAddressUpdateRequest(deliveryAddressId, invoiceAddressId);
    }

    public String getIdAddressDelivery() {
        return mIdAddressDelivery;
    }

    public void setIdAddressDelivery(String idAddressDelivery) {
        mIdAddressDelivery = idAddressDelivery;
    }

    public String getIdAddressInvoice() {
        return mIdAddressInvoice;
    }

    public void setIdAddressInvoice(String idAddressInvoice) {
        mIdAddressInvoice = idAddressInvoice;
    }

}
