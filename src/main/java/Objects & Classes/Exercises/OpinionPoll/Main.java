package ObjectsAndClassesEXERCISE.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= number ; i++) {
            String input = scanner.nextLine();
            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            if (age > 30){
                Person currentPerson = new Person(name, age);
                people.add(currentPerson);
            }
        }
        for (Person person : people){
            System.out.printf("%s - %d%n", person.getName(), person.getAge());
        }
    }
}
