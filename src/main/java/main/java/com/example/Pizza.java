package com.example;


import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;

    private Dough dough;

    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setToppings(numberOfToppings);
        setName(name);
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>();

    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;

    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double overallCalories = dough.calculateCalories();

        for (Topping topping : toppings) {
            overallCalories += topping.calculateCalories();
        }

        return overallCalories;

    }

    @Override
    public String toString(){
        return name + " - " + getOverallCalories();
    }
}
