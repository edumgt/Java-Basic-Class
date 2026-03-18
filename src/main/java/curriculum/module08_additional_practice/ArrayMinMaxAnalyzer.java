import java.util.Scanner;

public class ArrayMinMaxAnalyzer {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("How many numbers? ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("n must be positive.");
                return;
            }

            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("numbers[" + i + "] = ");
                numbers[i] = scanner.nextInt();
            }

            int min = numbers[0];
            int max = numbers[0];
            for (int value : numbers) {
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
            }

            System.out.println("Min: " + min);
            System.out.println("Max: " + max);
        }
    }
}
