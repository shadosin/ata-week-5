package com.kenzie.groupwork.shoppingadvisor.resources;

import java.math.BigDecimal;

public class AmazonsChoiceService {
    public AmazonsChoiceProduct getChoiceProduct(String searchTerm, String marketplaceId) {
        switch (searchTerm.toLowerCase()) {
            case "grill":
                return new AmazonsChoiceProduct(searchTerm, new Product("Cuisinart CCG190RB Portable Charcoal " +
                    "Grill, 14-Inch, Red, 14.5\" x 14.5\" x 15\"", "B00B58A0QU",
                    "Cuisinart", false, BigDecimal.valueOf(33.79)));
            case "propane grill":
                return new AmazonsChoiceProduct(searchTerm, new Product("Char-Broil Classic 360 3-Burner Liquid " +
                    "Propane Gas Grill", "B01HITNEEE",
                    "Char-Broil", false, BigDecimal.valueOf(169.99)));
            case "weber grill":
                return new AmazonsChoiceProduct(searchTerm, new Product("Weber 50060001 Q1000 Liquid Propane " +
                    "Grill,Chrome", "B00FDOONEC",
                    "Weber", false, BigDecimal.valueOf(179.99)));
            default:
                return null;
        }
    }
}
