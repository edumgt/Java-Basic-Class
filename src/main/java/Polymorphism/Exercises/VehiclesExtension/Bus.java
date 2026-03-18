package PolymorphismEXERCISES.VehiclesExtension;

public class Bus extends Vehicle {

    public static final double AC_ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKm + AC_ADDITIONAL_CONSUMPTION, tankCapacity);
    }

    public String driveEmpty(double distance) {
        this.fuelConsumptionPerKm -= AC_ADDITIONAL_CONSUMPTION;
        String result = super.driving(distance);
        this.fuelConsumptionPerKm += AC_ADDITIONAL_CONSUMPTION;
        return result;
    }


}
