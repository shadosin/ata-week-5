package com.kenzie.groupwork.shoppingadvisor;

import com.kenzie.groupwork.shoppingadvisor.client.EditorialServiceClient;
import com.kenzie.groupwork.shoppingadvisor.model.ShoppingContext;

import com.kenzie.test.infrastructure.reflect.ClassQuery;
import com.kenzie.test.infrastructure.reflect.ConstructorQuery;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.kenzie.test.infrastructure.assertions.IntrospectionAssertions.assertClassContainsMemberMethodNames;
import static com.kenzie.test.infrastructure.assertions.IntrospectionAssertions.assertDirectlyExtends;

public class Phase2Test {

    private static final String WIDGET_PACKAGE = "com.kenzie.groupwork.shoppingadvisor.widget";;
    private static final String EDITORIAL_WIDGET_CLASS_NAME = "EditorialAdviserWidget";
    private static final String ADVISER_WIDGET_CLASS_NAME = "ShoppingAdviserWidget";

    @Test
    void phase2_introspectEditorialAdviserWidgetClass_exists() {
        ClassQuery.inExactPackage(WIDGET_PACKAGE).withExactSimpleName(EDITORIAL_WIDGET_CLASS_NAME).findClassOrFail();
    }

    @Test
    void phase2_introspectEditorialAdviserWidgetClass_hasExpectedClassHierarchy() {
        // GIVEN
        Class<?> editorialAdviserWidgetClass = ClassQuery.inExactPackage(WIDGET_PACKAGE)
                .withExactSimpleName(EDITORIAL_WIDGET_CLASS_NAME)
                .findClassOrFail();

        Class<?> widgetClass = ClassQuery.inExactPackage(WIDGET_PACKAGE)
                .withExactSimpleName(ADVISER_WIDGET_CLASS_NAME)
                .findClassOrFail();

        // WHEN + THEN
        assertDirectlyExtends(editorialAdviserWidgetClass, widgetClass);
    }

    @Test
    void phase2_introspectEditorialAdviserWidgetClass_hasExpectedMemberMethod() {
        // GIVEN
        Class<?> editorialAdviserWidgetClass = ClassQuery.inExactPackage(WIDGET_PACKAGE)
                .withExactSimpleName(EDITORIAL_WIDGET_CLASS_NAME)
                .findClassOrFail();

        String[] expectedMethodNames = {"getAdvisedProducts"};

        // WHEN + THEN
        assertClassContainsMemberMethodNames(editorialAdviserWidgetClass, expectedMethodNames);
    }

    @Test
    void phase2_introspectEditorialAdviserWidgetClass_hasExpectedConstructor() {
        // GIVEN
        Class<?> editorialAdviserWidgetClass = ClassQuery.inExactPackage(WIDGET_PACKAGE)
                .withExactSimpleName(EDITORIAL_WIDGET_CLASS_NAME)
                .findClassOrFail();

        // WHEN + THEN
        ConstructorQuery.inClass(editorialAdviserWidgetClass).withExactArgTypes(Arrays.asList(ShoppingContext.class,
                EditorialServiceClient.class)).findConstructorOrFail();
    }
}
