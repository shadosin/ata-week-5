package com.kenzie.groupwork.shoppingadvisor.client;

import com.kenzie.groupwork.shoppingadvisor.resources.AmazonSearchService;
import com.kenzie.groupwork.shoppingadvisor.resources.SearchCategory;

import java.util.List;

/**
 * Connects to the AmazonSearchService to retrieve searchTerms related to a provided search term and
 * relevant to the provided SearchCategory.
 */
public class AmazonSearchServiceClient {

    private AmazonSearchService searchService;

    public AmazonSearchServiceClient() {
        this.searchService = new AmazonSearchService();
    }

    /**
     * Retrieves related search terms based on historical customer searches. The results
     * should be filtered to be relevant to the provided SearchCategory. The provided
     * searchTerm will be included in the returned list.
     *
     * @param searchTerm     - the term to find relevant related search terms for
     * @param searchCategory - the filter to determine if the discovered search terms are relevant
     * @return - related search terms, including the provided search termØ
     */
    public List<String> getRelatedSearchTerms(String searchTerm, SearchCategory searchCategory) {
        return searchService.getRelatedSearchTerms(searchTerm, searchCategory);
    }
}
