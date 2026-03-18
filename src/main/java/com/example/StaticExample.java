package com.example;
class Counter {
    // 모든 인스턴스가 공유하는 정적 변수
    static int count = 0;
    public Counter() {
        count += 100;  // 객체가 생성될 때마다 증가
    }
}

public class StaticExample {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        Counter c3 = new Counter();
        Counter c4 = new Counter();

        // 인스턴스가 달라도 같은 정적 변수에 접근
        System.out.println("생성된 객체 수: " + Counter.count); // 출력: 3
    }
}
