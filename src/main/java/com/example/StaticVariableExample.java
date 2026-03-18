package com.example;
class Student {
    String name;             // 인스턴스 변수
    final static String school = "동대문고"; // 정적 변수

    public Student(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("이름: " + name + ", 학교: " + school);
    }
}

public class StaticVariableExample {
    public static void main(String[] args) {

        //Student.school = "서울고";
        Student s1 = new Student("홍길동");
        s1.showInfo(); // 이름: 철수, 학교: 서울고

        Student s2 = new Student("이영희");
        //Student.school = "부산고";
        s2.showInfo(); // 이름: 영희, 학교: 서울고

    }
}
