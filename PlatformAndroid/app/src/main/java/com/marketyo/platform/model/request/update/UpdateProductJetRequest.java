package com.marketyo.platform.model.request.update;

import com.google.gson.annotations.SerializedName;
import com.marketyo.platform.model.product.Product;

/**
 * Createdby MBH on 08/03/2017.
 */

public class UpdateProductJetRequest {

    @SerializedName("idProduct")
    private String idProduct;
    @SerializedName("amount")
    private float Amount;
//    @SerializedName("Note")
//    private String Note = "";

    public static UpdateProductJetRequest fromProduct(Product product) {
        return new UpdateProductJetRequest(product.getId(), product.getCurrentAmount());
    }

    public String getProductId() {
        return idProduct;
    }

    public void setProductId(String id_product) {
        this.idProduct = id_product;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }


//    public String getNote() { return Note; }
//    public void setNote(String note) { Note = note; }

    public UpdateProductJetRequest() {
    }

    public UpdateProductJetRequest(String idProduct, float amount) {
        this.idProduct = idProduct;
        Amount = amount;
    }

    public UpdateProductJetRequest(long idProduct, float amount) {
        this(idProduct + "", amount);
    }
}
