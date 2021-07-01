package com.marketyo.platform.model.shop;

import com.google.gson.annotations.SerializedName;
import com.marketyo.platform.model.product.Product;

import java.util.List;

/**
 * Createdby MBH on 06/02/2017.
 */

public class ShoppingList {
    @SerializedName("Id")
    private Long id = null;
    @SerializedName("name")
    private String name = null;
    @SerializedName("items")
    private List<Product> shoppingListProducts = null;
    @SerializedName("color")
    private int color = 0xb21729;

    public ShoppingList() {
    }

    public ShoppingList(Long id, String name, List<Product> shoppingListProducts, int color) {
        this.id = id;
        this.name = name;
        this.shoppingListProducts = shoppingListProducts;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getShoppingListProducts() {
        return shoppingListProducts;
    }

    public void setShoppingListProducts(List<Product> shoppingListProducts) {
        this.shoppingListProducts = shoppingListProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public static int findShoppingList(List<ShoppingList> shopiLists, long shoppingListId) {
        if (shoppingListId < 0) return -1;
        int index = 0;
        for (ShoppingList shoppingList : shopiLists) {
            if (shoppingList.getId() == shoppingListId)
                return index;
            index++;
        }
        return -1;
    }

}
