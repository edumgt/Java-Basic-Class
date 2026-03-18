package Example.Example_15;

/*
 * 비선형 컬렉션 (Nonlinear Collection) 이란?
 * - 내부적으로 복잡한 형태로 데이터를 관리하는 컬렉션을 의미한다. (+ 즉, 비선형 컬렉션은 선형 컬렉션에 비해
 * 내부 동작이 복잡하다는 것을 알 수 있다.)
 *
 * 비선형 컬렉션은 데이터를 복잡한 형태로 관리하기 때문에 선형 컬렉션에 비해 구현 난이도가 높지만 많은 데이터를
 * 효율적으로 관리 할 수 있다는 장점이 존재한다. (+ 즉, 비선형 컬렉션은 관리되는 데이터의 개수가 많을수록
 * 성능이 뛰어나다는 것을 알 수 있다.)
 *
 * Java 주요 비선형 컬렉션 종류
 * - 셋 (Set)
 * - 맵 (Map)
 *
 * 셋 (Set) 이란?
 * - 관리되는 데이터의 중복을 허용하지 않는 컬렉션을 의미한다. (+ 즉, 셋은 수학의 집합의 특징을 지니고 있다는 것을
 * 알 수 있다.)
 *
 * 맵 (Map) 이란?
 * - 탐색에 특화 된 컬렉션을 의미하며 키 (Key) / 벨류 (Value) 쌍으로 데이터를 관리하는 특징이 존재한다. (+ 즉, 맵은
 * 데이터가 많을수록 다른 컬렉션에 비해 탐색 성능이 좋다는 것을 알 수 있다.)
 *
 * 맵은 키를 기반으로 벨류 (데이터) 를 제어하는 컬렉션이기 때문에 키는 중복을 허용하지 않는다. (+ 즉, 키는 데이터에
 * 접근하기 위한 식별자의 역할이라는 것을 알 수 있다.)
 *
 * 반면 벨류는 컬렉션을 통해 관리하고 싶은 실제 데이터이기 때문에 중복이 허용된다는 차이점이 존재한다.
 *
 * Java 의 비선형 컬렉션은 내부적으로 구현 방식에 따라 해시 테이블 (Hash Table) 기반 컬렉션과
 * 밸런스 이진 탐색 트리 (Balance Binary Search Tree) 기반 컬렉션으로 구분된다.
 *
 * 해시 테이블 (Hash Table) 이란?
 * - 해시 함수 (Hash Function) 를 기반으로 데이터를 빠르게 탐색 할 수 있는 컬렉션을 의미하며 메모리를 많이 사용하는
 * 단점이 존재한다. (+ 즉, 해시 테이블은 메모리를 희생해서 탐색 성능을 끌어올린다는 것을 알 수 있다.)
 *
 * 밸런스 이진 탐색 트리 (Balance Binary Search Tree) 란?
 * - 이진 탐색 알고리즘을 트리를 통해 표현 한 컬렉션을 의미하며 데이터가 추가 or 제거 되는 과정에서 트리의 균형이
 * 무너지지 않도록 스스로 균형을 회복하는 특징을 지니고 있다.
 *
 * 해시 테이블 vs 밸런스 이진 탐색 트리
 * - 해시 테이블은 내부적으로 해시 함수를 기반으로 데이터를 관리하기 때문에 최선의 경우 상수 시간 O (1) 에 데이터에
 * 접근하는 것이 가능하다. (+ 즉, 특정 데이터에 한번에 연산만으로 접근 한다는 것을 의미한다.)
 *
 * 단, 해시 테이블은 최악의 경우 탐색 성능이 선형 시간 O (N) 으로 떨어지는 단점이 존재한다. (+ 즉, 내부적으로
 * 충돌이 많이 발생 할 경우 탐색 성능이 저하 된다는 것을 알 수 있다.)
 *
 * 반면 밸런스 이진 탐색 트리는 해시 테이블과 달리 최선의 경우든 최악의 경우든 탐색 성능이 로그 시간 O (logN) 이다.
 * (+ 즉, 밸런스 이진 탐색 트리는 해시 테이블에 비해서 안정적이라는 것을 알 수 있다.)
 *
 * 단, 밸런스 이진 탐색 트리는 트리의 균형이 무너 질 경우 탐색 성능이 선형 시간 O (N) 으로 떨어지는 단점이 있기
 * 때문에 이를 방지하기 위해서 데이터가 추가 or 제거 되는 과정에서 트리의 균형을 회복하기 위한 추가적인 연산이
 * 발생한다. (+ 즉, 밸런스 이진 탐색은 데이터가 빈번하게 추가 or 제거 될 경우 프로그램 성능이 저하 된다는 것을
 * 알 수 있다.)
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Example 15 (컬렉션 - 2)
 */
public class CE01Example_15 {
	/** 초기화 */
	public static void main(String[] args) {
		Random oRandom = new Random();
		HashSet<Integer> oSetValues = new HashSet<>();
		
		System.out.println("=====> 데이터 입력 순서 <=====");
		
		for(int i = 0; i < 10; ++i) {
			int nVal = oRandom.nextInt(1, 10);
			System.out.printf("%d, ", nVal);
			
			oSetValues.add(nVal);
		}
		
		System.out.println("\n\n=====> 셋 <=====");
		
		/*
		 * 셋은 중복적인 데이터를 필터링하기 위한 용도로 활용되기 때문에 셋에 존재하는 데이터를 직접적으로 가져오기 위한
		 * 인터페이스가 존재하지 않는다. (+ 즉, 인덱스 연산자 등을 지원하지 않는다는 것을 알 수 있다.)
		 */
		for(int nVal: oSetValues) {
			System.out.printf("%d, ", nVal);
		}
		
		System.out.printf("\n\n개수 : %d\n", oSetValues.size());
		HashMap<String, Integer> oMapValues = new HashMap<>();
		
		for(int i = 0; i < 10; ++i) {
			String oKey = String.format("Key_%02d", i + 1);
			oMapValues.put(oKey, i + 1);
		}
		
		System.out.println("\n=====> 맵 <=====");
		
		/*
		 * 맵은 키/벨류 쌍으로 데이터를 관리하기 때문에 맵 컬렉션을 직접적으로 foreach 반복문에 사용하는 것이
		 * 불가능하다.
		 *
		 * 따라서 맵은 keySet 과 같은 메서드가 존재하며 해당 메서드를 활용하면 반복 가능한 데이터를 통해 맵에
		 * 존재하는 모든 데이터를 순회하는 것이 가능하다.
		 */
		for(String oKey : oMapValues.keySet()) {
			int nVal = oMapValues.get(oKey);
			System.out.printf("%s:%d, ", oKey, nVal);
		}
		
		System.out.println();
	}
}
