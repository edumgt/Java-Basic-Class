import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        // Vector 생성 (초기 용량 10)
        Vector<String> fruits = new Vector<>();

        // -----------------------------
        // C: Create (추가)
        // -----------------------------
        fruits.add("Apple");   // ["Apple"]
        fruits.add("Banana");  // ["Apple", "Banana"]
        fruits.add("Orange");  // ["Apple", "Banana", "Orange"]

        // -----------------------------
        // R: Read (조회)
        // -----------------------------
        System.out.println("첫 번째 과일: " + fruits.get(0)); // Apple

        // 전체 요소 출력
        for (String fruit : fruits) {
            System.out.println("과일: " + fruit);
        }

        // -----------------------------
        // U: Update (수정)
        // -----------------------------
        fruits.set(1, "Mango");   // 인덱스 1의 Banana → Mango
        System.out.println("수정 후: " + fruits);

        // -----------------------------
        // D: Delete (삭제)
        // -----------------------------
        fruits.remove("Apple");   // Apple 제거
        System.out.println("삭제 후: " + fruits);

        fruits.clear();           // 전체 삭제
        System.out.println("clear() 후: " + fruits);
    }
}
