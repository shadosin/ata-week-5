package com.kenzie.inheritance.flowergarden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlowerTest {
    private Flower flower;

    @BeforeEach
    void setUp() {
        flower = new Flower("rose", "yellow", Planting.BULB);

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
        assertFalse(isEqual, "A Flower should not be equal with null.");
    }

    @Test
    public void equals_sameAttributes_isTrue() {
        // GIVEN
        Object other = new Flower(flower.getKind(), flower.getColoration(), flower.getPlanting());

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertTrue(isEqual, "Flowers with the same kind, coloration, and planting should be equals.");
    }

    @Test
    public void equals_sameKindSameColorationDifferentPlanting_isFalse() {
        // GIVEN
        Object other = new Flower(flower.getKind(), flower.getColoration(),
            Planting.values()[flower.getPlanting().ordinal() + 1]);

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertFalse(isEqual, "Flowers with the same kind and coloration should not be equal if planting differs.");
    }

    @Test
    public void equals_sameKindDifferentColoration_isFalse() {
        // GIVEN
        Object other = new Flower(flower.getKind(), "different" + flower.getColoration(), flower.getPlanting());

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertFalse(isEqual, "Flowers with the same kind and different coloration should not be equals.");
    }

    @Test
    public void equals_differentKindSameColoration_isFalse() {
        // GIVEN
        Object other = new Flower("different" + flower.getKind(), flower.getColoration(), flower.getPlanting());

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertFalse(isEqual, "Flowers with different kind and same coloration should not be equals.");
    }

    @Test
    public void equals_differentClass_isFalse() {
        // GIVEN
        Object other = new String("Not a Flower!");

        // WHEN
        boolean isEqual = flower.equals(other);

        // THEN
        assertFalse(isEqual, "A Flower can never equal a non Flower.");
    }
}
