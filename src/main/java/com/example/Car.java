package com.example;

public class Car {
    public final String brand = "Hyundai"; // 어디서든 접근 가능
    public int year = 2025; // 같은 패키지 + 상속 관계에서 접근 가능
    public String model = "Avante"; // default (package-private): 같은 패키지에서만
    private int speed = 0; // 클래스 내부에서만 접근 가능

    public void drive() {
        speed = 60; // private 멤버는 클래스 내부라 접근 가능
        System.out.println("달리는 중... 속도: " + speed);
    }

    private void secretFunction() {
        System.out.println("비밀 기능 실행!");
    }
}
