package InheritanceEXERCISES.NeedForSpeed;

public class Vehicle {

    final static double DEFAULT_FUEL_CONSUMPTION = 1.25;

    private double fuelConsumption;

    private double fuel;

    private int horsePower;

    public Vehicle(double fuel, int horsePower) {
        setFuel(fuel);
        setHorsePower(horsePower);
        setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);

    }

    public void drive(double kilometers) {
        double neededFuel = kilometers * fuelConsumption;
        if (fuel >= neededFuel) {
            fuel -= neededFuel;
        }
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
