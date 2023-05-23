package com.kenzie.groupwork.shoppingadvisor.model;

import com.kenzie.groupwork.shoppingadvisor.resources.SearchCategory;

/**
 * The context surrounding where a ShoppingAdviserWidget will be rendered. This includes what was
 * being searched for, in what category, and on what amazon retail site.
 */
public class ShoppingContext {
    private SearchCategory searchCategory;
    private String marketplaceId;
    private String searchTerm;

    public ShoppingContext(String searchTerm, SearchCategory searchCategory, String marketplaceId) {
        this.searchTerm = searchTerm;
        this.searchCategory = searchCategory;
        this.marketplaceId = marketplaceId;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public String getMarketplaceId() {
        return marketplaceId;
    }

    public SearchCategory getSearchCategory() {
        return searchCategory;
    }
}
