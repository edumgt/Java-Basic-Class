package com.example;

import java.util.Scanner;

public class PizzaExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pizza pizza = null;
        Dough dough;

        // 🍕 피자 이름과 토핑 개수 입력
        System.out.print("피자 이름과 토핑 개수를 입력하세요 (예: Pizza Margherita 2): ");
        String[] pizzaData = scanner.nextLine().trim().split("\\s+");

        try {
            pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("⚠ 입력 형식이 잘못되었습니다. (예: Pizza Margherita 2)");
            // return;
        }

        // 🍞 도우 정보 입력
        System.out.print("도우 정보를 입력하세요 (예: Dough White Chewy 200): ");
        String[] doughData = scanner.nextLine().trim().split("\\s+");

        try {
            dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));
            /* 중요 */
            pizza.setDough(dough);

        } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            System.out.println("⚠ 입력 형식이 잘못되었습니다. (예: Dough White Chewy 200)");
            // return;
        }

        // 🍖 토핑 정보 입력 (END 입력 시 종료)
        System.out.println("토핑 정보를 입력하세요 (예: Topping Cheese 50). 끝내려면 END 입력:");
        String command = scanner.nextLine();

        while (!command.equalsIgnoreCase("END")) {
            String[] toppingData = command.trim().split("\\s+");

            if (toppingData.length < 3) {
                System.out.println("⚠ 입력 형식이 잘못되었습니다. (예: Topping Cheese 50)");
            } else {
                String toppingType = toppingData[1];
                double weight;

                try {
                    weight = Double.parseDouble(toppingData[2]);
                    /* 중요 */
                    pizza.addTopping(new Topping(toppingType, weight));

                } catch (NumberFormatException e) {
                    System.out.println("⚠ 토핑 무게는 숫자여야 합니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println("⚠ 오류: " + e.getMessage());
                }
            }

            System.out.print("다음 토핑을 입력하세요 (END 입력 시 종료): ");
            command = scanner.nextLine();
        }

        // 🍕 최종 결과
        System.out.println("\n✅ 피자 제작 완료!");
        System.out.println(pizza);

        scanner.close();
    }
}
