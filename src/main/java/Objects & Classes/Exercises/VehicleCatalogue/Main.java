package ObjectsAndClassesEXERCISE.VehicleCatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCars = 0;
        int totalTrucks = 0;
        double carsHorsepower = 0;
        double trucksHorsepower = 0;
        List<Vehicle> vehiclesList = new ArrayList<>();
        String vehicleData = scanner.nextLine();
        while (!vehicleData.equals("End")){
            String type = vehicleData.split(" ")[0];
            String model = vehicleData.split(" ")[1];
            String color = vehicleData.split(" ")[2];
            int horsepower = Integer.parseInt(vehicleData.split(" ")[3]);
            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehiclesList.add(vehicle);
            if (type.equals("car")){
                carsHorsepower += horsepower;
                totalCars++;
            } else {
                trucksHorsepower += horsepower;
                totalTrucks++;
            }
            vehicleData = scanner.nextLine();
        }
        String model = scanner.nextLine();
        while (!model.equals("Close the Catalogue")){
            for (Vehicle vehicle : vehiclesList){
                String currentModel = vehicle.getModel();
                if (model.equals(currentModel)){
                    System.out.println(vehicle);
                }
            }
            model = scanner.nextLine();
        }
        double averageCarsHorsepower = carsHorsepower / totalCars;
        double averageTrucksHorsepower = trucksHorsepower / totalTrucks;
        if (totalCars == 0){
            averageCarsHorsepower = 0;
        }
        if (totalTrucks == 0){
            averageTrucksHorsepower = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarsHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTrucksHorsepower);
    }
}
