package Example.Example_07;

/*
 * 래퍼 클래스 (Wrapper Class) 란?
 * - 기본 자료형을 감싸는 클래스를 의미한다. (+ 즉, 기본 자료형을 대체하는 클래스라는 것을 알 수 있다.)
 *
 * Java 는 객체 지향 프로그래밍 언어이기 때문에 많은 표준 라이브러리가 객체를 대상으로 동작하도록 설계되어있다. (+ 즉,
 * 클래스가 기본이라는 것을 의미한다.)
 *
 * 따라서 기본적으로 Java 의 기본 자료형은 클래스를 대상으로 동작하는 라이브러리에는 사용하는 것이 불가능하기 때문에
 * 이를 대체하기 위한 클래스가 필요하며 그것이 바로 래퍼 클래스이다. (+ 즉, 래퍼 클래스를 활용하면 기본 자료형도
 * 클래스를 대상으로 동작하는 라이브러리에 사용하는 것이 가능하다.)
 *
 * Java 래퍼 클래스 종류
 * - Boolean			<- boolean
 * - Character			<- char
 * - Byte				<- byte
 * - Short				<- short
 * - Integer			<- int
 * - Long				<- long
 * - Float				<- float
 * - Double				<- double
 *
 * Ex)
 * List<Integer> oListValues = new ArrayList<>();
 * oListValues.add(1);
 * oListValues.add(2);
 * oListValues.add(3);
 *
 * int nVal = oListValues.get(0);
 * System.out.println(nVal);
 *
 * 위와 같이 Java 는 모든 기본 자료형을 대체하기 위한 래퍼 클래스를 제공하며 래퍼 클래스는 Boxing/Unboxing 을
 * 지원하기 때문에 기본 자료형을 제어 하듯이 명령문을 작성하는 것이 가능하다. (+ 즉, 래퍼 클래스는 내부적으로
 * 기본 자료형을 제어하기 위한 다양한 기능을 지원한다는 것을 알 수 있다.)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Example 7
 */
public class CE01Example_07 {
	/** 초기화 */
	public static void main(String[] args) {
		Random oRandom = new Random();
		List<Integer> oListValues = new ArrayList<>();
		
		for(int i = 0; i < 10; ++i) {
			/*
			 * 아래와 같이 기본 자료형 데이터를 명시해도 내부적으로 Boxing 에 의해서 래퍼 클래스 객체로
			 * 변환 된다는 것을 알 수 있다.
			 */
			Integer oVal = oRandom.nextInt(1, 100);
			oListValues.add(oVal);
		}
		
		System.out.println("=====> 리스트 <=====");
		
		for(int i = 0; i < oListValues.size(); ++i) {
			/*
			 * 아래와 같이 래퍼 클래스 객체를 기본 자료형 변수에 할당 할 경우 내부적으로 Unboxing 에 의해서
			 * 자동으로 기본 자료형으로 변환 된다는 것을 알 수 있다.
			 */
			int nVal = oListValues.get(i);
			System.out.printf("%d, ", nVal);
		}
		
		System.out.println();
	}
}
