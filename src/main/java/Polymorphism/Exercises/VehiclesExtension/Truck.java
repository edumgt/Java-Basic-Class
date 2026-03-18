package PolymorphismEXERCISES.VehiclesExtension;

public class Truck extends Vehicle {

    public static final double AC_ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm + AC_ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    @Override
    public void refueling(double liters) {
        super.refueling(liters * 0.95);

    }
}
