package com.kenzie.groupwork.shoppingadvisor;

import com.kenzie.groupwork.shoppingadvisor.client.AmazonSearchServiceClient;
import com.kenzie.groupwork.shoppingadvisor.client.AmazonsChoiceServiceClient;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingContext;
import com.kenzie.groupwork.shoppingadvisor.resources.SearchCategory;
import com.kenzie.groupwork.shoppingadvisor.widget.AmazonsChoiceAdviserWidget;
import com.kenzie.groupwork.shoppingadvisor.widget.ShoppingAdviserWidget;

import com.kenzie.test.infrastructure.reflect.MethodInvoker;
import com.kenzie.test.infrastructure.reflect.MethodQuery;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class Phase3Test {

    @Test
    void phase3_introspectShoppingAdviserWidgetTestRenderer_methodHasCorrectParams() {
        Method method = null;
        try {
            method = MethodQuery.inType(ShoppingAdviserWidgetTestRenderer.class).withExactName("getRenderableContent")
                    .withExactArgTypes(Arrays.asList(ShoppingAdviserWidget.class)).findMethod();
        } catch(Exception e) {}

        assertNotNull(method, "Expected ShoppingAdviserWidgetTestRenderer#getRenderableContent to accept a " +
                "AmazonSearchServiceClient or a EditorialAdviserWidget");
    }

    @Test
    void phase3_invokeGetRenderableContentWithEditorialAdviserWidget_contentReturned() {
        // GIVEN
        EditorialAdviserWidgetWrapper wrappedEditorialAdviserWidget = EditorialAdviserWidgetWrapper.create();
        Method getRenderableContentMethod = MethodQuery.inType(ShoppingAdviserWidgetTestRenderer.class)
                .withExactName("getRenderableContent")
                .findMethod();

        // WHEN & THEN
        try {
            MethodInvoker.invokeInstanceMethodWithReturnValue(new ShoppingAdviserWidgetTestRenderer(),
                    getRenderableContentMethod, wrappedEditorialAdviserWidget.getWrappedInstance());
        } catch (Exception e) {
            fail("Unable to call getRenderableContent for a EditorialAdviserWidget.", e);
        }
    }

    @Test
    void phase3_invokeGetRenderableContentWithAmazonsChoiceAdviserWidget_contentReturned() {
        // GIVEN
        AmazonsChoiceAdviserWidget amazonsChoiceAdviserWidget = new AmazonsChoiceAdviserWidget(
                new ShoppingContext("grill", SearchCategory.HOME_AND_GARDEN, "ATVPDKIKX0DER"),
                new AmazonsChoiceServiceClient(), new AmazonSearchServiceClient());


        // WHEN & THEN
        try {
            ShoppingAdviserWidgetTestRenderer renderer = new ShoppingAdviserWidgetTestRenderer();
            renderer.getRenderableContent(amazonsChoiceAdviserWidget);
        } catch (Exception e) {
            fail("Unable to call getRenderableContent for a AmazonsChoiceAdviserWidget.", e);
        }
    }
}
