import java.lang.management.*; // JVM 관리 인터페이스 전부 import
import java.util.List;

/**
 * JVM이 현재 사용하는 리소스 상태를 출력하는 예제입니다.
 * java.lang.management 패키지를 사용합니다.
 */
public class SystemMetricsDemo {
    public static void main(String[] args) {
        System.out.println("🧠 JVM 런타임 리소스 정보 출력\n");

        // 🔹 Memory (Heap, Non-Heap)
        MemoryMXBean memoryMXBean = ManagementFactory
        .getMemoryMXBean();
        MemoryUsage heap = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("📦 Heap Memory:");
        System.out.printf("   사용 중: %.2f MB%n", 
        heap.getUsed() / 1024.0 / 1024);
        System.out.printf("   최대 허용: %.2f MB%n", 
        heap.getMax() / 1024.0 / 1024);

        System.out.println("📦 Non-Heap Memory:");
        System.out.printf("   사용 중: %.2f MB%n", 
        nonHeap.getUsed() / 1024.0 / 1024);
        System.out.printf("   최대 허용: %.2f MB%n", 
        nonHeap.getMax() / 1024.0 / 1024);

        // 🔹 Thread 정보
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        System.out.println("🧵 스레드 정보:");
        System.out.printf("   실행 중인 스레드 수: %d%n", 
        threadMXBean.getThreadCount());
        System.out.printf("   데몬 스레드 수: %d%n", 
        threadMXBean.getDaemonThreadCount());
        System.out.printf("   총 생성된 스레드 수: %d%n", 
        threadMXBean.getTotalStartedThreadCount());

        // 🔹 클래스 로딩 정보
        ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();
        System.out.println("📚 클래스 로딩 정보:");
        System.out.printf("   현재 로딩된 클래스 수: %d%n", 
        classBean.getLoadedClassCount());
        System.out.printf("   총 로딩된 클래스 수: %d%n", 
        classBean.getTotalLoadedClassCount());
        System.out.printf("   언로딩된 클래스 수: %d%n", 
        classBean.getUnloadedClassCount());

        // 🔹 운영체제 및 CPU 정보
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("💻 OS 및 CPU 정보:");
        System.out.printf("   운영체제: %s (%s) %s%n", 
        osBean.getName(), osBean.getArch(), osBean.getVersion());
        System.out.printf("   CPU 코어 수: %d%n", 
        osBean.getAvailableProcessors());
        System.out.printf("   시스템 부하 평균 (최근 1분): %.2f%n", 
        osBean.getSystemLoadAverage());

        // 🔹 런타임 정보
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        System.out.println("⏱ 실행 정보:");
        System.out.printf("   JVM 이름: %s%n", runtimeBean.getVmName());
        System.out.printf("   시작 시간: %d ms (Epoch 기준)%n", 
        runtimeBean.getStartTime());
        System.out.printf("   실행 시간: %d ms%n", 
        runtimeBean.getUptime());

        // 🔹 Garbage Collector 정보
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        System.out.println("♻️ 가비지 컬렉터:");
        for (GarbageCollectorMXBean gc : gcBeans) {
            System.out.printf("   - %s: %d회 수집, 총 시간: %d ms%n",
                    gc.getName(), gc.getCollectionCount(), gc.getCollectionTime());
        }

        System.out.println("\n✅ 리소스 정보 출력 완료.");
    }
}
