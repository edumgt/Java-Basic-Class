package PolymorphismEXERCISES.WildFarm;


import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    protected Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            System.out.printf("%ss are not eating that type of food!%n", this.getClass().getSimpleName());
        } else {
            setFoodEaten(food.getQuantity());
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", getAnimalType(), getAnimalName(), df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
