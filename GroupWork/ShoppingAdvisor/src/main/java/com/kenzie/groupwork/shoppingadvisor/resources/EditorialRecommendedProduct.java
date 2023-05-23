package com.kenzie.groupwork.shoppingadvisor.resources;
/**
 * A product recommended by an editorial. The recommendation string will provide what
 * the product was recommended for, such as "Best all around" or "Best value".
 */
public class EditorialRecommendedProduct {
    private String recommendation;
    private Product product;

    public EditorialRecommendedProduct(String recommendation, Product product) {
        this.recommendation = recommendation;
        this.product = product;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public Product getProduct() {
        return product;
    }
}
