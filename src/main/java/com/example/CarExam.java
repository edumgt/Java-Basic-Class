package com.example;

import com.example.*;
import com.hyundai.namyang.*;

public class CarExam {
    public static void main(String[] args) {
        Car car = new Car();

        System.out.println(car.brand);  // ✅ public 접근 가능
        System.out.println(car.year);   // ✅ 같은 패키지라 접근 가능
        System.out.println(car.model);  // ✅ default (같은 패키지)
        // System.out.println(car.speed); // ❌ private → 컴파일 에러

        car.drive(); // ✅ public 메서드라 접근 가능
        // car.secretFunction(); // ❌ private 메서드 접근 불가
    }
}
