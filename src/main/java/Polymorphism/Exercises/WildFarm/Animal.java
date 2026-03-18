package PolymorphismEXERCISES.WildFarm;

public abstract class Animal {

    private String animalName;

    private String animalType;

    private Double animalWeight;

    private Integer foodEaten = 0;

    protected Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
    }

    protected String getAnimalName() {
        return animalName;
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected String getAnimalType() {
        return animalType;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected Double getAnimalWeight() {
        return animalWeight;
    }

    protected void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten += foodEaten;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);


}
