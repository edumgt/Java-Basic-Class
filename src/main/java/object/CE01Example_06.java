package Example.Example_06;

/*
 * Object 클래스란?
 * - Java 에 존재하는 모든 클래스가 직/간접적으로 상속하는 클래스를 의미한다. (+ 즉, Object 클래스는
 * 모든 클래스의 최상위 클래스라는 것을 알 수 있다.)
 *
 * Object 클래스에는 finalize 메서드를 비롯한 다양한 메서드가 존재하며 Java 의 모든 클래스는 해당 메서드를
 * 활용하는 것이 가능하다. (+ 즉, 필요에 따라 재정의해서 활용하는 것이 가능하다.)
 *
 * Ex)
 * class CSomeClass {
 * 		@Override
 * 		public String toString() {
 * 			return "클래스 정보";
 * 		}
 * }
 *
 * CSomeClass oSomeObj = new CSomeClass();
 * System.out.println(oSomeObj);
 *
 * 위와 같이 Object 클래스에는 toString 메서드가 존재하며 해당 메서드가 존재하기 때문에
 * System.out.println 메서드에 객체를 전달하는 것이 가능하다. (+ 즉, System.out.println 메서드 내부에서
 * 입력으로 전달 된 객체의 toString 메서드를 호출한다는 것을 알 수 있다.)
 */

/**
 * Example 6
 */
public class CE01Example_06 {
	/** 초기화 */
	public static void main(String[] args) {
		CCharacter oCharacter = new CCharacter(1, 5, 10);
		
		/*
		 * 클래스는 참조 형식 자료형이기 때문에 아래와 같이 특정 클래스 형 변수를 다른 변수에 할당하면
		 * 얕은 복사가 이루어진다. (+ 즉, 사본 변수가 참조하는 객체를 변경했을 경우 원본 변수도 영향을
		 * 받는다는 것을 알 수 있다.)
		 */
		CCharacter oCharacter_CloneA = oCharacter;
		oCharacter_CloneA.setLv(5);
		oCharacter_CloneA.setHp(25);
		oCharacter_CloneA.setAtk(50);
		
		/*
		 * clone 메서드란?
		 * - 사본 객체를 생성하는 역할을 수행하는 메서드를 의미한다. (+ 즉, clone 메서드를 활용하면
		 * 내부적으로 깊은 복사를 통해 완전한 사본 객체를 생성한다는 것을 알 수 있다.)
		 *
		 * 단, 사본 객체를 생성하기 위해서는 해당 객체의 클래스에 clone 메서드를 재정의해줘야한다. (+ 즉,
		 * Object 클래스에 존재하는 clone 메서드를 호출 할 경우 내부적으로 CloneNotSupportedException 예외가
		 * 발생한다는 것을 알 수 있다.)
		 */
		CCharacter oCharacter_CloneB = (CCharacter)oCharacter.clone();
		oCharacter_CloneB.setLv(10);
		oCharacter_CloneB.setHp(500);
		oCharacter_CloneB.setAtk(100);
		
		System.out.println("=====> 원본 캐릭터 <=====");
		System.out.println(oCharacter);
		
		System.out.println("\n=====> 사본 캐릭터 - A <=====");
		System.out.println(oCharacter_CloneA);
		
		System.out.println("\n=====> 사본 캐릭터 - B <=====");
		System.out.println(oCharacter_CloneB);
	}
}
