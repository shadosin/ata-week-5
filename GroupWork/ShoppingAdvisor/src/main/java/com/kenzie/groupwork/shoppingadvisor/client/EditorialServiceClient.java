package com.kenzie.groupwork.shoppingadvisor.client;

import com.kenzie.groupwork.shoppingadvisor.resources.EditorialRecommendedProduct;
import com.kenzie.groupwork.shoppingadvisor.resources.EditorialService;
import com.kenzie.groupwork.shoppingadvisor.resources.SearchCategory;

import java.util.List;

/**
 * Connects tot he EditorialService to provide recommendations from a related
 * editorial.
 */
public class EditorialServiceClient {

    private EditorialService editorialService;

    public EditorialServiceClient() {
        editorialService = new EditorialService();
    }

    /**
     * Retrieve recommendations from an editorial. A relevant editorial will be found, if one exists,
     * and the recommendations will be returned from it. The editorial must be relevant to the searchTerm
     * and further refined by SearchCategory. Recommended products not sold in the specified marketplace
     * will not be returned.
     *
     * @param searchTerm     used to search for relevant editorials
     * @param searchCategory acts as a filter to ensure the editorial is related to the search
     * @param marketplaceId  acts as a filter to ensure the recommended products are sold in the marketplace
     * @return a list of products recommended by a relevant editorial
     */
    public List<EditorialRecommendedProduct> getEditorialRecommendedProducts(
            String searchTerm,
            SearchCategory searchCategory,
            String marketplaceId) {
        return editorialService.getEditorialRecommendedProducts(searchTerm, searchCategory, marketplaceId);
    }
}
