# Java Basic 50-Exercise Catalog

`src/main/java/curriculum` 내 소스를 기준으로 입문 학습 흐름에 맞춰 `EX01~EX50`으로 분류했습니다.

## Module Summary
| Module | Range | Count | Core Theme |
|---|---|---:|---|
| module01_input_output | EX01-EX08 | 8 | 입력/출력, 기초 산술 |
| module02_math_geometry | EX09-EX16 | 8 | 수학 공식, 좌표/기하 |
| module03_control_flow | EX17-EX22 | 6 | 조건문, 반복문 |
| module04_strings_logic | EX23-EX24 | 2 | 문자열 파싱/패턴 |
| module05_collections | EX25-EX31 | 7 | List/Set/Map |
| module06_jvm_diagnostics | EX32-EX33 | 2 | JVM 메모리/스레드 진단 |
| module07_simulation_projects | EX34-EX36 | 3 | 콘솔 시뮬레이션 미니 프로젝트 |
| module08_additional_practice | EX37-EX50 | 14 | 종합 실습(알고리즘/OOP/예외) |

## module01_input_output (EX01-EX08)
| ID | File | Practice Focus |
|---|---|---|
| EX01 | `src/main/java/curriculum/module01_input_output/ProductOfThreeNumbers.java` | `Scanner` 입력 3개를 받아 곱 계산 |
| EX02 | `src/main/java/curriculum/module01_input_output/SumOfThreeNumbers.java` | 쉼표 문자열 분해(`split`) + 정수 합계 |
| EX03 | `src/main/java/curriculum/module01_input_output/SwapNumbers.java` | 두 수 교환(산술 연산 기반) |
| EX04 | `src/main/java/curriculum/module01_input_output/SwapNumbersWithoutThirdVariable.java` | 임시 변수 없는 교환 로직 |
| EX05 | `src/main/java/curriculum/module01_input_output/TimeConverter.java` | 초 단위 시간을 시/분/초로 변환 |
| EX06 | `src/main/java/curriculum/module01_input_output/TipsCalculator.java` | 팁/총액 계산과 백분율 처리 |
| EX07 | `src/main/java/curriculum/module01_input_output/TotalAmountPayable.java` | 수량 x 단가 결제 금액 계산 |
| EX08 | `src/main/java/curriculum/module01_input_output/TotalSalaryCalculator.java` | 기본급 + 수당(HRA/DA/TA) 총급여 계산 |

## module02_math_geometry (EX09-EX16)
| ID | File | Practice Focus |
|---|---|---|
| EX09 | `src/main/java/curriculum/module02_math_geometry/Quadratic.java` | 이차방정식 판별식/근 계산 |
| EX10 | `src/main/java/curriculum/module02_math_geometry/RectanglePropertiesCalculator.java` | 직사각형 넓이/둘레 계산 |
| EX11 | `src/main/java/curriculum/module02_math_geometry/RunwayLength.java` | 속도/가속도 기반 활주로 길이 계산 |
| EX12 | `src/main/java/curriculum/module02_math_geometry/SimpleInterestInput.java` | 단리 이자 공식 적용 |
| EX13 | `src/main/java/curriculum/module02_math_geometry/SimultaneousUsingCramerRule.java` | 크래머 공식으로 연립방정식 해 구하기 |
| EX14 | `src/main/java/curriculum/module02_math_geometry/TriangleArea.java` | 좌표 거리 + 헤론 공식 면적 계산 |
| EX15 | `src/main/java/curriculum/module02_math_geometry/TwoPointDistance.java` | 2점 사이 유클리드 거리 계산 |
| EX16 | `src/main/java/curriculum/module02_math_geometry/VolumeOfCylinder.java` | 원기둥 넓이/부피 계산 |

## module03_control_flow (EX17-EX22)
| ID | File | Practice Focus |
|---|---|---|
| EX17 | `src/main/java/curriculum/module03_control_flow/PalindromeNumber.java` | 자리수 분해와 회문 수 판별 |
| EX18 | `src/main/java/curriculum/module03_control_flow/PrimeNumberTo1000.java` | 소수 판별 반복문 최적화 기초 |
| EX19 | `src/main/java/curriculum/module03_control_flow/RandomMonth.java` | 난수 + if-else 체인 분기 |
| EX20 | `src/main/java/curriculum/module03_control_flow/ReverseNumber.java` | 숫자 뒤집기 메서드 구현 |
| EX21 | `src/main/java/curriculum/module03_control_flow/TimePlus15Minutes.java` | 시간 덧셈 로직 + 출력 포맷팅 |
| EX22 | `src/main/java/curriculum/module03_control_flow/WindChillIndex.java` | 범위 검증 + 풍속체감지수 계산 |

## module04_strings_logic (EX23-EX24)
| ID | File | Practice Focus |
|---|---|---|
| EX23 | `src/main/java/curriculum/module04_strings_logic/NumberPyramidEnhanced.java` | 중첩 반복문 기반 피라미드 출력 |
| EX24 | `src/main/java/curriculum/module04_strings_logic/TakeSkipRope.java` | 문자열/숫자 분리 후 take-skip 복호화 로직 |

## module05_collections (EX25-EX31)
| ID | File | Practice Focus |
|---|---|---|
| EX25 | `src/main/java/curriculum/module05_collections/HashMapToJsonExample.java` | `Map` 순회와 JSON 문자열 직렬화 기본 |
| EX26 | `src/main/java/curriculum/module05_collections/HashSetExample.java` | `HashSet` 중복 제거와 집합 연산 기초 |
| EX27 | `src/main/java/curriculum/module05_collections/HashTableExample.java` | `Hashtable` 기반 로그인 검증 루프 |
| EX28 | `src/main/java/curriculum/module05_collections/ListCrudExample.java` | `List` CRUD(Create/Read/Update/Delete) |
| EX29 | `src/main/java/curriculum/module05_collections/ListPerformanceTest.java` | `ArrayList` vs `LinkedList` 접근 성능 비교 |
| EX30 | `src/main/java/curriculum/module05_collections/StudentAcademy.java` | `Map` 누적/평균 + Stream 필터링 |
| EX31 | `src/main/java/curriculum/module05_collections/VectorExample.java` | `Vector` 동작 및 수정/삭제 실습 |

## module06_jvm_diagnostics (EX32-EX33)
| ID | File | Practice Focus |
|---|---|---|
| EX32 | `src/main/java/curriculum/module06_jvm_diagnostics/SystemMetricsDemo.java` | `java.lang.management`로 JVM 지표 조회 |
| EX33 | `src/main/java/curriculum/module06_jvm_diagnostics/WorldSwimmingRecordWithDiagnostics.java` | 문제 풀이 + JVM 메모리/스레드 진단 결합 |

## module07_simulation_projects (EX34-EX36)
| ID | File | Practice Focus |
|---|---|---|
| EX34 | `src/main/java/curriculum/module07_simulation_projects/LadyBugsLogColor.java` | 배열 상태 전이 기반 시뮬레이션 |
| EX35 | `src/main/java/curriculum/module07_simulation_projects/PhysicsMenuCalculator.java` | 메뉴형 콘솔 앱 + 입력 예외 처리 |
| EX36 | `src/main/java/curriculum/module07_simulation_projects/Race.java` | 정규식 파싱 + 랭킹 집계/정렬 |

## module08_additional_practice (EX37-EX50)
| ID | File | Practice Focus |
|---|---|---|
| EX37 | `src/main/java/curriculum/module08_additional_practice/ArrayAverageVariance.java` | 배열 평균/분산 계산 |
| EX38 | `src/main/java/curriculum/module08_additional_practice/ArrayMinMaxAnalyzer.java` | 배열 최소/최대 탐색 |
| EX39 | `src/main/java/curriculum/module08_additional_practice/BankAccountOOPDemo.java` | 캡슐화된 계좌 도메인 모델 기초 |
| EX40 | `src/main/java/curriculum/module08_additional_practice/ContactBookConsole.java` | 연락처 Map CRUD 콘솔 구현 |
| EX41 | `src/main/java/curriculum/module08_additional_practice/EvenOddChecker.java` | 짝수/홀수 분기 처리 |
| EX42 | `src/main/java/curriculum/module08_additional_practice/GradeCalculator.java` | 점수 구간별 학점 판정 |
| EX43 | `src/main/java/curriculum/module08_additional_practice/MiniBoardConsole.java` | 게시판 글 등록/조회/검색 |
| EX44 | `src/main/java/curriculum/module08_additional_practice/MultiplicationTablePrinter.java` | 반복문 기반 구구단 출력 |
| EX45 | `src/main/java/curriculum/module08_additional_practice/NumberGuessingGame.java` | 랜덤 수 맞추기 루프 게임 |
| EX46 | `src/main/java/curriculum/module08_additional_practice/PasswordPolicyChecker.java` | 비밀번호 정책 검사(길이/대소문자/숫자) |
| EX47 | `src/main/java/curriculum/module08_additional_practice/SafeDivisionCalculator.java` | 입력 예외/0 나누기 예외 처리 |
| EX48 | `src/main/java/curriculum/module08_additional_practice/ShapeInheritanceDemo.java` | 추상 클래스 + 상속 다형성 |
| EX49 | `src/main/java/curriculum/module08_additional_practice/SimpleATMMenu.java` | 상태 기반 ATM 메뉴 제어 |
| EX50 | `src/main/java/curriculum/module08_additional_practice/StringFrequencyMap.java` | 문자 빈도수 집계(`Map`) |
