package PolymorphismEXERCISES.WildFarm;


import java.text.DecimalFormat;

public class Cat extends Felime {

    private String catBreed;


    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String catBreed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.catBreed = catBreed;
    }

    public String getCatBreed() {
        return this.catBreed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");

    }

    @Override
    public void eat(Food food) {
        setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(), getAnimalName(), getCatBreed(), df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
