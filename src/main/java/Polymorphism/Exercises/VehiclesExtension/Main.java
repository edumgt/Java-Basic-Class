package PolymorphismEXERCISES.VehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInput = scanner.nextLine().split("\\s+");
        String[] truckInput = scanner.nextLine().split("\\s+");
        String[] busInput = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]), Double.parseDouble(carInput[3]));
        Truck truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]), Double.parseDouble(truckInput[3]));
        Bus bus = new Bus(Double.parseDouble(busInput[1]), Double.parseDouble(busInput[2]), Double.parseDouble(busInput[3]));

        int commands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commands; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String currentCommand = input[0];
            String currentVehicle = input[1];
            double argument = Double.parseDouble(input[2]);

            try {
                switch (currentCommand) {
                    case "Drive":
                        if (currentVehicle.equals("Car")) {
                            System.out.println(car.driving(argument));
                        } else if (currentVehicle.equals("Truck")) {
                            System.out.println(truck.driving(argument));
                        } else {
                            System.out.println(bus.driving(argument));
                        }
                        break;
                    case "DriveEmpty":
                        System.out.println(bus.driveEmpty(argument));
                        break;
                    case "Refuel":
                        if (currentVehicle.equals("Car")) {
                            car.refueling(argument);
                        } else if (currentVehicle.equals("Truck")) {
                            truck.refueling(argument);
                        } else {
                            bus.refueling(argument);
                        }
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);


    }
}
