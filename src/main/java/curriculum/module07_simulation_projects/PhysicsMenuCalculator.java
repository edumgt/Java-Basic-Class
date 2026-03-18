import java.util.InputMismatchException;
import java.util.Scanner;

public class PhysicsMenuCalculator {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\n🚀 Physics Mini Calculator (m, s 단위)\n");
                System.out.println("메뉴를 선택하세요:");
                System.out.println("  1. 가속도 (Acceleration)");
                System.out.println("  2. 평균 속도 (Average Velocity)");
                System.out.println("  3. 이동 거리 (Distance)");
                System.out.println("  9. JVM 상태 출력");
                System.out.println("  0. 종료");
                System.out.print("\n👉 선택: ");

                int choice = safeReadInt(input);

                switch (choice) {
                    case 1:
                        double u1 = safeReadDouble(input, "초기 속도 (m/s): ");
                        double v1 = safeReadDouble(input, "최종 속도 (m/s): ");
                        double t1 = safeReadDouble(input, "시간 (s): ");
                        double acceleration = (v1 - u1) / t1;
                        System.out.println("\n▶ 가속도 = " + String.format("%.4f", acceleration) + " m/s^2");
                        break;

                    case 2:
                        double u2 = safeReadDouble(input, "초기 속도 (m/s): ");
                        double v2 = safeReadDouble(input, "최종 속도 (m/s): ");
                        double avg_velocity = (u2 + v2) / 2.0;
                        System.out.println("\n▶ 평균 속도 = " + String.format("%.4f", avg_velocity) + " m/s");
                        break;

                    case 3:
                        double u3 = safeReadDouble(input, "초기 속도 (m/s): ");
                        double v3 = safeReadDouble(input, "최종 속도 (m/s): ");
                        double t3 = safeReadDouble(input, "시간 (s): ");
                        double avg_v3 = (u3 + v3) / 2.0;
                        double distance = avg_v3 * t3;
                        System.out.println("\n▶ 이동 거리 = " + String.format("%.4f", distance) + " m");
                        break;

                    case 9: // JVM 상태 출력
                        printJvmStatus();
                        break;

                    case 0:
                        System.out.println("\n👋 프로그램을 종료합니다.");
                        running = false;
                        break;

                    default:
                        System.out.println("\n❌ 잘못된 선택입니다. (0~3, 9 입력)");
                }
            }
        }
    }

    // ✅ 안전하게 int 입력받기
    private static int safeReadInt(Scanner input) {
        while (true) {
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("❌ 잘못된 입력입니다. 정수를 입력하세요: ");
                input.nextLine();
            }
        }
    }

    // ✅ 안전하게 double 입력받기
    private static double safeReadDouble(Scanner input, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return input.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("❌ 잘못된 입력입니다. 숫자를 입력하세요.");
                input.nextLine();
            }
        }
    }

    // ✅ JVM 상태 출력 함수
    private static void printJvmStatus() {
        Runtime rt = Runtime.getRuntime();

        long total = rt.totalMemory() / (1024 * 1024);
        long free = rt.freeMemory() / (1024 * 1024);
        long max = rt.maxMemory() / (1024 * 1024);

        Thread current = Thread.currentThread();
        ClassLoader loader = PhysicsMenuCalculator.class.getClassLoader();

        System.out.println("\n🖥 JVM 상태 출력 -------------------");
        System.out.println("▶ 힙 메모리 총량 (total): " + total + " MB");
        System.out.println("▶ 사용 가능 메모리 (free): " + free + " MB");
        System.out.println("▶ JVM 최대 메모리 (max): " + max + " MB");
        System.out.println("\n▶ 현재 스레드: " + current.getName() +
                           " (ID=" + current.getId() + ", 상태=" + current.getState() + ")");
        System.out.println("▶ 클래스 로더: " + loader);
        System.out.println("-----------------------------------\n");
    }
}
