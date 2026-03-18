package PolymorphismEXERCISES.VehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {

    protected double tankCapacity;

    protected double fuelQuantity;

    protected double fuelConsumptionPerKm;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public String driving(double distance) {
        DecimalFormat df = new DecimalFormat("##.##");
        double neededFuel = distance * fuelConsumptionPerKm;
        if (this.fuelQuantity >= neededFuel) {
            this.fuelQuantity -= neededFuel;
            return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
        }
        return String.format("%s needs refueling", this.getClass().getSimpleName());
    }

    public void refueling(double liters) {
        if (fuelQuantity + liters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        } else if (liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        fuelQuantity += liters;

    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }

}
