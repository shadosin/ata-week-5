package com.kenzie.groupwork.shoppingadvisor.widget;

import com.kenzie.groupwork.shoppingadvisor.client.AmazonSearchServiceClient;
import com.kenzie.groupwork.shoppingadvisor.client.AmazonsChoiceServiceClient;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingAdviserProduct;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingContext;
import com.kenzie.groupwork.shoppingadvisor.resources.AmazonsChoiceProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * A ShoppingAdviserWidget that recommends Amazon's Choice products
 * for related search terms to that in the ShoppingContext.
 */
public class AmazonsChoiceAdviserWidget extends ShoppingAdviserWidget {

    private AmazonsChoiceServiceClient amazonsChoiceServiceClient;
    private AmazonSearchServiceClient amazonSearchServiceClient;

    public AmazonsChoiceAdviserWidget(ShoppingContext shoppingContext,
                                      AmazonsChoiceServiceClient amazonsChoiceServiceClient,
                                      AmazonSearchServiceClient amazonSearchServiceClient) {
        super("Customers shopped Amazon's Choice for...", shoppingContext);
        this.amazonsChoiceServiceClient = amazonsChoiceServiceClient;
        this.amazonSearchServiceClient = amazonSearchServiceClient;
    }

    @Override
    public List<ShoppingAdviserProduct> getAdvisedProducts() {
        List<String> relatedSearchTerms =
            amazonSearchServiceClient.getRelatedSearchTerms(getShoppingContext().getSearchTerm(),
                getShoppingContext().getSearchCategory());

        List<AmazonsChoiceProduct> amazonsChoiceProducts = new ArrayList<>();
        for (String searchTerm : relatedSearchTerms) {
            AmazonsChoiceProduct choiceProduct = amazonsChoiceServiceClient.getChoiceProduct(searchTerm,
                getShoppingContext().getMarketplaceId());
            if (choiceProduct != null) {
                amazonsChoiceProducts.add(choiceProduct);
            }
        }

        List<ShoppingAdviserProduct> shoppingAdviserProducts = new ArrayList<>();
        for (AmazonsChoiceProduct choiceProduct : amazonsChoiceProducts) {
            shoppingAdviserProducts.add(new ShoppingAdviserProduct(choiceProduct.getSearchTerm(),
                choiceProduct.getProduct()));
        }

        return shoppingAdviserProducts;
    }
}
