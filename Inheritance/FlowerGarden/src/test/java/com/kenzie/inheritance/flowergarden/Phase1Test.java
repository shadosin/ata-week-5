package com.kenzie.inheritance.flowergarden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Phase1Test {

    private List<Flower> catalog;
    private GardenCategory gardenCategory;

    @BeforeEach
    void setUp() {
        catalog = Arrays.asList(
            new SymbolicFlower("tulip", "red", "perfect love"),
            new SymbolicFlower("tulip", "yellow", "hope"),
            new Flower("tulip", "yellow with purple tips", Planting.BULB),
            new Flower("tulip", "pink", Planting.BULB),
            new SymbolicFlower("daisy", "white", "innocence"),
            new SymbolicFlower("rose", "red", "true love"),
            new SymbolicFlower("rose", "white", "purity"),
            new SymbolicFlower("rose", "dark pink", "gratitude"),
            new Flower("basil", "green", Planting.SEEDLING),
            new Flower("basil", "green", Planting.SEED),
            new Flower("peanut", "yellow", Planting.SEED),
            new SymbolicFlower("azalea", "red", "temperance"),
            new SymbolicFlower("sweetpea", "white", "gratitude"));

        gardenCategory = new GardenCategory(catalog);
    }

    @Test
    void searchCatalog_flowerInCatalog_returnsTrue() {
        // GIVEN
        Flower flower = new Flower("tulip", "yellow with purple tips", Planting.BULB);

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertTrue(matches, String.format("Expected %s to be contained in the catalog: %s", flower, catalog));
    }

    @Test
    void searchCatalog_flowerKindNotInCatalog_returnsFalse() {
        // GIVEN
        Flower flower = new Flower("birds of paradise", "orange", Planting.SEED);

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertFalse(matches, String.format("Did NOT expect %s to be contained in the catalog: %s", flower, catalog));
    }

    @Test
    void searchCatalog_flowerKindMatchesInCatalog_returnsFalse() {
        // GIVEN
        Flower flower = new Flower("tulip", "orange", Planting.SEED);

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertFalse(matches, String.format("Did NOT expect %s to be contained in the catalog: %s", flower, catalog));
    }

    @Test
    void searchCatalog_flowerKindAndColorMatchesInCatalog_returnsFalse() {
        // GIVEN
        Flower flower = new Flower("tulip", "pink", Planting.SEED);

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertFalse(matches, String.format("Did NOT expect %s to be contained in the catalog: %s", flower, catalog));
    }

    @Test
    void searchCatalog_flowerKindAndCutMatchesInCatalog_returnsFalse() {
        // GIVEN
        Flower flower = new Flower("tulip", "orange", Planting.BULB);

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertFalse(matches, String.format("Did NOT expect %s to be contained in the catalog: %s", flower, catalog));
    }

    @Test
    void searchCatalog_flowerColorAndCutMatchesInCatalog_returnsFalse() {
        // GIVEN
        Flower flower = new Flower("rose", "pink", Planting.BULB);

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertFalse(matches, String.format("Did NOT expect %s to be contained in the catalog: %s", flower, catalog));
    }

}
