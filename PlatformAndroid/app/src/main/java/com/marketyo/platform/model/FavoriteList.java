package com.marketyo.platform.model;

import com.google.gson.annotations.SerializedName;
import com.marketyo.platform.model.product.Product;

import java.util.List;

public class FavoriteList {

    @SerializedName("products")
    private List<Product> mProducts;

    public List<Product> getProducts() {
        return mProducts;
    }

    public void setProducts(List<Product> products) {
        mProducts = products;
    }

}
