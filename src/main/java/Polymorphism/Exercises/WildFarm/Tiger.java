package PolymorphismEXERCISES.WildFarm;

public class Tiger extends Felime {

    private String livingRegion;


    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }


    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");

    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Meat)) {
            System.out.printf("%ss are not eating that type of food!%n", this.getClass().getSimpleName());
        } else {
            setFoodEaten(food.getQuantity());
        }
    }
}
