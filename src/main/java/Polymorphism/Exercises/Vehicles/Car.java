package PolymorphismEXERCISES.Vehicles;

public class Car extends Vehicle {

    public static final double AC_ADDITIONAL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm + AC_ADDITIONAL_CONSUMPTION);
    }

}
