package com.kenzie.groupwork.shoppingadvisor.widget;

import com.kenzie.groupwork.shoppingadvisor.model.ShoppingAdviserProduct;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingContext;
import com.kenzie.groupwork.shoppingadvisor.resources.TextTable;

import java.util.ArrayList;
import java.util.List;

/**
 * A ShoppingAdvisorWidget provides an Amazon customer with recommendations
 * based on what they are searching for. A widget contains a title and a list
 * of ShoppingAdviserProducts.
 */
public class ShoppingAdviserWidget {
    private ShoppingContext context;
    private String title;

    public ShoppingAdviserWidget(String title, ShoppingContext context) {
        this.context = context;
        this.title = title;
    }

    public ShoppingContext getShoppingContext() {
        return this.context;
    }

    public String getTitle() {
        return this.title;
    }

    public List<ShoppingAdviserProduct> getAdvisedProducts() {
        return new ArrayList<>();
    }

    /**
     * Returns a text rendering of the widget, useful in testing purposes.
     *
     * @returns rendered widget String
     */
    public String getSimpleRendering() {
        String widgetTitle = getTitle();
        List<ShoppingAdviserProduct> products = getAdvisedProducts();

        if (products.isEmpty()) {
            throw new IllegalArgumentException("Unable to render a shopping adviser widget with no products.");
        }

        // Generation of the widget's text contents - no need to read the code below here!
        List<String> headers = getHeaders(widgetTitle, products);

        List<List<String>> rows = new ArrayList<>();
        rows.add(getAdviceLabels(products));
        rows.add(getProductTitles(products));
        rows.add(getPrices(products));

        TextTable table = new TextTable(headers, rows);
        return table.toString();
    }

    // THE PRIVATE METHODS BELOW ARE USED FOR THE TEXT RENDERING OF THE WIDGET.

    private List<String> getPrices(List<ShoppingAdviserProduct> products) {
        List<String> prices = new ArrayList<>();
        for (ShoppingAdviserProduct product : products) {
            prices.add(product.getPrice().toPlainString());
        }
        return prices;
    }

    private List<String> getProductTitles(List<ShoppingAdviserProduct> products) {
        List<String> productTitles = new ArrayList<>();
        for (ShoppingAdviserProduct product : products) {
            productTitles.add(product.getTitle());
        }
        return productTitles;
    }

    private List<String> getAdviceLabels(List<ShoppingAdviserProduct> products) {
        List<String> adviceLabels = new ArrayList<>();
        for (ShoppingAdviserProduct product : products) {
            adviceLabels.add(product.getAdviceLabel());
        }
        return adviceLabels;
    }

    private List<String> getHeaders(String widgetTitle, List<ShoppingAdviserProduct> products) {
        List<String> headers = new ArrayList<>();
        headers.add(widgetTitle);

        for (int i = 0; i < products.size() - 1; i++) {
            headers.add("");
        }

        return headers;
    }
}
