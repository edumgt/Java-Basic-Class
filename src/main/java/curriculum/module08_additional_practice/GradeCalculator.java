import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter score (0~100): ");
            int score = scanner.nextInt();

            if (score < 0 || score > 100) {
                System.out.println("Invalid score range.");
                return;
            }

            String grade;
            if (score >= 90) {
                grade = "A";
            } else if (score >= 80) {
                grade = "B";
            } else if (score >= 70) {
                grade = "C";
            } else if (score >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            System.out.println("Grade: " + grade);
        }
    }
}
