package PolymorphismEXERCISES.WildFarm;

public class Mouse extends Mammal {


    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }


    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            System.out.printf("Mice are not eating that type of food!%n");
        } else {
            setFoodEaten(food.getQuantity());
        }
    }


    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

}
