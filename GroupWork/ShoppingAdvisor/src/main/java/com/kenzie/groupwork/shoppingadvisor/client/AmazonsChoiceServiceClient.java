package com.kenzie.groupwork.shoppingadvisor.client;

import com.kenzie.groupwork.shoppingadvisor.resources.AmazonsChoiceProduct;
import com.kenzie.groupwork.shoppingadvisor.resources.AmazonsChoiceService;

/**
 * Connects to the AmazonsChoiceService to get Amazon`s Choice products for a
 * searchTerm in a specific marketplace.
 */
public class AmazonsChoiceServiceClient {

    private AmazonsChoiceService amazonsChoiceService;

    public AmazonsChoiceServiceClient() {
        this.amazonsChoiceService = new AmazonsChoiceService();
    }

    /**
     * Get Amazon's Choice product for the provided search term sold in the provided marketplaceId.
     *
     * @param searchTerm    - what the customer needs a recommendation for
     * @param marketplaceId - the id of the marketplace this product will be recommended in
     * @return Amazon's Choice recommendation
     */
    public AmazonsChoiceProduct getChoiceProduct(String searchTerm, String marketplaceId) {
        return amazonsChoiceService.getChoiceProduct(searchTerm, marketplaceId);
    }
}
