package EncapsulationEXERCISES.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;

    private double money;

    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (money < product.getCost()) {
            throw new IllegalArgumentException(getName() + " can't afford " + product.getName());
        }
        products.add(product);
        money -= product.getCost();

    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    @Override
    public String toString() {
        if (!products.isEmpty()) {
            return String.format("%s - %s", this.name, products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        } else {
            return String.format("%s - Nothing bought", this.name);
        }
    }


}
