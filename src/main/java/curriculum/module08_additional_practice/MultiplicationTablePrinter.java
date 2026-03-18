import java.util.Scanner;

public class MultiplicationTablePrinter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter table number (2~9): ");
            int n = scanner.nextInt();
            for (int i = 1; i <= 9; i++) {
                System.out.printf("%d x %d = %d%n", n, i, n * i);
            }
        }
    }
}
