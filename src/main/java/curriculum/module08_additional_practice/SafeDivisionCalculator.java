import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeDivisionCalculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Dividend: ");
            double a = scanner.nextDouble();
            System.out.print("Divisor: ");
            double b = scanner.nextDouble();

            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero.");
            }

            System.out.println("Result: " + (a / b));
        } catch (InputMismatchException e) {
            System.out.println("Invalid number format.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
