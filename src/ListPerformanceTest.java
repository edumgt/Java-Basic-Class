import java.util.ArrayList;   // ArrayList 클래스 import (배열 기반 List)
import java.util.LinkedList;  // LinkedList 클래스 import (이중 연결리스트 기반 List)
import java.util.List;        // List 인터페이스 import (ArrayList, LinkedList의 부모 인터페이스)

public class ListPerformanceTest {  // 클래스 정의
    public static void main(String[] args) {  // 자바 프로그램 실행 진입점 main 메서드
        int n = 100000; // 10만 개 → 테스트할 데이터 개수

        // -----------------------------
        // ArrayList 성능 테스트
        // -----------------------------
        List<Integer> arrayList = new ArrayList<>();
        // ArrayList 객체 생성 (정수 Integer를 담는 리스트)
        // 내부적으로 배열을 사용 → 인덱스 접근 빠름, 삽입/삭제는 느림

        long start = System.currentTimeMillis();
        // 현재 시간(밀리초)을 가져옴 → 성능 측정 시작 시간 기록

        for (int i = 0; i < n; i++) {
            arrayList.add(i); // 끝에 i를 추가 (0부터 99,999까지)
        }
        // for문 종료 후 → arrayList 크기는 100,000개
        // add()는 평균적으로 O(1), 배열 공간 초과 시 확장 발생

        long end = System.currentTimeMillis();
        // 성능 측정 종료 시간 기록

        System.out.println("ArrayList add: " + (end - start) + "ms");
        // add 실행에 걸린 시간 출력

        start = System.currentTimeMillis();
        // 랜덤 접근 성능 측정 시작 시간

        for (int i = 0; i < n; i++) {
            arrayList.get(i); // 인덱스를 이용해 원소 접근 (O(1))
        }
        // for문이 끝나면 전체 요소를 순차적으로 get()

        end = System.currentTimeMillis();
        // 랜덤 접근 종료 시간 기록

        System.out.println("ArrayList get: " + (end - start) + "ms");
        // get 실행에 걸린 시간 출력

        // -----------------------------
        // LinkedList 성능 테스트
        // -----------------------------
        List<Integer> linkedList = new LinkedList<>();
        // LinkedList 객체 생성 (이중 연결 리스트 구조 → 삽입/삭제 빠름, 인덱스 접근 느림)

        start = System.currentTimeMillis();
        // add 성능 측정 시작

        for (int i = 0; i < n; i++) {
            linkedList.add(i); // 끝에 i를 추가 (0부터 99,999까지)
        }
        // LinkedList add()는 O(1), 끝에 추가는 빠름

        end = System.currentTimeMillis();
        // 종료 시간 기록

        System.out.println("LinkedList add: " + (end - start) + "ms");
        // LinkedList add 실행 시간 출력

        start = System.currentTimeMillis();
        // get 성능 측정 시작

        for (int i = 0; i < n; i++) {
            linkedList.get(i); // 인덱스를 이용해 원소 접근
        }
        // LinkedList get(i)는 내부적으로 0 또는 끝에서부터 순차 탐색 → O(n)
        // 따라서 전체 n번 반복하면 O(n^2) → 매우 느림

        end = System.currentTimeMillis();
        // get 종료 시간 기록

        System.out.println("LinkedList get: " + (end - start) + "ms");
        // LinkedList get 실행 시간 출력
    }
}
