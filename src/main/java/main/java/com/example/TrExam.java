package com.example;

import java.util.Scanner;

public class TrExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🚦 사용 안내
        System.out.println("===== 🚦 신호등 시뮬레이터 =====");
        System.out.println("가능한 신호: RED, GREEN, YELLOW");
        System.out.print("신호등 상태들을 공백으로 구분해 입력하세요 (예: RED GREEN YELLOW): ");
        String[] values = scanner.nextLine().trim().split("\\s+");

        System.out.print("변경 횟수를 입력하세요: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("⚠ 숫자를 입력해야 합니다. 프로그램을 종료합니다.");
            return;
        }

        System.out.println("\n🚦 신호 변경 시작:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < values.length; j++) {
                String name = values[j];

                try {
                    // enum에서 현재 신호 위치 가져오기
                    int currentIndex = TrafficLights.valueOf(name).ordinal() + 1;
                    if (currentIndex >= TrafficLights.values().length) {
                        currentIndex = 0;
                    }
                    values[j] = TrafficLights.values()[currentIndex].name();
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠ 알 수 없는 신호(" + name + ")는 무시합니다.");
                }
            }
            System.out.printf("Step %d → %s%n", i + 1, String.join(" ", values));
        }

        System.out.println("\n✅ 시뮬레이션 종료");
        scanner.close();
    }
}
