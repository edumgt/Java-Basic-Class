import java.util.ArrayList; // ArrayList 클래스를 사용하기 위해 import
import java.util.List;      // List 인터페이스를 사용하기 위해 import

public class ListCrudExample {
    public static void main(String[] args) {
        // List 인터페이스 타입으로 선언하고 ArrayList 객체 생성
        // 제네릭 타입을 <String>으로 지정 → 문자열(String)만 저장 가능
        List<String> fruits = new ArrayList<>();

        // -----------------------------
        // C: Create (생성/추가)
        // -----------------------------
        fruits.add("Apple");   // 리스트에 "Apple" 추가 → 현재 상태: ["Apple"]
        fruits.add("Orange");  // 리스트에 "Orange" 추가 → 현재 상태: ["Apple", "Orange"]

        // -----------------------------
        // R: Read (조회)
        // -----------------------------
        System.out.println("First fruit: " + fruits.get(1));
        // get(1) → 인덱스 1의 값 "Orange" 반환
        // 출력 결과: First fruit: Orange
        // ⚠️ 주석은 인덱스 0("Apple")이라 되어 있지만 실제 코드에서는 get(1)이라 "Orange" 출력됨

        // 리스트의 모든 요소를 순회하며 출력
        for (String f : fruits) {
            System.out.println("Fruit: " + f);        // 각 요소 문자열 출력
            System.out.println("Fruit: " + f.length()); // 각 문자열의 길이 출력
            // 반복 결과:
            // Fruit: Apple
            // Fruit: 5
            // Fruit: Orange
            // Fruit: 6
        }

        // -----------------------------
        // U: Update (수정)
        // -----------------------------
        fruits.set(1, "Banana");
        // 인덱스 1의 값 "Orange" → "Banana"로 변경
        // 현재 상태: ["Apple", "Banana"]

        System.out.println(fruits.get(1));
        // get(1) → "Banana"
        // 출력 결과: Banana

        // -----------------------------
        // D: Delete (삭제)
        // -----------------------------
        fruits.remove("Apple");
        // "Apple" 요소 삭제
        // 현재 상태: ["Banana"]

        fruits.clear();
        // 리스트의 모든 요소 제거
        // 현재 상태: []
    }
}
