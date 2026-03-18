package ObjectsAndClassesEXERCISE.OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> peopleList = new ArrayList<>();
        String personData = scanner.nextLine();
        while (!personData.equals("End")){
            String name = personData.split(" ")[0];
            String ID = personData.split(" ")[1];
            int age = Integer.parseInt(personData.split(" ")[2]);
            Person person = new Person(name, ID, age);
            peopleList.add(person);
            personData = scanner.nextLine();
        }
        peopleList.sort(Comparator.comparingInt(Person :: getAge));
        for (Person person : peopleList){
            System.out.println(person.toString());
        }
    }
}
