import java.lang.management.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 프로그램 설명:
 * 이 프로그램은 문자열에서 숫자와 문자를 분리한 후,
 * 숫자를 이용해 'take' 및 'skip' 명령을 만들어 메시지를 추출합니다.
 *
 * JVM 자원(메모리, 트리드, 클래스 로딩) 정보도 포함하여
 * 규정한 시간에 이 프로그램이 어떻게 JVM의 Stack/Heap을 사용하는지 확인가능.
 */
public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\u2753 \uba54시지를 입력하세요 (문자+숫자 혼합): ");
        StringBuilder messageBuilder = new StringBuilder(scanner.nextLine());

        List<Integer> allNumbers = new ArrayList<>();

        // 숫자 발견시 Heap에서 StringBuilder 가공하고 Stack에서 i 차례
        for (int i = 0; i < messageBuilder.length(); i++) {
            char currentSymbol = messageBuilder.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                allNumbers.add(Character.getNumericValue(currentSymbol));
                messageBuilder.deleteCharAt(i);
                i--;
            }
        }

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < allNumbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(allNumbers.get(i));
            } else {
                skipList.add(allNumbers.get(i));
            }
        }

        StringBuilder resultString = new StringBuilder();
        int minSize = Math.min(takeList.size(), skipList.size());

        for (int i = 0; i < minSize; i++) {
            int takeNum = takeList.get(i);
            int skipNum = skipList.get(i);

            if (takeNum > 0) {
                int takeLen = Math.min(takeNum, messageBuilder.length());
                resultString.append(messageBuilder, 0, takeLen);
                messageBuilder.delete(0, takeLen);
            }
            if (skipNum > 0) {
                int skipLen = Math.min(skipNum, messageBuilder.length());
                messageBuilder.delete(0, skipLen);
            }
        }

        if (takeList.size() > skipList.size()) {
            int lastTake = takeList.get(takeList.size() - 1);
            int takeLen = Math.min(lastTake, messageBuilder.length());
            resultString.append(messageBuilder, 0, takeLen);
        }

        System.out.println("\ud83d\udce8 \ucd94출된 \uba54시지: " + resultString);

        // === JVM 리소스 표시 ===
        System.out.println("\n\ud83d\udd27 JVM 실행 정보:");
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryBean.getNonHeapMemoryUsage();

        System.out.printf("\ud83e\udde0 Heap: %.2f MB used / %.2f MB max\n", heap.getUsed() / 1024.0 / 1024, heap.getMax() / 1024.0 / 1024);
        System.out.printf("\ud83e\udde0 Non-Heap: %.2f MB used / %.2f MB max\n", nonHeap.getUsed() / 1024.0 / 1024, nonHeap.getMax() / 1024.0 / 1024);

        for (MemoryPoolMXBean pool : ManagementFactory.getMemoryPoolMXBeans()) {
            MemoryUsage usage = pool.getUsage();
            System.out.printf("\ud83d\udce6 %s: %.2f MB used / %.2f MB max\n",
                    pool.getName(), usage.getUsed() / 1024.0 / 1024, usage.getMax() / 1024.0 / 1024);
        }

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        System.out.printf("\ud83e\udde5 \ud2b8\ub9ac\ub4dc: %d\uac1c running\n", threadBean.getThreadCount());

        ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();
        System.out.printf("\ud83d\udcd6 \ub85c딩된 \ud074래스: %d\uac1c\n", classBean.getLoadedClassCount());

        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        System.out.printf("\u23f3 \uc2dc작 \uc9c0방: %.2f \ucd08\n", runtimeBean.getUptime() / 1000.0);

        scanner.close();
    }
}
