package com.kenzie.inheritance.flowergarden;

/**
 * Class representing a variation of flowering plant, useful for garden planning.
 */
public class Flower {
    private String kind;
    private String coloration;
    private Planting planting;

    /**
     * Constructor populating the necessary Flower instance variables.
     *
     * @param kind       The kind of the flower, such as "tulip"
     * @param coloration The coloration of the flower, such as "red with white striping"
     * @param planting   The planting of the flower, such as "seed" or "graft"
     */
    public Flower(String kind, String coloration, Planting planting) {
        this.kind = kind;
        this.coloration = coloration;
        this.planting = planting;
    }

    public String getKind() {
        return kind;
    }

    public String getColoration() {
        return coloration;
    }

    public Planting getPlanting() {
        return planting;
    }

    /**
     * Returns a short description of how to care for your plant.
     *
     * @return a short description of how to care for your plant.
     */
    public String getCareInstructions() {
        String instructions = "This is a special case; please consult our website.";
        if (planting == Planting.SEEDLING || planting == Planting.TRANSPLANT) {
            instructions = "Remove the seedling from its pot and place it in a pot-sized hole.";
        } else if (planting == Planting.GRAFT) {
            instructions = "This is really difficult. Consult an expert.";
        } else if (planting == Planting.SEED) {
            instructions = "Push the seed approximately 1cm into damp, tilled soil.";
        }
        return instructions;
    }

    /**
     * Sends a message to the customer with instructions on how to care for their newly purchased flower.
     * <p>
     * Since we're not in production, this just prints to the terminal.
     */
    public void sendCareInstructions() {
        // Assume this sent an email, instead of printing to the console
        String careInstructions = getCareInstructions();
        System.out.println(String.format("Thanks for purchasing a %s %s.%nHere's how to care for it!%n%s",
            kind, coloration, careInstructions));
    }

    @Override
    public String toString() {
        return String.format("Flower: {Kind: %s, Coloration: %s, Planting: %s}",
            kind, coloration, planting);
    }
}
