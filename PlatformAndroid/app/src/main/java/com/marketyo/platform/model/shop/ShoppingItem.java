package com.marketyo.platform.model.shop;

import com.google.gson.annotations.SerializedName;
import com.marketyo.platform.model.product.Product;

/**
 * Createdby MBH on 06/02/2017.
 */

public class ShoppingItem {
    @SerializedName("Id")
    private Long id = null;
    @SerializedName("product")
    private Product product = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
