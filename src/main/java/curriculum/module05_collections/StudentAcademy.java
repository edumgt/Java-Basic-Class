
/**
 * 📚 프로그램 설명:
 * 이 프로그램은 학생 이름과 성적(grade)을 입력받아,
 * 동일한 학생의 경우 성적을 평균 내고,
 * 평균 성적이 4.50 이상인 학생만 필터링해서 출력합니다.
 *
 * 예시 입력:
 * 3
 * Alice
 * 5.0
 * Bob
 * 4.0
 * Alice
 * 6.0
 *
 * 출력:
 * Alice -> 5.50
 *
 * 💡 특징:
 * - LinkedHashMap을 사용해 입력 순서를 유지
 * - 람다식과 Stream API를 활용한 필터링 및 출력
 * - Map.merge 또는 Stream의 filter/map 등을 학습할 수 있음
 *
 * 🧩 Spring 예시 연계:
 * - 성적 처리 API 컨트롤러에서 Map<String, Double>으로 학생 성적 관리 가능
 * - Stream을 활용해 학생 필터링 또는 정렬된 결과 반환 가능
 * - @RequestBody를 통해 JSON → Map 변환 후 stream 처리
 */
import java.lang.management.*;
import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        System.out.println("\n🧠 JVM 메모리 구조 설명 시작");
        System.out.println("🔸 Stack: 지역 변수 및 참조가 저장됩니다.");
        System.out.println("🔹 Heap: 객체(Map, Scanner 등)가 저장됩니다.");
        System.out.println("🗂️ Metaspace: 클래스 메타정보가 저장됩니다.\n");

        Scanner scanner = new Scanner(System.in); // Stack에 참조, Heap에 객체

        Map<String, Double> grades = new LinkedHashMap<>(); // Heap에 저장, 참조는 Stack

        System.out.print("입력할 학생 수를 입력하세요: ");
        int rows = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= rows; i++) {
            System.out.printf("학생 %d의 이름을 입력하세요: ", i);
            String name = scanner.nextLine();

            System.out.printf("학생 %d의 성적을 입력하세요: ", i);
            double grade = Double.parseDouble(scanner.nextLine());

            if (!grades.containsKey(name)) {
                grades.put(name, grade);
            } else {
                double newGrade = (grades.get(name) + grade) / 2;
                grades.put(name, newGrade);
            }
        }

        System.out.println("\n📊 평균 4.50 이상 학생 명단:");
        grades.entrySet().stream()
                .filter(student -> student.getValue() >= 4.50)
                .forEach(student -> System.out.printf("%s -> %.2f%n",
                        student.getKey(),
                        student.getValue()));

        // 🔍 JVM 실행 리소스 출력
        System.out.println("\n🧪 JVM 리소스 상태:");
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryBean.getNonHeapMemoryUsage();

        System.out.printf("🧠 Heap 메모리: %.2f MB / %.2f MB%n",
                heap.getUsed() / 1024.0 / 1024, heap.getMax() / 1024.0 / 1024);
        System.out.printf("🧠 Non-Heap 메모리: %.2f MB / %.2f MB%n",
                nonHeap.getUsed() / 1024.0 / 1024, nonHeap.getMax() / 1024.0 / 1024);

        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            MemoryUsage usage = pool.getUsage();
            System.out.printf("📦 %s: %.2f MB / %.2f MB%n",
                    pool.getName(), usage.getUsed() / 1024.0 / 1024, usage.getMax() / 1024.0 / 1024);
        }

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        System.out.printf("\n🧵 현재 스레드 수: %d개%n", threadBean.getThreadCount());

        ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();
        System.out.printf("📚 로딩된 클래스 수: %d개%n", classBean.getLoadedClassCount());

        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        System.out.printf("⏱️ 프로그램 Uptime: %.2f초%n", runtime.getUptime() / 1000.0);

        scanner.close();
    }
}
