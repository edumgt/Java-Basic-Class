package InterfacesAndAbstractionEXERCISES.FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        for (int i = 0; i < people; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            if (data.length == 3) {
                String group = data[2];
                Rebel rebel = new Rebel(name, age, group);
                buyers.put(rebel.getName(), rebel);
            } else {
                String id = data[2];
                String birthDate = data[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);
                buyers.put(citizen.getName(), citizen);
            }

        }

        String currentName = scanner.nextLine();

        while (!"End".endsWith(currentName)) {

            Buyer buyer = buyers.get(currentName);

            if (buyer != null){
                buyer.buyFood();
            }

            currentName = scanner.nextLine();
        }

        int allFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(allFood);
    }


}
