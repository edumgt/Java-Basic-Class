package com.example;

public class Dough {

    private String flourType;

    private String bakingTechnique;

    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public double calculateCalories() {
        double calories = 0;

        switch (flourType) {
            case "White":
                if (bakingTechnique.equals("Crispy")) {
                    calories = (2 * weight) * 1.5 * 0.9;
                } else if (bakingTechnique.equals("Chewy")) {
                    calories = (2 * weight) * 1.5 * 1.1;
                } else {
                    calories = (2 * weight) * 1.5 * 1.0;
                }
                break;
            case "Wholegrain":
                if (bakingTechnique.equals("Crispy")) {
                    calories = (2 * weight) * 1.0 * 0.9;
                } else if (bakingTechnique.equals("Chewy")) {
                    calories = (2 * weight) * 1.0 * 1.1;
                } else {
                    calories = (2 * weight) * 1.0 * 1.0;
                }
                break;
        }

        return calories;

    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
}
