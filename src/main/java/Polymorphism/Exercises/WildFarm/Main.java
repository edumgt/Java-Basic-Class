package PolymorphismEXERCISES.WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] animalData = input.split("\\s+");
            Animal animal = createAnimal(animalData);

            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = createFood(foodData);

            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);

    }


    private static Food createFood(String[] foodData) {
        String foodType = foodData[0];
        Integer foodQuantity = Integer.parseInt(foodData[1]);

        Food food = null;

        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(foodQuantity);
                break;
            case "Meat":
                food = new Meat(foodQuantity);
                break;
        }

        return food;

    }

    private static Animal createAnimal(String[] animalData) {
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];

        Animal animal = null;

        switch (animalType) {
            case "Mouse":
                animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                break;
            case "Cat":
                String catBreed = animalData[4];
                animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                break;
            case "Tiger":
                animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                break;
        }

        return animal;
    }
}
