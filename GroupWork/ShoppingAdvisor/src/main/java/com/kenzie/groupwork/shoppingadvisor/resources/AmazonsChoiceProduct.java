package com.kenzie.groupwork.shoppingadvisor.resources;


/**
 * A highly rated and well-priced product for the provided search term.
 */
public class AmazonsChoiceProduct {
    private Product product;
    private String searchTerm;

    public AmazonsChoiceProduct(String searchTerm, Product product) {
        this.searchTerm = searchTerm;
        this.product = product;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public Product getProduct() {
        return product;
    }
}
