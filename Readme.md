# Java Basic Curriculum (50 Exercises)

이 저장소의 Java 학습 소스를 `src/main/java/curriculum` 기준으로 재구성하고, **기초 교육용 50개 세부 실습(EX01~EX50)** 으로 분류했습니다.

## 1) 재구성 결과
- 모듈 수: 8개
- 실습 수: 50개
- 기준 경로: `src/main/java/curriculum`
- 상세 실습표: `docs/java-basic-curriculum-50.md`

## 2) 디렉터리 구조
```text
src/main/java/curriculum/
  module01_input_output           (8)
  module02_math_geometry          (8)
  module03_control_flow           (6)
  module04_strings_logic          (2)
  module05_collections            (7)
  module06_jvm_diagnostics        (2)
  module07_simulation_projects    (3)
  module08_additional_practice    (14)
```

## 3) 실습 실행 방법
기본 패키지(default package) 예제이므로, `-d out` 옵션으로 컴파일하고 `-cp out`으로 실행하는 방식을 권장합니다.

사전 조건:
- JDK 8+
- `rg`(ripgrep) 설치 시 전체 컴파일 명령 사용 가능

단일 실습 1개 실행 예시:
```bash
mkdir -p out
javac -d out src/main/java/curriculum/module08_additional_practice/GradeCalculator.java
java -cp out GradeCalculator
```

다른 실습으로 바꿔 실행:
```bash
rm -rf out && mkdir out
javac -d out src/main/java/curriculum/module03_control_flow/PalindromeNumber.java
java -cp out PalindromeNumber
```

전체 50개 컴파일:
```bash
rm -rf out && mkdir out
javac -d out $(rg --files src/main/java/curriculum -g '*.java' | sort)
```

전체 컴파일 후 원하는 실습 실행:
```bash
java -cp out NumberGuessingGame
java -cp out SystemMetricsDemo
```

EX 번호로 실습 파일 찾기:
```bash
rg "EX42" docs/java-basic-curriculum-50.md
```

## 4) 커리큘럼 사용 권장 순서
1. module01 ~ module03: 입력/연산/제어문
2. module04 ~ module05: 문자열 로직 + 컬렉션
3. module06 ~ module07: JVM 진단 + 시뮬레이션 프로젝트
4. module08: 실무형 콘솔 미니 과제

## 5) 비고
- `module05_collections`의 JSON 예제는 외부 라이브러리 없이 동작하도록 정리했습니다.
- 기존 대형 예제 세트(`src/main/java`의 다른 경로)는 보존하고, 본 커리큘럼은 입문 학습 트랙으로 분리해 제공됩니다.
