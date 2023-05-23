package com.kenzie.inheritance.visitorlogs.model;

import com.kenzie.test.infrastructure.reflect.ClassQuery;
import com.kenzie.test.infrastructure.reflect.MethodInvoker;
import com.kenzie.test.infrastructure.reflect.MethodQuery;
import com.kenzie.test.infrastructure.reflect.ConstructorQuery;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitTest {
    private static final String BASE_PACKAGE = "com.kenzie.inheritance.visitorlogs";

    @Test
    public void testDefaultVisitVisualizesAsAnonymous() throws UnsupportedEncodingException {
        // GIVEN
        // An anonymous visit
        Visit visit = new Visit();

        // With all output captured by our own stream
        ByteArrayOutputStream capture = new ByteArrayOutputStream(100);
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(capture));

        // WHEN
        // We visualize the visit
        visit.visualize();
        // And restore stdout
        System.setOut(stdout);

        // THEN
        // The output block is blue
        // An expected anonymous character is a space ' '
        String anonymousVisitVisualization = getExpectedVisualization(VisitColor.ANONYMOUS_VISITOR_COLOR, ' ');
        String actual = capture.toString("UTF-8");
        assertEquals(anonymousVisitVisualization, actual);
    }

    @Test
    public void visit_type_amazon_overrides_methods_and_exists_extends_Visit() {
        // GIVEN

        // The Class Exists
        Class<?> amazonAccountVisitClass = assertDoesNotThrow( () -> ClassQuery.inContainingPackage(BASE_PACKAGE)
                .withExactSimpleName("AmazonAccountVisit")
                .findClassOrFail(), "The AmazonAccountVisit generated Subclass must exist");

        // The constructor for the Subclass
        Constructor constructor = assertDoesNotThrow( () -> ConstructorQuery.inClass(amazonAccountVisitClass)
                .withNoArgs()
                .findConstructor(), "The AmazonAccountVisit Constructor with no arguments was not found.");

                // The Class extends the Visit class
        assertTrue(amazonAccountVisitClass.getSuperclass() == Visit.class);

        // The getVisitCharacter Method in the Class Exists
        Method getVisitCharacterMethod = assertDoesNotThrow( () -> MethodQuery.inType(amazonAccountVisitClass)
                .withExactName("getVisitCharacter")
                .findMethodOrFail(), "The method getVisitCharacter was not found in Subclass AmazonAccountVisit");

        // The getVisitColor Method in the Class Exists
        Method getVisitColorMethod = assertDoesNotThrow( () -> MethodQuery.inType(amazonAccountVisitClass)
                .withExactName("getVisitColor")
                .findMethodOrFail(), "The method getVisitColor was not found in Subclass AmazonAccountVisit");

        Object amazonClassObject = null;

        try {
            amazonClassObject = constructor.newInstance();
        } catch (Exception e) {
            try {
                throw new InstantiationException("Cannot instantiate amazonClassObject.");
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            }
        }

        // The getVisitCharacterMethod overrides the base functionality in the subclass and returns character
        Object amazonAccountVisitCharacter = MethodInvoker.invokeInstanceMethodWithReturnValue(amazonClassObject, getVisitCharacterMethod);

        assertEquals(amazonAccountVisitCharacter.toString(), "@");

        // The getVisitCharacterMethod overrides the base functionality in the subclass and returns the appropriate VISITOR COLOR
        Object amazonAccountVisitColor = MethodInvoker.invokeInstanceMethodWithReturnValue(amazonClassObject, getVisitColorMethod);
        assertEquals(amazonAccountVisitColor, VisitColor.AMAZON_VISITOR_COLOR);
    }

    @Test
    public void visit_type_zappos_overrides_methods_and_exists_extends_Visit() {
        // GIVEN

        // The Class Exists
        Class<?> zapposAccountVisitClass = assertDoesNotThrow( () -> ClassQuery.inContainingPackage(BASE_PACKAGE)
                .withExactSimpleName("ZapposAccountVisit")
                .findClassOrFail(), "The ZapposAccountVisit generated Subclass must exist");

        // The constructor for the Subclass
        Constructor constructor = assertDoesNotThrow( () -> ConstructorQuery.inClass(zapposAccountVisitClass)
                .withNoArgs()
                .findConstructor(), "The ZapposAccountVisit Constructor with no arguments was not found.");

        // The Class extends the Visit class
        assertTrue(zapposAccountVisitClass.getSuperclass() == Visit.class);

        // The getVisitCharacter Method in the Class Exists
        Method getVisitCharacterMethod = assertDoesNotThrow( () -> MethodQuery.inType(zapposAccountVisitClass)
                .withExactName("getVisitCharacter")
                .findMethodOrFail(), "The method getVisitCharacter was not found in Subclass ZapposAccountVisit");

        // The getVisitColor Method in the Class Exists
        Method getVisitColorMethod = assertDoesNotThrow( () -> MethodQuery.inType(zapposAccountVisitClass)
                .withExactName("getVisitColor")
                .findMethodOrFail(), "The method getVisitColor was not found in Subclass ZapposAccountVisit");

        Object zapposClassObject = null;

        try {
            zapposClassObject = constructor.newInstance();
        } catch (Exception e) {
            try {
                throw new InstantiationException("Cannot instantiate zapposClassObject.");
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            }
        }

        // The getVisitCharacterMethod overrides the base functionality in the subclass and returns character
        Object zapposAccountVisitCharacter = MethodInvoker.invokeInstanceMethodWithReturnValue(zapposClassObject, getVisitCharacterMethod);

        assertEquals(zapposAccountVisitCharacter.toString(), "@");

        // The getVisitCharacterMethod overrides the base functionality in the subclass and returns the appropriate VISITOR COLOR
        Object zapposAccountVisitColor = MethodInvoker.invokeInstanceMethodWithReturnValue(zapposClassObject, getVisitColorMethod);
        assertEquals(zapposAccountVisitColor, VisitColor.ZAPPOS_VISITOR_COLOR);
    }

    @Test
    public void visit_type_test_overrides_methods_and_exists_extends_Visit() {
        // GIVEN

        // The Class Exists
        Class<?> testVisitClass = assertDoesNotThrow( () -> ClassQuery.inContainingPackage(BASE_PACKAGE)
                .withExactSimpleName("TestVisit")
                .findClassOrFail(), "The TestVisit generated Subclass must exist");

        // The constructor for the Subclass
        Constructor constructor = assertDoesNotThrow( () -> ConstructorQuery.inClass(testVisitClass)
                .withNoArgs()
                .findConstructor(), "The TestVisit Constructor with no arguments was not found.");

        // The Class extends the Visit class
        assertTrue(testVisitClass.getSuperclass() == Visit.class);

        // The getVisitCharacter Method in the Class Exists
        Method getVisitCharacterMethod = assertDoesNotThrow( () -> MethodQuery.inType(testVisitClass)
                .withExactName("getVisitCharacter")
                .findMethodOrFail(), "The method getVisitCharacter was not found in Subclass TestVisit");

        // The getVisitColor Method in the Class Exists
        Method getVisitColorMethod = assertDoesNotThrow( () -> MethodQuery.inType(testVisitClass)
                .withExactName("getVisitColor")
                .findMethodOrFail(), "The method getVisitColor was not found in Subclass TestVisit");

        Object testVisitClassObject = null;

        try {
            testVisitClassObject = constructor.newInstance();
        } catch (Exception e) {
            try {
                throw new InstantiationException("Cannot instantiate testVisitClassObject.");
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            }
        }

        // The getVisitCharacterMethod overrides the base functionality in the subclass and returns character
        Object testVisitCharacter = MethodInvoker.invokeInstanceMethodWithReturnValue(testVisitClassObject, getVisitCharacterMethod);

        assertEquals(testVisitCharacter.toString(), " ");

        // The getVisitCharacterMethod overrides the base functionality in the subclass and returns the appropriate VISITOR COLOR
        Object testVisitColor = MethodInvoker.invokeInstanceMethodWithReturnValue(testVisitClassObject, getVisitColorMethod);
        assertEquals(testVisitColor, VisitColor.TEST_VISITOR_COLOR);
    }

    private String getExpectedVisualization(VisitColor visitColor, char ch) {
        return String.format("\u001b[%sm%c\u001b[0m", visitColor.getAnsiCode(), ch);
    }
}
