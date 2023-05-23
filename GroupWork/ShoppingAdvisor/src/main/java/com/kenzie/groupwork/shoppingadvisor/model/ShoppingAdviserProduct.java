package com.kenzie.groupwork.shoppingadvisor.model;

import com.kenzie.groupwork.shoppingadvisor.resources.Product;

import java.math.BigDecimal;

/**
 * A product recommended by the ShoppingAdviser team. The advice label provides information
 * about why the product is being suggested.
 */
public class ShoppingAdviserProduct {
    private String adviceLabel;
    private Product product;

    public ShoppingAdviserProduct(String adviceLabel, Product product) {
        this.adviceLabel = adviceLabel;
        this.product = product;
    }

    public String getAdviceLabel() {
        return adviceLabel;
    }

    public String getTitle() {
        return product.getTitle();
    }

    public BigDecimal getPrice() {
        return product.getListPrice();
    }
}
