package com.kenzie.groupwork.shoppingadvisor.resources;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class EditorialService {

    public List<EditorialRecommendedProduct> getEditorialRecommendedProducts(String searchTerm,
        SearchCategory searchCategory, String marketplaceIds) {
        switch (searchTerm.toLowerCase()) {
            case "grill":
                return Arrays.asList(
                    new EditorialRecommendedProduct("Best for Travel",
                        new Product("ISUMER Charcoal Grill Barbecue Portable BBQ", "B07D6FSMX3", "ISUMER",
                            false, BigDecimal.valueOf(28.99))),
                    new EditorialRecommendedProduct("Best for Large Groups",
                        new Product("Weber Original Kettle Premium 26 Inch Charcoal Grill, Black", "B00N65AAW4",
                            "Weber", false, BigDecimal.valueOf(379.99))),
                    new EditorialRecommendedProduct("We Also Like",
                        new Product("MASTER COOK 3 Burner BBQ Propane Gas Grill", "B082HG76CB", "MASTER COOK",
                            false, BigDecimal.valueOf(183.99))));
            default:
                return Arrays.asList();
        }
    }
}
