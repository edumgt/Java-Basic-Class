package Example.Example_11;

/*
 * 람다 (Lambda) 란?
 * - 이름이 없는 메서드를 구현 할 수 있는 기능을 의미한다. (+ 즉, 람다는 일반적인 메서드와 달리 재사용을 위해서
 * 구현되는 메서드가 아니라는 것을 알 수 있다.)
 *
 * 람다는 일회성 메서드를 구현하는데 주로 활용되며 다른 메서드 내부에 구현되기 때문에 내장 메서드라고도 불린다.
 * (+ 즉, 람다는 자신을 감싸고 있는 외부 메서드의 일부라는 것을 알 수 있다.)
 *
 * 람다는 자신을 감싸고 있는 외부 메서드의 일부이기 때문에 외부 메서드에 존재하는 지역 변수에 접근하는 것이 가능하다.
 * (+ 즉, 외부 메서드에 존재하는 지역 변수는 람다의 입력으로 전달 할 필요가 없다는 것을 알 수 있다.)
 *
 * 단, 람다는 이름이 존재하지 않기 때문에 람다를 호출하기 위해서는 람다를 참조 할 자료형이 필요하며
 * 이때 인터페이스를 활용 할 수 있다. (+ 즉, 인터페이스는 단순한 상호 작용을 위한 수단이기 때문에 이를 통해
 * 람다와 상호 작용을 한다는 것을 알 수 있다.)
 *
 * 또한 람다는 이름이 없는 하나의 메서드를 구현하는 기능이기 때문에 추상 메서드가 2 개 이상 존재하는 인터페이스를
 * 통해서는 구현하는 것이 불가능하다. (+ 즉, 추상 메서드가 1 개만 존재하는 인터페이스를 통해서만 람다를 구현하는
 * 것이 가능하다.)
 *
 * Java 람다 구현 방법
 * - 매개 변수 + 람다 몸체
 *
 * Ex)
 * interface ISomeInterface {
 * 		public void someMethod(int a_nValA, int a_nValB);
 * }
 *
 * ISomeInterface oLambda = (a_nValA, a_nValB) -> {
 * 		// Do Something
 * };
 *
 * oLambda.someMethod(10, 20);
 *
 * 위와 같이 람다는 단독으로 구현하는 것을 불가능하며 인터페이스를 통해 람다를 호출 할 수 있다는 것을 알 수 있다.
 * 또한 람다의 매개 변수에는 자료형을 생략해야한다. (+ 즉, 자료형을 명시하면 컴파일 에러가 발생한다는 것을 알 수 있다.)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Example 11 (람다)
 */
public class CE01Example_11 {
	/** 초기화 */
	public static void main(String[] args) {
		IWriter oLambda = getLambda(10);
		oLambda.writeVal();
		
		Random oRandom = new Random();
		List<Integer> oListValues = new ArrayList<>();
		
		for(int i = 0; i < 10; ++i) {
			oListValues.add(oRandom.nextInt(1, 100));
		}
		
		System.out.println("\n=====> 리스트 <=====");
		printValues(oListValues);
		
		/*
		 * 아래와 같이 익명 내부 클래스를 활용하면 일회성 객체를 생성하는 것이 가능하다. (+ 즉, 익명 내부 클래스는
		 * 일반적으로 재사용 되지 않는 임시 객체를 생성 할 때 주로 활용 된다는 것을 알 수 있다.)
		 */
		sortValues(oListValues, new ICompare() {
			/** 값을 비교한다 */
			@Override
			public int compare(int a_nLhs, int a_nRhs) {;
				return a_nLhs - a_nRhs;
			}
		});
		
		System.out.println("\n=====> 리스트 - 오름 차순 정렬 후 <=====");
		printValues(oListValues);
		
		/*
		 * 아래와 같이 람다를 활용하면 익명 내부 클래스를 사용하는 것보다 명령문을 간소화 시키는 것이 가능하다. (+ 즉,
		 * 람다 내부에 작성 된 명령문과 매개 변수를 Java 컴파일러가 분석해서 메서드 유형을 유추한다는 것을
		 * 알 수 있다.)
		 */
		sortValues(oListValues, (a_nLhs, a_nRhs) -> {
			return a_nRhs - a_nLhs;
		});
		
		System.out.println("\n=====> 리스트 - 내름 차순 정렬 후 <=====");
		printValues(oListValues);
	}
	
	/**
	 * 출력 인터페이스
	 */
	private interface IWriter {
		/** 값을 출력한다 */
		public void writeVal();
	}
	
	/** 람다를 반환한다 */
	private static IWriter getLambda(int a_nVal) {
		return () -> {
			/*
			 * 람다 내부에서는 외부 지역에 존재하는 지역 변수를 해당 변수의 생명 주기와 상관 없이 접근하는 것이
			 * 가능하다.
			 *
			 * 람다는 구현 된 지역의 일부이기 때문에 해당 지역에 선언 된 지역 변수를 람다 내부에서 접근하기 위해
			 * 해당 변수에 대한 사본을 지니고 있기 때문이다. (+ 즉, 외부 지역에 선언 된 지역 변수가 메모리 상에서
			 * 제거 되어도 람다 내부에서는 해당 변수에 자유롭게 접근 가능하다는 것을 알 수 있다.)
			 */
			System.out.printf("람다 : %d\n", a_nVal);
		};
	}
	
	/** 값을 정렬한다 */
	private static void sortValues(List<Integer> a_oListValues, ICompare a_oCompare) {
		for(int i = 0; i < a_oListValues.size(); ++i) {
			for(int j = 0; j < a_oListValues.size() - (i + 1); ++j) {
				int nLhs = a_oListValues.get(j);
				int nRhs = a_oListValues.get(j + 1);
				
				// 정렬이 필요 없을 경우
				if(a_oCompare.compare(nLhs, nRhs) <= 0) {
					continue;
				}
				
				a_oListValues.set(j, nRhs);
				a_oListValues.set(j + 1, nLhs);
			}
		}
	}
	
	/** 값을 출력한다 */
	private static void printValues(List<Integer> a_oListValues) {
		for(int i = 0; i < a_oListValues.size(); ++i) {
			System.out.printf("%d, ", a_oListValues.get(i));
		}
		
		System.out.println();
	}
}
