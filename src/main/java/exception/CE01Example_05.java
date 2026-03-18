package Example.Example_05;

/*
 * 예외 처리 (Exception Handling) 란?
 * - 의도치 않은 상황을 처리하기 위한 기능을 의미한다. (+ 즉, 예외 처리를 활용하면 프로그램이 실행 중에 발생하는
 * 여러 의도치 않은 결과를 유연하게 처리하는 것이 가능하다.)
 *
 * 사용자는 항상 프로그래머의 의도대로 프로그램을 사용하는 것이 아니기 때문에 예상하지 못한 행동을 사용자가 했을 경우
 * 프로그램은 이에 대해 적절하게 대처 할 필요가 있다. (+ 즉, 사용자의 행동에 유연하게 대처 할 수록 프로그램의 안정성이
 * 향상된다는 것을 알 수 있다.)
 *
 * 기본적으로 프로그래머는 사용자의 행동을 예측해서 프로그램을 제작 할 필요가 있지만 이는 현실적으로 어려우며 사용자는
 * 언제든지 프로그래머의 예측을 벗어난 행동을 할 가능성이 존재한다.
 *
 * 따라서 Java 는 이와 같은 상황을 유연하게 대처하기 위한 예외 처리 기능을 제공하며 해당 기능을 활용하면 프로그램의
 * 안정성을 향상 시키는 것이 가능하다.
 *
 * Ex)
 * try {
 * 		// 예외 발생 가능성이 존재하는 명령문
 * } catch(Exception oException) {
 * 		// 예외 처리 명령문
 * }
 *
 * Java 예외 처리 관련 키워드
 * - try
 * - catch
 * - finally
 * - throw / throws
 *
 * try 키워드란?
 * - 예외 발생 가능한 명령문 블럭을 지정 할 수 있는 키워드를 의미한다. (+ 즉, try 블럭 내부에서 발생한 예외는
 * catch 키워드를 활용해서 처리하는 것이 가능하다.)
 *
 * catch 키워드란?
 * - try 블럭에서 발생한 예외를 처리하기 위한 명령문 블럭을 지정 할 수 있는 키워드를 의미한다. (+ 즉, catch 블럭을
 * 활용하면 의도치 않은 결과를 처리하기 위한 명령문을 작성하는 것이 가능하다.)
 *
 * finally 키워드란?
 * - try 블럭에서 예외가 발생하더라도 반드시 실행되어야 할 명령문 블럭을 지정 할 수 있는 키워드를 의미한다. (+ 즉,
 * finally 블럭에 작성 된 명령문은 try 블럭에서 예외가 발생하더라도 반드시 실행된다는 것을 알 수 있다.)
 *
 * throw / throws 키워드란?
 * - throw 키워드는 명시적으로 예외를 발생 시키는 역할을 수행하는 키워드를 의미한다. (+ 즉, throw 키워드를 활용하면
 * 의도적으로 예외를 발생 시키는 것이 가능하다.)
 *
 * throws 키워드는 try 블럭에서 발생한 예외가 해당 명령문을 실행하고 있는 메서드를 호출한 곳으로 예외가
 * 전파 될 가능성이 있다는 사실을 알리는 키워드를 의미한다. (+ 즉, throws 키워드는 발생한 예외를 의도적으로 처리하지
 * 않는다는 것을 컴파일러에게 알리는 역할을 수행한다.)
 *
 * Java 예외 처리 규칙
 * - try 블럭에서 예외가 발생 or 발생 할 가능성이 있다면 예외를 처리하기 위한 catch 블럭을 반드시 작성해줘야한다.
 * (+ 즉, catch 블럭을 작성해주지 않으면 컴파일 에러가 발생한다.)
 *
 * 만약 catch 블럭 작성을 생략하고 싶다면 반드시 해당 명령문을 실행하고 있는 메서드에 throws 키워드를 명시해서
 * 메서드를 호출한 곳에서 예외를 처리하도록 해줘야한다. (+ 즉, try 블럭에서 발생한 예외가 처리 되지 않을 경우
 * 메서드 호출 순서를 역행하면서 예외가 전파된다는 것을 알 수 있다.)
 *
 * 사용자 정의 예외란?
 * - Java 에서 기본적으로 제공하는 예외 이외에 사용자 (프로그래머) 가 필요에 따라 직접 정의해서 사용하는 예외를
 * 의미한다. (+ 즉, 사용자 정의 예외를 활용하면 제작하는 프로그램에 특화 된 예외를 정의하는 것이 가능하다.)
 *
 * Java 에서 예외는 클래스를 통해 정의되기 때문에 사용자 정의 예외도 클래스를 통해 정의하는 것이 가능하며 이는
 * Exception 클래스를 상속하는 것으로 정의 가능하다.
 *
 * Ex)
 * class CSomeException extends Exception {
 * 		public CSomeException(String a_oMsg) {
 * 			super(a_oMsg);
 * 		}
 * }
 *
 * public void SomeMethod() throws CSomeException {
 * 		throw new CSomeException();
 * }
 *
 * 위와 같이 Exception 클래스를 상속해서 예외 클래스를 정의하고 나면 해당 클래스를 통해 생성 된 객체를
 * throw 키워드를 통해서 전파 시키는 것이 가능하다. (+ 즉, 예외 발생이 가능하다는 것을 알 수 있다.)
 */

import java.util.Scanner;

/**
 * Example 5 (에외 처리)
 */
public class CE01Example_05 {
	/** 초기화 */
	public static void main(String[] args) {
		System.out.print("정수 (2 개) 입력 : ");
		Scanner oScanner = new Scanner(System.in);
		
		int nValA = oScanner.nextInt();
		int nValB = oScanner.nextInt();
		
		try {
			System.out.println("=====> 산술 연산자 <=====");
			System.out.printf("%d + %d = %d\n", nValA, nValB, nValA + nValB);
			System.out.printf("%d - %d = %d\n", nValA, nValB, nValA - nValB);
			System.out.printf("%d * %d = %d\n", nValA, nValB, nValA * nValB);
			
			/*
			 * / (나누기 연산자), % (나머지 연산자) 는 우항에 0 이 올 경우 내부적으로 예외가 발생하는 특징이
			 * 존재한다. (+ 즉, 발생하는 예외를 처리하지 않을 경우 프로그램이 종료 된다는 것을 알 수 있다.)
			 *
			 * 단, / (나누기 연산자) 는 우항에 실수 0 이 올 경우 예외가 발생하지 않고 infinite 로 처리된다.
			 * (+ 즉, 계산이 불가능하다는 것을 알 수 있다.)o
			 */
			System.out.printf("%d / %d = %f\n", nValA, nValB, nValA / (float)nValB);
			System.out.printf("%d %% %d = %d\n", nValA, nValB, nValA % nValB);
		} catch(Exception oException) {
			System.out.printf("\n%s 가 발생했습니다.\n", oException.getMessage());
		}
		
		try {
			invokeException();
			
			/*
			 * invokeException 메서드 내부에서 예외가 발생 했기 때문에 아래 명령문은 실행 되지 않는다는 것을
			 * 알 수 있다. (+ 즉, 예외가 발생한 라인 이후에 명령문은 실행 되지 않는다는 것을 의미한다.)
			 */
			System.out.println("예외가 발생해서 해당 메세지는 출력 되지 않습니다.");
		} catch(Exception oException) {
			System.out.printf("\n%s 가 발생했습니다.\n", oException.getMessage());
		}
	}
	
	/** 예외를 발생 시킨다 */
	private static void invokeException() throws Exception {
		try {
			/*
			 * 아래와 같이 throw 키워드를 활용하면 예외를 의도적으로 발생 시키는 것이 가능하다.
			 */
			throw new CException("사용자 정의 예외");
		} finally {
			/*
			 * 아래와 같이 finally 블럭 내부에 존재하는 명령문은 예외 발생 여부와 상관 없이
			 * 항상 실행 된다는 것을 알 수 있다.
			 */
			System.out.println("finally 블럭이 실행되었습니다.");
		}
	}
}
