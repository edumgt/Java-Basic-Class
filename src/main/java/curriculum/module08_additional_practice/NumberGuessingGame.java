import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(100) + 1;
        int attempts = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Guess the number (1~100)");
            while (true) {
                System.out.print("Input: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < target) {
                    System.out.println("Too low.");
                } else if (guess > target) {
                    System.out.println("Too high.");
                } else {
                    System.out.println("Correct! attempts=" + attempts);
                    break;
                }
            }
        }
    }
}
