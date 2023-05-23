package com.kenzie.groupwork.shoppingadvisor.resources;

import java.util.Arrays;
import java.util.List;

public class AmazonSearchService {

    public List<String> getRelatedSearchTerms(String searchTerm, SearchCategory searchCategory) {
        switch (searchTerm.toLowerCase()) {
            case "grill":
                return Arrays.asList("grill", "propane grill", "weber grill", "weber grill 2 thermometer");
            default:
                return Arrays.asList();
        }
    }
}
