package Example.Example_14;

/*
 * 컬렉션 (Collection) 이란?
 * - 여러 데이터를 효율적으로 관리 할 수 있는 기능을 의미한다. (+ 즉, 컬렉션을 활용하면 여러 데이터를 제어해서
 * 다양한 결과를 출력하는 프로그램을 제작하는 것이 가능하다.)
 *
 * 컬렉션은 내부적으로 데이터를 관리하는 형태에 따라 선형 컬렉션과 비선형 컬렉션으로 구분된다.
 *
 * 선형 컬렉션 (Linear Collection) 이란?
 * - 내부적으로 데이터를 1 차원 형태로 관리하는 컬렉션을 의미한다. (+ 즉, 데이터를 단순한 형태로 관리한다는 것을
 * 알 수 있다.)
 *
 * 데이터가 관리되는 형태가 단순하기 때문에 적은 데이터를 관리하는데 효율적이다. (+ 즉, 관리되는 데이터의 개수가
 * 많을수록 효율이 떨어진다는 것을 알 수 있다.)
 *
 * Java 주요 선형 컬렉션 종류
 * - 리스트 (List)
 * - 스택 (Stack)
 * - 큐 (Queue)
 *
 * 리스트 (List) 란?
 * - 내부적으로 관리되는 데이터의 순서가 존재하는 컬렉션을 의미한다. (+ 즉, 리스트에 존재하는 데이터는
 * 번호를 통해 관리 및 제어가 가능하다는 것을 알 수 있다.)
 *
 * 리스트에 존재하는 데이터는 인덱스 번호가 존재하며 해당 번호를 통해 특정 위치에 데이터를 저장하거나 가져오는 것이
 * 가능하다.
 *
 * 인덱스 번호의 범위는 0 ~ 리스트 길이 - 1 이며 잘못된 인덱스 번호를 명시 할 경우 내부적으로 예외가 발생하기 때문에
 * 주의가 필요하다. (+ 즉, 명령문을 좀 더 안정적으로 작성하고 싶다면 if 조건문 등을 활용해야한다는 것을 알 수 있다.)
 *
 * 리스트는 내부적으로 구현 방법에 배열 기반 리스트와 연결 기반 리스트가 존재한다.
 *
 * 배열 기반 리스트 (Array List) 란?
 * - 내부적으로 배열을 통해 데이터의 순서를 만들어내는 컬렉션을 의미한다. (+ 즉, 배열이 데이터를 관리하는 방식을
 * 그대로 따르고 있다는 것을 알 수 있다.)
 *
 * 연결 기반 리스트 (Linked List) 란?
 * - 참조를 기반으로 데이터의 순서를 만들어내는 컬렉션을 의미한다. (+ 즉, 데이터의 순서와 메모리의 순서가 일치하지
 * 않는다는 것을 알 수 있다.)
 *
 * 배열 기반 리스트 vs 연결 기반 리스트
 * - 배열 기반 리스트는 배열을 이용해서 데이터의 순서를 만들어내기 때문에 특정 데이터가 위치한 순서를 알고 있다면
 * [] (인덱스 연산자) 를 사용해서 한번에 접근하는 것이 가능하다. (+ 즉, 임의 접근이 가능하다는 것을 알 수 있다.)
 *
 * 단, 배열은 크기가 미리 정해져 있기 때문에 새로운 데이터를 추가하기 위한 공간이 부족 할 경우 새로운 공간을 만들어서
 * 기존 데이터를 이동시켜야하는 단점이 존재한다.
 *
 * 또한 관리하고 있는 데이터의 특정 위치에 새로운 데이터를 추가하거나 제거 할 경우 데이터의 이동이 발생한다. (+ 즉,
 * 배열 리스트는 데이터의 삽입/제거가 빈번하게 발생 할 경우 프로그램의 성능이 저하된다는 것을 알 수 있다.)
 *
 * 반면 연결 리스트는 참조에 의해서 데이터의 순서를 만들어내기 때문에 중간에 데이터가 추가되거나 제거 된다하더라도
 * 데이터의 이동이 발생하지 않는다. (+ 즉, 데이터의 삽입/제거가 빈번하게 발생 할 경우 배열 리스트에 비해
 * 효율적으로 동작한다는 것을 알 수 있다.)
 *
 * 단, 연결 리스트는 임의 접근이 불가능하기 때문에 특정 데이터의 위치를 알고 있다 하더라도 항상 처음부터 차례대로
 * 접근해야되는 단점이 존재한다. (+ 즉, 데이터의 탐색이 빈번 할 경우 연결 리스트는 프로그램의 성능이 저하된다는 것을
 * 알 수 있다.)
 *
 * 스택 (Stack) 이란?
 * - FILO (First In Last Out) or LIFO (Last In First Out) 구조로 데이터를 관리하는 컬렉션을 의미한다. (+ 즉,
 * 스택은 내부적으로 관리하는 데이터의 입/출력 순서를 엄격하게 제한하는 컬렉션이라는 것을 알 수 있다.)
 *
 * 큐 (Queue) 란?
 * - FIFO (First In First Out) or LILO (Last In Last Out) 구조로 데이터를 관리하는 컬렉션을 의미한다. (+ 즉,
 * 큐 또한 스택과 마찬가지로 내부적으로 관리하는 데이터의 입/출력 순서를 엄격하게 제한하는 컬렉션이라는 것을
 * 알 수 있다.)
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Example 14 (컬렉션 - 1)
 */
public class CE01Example_14 {
	/** 초기화 */
	public static void main(String[] args) {
		Random oRandom = new Random();
		
		List<Integer> oListValuesA = new ArrayList<>();
		LinkedList<Integer> oListValuesB = new LinkedList<>();
		
		for(int i = 0; i < 10; ++i) {
			int nVal = oRandom.nextInt(1, 100);
			
			oListValuesA.add(nVal);
			oListValuesB.add(nVal);
		}
		
		System.out.println("=====> 배열 리스트 <=====");
		
		for(int i = 0; i < oListValuesA.size(); ++i) {
			System.out.printf("%d, ", oListValuesA.get(i));
		}
		
		System.out.println("\n\n=====> 연결 리스트 <=====");
		
		for(int i = 0; i < oListValuesB.size(); ++i) {
			System.out.printf("%d, ", oListValuesB.get(i));
		}
		
		/*
		 * 스택은 다른 컬렉션과 달리 인터페이스를 기준으로 구현 된 컬렉션이 아니라는 것을 알 수 있다. (+ 즉, 스택은
		 * Java 이전 버전과 호환성을 위해서 존재하는 컬렉션이라는 것을 알 수 있다.)
		 */
		Stack<Integer> oStackValues = new Stack<>();
		Queue<Integer> oQueueValues = new LinkedList<>();
		
		System.out.println("\n\n=====> 데이터 입력 순서 <=====");
		
		for(int i = 0; i < 10; ++i) {
			int nVal = oRandom.nextInt(1, 100);
			System.out.printf("%d, ", nVal);
			
			oStackValues.add(nVal);
			oQueueValues.add(nVal);
		}
		
		System.out.println("\n\n=====> 스택 <=====");
		
		while(!oStackValues.isEmpty()) {
			/*
			 * 스택은 다른 컬렉션과 달리 특정 데이터를 가져오면 해당 데이터는 스택에서 제거 되는 특징이 존재한다.
			 * (+ 즉, 스택은 데이터를 제거함으로서 데이터의 접근 순서를 엄격하게 제한 한다는 것을 알 수 있다.)
			 */
			System.out.printf("%d, ", oStackValues.pop());
		}
		
		System.out.println("\n\n=====> 큐 <=====");
		
		while(!oQueueValues.isEmpty()) {
			/*
			 * 큐도 스택과 마찬가지로 특정 데이터를 가져오면 해당 데이터는 큐에서 제거 되는 특징이 존재한다. (+ 즉,
			 * 큐 인터페이스를 구현하는 모든 컬렉션이 동일한 특징을 지니고 있다는 것을 의미한다.)
			 */
			System.out.printf("%d, ", oQueueValues.poll());
		}
		
		System.out.println();
	}
}
