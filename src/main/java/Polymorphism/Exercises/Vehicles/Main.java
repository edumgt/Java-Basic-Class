package PolymorphismEXERCISES.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));

        String[] truckInput = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));

        int commands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String currentCommand = input[0];
            String currentVehicle = input[1];

            switch (currentCommand) {
                case "Drive":
                    double distance = Double.parseDouble(input[2]);
                    if (currentVehicle.equals("Car")) {
                        System.out.println(car.driving(distance));
                    } else {
                        System.out.println(truck.driving(distance));
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(input[2]);
                    if (currentVehicle.equals("Car")) {
                        car.refueling(liters);
                    } else {
                        truck.refueling(liters);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);


    }
}
