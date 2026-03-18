import java.util.Scanner;
import java.lang.management.*;
// 외부 패키지를 현재 클래스에 불러오기 위해 사용합니다.

public class LadyBugsLogColor {

    // ANSI 색상 정의
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🐞 무당벌레 시뮬레이션 시작");
        System.out.print("필드 크기 입력: ");
        int fieldSize = Integer.parseInt(scanner.nextLine());

        System.out.print("무당벌레 위치 입력 (공백 구분, 예: 0 3): ");
        String[] indexes = scanner.nextLine().split(" ");
        int[] ladyBugs = new int[fieldSize];

        for (String index : indexes) {
            int i = Integer.parseInt(index);
            if (i >= 0 && i < fieldSize) {
                ladyBugs[i] = 1;
            }
        }

        printField(ladyBugs); // 초기 상태 출력

        System.out.println("명령 입력 (예: 3 right 2), 종료하려면 'end':");
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] parts = command.split(" ");
            if (parts.length != 3) {
                System.out.println(RED + "⚠️ 형식 오류! 예: 1 left 2" + RESET);
                command = scanner.nextLine();
                continue;
            }

            int start = Integer.parseInt(parts[0]);
            String dir = parts[1];
            int distance = Integer.parseInt(parts[2]);

            if (distance < 0) {
                distance = Math.abs(distance);
                dir = dir.equals("left") ? "right" : "left";
            }

            System.out.printf(BLUE + "➡ 명령어: %d %s %d" + RESET + "\n", start, dir, distance);

            if (start < 0 || start >= fieldSize || ladyBugs[start] == 0) {
                System.out.printf(YELLOW + "⚠️ 무당벌레 없음 또는 잘못된 위치: %d번 칸\n" + RESET, start);
                printField(ladyBugs);
                command = scanner.nextLine();
                continue;
            }

            ladyBugs[start] = 0; // 출발
            int pos = start;
            boolean landed = false;

            while (true) {
                pos = dir.equals("right") ? pos + distance : pos - distance;

                if (pos < 0 || pos >= fieldSize) {
                    System.out.println(RED + "❗ 무당벌레가 들판을 벗어났습니다." + RESET);
                    break;
                }

                if (ladyBugs[pos] == 0) {
                    ladyBugs[pos] = 1;
                    System.out.printf(GREEN + "✅ %d번 칸에 착지 완료\n" + RESET, pos);
                    landed = true;
                    break;
                } else {
                    System.out.printf(YELLOW + "⛔ %d번 칸은 이미 차있음 → 계속 점프\n" + RESET, pos);
                }
            }

            if (!landed && pos >= 0 && pos < fieldSize) {
                System.out.println(RED + "❗ 더 이상 이동 불가, 착지 실패" + RESET);
            }

            printField(ladyBugs); // 상태 출력
            command = scanner.nextLine();
        }

        System.out.println(GREEN + "✅ 시뮬레이션 종료" + RESET);
        scanner.close();

        // === JVM 상태 정보 출력 ===
        System.out.println("\n📘 [JVM 실행 상태 및 메모리 정보]");

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryBean.getNonHeapMemoryUsage();

        System.out.printf("🧠 Heap 메모리 사용량: %.2f MB / %.2f MB%n",
                heap.getUsed() / 1024.0 / 1024, heap.getMax() / 1024.0 / 1024);
        System.out.printf("🧠 Non-Heap 메모리 사용량: %.2f MB / %.2f MB%n",
                nonHeap.getUsed() / 1024.0 / 1024, nonHeap.getMax() / 1024.0 / 1024);

        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            MemoryUsage usage = pool.getUsage();
            System.out.printf("📦 메모리 풀 [%s]: %.2f MB / %.2f MB%n",
                    pool.getName(), usage.getUsed() / 1024.0 / 1024, usage.getMax() / 1024.0 / 1024);
        }

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        System.out.printf("🧵 현재 실행 중인 스레드 수: %d%n", threadBean.getThreadCount());

        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        System.out.printf("⏳ 프로그램 실행 시간(Uptime): %.2f초%n", runtimeBean.getUptime() / 1000.0);

        ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();
        System.out.printf("📚 로딩된 클래스 수: %d개%n", classBean.getLoadedClassCount());

        // === 메모리 구조 해설 ===
        System.out.println("\n📂 [Stack과 Heap 메모리 구조 해설]");
        System.out.println("✔ Stack: 지역 변수, 메서드 호출 정보 등 (예: command, pos, start 등)");
        System.out.println("✔ Heap: 객체 및 배열 (예: ladyBugs[], Scanner, String 등)");
    }

    // 필드 시각화 출력
    private static void printField(int[] field) {
        for (int i : field) {
            System.out.print(i == 1 ? "L " : ". ");
        }
        System.out.println();
    }
}
