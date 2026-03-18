import java.util.Scanner;
import java.lang.management.*;

public class NumberPyramidEnhanced {

    // ANSI 색상 코드
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    // 색상 배열 (행 번호에 따라 색상 순환)
    public static final String[] COLORS = { GREEN, YELLOW, RED, BLUE, PURPLE, CYAN };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력
        System.out.print("\uD83D\uDCCC 숫자 피라미드의 마지막 숫자 n을 입력하세요: ");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.print("\uD83D\uDD22 별 대신 숫자를 출력하시겠습니까? (yes/no): ");
        boolean useNumbers = scanner
                .nextLine()
                .trim()
                .equalsIgnoreCase("yes");

        int currentNumber = 0;
        boolean isDone = false;

        System.out.println("\n\uD83C\uDFAF 피라미드 출력:\n");

        for (int row = 1; row <= n; row++) {
            // 줄 시작 시 색상 선택
            String color = COLORS[(row - 1) % COLORS.length];

            // 우측 정렬을 위한 공백 출력
            for (int s = 0; s < n - row; s++) {
                System.out.print("  "); // 2칸 공백
            }

            for (int j = 1; j <= row; j++) {
                currentNumber++;
                if (currentNumber > n) {
                    isDone = true;
                    break;
                }

                // 출력: 숫자 또는 별, 색상 포함
                String value = useNumbers ? String.valueOf(currentNumber) : "*";
                System.out.print(color + value + " " + RESET);
            }

            System.out.println(); // 줄 바꿈

            if (isDone)
                break;
        }

        // JVM 리소스 정보 출력
        System.out.println("\n\uD83D\uDEE0 JVM 리소스 정보:");
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryBean.getNonHeapMemoryUsage();

        System.out.printf("\uD83E\uDDE0 Heap 메모리 사용량: %.2f MB / %.2f MB\n",
                heap.getUsed() / 1024.0 / 1024, heap.getMax() / 1024.0 / 1024);
        System.out.printf("\uD83E\uDDE0 Non-Heap 메모리 사용량: %.2f MB / %.2f MB\n",
                nonHeap.getUsed() / 1024.0 / 1024, nonHeap.getMax() / 1024.0 / 1024);

        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            MemoryUsage usage = pool.getUsage();
            System.out.printf("\uD83D\uDD39 메모리 풀 [%s]: %.2f MB 사용 / %.2f MB 한도\n",
                    pool.getName(), usage.getUsed() / 1024.0 / 1024, usage.getMax() / 1024.0 / 1024);
        }

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        System.out.printf("\uD83E\uDDD5\u200D\u2642\uFE0F 현재 실행 중인 스레드 수: %d개\n", threadBean.getThreadCount());

        ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();
        System.out.printf("\uD83D\uDCDA 로딩된 클래스 수: %d개\n", classBean.getLoadedClassCount());

        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        System.out.printf("\u23F3 프로그램 실행 시간: %.2f초\n", runtimeBean.getUptime() / 1000.0);

        scanner.close();
    }
}
