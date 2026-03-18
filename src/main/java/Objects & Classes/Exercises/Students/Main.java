package ObjectsAndClassesEXERCISE.Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentsList = new ArrayList<>();
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= count ; i++) {
            String studentData = scanner.nextLine();
            String firstName = studentData.split(" ")[0];
            String lastName = studentData.split(" ")[1];
            double grade = Double.parseDouble(studentData.split(" ")[2]);
            Student student = new Student(firstName, lastName, grade);
            studentsList.add(student);
        }
        studentsList.sort(Comparator.comparingDouble(Student :: getGrade).reversed());
        for (Student student : studentsList){
            System.out.println(student.toString());
        }
    }
}
