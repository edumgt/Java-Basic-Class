package Example.Example_12;

/*
 * 제네릭 (Generic) 이란?
 * - 자료형을 명시하지 않고 메서드 or 클래스를 정의 할 수 있는 기능을 의미한다. (+ 즉, 제네릭을 활용하면 동일한
 * 명령문을 지닌 메서드 or 클래스의 중복을 줄이는 것이 가능하다.)
 *
 * Java 는 강력 형식 언어 (Strong Type Language) 이기 때문에 자료형이 다르면 동일한 명령문을 다시 작성해야되는
 * 단점이 존재한다. (+ 즉, 명령문의 중복이 발생한다는 것을 알 수 있다.)
 *
 * 이때 제네릭을 활용하면 중복으로 발생하는 명령문을 최소화 시키는 것이 가능하다. (+ 즉, 자료형이 달라도 명령문이
 * 동일하다면 제네릭을 활용하는 것이 가능하다.)
 *
 * 단, 제네릭은 기본 자료형은 지원하지 않기 때문에 기본 자료형을 기반으로 제네릭 메서드 or 클래스를 구현하고 싶다면
 * 래퍼 클래스를 활용해야한다. (+ 즉, 제네릭은 내부적으로 클래스를 기반으로 동작하도록 설계 되어있다는 것을
 * 알 수 있다.)
 *
 * Java 제네릭 메서드 구현 방법
 * - 제네릭 형식 인자 + 반환형 + 메서드 이름 + 매개 변수 + 메서드 몸체
 *
 * Ex)
 * <T> void someMethod(T a_tValA, T a_tValB) {
 * 		// Do Something
 * }
 *
 * someMethod(10, 20);
 * someMethod(10.0f, 20.0f);
 *
 * 위와 같이 제네릭 메서드는 제네릭 형식 인자를 지정함으로서 기존 자료형 자리를 대체하는 것이 가능하다. (+ 즉,
 * 제네릭 형식 인자는 메서드가 호출 될 때 전달 되는 데이터를 참조해서 실제 자료형으로 치환 된다는 것을 알 수 있다.)
 *
 * 제네릭 메서드를 호출 할 때 자료형을 명시하지 않으면 매개 변수에 전달 되는 데이터를 기반으로 Java 컴파일러가
 * 자동으로 자료형을 결정한다. (+ 즉, 자료형을 직접 명시하지 않아도 된다.)
 *
 * 단, Java 컴파일러가 자료형을 결정하는 것은 매개 변수에 전달 되는 데이터를 기반으로 결정하기 때문에 만약
 * 데이터만으로 결정이 불가능하다면 해당 경우 자료형을 직접적으로 명시해줘야한다.
 *
 * Ex)
 * CSomeClass.<Integer>someMethod(10, 20);
 * CSomeClass.<Float>someMethod(10.0f, 20.0f);
 *
 * 위와 같이 제네릭 형식 인자의 자료형을 직접 명시해주는 것이 가능하다.
 *
 * 제네릭 형식 인자 (Generic Parameter) 란?
 * - 자료형이 결정 되기 전까지 임시적으로 사용 되는 자료형을 의미한다. (+ 즉, 제네릭 형식 인자는 자료형 자리에
 * 명시 되는 임시 자료형이라는 것을 알 수 있다.)
 *
 * Java 제네릭 규칙
 * - Java 의 제네릭은 기본적으로 모든 자료형에 대응 되어야한다. (+ 즉, 제네릭 메서드 or 제네릭 클래스는
 * 어떤 자료형을 명시한다 하더라도 명령문이 동작해야한다는 것을 알 수 있다.)
 *
 * 만약 특정 자료형에만 동작하도록 제네릭을 구현하고 싶다면 제네릭 형식 인자의 자료형을 제한해야한다. (+ 즉,
 * 제네릭 형식 인자를 특정 자료형으로 제한함으로서 원하는 자료형에만 동작하는 제네릭을 구현하는 것이 가능하다.)
 *
 * Ex)
 * <T extends CSomeClass or ISomeInterface> void someMethod(T a_tValA, T a_tValB) {
 * 		// Do Something
 * }
 *
 * 위와 같이 extends 키워드를 활용하면 특정 클래스나 인터페이스를 구현하고 있는 자료형만으로 제네릭 형식 인자를
 * 제한하는 것이 가능하다. (+ 즉, 특정 자료형을 직접적으로 명시하는 것은 지원하지 않는다는 것을 알 수 있다.)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Example 12 (제네릭 - 1)
 */
public class CE01Example_12 {
	/** 초기화 */
	public static void main(String[] args) {
		Random oRandom = new Random();
		List<Integer> oListValues = new ArrayList<>();
		
		for(int i = 0; i < 10; ++i) {
			oListValues.add(oRandom.nextInt(1, 100));
		}
		
		System.out.println("=====> 리스트 - 정렬 전 <=====");
		printValues(oListValues);
		
		sortValues(oListValues, 0, oListValues.size() - 1);
		System.out.println("\n=====> 리스트 - 정렬 후 <=====");
		
		/*
		 * 아래와 같이 제네릭 형식 인자의 자료형을 직접 명시하는 것이 가능하다. (+ 즉,
		 * 제네릭 형식 인자의 자료형을 직접 명시함으로서 가독성을 향상 시키는 것이 가능하다.)
		 */
		CE01Example_12.<Integer>printValues(oListValues);
	}
	
	/*
	 * 아래와 같이 extends 키워드를 통해 제네릭 형식 인자의 자료형을 특정 클래스 or 인터페이스를 따르는 자료형으로
	 * 제한하는 것이 가능하다.
	 */
	/** 값을 정렬한다 */
	private static <T extends Comparable<T>> void sortValues(List<T> a_oListValues, int a_nLeft, int a_nRight) {
		// 값 정렬이 불가능 할 경우
		if(a_nLeft >= a_nRight) {
			return;
		}
		
		int nMiddle = (a_nLeft + a_nRight) / 2;
		
		sortValues(a_oListValues, a_nLeft, nMiddle);
		sortValues(a_oListValues, nMiddle + 1, a_nRight);
		
		int nLeft = a_nLeft;
		int nRight = nMiddle + 1;
		
		List<T> oListValues_Temp = new ArrayList<>();
		
		while(true) {
			while(nLeft <= nMiddle) {
				// 정렬이 불가능 할 경우
				if(a_oListValues.get(nLeft).compareTo(a_oListValues.get(nRight)) > 0) {
					break;
				}
				
				oListValues_Temp.add(a_oListValues.get(nLeft++));
			}
			
			while(nRight <= a_nRight) {
				// 정렬이 불가능 할 경우
				if(a_oListValues.get(nRight).compareTo(a_oListValues.get(nLeft)) > 0) {
					break;
				}
				
				oListValues_Temp.add(a_oListValues.get(nRight++));
			}
			
			// 정렬이 불가능 할 경우
			if(nLeft > nMiddle || nRight > a_nRight) {
				break;
			}
		}
		
		while(nLeft <= nMiddle) {
			oListValues_Temp.add(a_oListValues.get(nLeft++));
		}
		
		while(nRight <= a_nRight) {
			oListValues_Temp.add(a_oListValues.get(nRight++));
		}
		
		for(int i = 0; i < oListValues_Temp.size(); ++i) {
			T tVal = oListValues_Temp.get(i);
			a_oListValues.set(a_nLeft + i, tVal);
		}
	}
	
	/** 값을 출력한다 */
	private static <T> void printValues(List<T> a_oListValues) {
		for(int i = 0; i < a_oListValues.size(); ++i) {
			System.out.printf("%s, ", a_oListValues.get(i));
		}
		
		System.out.println();
	}
}
