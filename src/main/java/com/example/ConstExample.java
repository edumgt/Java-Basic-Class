package com.example;
class MathUtil {
    // 수학 관련 상수
    final static public 
    double PI = 3.141592653589793;
    
    
    public static final double E = 2.718281828459045;

    // 물리 상수
    public static final double LIGHT_SPEED = 299_792_458;  // m/s
    public static final double GRAVITY = 9.80665;          // m/s^2

    // 변환 상수
    public static final double INCH_TO_CM = 2.54;
    public static final double POUND_TO_KG = 0.453592;
}


public class ConstExample {
    public static void main(String[] args) {
        // 원의 넓이 계산
        double radius = 20;
        double area = MathUtil.PI * radius * radius;
        System.out.println("반지름 5의 원 넓이 = " + area);

        // 자연로그 밑
        System.out.println("자연상수 e = " + MathUtil.E);

        // 중력가속도
        double mass = 70; // kg
        double weight = mass * MathUtil.GRAVITY;
        System.out.println("몸무게 70kg인 사람의 무게(뉴턴) = " + weight);

        // 단위 변환
        double inch = 10;
        double cm = inch * MathUtil.INCH_TO_CM;
        System.out.println("10 inch = " + cm + " cm");

        double pound = 150;
        double kg = pound * MathUtil.POUND_TO_KG;
        System.out.println("150 pound = " + kg + " kg");
    }
}

