package InterfacesAndAbstractionEXERCISES.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> birthables = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split("\\s+");
            String currentType = data[0];

            switch (currentType) {
                case "Citizen":
                    Citizen citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    birthables.add(citizen);
                    break;
                case "Pet":
                    Pet pet = new Pet(data[1], data[2]);
                    birthables.add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        birthables.stream().map(Birthable::getBirthDate).filter(b -> b.endsWith(year)).forEach(System.out::println);

    }


}
