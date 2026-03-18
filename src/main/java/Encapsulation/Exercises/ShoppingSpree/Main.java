package EncapsulationEXERCISES.ShoppingSpree;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        LinkedHashMap<String, Product> products = new LinkedHashMap<>();

        String[] peopleData = scanner.nextLine().split("\\;");

        for (String peopleDatum : peopleData) {
            String name = peopleDatum.split("\\=")[0];
            double money = Double.parseDouble(peopleDatum.split("\\=")[1]);

            try {
                Person person = new Person(name, money);
                people.put(person.getName(), person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productsData = scanner.nextLine().split("\\;");

        for (String productDatum : productsData) {
            String name = productDatum.split("\\=")[0];
            double cost = Double.parseDouble(productDatum.split("\\=")[1]);

            try {
                Product product = new Product(name, cost);
                products.put(product.getName(), product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String personName = command.split("\\s+")[0];
            String productName = command.split("\\s+")[1];

            Person buyer = people.get(personName);
            Product product = products.get(productName);

            try {
                buyer.buyProduct(product);
                System.out.println(buyer.getName() + " bought " + product.getName());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();

        }

        products.values().forEach(System.out::println);
    }
}
