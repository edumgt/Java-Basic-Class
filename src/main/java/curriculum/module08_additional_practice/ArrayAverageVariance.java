import java.util.Scanner;

public class ArrayAverageVariance {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("How many numbers? ");
            int n = scanner.nextInt();
            if (n <= 0) {
                System.out.println("n must be positive.");
                return;
            }

            double[] values = new double[n];
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                System.out.print("values[" + i + "] = ");
                values[i] = scanner.nextDouble();
                sum += values[i];
            }

            double avg = sum / n;
            double variance = 0.0;
            for (double value : values) {
                double diff = value - avg;
                variance += diff * diff;
            }
            variance /= n;

            System.out.printf("Average: %.4f%n", avg);
            System.out.printf("Variance: %.4f%n", variance);
        }
    }
}
