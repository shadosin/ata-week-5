package com.kenzie.groupwork.shoppingadvisor;

import com.kenzie.groupwork.shoppingadvisor.ATATestHelpers.ATAFileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.kenzie.test.infrastructure.assertions.PlantUmlClassDiagramAssertions.assertClassDiagramContainsClass;
import static com.kenzie.test.infrastructure.assertions.PlantUmlClassDiagramAssertions.assertClassDiagramIncludesContainsRelationship;
import static com.kenzie.test.infrastructure.assertions.PlantUmlClassDiagramAssertions.assertClassDiagramIncludesExtendsRelationship;


public class Phase1Test {

    private static final String CLASS_DIAGRAM_PATH = "src/main/java/com/kenzie/groupwork/shoppingadvisor/shopping_adviser.puml";


    @ParameterizedTest
    @ValueSource(strings = {
            "EditorialServiceClient", "EditorialAdviserWidget"})
    void phase1_getClassDiagram_includesExpectedTypes(String expectedClass) {
        // GIVEN - diagram path

        // WHEN
        String content = getFileContentFromResources(CLASS_DIAGRAM_PATH);

        // THEN - contains each class
        assertClassDiagramContainsClass(content, expectedClass);
    }

    @Test
    void phase1_getClassDiagram_includesExpectedRelationships() {
        // GIVEN - diagram path

        // WHEN
        String content = getFileContentFromResources(CLASS_DIAGRAM_PATH);

        // THEN - diagram includes these has-a relationships
        assertClassDiagramIncludesContainsRelationship(content, "EditorialAdviserWidget", "EditorialServiceClient");
        assertClassDiagramIncludesExtendsRelationship(content, "EditorialAdviserWidget", "ShoppingAdviserWidget");
    }

    private static String getFileContentFromResources(String filename) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            ATAFileReader fileReader = new ATAFileReader(filename);
            fileReader.readLines().forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Unable to find file: %s.", filename), e);
        }

        return contentBuilder.toString();
    }
}
