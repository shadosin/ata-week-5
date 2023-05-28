package com.kenzie.inheritance.flowergarden;

import java.util.Objects;

/**
 * Class representing a flower that has symbolic meaning.
 */
public class SymbolicFlower extends Flower {
    private String significance;

    /**
     * Constructor populating the necessary SymbolicFlower instance variables.
     *
     * @param kind         The kind of the flower, such as "tulip"
     * @param coloration   The coloration of the flower, such as "red with white striping"
     * @param significance The meanings of the flower
     */
    public SymbolicFlower(String kind, String coloration, String significance) {
        super(kind, coloration, Planting.CUT);
        this.significance = significance;
    }

    public String getSignificance() {
        return significance;
    }

    /**
     * Symbolic flowers are always Cut for arrangements.
     * Cut flowers for arrangements should be placed in water.
     */
    @Override
    public String getCareInstructions() {
        return "Fill with enough cold water to submerge the cut end, at least once per day.";
    }

    @Override
    public String toString() {
        return String.format("SymbolicFlower: {Kind: %s, Coloration: %s, Planting: %s Significance: %s}",
            getKind(), getColoration(), getPlanting(), significance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SymbolicFlower that)) return false;
        if (!super.equals(o)) return false;
        return getSignificance().equals(that.getSignificance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSignificance());
    }
}
