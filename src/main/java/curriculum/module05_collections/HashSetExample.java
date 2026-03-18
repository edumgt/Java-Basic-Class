import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // HashSet 생성
        HashSet<String> fruits = new HashSet<>();

        // 요소 추가
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple1"); // 중복 → 무시됨

        // 크기 확인
        System.out.println("과일 개수: " + fruits.size()); // 3

        // 출력 (순서는 보장되지 않음)
        System.out.println("과일 목록: " + fruits);

        // 포함 여부 확인
        System.out.println("Banana 포함? " + fruits.contains("Banana"));

        // 요소 제거
        fruits.remove("Orange");
        System.out.println("Orange 제거 후: " + fruits);
    }
}
