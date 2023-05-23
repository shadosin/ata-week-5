package com.kenzie.groupwork.shoppingadvisor;

import com.kenzie.groupwork.shoppingadvisor.client.AmazonSearchServiceClient;
import com.kenzie.groupwork.shoppingadvisor.client.AmazonsChoiceServiceClient;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingContext;
import com.kenzie.groupwork.shoppingadvisor.resources.SearchCategory;
import com.kenzie.groupwork.shoppingadvisor.widget.AmazonsChoiceAdviserWidget;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Phase0Test {

    private ShoppingAdviserWidgetTestRenderer renderer = new ShoppingAdviserWidgetTestRenderer();

    @Test
    public void phase0_getRenderableContentForAmazonsChoiceAdviserWidget_returnsContent() {
        AmazonsChoiceAdviserWidget amazonsChoiceAdviserWidget = new AmazonsChoiceAdviserWidget(
                new ShoppingContext("grill", SearchCategory.HOME_AND_GARDEN, "ATVPDKIKX0DER"),
                new AmazonsChoiceServiceClient(), new AmazonSearchServiceClient());
        String expectedContent = "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n" +
                "| Customers shopped Amazon's Choice for...                                      |                                                          |                                                  |\n" +
                " ============================================================================================================================================================================================= \n" +
                "| grill                                                                         | propane grill                                            | weber grill                                      |\n" +
                " --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n" +
                "| Cuisinart CCG190RB Portable Charcoal Grill, 14-Inch, Red, 14.5\" x 14.5\" x 15\" | Char-Broil Classic 360 3-Burner Liquid Propane Gas Grill | Weber 50060001 Q1000 Liquid Propane Grill,Chrome |\n" +
                " --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- \n" +
                "| 33.79                                                                         | 169.99                                                   | 179.99                                           |\n" +
                " --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ";

        String renderableContent = renderer.getRenderableContent(amazonsChoiceAdviserWidget);
        System.out.println(renderableContent);

        assertEquals(expectedContent.replaceAll("\\s", ""), renderableContent.replaceAll("\\s", ""),
                "Incorrect content returned from getRenderableContent()");
    }
}
