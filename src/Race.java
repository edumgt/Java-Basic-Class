import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.lang.management.*;

public class Race {
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println(BLUE + "\n🚀 [JVM 구조 설명]" + RESET);
        System.out.println("🔸 Stack: 지역 변수 및 참조값 저장");
        System.out.println("🔹 Heap: 객체(Map, Scanner 등)가 저장됨");
        System.out.println("📘 Metaspace: 클래스 메타정보 저장\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("참가자 이름을 ', '로 구분하여 입력하세요: ");
        Map<String, Integer> participantsInfo = new LinkedHashMap<>();
        List<String> participants = Arrays
                .stream(scanner.nextLine().split(",\\s*"))
                .collect(Collectors.toList());
        participants.forEach(p -> participantsInfo.put(p, 0));

        Pattern namePattern = Pattern.compile("[A-Za-z]+");
        Pattern kilometersPattern = Pattern.compile("[0-9]");

        System.out.println("\n경주 로그 데이터를 입력하세요 (end of race 입력 시 종료):");
        String input = scanner.nextLine();

        while (!input.equals("end of race")) {
            Matcher nameMatcher = namePattern.matcher(input);
            StringBuilder nameBuilder = new StringBuilder();
            while (nameMatcher.find())
                nameBuilder
                        .append(nameMatcher.group());
            String currentName = nameBuilder.toString();

            Matcher kmMatcher = kilometersPattern.matcher(input);
            int currentKm = 0;
            while (kmMatcher.find())
                currentKm += Integer.parseInt(kmMatcher.group());

            if (participants.contains(currentName)) {
                int newKm = participantsInfo.get(currentName) + currentKm;
                participantsInfo.put(currentName, newKm);
            }
            input = scanner.nextLine();
        }

        List<Map.Entry<String, Integer>> top3 = participantsInfo
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("\n🏁 결과 발표:");
        System.out.printf("1st place: %s (%d km)%n", top3.get(0).getKey(), top3.get(0).getValue());
        System.out.printf("2nd place: %s (%d km)%n", top3.get(1).getKey(), top3.get(1).getValue());
        System.out.printf("3rd place: %s (%d km)%n", top3.get(2).getKey(), top3.get(2).getValue());

        // 🔍 JVM 리소스 사용 정보
        System.out.println(BLUE + "\n📊 [JVM 리소스 상태 정보]" + RESET);

        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

        System.out.printf("Heap 메모리: %.2f MB / %.2f MB%n",
                heap.getUsed() / 1024.0 / 1024, heap.getMax() / 1024.0 / 1024);
        System.out.printf("Non-Heap 메모리: %.2f MB / %.2f MB%n",
                nonHeap.getUsed() / 1024.0 / 1024, nonHeap.getMax() / 1024.0 / 1024);

        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            if (pool.getName().contains("Metaspace")) {
                MemoryUsage usage = pool.getUsage();
                System.out.printf("Metaspace: %.2f MB / %.2f MB%n",
                        usage.getUsed() / 1024.0 / 1024, usage.getMax() / 1024.0 / 1024);
            }
        }

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        System.out.printf("활성 스레드 수: %d%n", threadBean.getThreadCount());

        ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();
        System.out.printf("로딩된 클래스 수: %d%n", classBean.getLoadedClassCount());

        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        System.out.printf("JVM 실행 시간: %.2f 초%n", runtimeBean.getUptime() / 1000.0);

        scanner.close();
        System.out.println(GREEN + "\n✅ 프로그램 종료" + RESET);
    }
}

/**
 * 프로그램 설명:
 * 이 프로그램은 경주 대회 참가자들의 문자열 입력 데이터를 통해
 * 각 참가자의 이름과 달린 거리(km)를 파싱하고,
 * 가장 많이 달린 상위 3명의 이름과 해당 거리를 출력합니다.
 *
 * 입력 형식은 문자+숫자 혼합이며, 문자 부분은 이름, 숫자는 달린 거리로 인식됩니다.
 *
 * 예시 입력:
 * George, Peter, Bill
 * G4e@55or%6g6!68e!!@
 * e!!@2@34r@r@t334P%et%^#e5346r
 * e@345ll34@@i433ll
 * end of race
 *
 * 출력 예시:
 * 1st place: George (98 km)
 * 2nd place: Peter (78 km)
 * 3rd place: Bill (65 km)
 * 추출 과정:
 * 문자 제외하고 숫자만 추출 → 4, 5, 5, 6, 6, 8
 * 
 * 합산 결과 → 4 + 5 + 5 + 6 + 6 + 8 = 34
 * 
 * → 이 입력 줄에서 참가자 이름 George가 34 km 달렸다고 인식됩니다.
 * 
 * z3x4c5
 * as33d45@@@@@@@
 * q22w11@@@@@@@@@@@@@@e5
 * end of race
 * ? 결과 발표:
 * 1st place: asd (15 km)
 * 2nd place: zxc (12 km)
 * 3rd place: qwe (11 km)
 */
