package com.kenzie.inheritance.flowergarden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SymbolicFlowerTest {
    private SymbolicFlower flower;

    @BeforeEach
    void setUp() {
        flower = new SymbolicFlower("rose", "white", "virtue");
    }

    @Test
    public void equals_sameObject_isTrue() {
        // GIVEN
        Object other = flower;

        // WHEN
        boolean result = flower.equals(other);

        // THEN
        assertTrue(result, "An object should be equal with itself.");
    }

    @Test
    public void equals_nullObject_returnsFalse() {
        // GIVEN
        Object other = null;

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertFalse(isEqual, "A SymbolicFlower should not be equal with null.");
    }

    @Test
    public void equals_sameAttributes_isTrue() {
        // GIVEN
        Object other = new SymbolicFlower(flower.getKind(), flower.getColoration(),
            flower.getSignificance());

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertTrue(isEqual,
            "SymbolicFlowers with the same kind, coloration, planting, and significance should be equals.");
    }

    @Test
    public void equals_sameMeaningDifferentOtherAttributes_isFalse() {
        // GIVEN
        Object other = new SymbolicFlower("different" + flower.getKind(), "different" + flower.getColoration(), flower.getSignificance());

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertFalse(isEqual,
            "SymbolicFlowers with the same meaning should be equals, even if other attributes differ.");
    }

    @Test
    public void equals_differentMeaningSameOtherAttributes_isFalse() {
        // GIVEN
        Object other = new SymbolicFlower(flower.getKind(), flower.getColoration(),
            "different" + flower.getSignificance());

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertFalse(isEqual, "SymbolicFlowers with different meaning should not be equals.");
    }

    @Test
    public void equals_notSameClass_isFalse() {
        // GIVEN
        Object other = new Flower(flower.getKind(), flower.getColoration(), flower.getPlanting());

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertFalse(isEqual, "A SymbolicFlower can never equal a non-SymbolicFlower, even a superclass.");
    }
}
