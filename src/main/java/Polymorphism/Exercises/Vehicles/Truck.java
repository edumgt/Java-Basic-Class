package PolymorphismEXERCISES.Vehicles;

public class Truck extends Vehicle {

    public static final double AC_ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm + AC_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters * 0.95);

    }
}
