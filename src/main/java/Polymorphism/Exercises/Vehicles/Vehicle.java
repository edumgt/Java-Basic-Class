package PolymorphismEXERCISES.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    protected double fuelQuantity;

    protected double fuelConsumptionPerKm;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
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
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }

}
