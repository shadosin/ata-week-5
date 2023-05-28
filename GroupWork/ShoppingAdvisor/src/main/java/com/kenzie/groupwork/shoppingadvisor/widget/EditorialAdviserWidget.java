package com.kenzie.groupwork.shoppingadvisor.widget;

import com.kenzie.groupwork.shoppingadvisor.client.AmazonSearchServiceClient;
import com.kenzie.groupwork.shoppingadvisor.client.EditorialServiceClient;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingAdviserProduct;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingContext;
import com.kenzie.groupwork.shoppingadvisor.resources.EditorialRecommendedProduct;

import java.util.ArrayList;
import java.util.List;

public class EditorialAdviserWidget extends ShoppingAdviserWidget {
    private EditorialServiceClient editorialServiceClient;
    public EditorialAdviserWidget(EditorialServiceClient editorialServiceClient, ShoppingContext context){
        super("Editorial recommendation", context);
        this.editorialServiceClient = editorialServiceClient;
    }
    @Override
    public List<ShoppingAdviserProduct> getAdvisedProducts() {
        List<ShoppingAdviserProduct> adviserProducts = new ArrayList<>();
        List<EditorialRecommendedProduct> searchTerms = editorialServiceClient.getEditorialRecommendedProducts(getShoppingContext().getSearchTerm(),
                getShoppingContext().getSearchCategory(),
                getShoppingContext().getMarketplaceId());

        for (EditorialRecommendedProduct editorialProduct : searchTerms) {
            ShoppingAdviserProduct adviserProduct = new ShoppingAdviserProduct(
                    editorialProduct.getRecommendation(),
                    editorialProduct.getProduct());

            adviserProducts.add(adviserProduct);
        }

        return adviserProducts;
    }
}
