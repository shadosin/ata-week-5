package com.kenzie.groupwork.shoppingadvisor;

import com.kenzie.groupwork.shoppingadvisor.client.EditorialServiceClient;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingContext;
import com.kenzie.groupwork.shoppingadvisor.resources.SearchCategory;
import com.kenzie.test.infrastructure.reflect.ClassQuery;
import com.kenzie.test.infrastructure.reflect.ConstructorQuery;
import com.kenzie.test.infrastructure.reflect.MethodQuery;
import com.kenzie.test.infrastructure.wrapper.WrapperBase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class EditorialAdviserWidgetWrapper extends WrapperBase {
    private static final String WIDGET_PACKAGE = "com.kenzie.groupwork.shoppingadvisor.widget";
    private static final String EDITORIAL_WIDGET_CLASS_NAME = "EditorialAdviserWidget";
    private static Class<?> wrappedClass = null;

    protected EditorialAdviserWidgetWrapper(Object wrappedInstance) {
        super(wrappedInstance);
    }

    public static EditorialAdviserWidgetWrapper create() {
        Class<?> editorialAdviserWidgetClass = ClassQuery.inExactPackage(WIDGET_PACKAGE)
            .withExactSimpleName(EDITORIAL_WIDGET_CLASS_NAME).findClassOrFail();

        Constructor ctor = ConstructorQuery.inClass(editorialAdviserWidgetClass).withExactArgTypes(Arrays.asList(ShoppingContext.class,
            EditorialServiceClient.class)).findConstructorOrFail();

        Object editorialAdviserWidgetObject = null;
        try {
            editorialAdviserWidgetObject = ctor.newInstance(
                new ShoppingContext("grill", SearchCategory.HOME_AND_GARDEN, "ATVPDKIKX0DER"),
                new EditorialServiceClient());
        } catch (Exception e) {
            try {
                editorialAdviserWidgetObject = ctor.newInstance(
                        new EditorialServiceClient(),
                        new ShoppingContext("grill", SearchCategory.HOME_AND_GARDEN, "ATVPDKIKX0DER"));
                System.out.println("Could not invoke EditorialAdviserWidget constructor.");
            } catch (Exception ex) {
                System.out.println("Could not invoke EditorialAdviserWidget constructor.");
            }
        }
        return new EditorialAdviserWidgetWrapper(editorialAdviserWidgetObject);
    }

    public String getSimpleRendering() {
        Method getSimpleRenderingMethod = MethodQuery.inType(getWrappedClass())
            .withExactName("getSimpleRendering").findMethodOrFail();

        return (String) this.invokeInstanceMethodWithReturnValue(getSimpleRenderingMethod);
    }

    @Override
    public Class<?> getWrappedClass() {
        if (null != wrappedClass) {
            return wrappedClass;
        }
        wrappedClass = ClassQuery.inExactPackage(WIDGET_PACKAGE).withExactSimpleName(EDITORIAL_WIDGET_CLASS_NAME).findClassOrFail();

        return wrappedClass;
    }
}
