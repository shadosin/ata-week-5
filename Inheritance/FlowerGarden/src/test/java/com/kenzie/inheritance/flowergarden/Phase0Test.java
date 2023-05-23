package com.kenzie.inheritance.flowergarden;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Phase0Test {

    @Test
    void gardenPurchase_buyFlower_succeeds() {
        // GIVEN
        GardenCategory category = new GardenCategory(new ArrayList<>());
        Flower flower = new Flower("rose", "yellow", Planting.BULB);

        // WHEN & THEN
        category.purchase(flower);
    }

    @Test
    void gardenPurchase_buySymbolicFlower_succeeds() {
        // GIVEN
        GardenCategory category = new GardenCategory(new ArrayList<>());
        Flower flower = new SymbolicFlower("rose", "yellow", "master coder");

        // WHEN & THEN
        category.purchase(flower);
    }
}
