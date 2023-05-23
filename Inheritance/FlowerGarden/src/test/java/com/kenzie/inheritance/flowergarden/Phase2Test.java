package com.kenzie.inheritance.flowergarden;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Phase2Test {

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
    void searchCatalog_symbolicFlowerInCatalog_returnsTrue() {
        // GIVEN
        Flower flower = new SymbolicFlower("daisy", "white", "innocence");

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertTrue(matches, String.format("Expected %s to be contained in the catalog: %s", flower, catalog));
    }

    @Test
    void searchCatalog_symbolicFlowerNotInCatalog_returnsFalse() {
        // GIVEN
        Flower flower = new SymbolicFlower("hyacinth", "white", "innocence");

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertFalse(matches, String.format("Did NOT expect %s to be contained in the catalog: %s", flower, catalog));
    }

    @Test
    void searchCatalog_symbolicFlowerLikeFlowerNotInCatalog_returnsFalse() {
        // GIVEN
        Flower flower = new SymbolicFlower("tulip", "pink", "peace");

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertFalse(matches, String.format("Did NOT expect %s to be contained in the catalog: %s", flower, catalog));
    }

    @Test
    void searchCatalog_symbolicFlowerWithSameSignificanceInCatalog_returnsFalse() {
        // GIVEN
        Flower flower = new SymbolicFlower("tulip", "white", "innocence");

        // WHEN
        boolean matches = gardenCategory.searchCatalog(flower);

        // THEN
        assertFalse(matches, String.format("Did NOT expect %s to be contained in the catalog: %s", flower, catalog));
    }
}
