import java.util.Scanner;
import java.lang.management.*; // JVM 정보 출력을 위한 패키지

/**
 * 프로그램 설명:
 * 이 프로그램은 사용자가 입력한 시간(시, 분)에 15분을 더한 결과를 출력합니다.
 * 시간 입력은 24시간 형식(0~23시, 0~59분)으로 받아 처리됩니다.
 *
 * 주요 처리 과정:
 * - 전체 시간을 분 단위로 변환
 * - 15분을 더한 뒤 시/분으로 재변환
 * - 24시를 초과하는 경우 0시로 순환 처리 (modulo 연산 사용)
 *
 * JVM 관련 출력 추가:
 * - Heap/Non-Heap 메모리 사용량
 * - Loaded Class 수
 * - 실행 시간, Active Thread 수 출력
 */

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("현재 시(0~23)를 입력하세요: ");
        int hours = Integer.parseInt(scanner.nextLine());

        System.out.print("현재 분(0~59)를 입력하세요: ");
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMin = hours * 60 + minutes + 15;
        int newHour = (totalMin / 60) % 24;
        int newMin = totalMin % 60;

        System.out.println("\n🕒 다양한 시간 출력 형식:");
        System.out.printf("① 기본 포맷: %d:%02d%n", newHour, newMin);
        System.out.printf("② 한국어 스타일: %d시 %02d분%n", newHour, newMin);
        System.out.printf("③ 시도 2자리 표시: %02d:%02d%n", newHour, newMin);

        String amPm = (newHour < 12) ? "오전" : "오후";
        int hour12 = (newHour % 12 == 0) ? 12 : newHour % 12;
        System.out.printf("④ 12시간제: %s %d:%02d%n", amPm, hour12, newMin);
        System.out.printf("⑤ 영문 표현: It is %d hours and %02d minutes.%n", newHour, newMin);

        // ===== JVM 메모리 및 실행 환경 정보 출력 =====
        System.out.println("\n📊 JVM 리소스 정보:");

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryBean.getNonHeapMemoryUsage();

        System.out.printf("- 📦 Heap 사용량: %,d / %,d bytes%n", heap.getUsed(), heap.getMax());
        System.out.printf("- 📂 Non-Heap 사용량: %,d / %,d bytes%n", nonHeap.getUsed(), nonHeap.getMax());

        ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();
        System.out.printf("- 📘 로딩된 클래스 수: %,d개%n", classBean.getLoadedClassCount());

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        System.out.printf("- 🧵 활성 스레드 수: %d%n", threadBean.getThreadCount());

        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        System.out.printf("- ⏱️ 실행 시간 (ms): %,d%n", runtimeBean.getUptime());

        scanner.close();
    }
}
