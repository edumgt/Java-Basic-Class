package com.example;

public class Topping {

    private String toppingType;

    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public double calculateCalories() {
        double calories;

        // if (toppingType.equals("Meat")) {
        // calories = (2 * weight) * 1.2;
        // } else if (toppingType.equals("Veggies")) {
        // calories = (2 * weight) * 0.8;
        // } else if (toppingType.equals("Cheese")) {
        // calories = (2 * weight) * 1.1;
        // } else {
        // calories = (2 * weight) * 0.9;

        // }

        calories = switch (toppingType) {
            case "Meat" -> (2 * weight) * 1.2;
            case "Veggies" -> (2 * weight) * 0.8;
            case "Cheese" -> (2 * weight) * 1.1;
            default -> (2 * weight) * 0.9;
        };

        return calories;

    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") 
        && !toppingType.equals("Veggies") 
        && !toppingType.equals("Cheese")
        && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }
}
