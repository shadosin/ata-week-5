package com.kenzie.inheritance.visitorlogs;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitVisualizerTest {

    @Test
    public void testVisualizerRuns() {
        // GIVEN
        // The default VisitFactory
        VisitFactory factory = new VisitFactory();
        // And VisitVisualizer
        VisitVisualizer visualizer = new VisitVisualizer(factory);

        // WHEN
        // We run the visualization
        visualizer.visualize("visitors.log");

        // THEN
        // Manually check output
    }

    @Test
    public void testVisualizationHasCorrectNumberOfVisits() throws UnsupportedEncodingException {
        // GIVEN
        // All output captured by our own stream
        ByteArrayOutputStream capture = new ByteArrayOutputStream(1000);
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(capture));
        // And a visit factory providing Visits by account type
        VisitFactory factory = new VisitFactory();
        // And VisitVisualizer
        VisitVisualizer visualizer = new VisitVisualizer(factory);

        // WHEN
        // We run the visualization
        visualizer.visualize("visitors.log");
        // and restore stdout
        System.setOut(stdout);
        // and strip the header and formatting out of the visualization
        String output = capture.toString("UTF-8");
        String noHeader = output.substring(output.indexOf('\n')+1);
        String strippedOutput = noHeader.replaceAll("[^@ X]", "");

        // THEN
        // The stripped output has 5 characters
        assertEquals(5, strippedOutput.length(),
                String.format("Expected 5 characters in visualization '%s'", strippedOutput));

        // Count the number of X
        String allXs = strippedOutput.replaceAll("[^X]", "");
        assertEquals(0, allXs.length(), "There should be no invalid visitors");

        // Count the number of @ signs
        String allAts = strippedOutput.replaceAll("[^@]", "");
        assertEquals(3, allAts.length(), "There should be 3 persisted visits");

        // Count the number of spaces
        String allSpaces = strippedOutput.replaceAll("[^ ]", "");
        assertEquals(2, allSpaces.length(), "There should be 2 temporary visits");
    }
}
