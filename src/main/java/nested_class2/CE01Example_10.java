package Example.Example_10;

/*
 * 비정적 중첩 클래스 (Nonstatic Nested Class) 란?
 * - 비정적 중첩 클래스는 해당 클래스를 감싸는 외부 클래스의 객체 내부에 생성 가능한 클래스를 의미한다. (+ 즉,
 * 비정적 중첩 클래스를 통해 생성 된 객체는 외부 클래스를 통해 생성 된 객체 내부에 존재한다는 것을 알 수 있다.)
 *
 * 비정적 중첩 클래스를 통해 생성 된 객체는 해당 클래스를 감싸는 외부 클래스 객체의 일부로 취급 되기 때문에
 * 외부 클래스 객체의 private 멤버에 접근하는 것이 가능하다. (+ 즉, 내부 클래스 자체가 외부 클래스의 일부라는 것을
 * 알 수 있다.)
 *
 * Java 비정적 중첩 클래스 종류
 * - 멤버 내부 클래스 (Member Inner Class)
 * - 지역 내부 클래스 (Local Inner Class)
 * - 익명 내부 클래스 (Anonymous Inner Class)
 *
 * 위와 같이 비정적 중첩 클래스는 정의하는 위치와 방법에 따라 다양한 종류가 존재한다는 것을 알 수 있다.
 *
 * 멤버 내부 클래스 (Member Inner Class) 란?
 * - 일반적인 내부 클래스로서 클래스 내부에 정의되는 클래스를 의미한다. (+ 즉, 멤버 내부 클래스는
 * 외부 클래스 내부에 생성되며 외부 클래스의 일부로 취급된다.)
 *
 * Ex)
 * class COuter {
 * 		private int m_nVal = 0;
 *
 * 		class CInner {
 * 			public void someMethod() {
 * 				System.out.println(m_nVal);
 * 			}
 * 		}
 * }
 *
 * COuter oOuter = new COuter();
 *
 * COuter.CInner oInner = oOuter.new CInner();
 * oInner.someMethod();
 *
 * 위와 같이 멤버 내부 클래스는 외부 클래스 객체 내부에 생성되기 때문에 생성 시 외부 클래스 객체를
 * 지정해야한다. (+ 즉, 어떤 객체 내부에 생성 할 지 명시해야한다는 것을 의미한다.)
 *
 * 지역 내부 클래스 (Local Inner Class) 란?
 * - 멤버 내부 클래스와 유사하지만 특정 지역 내부에 정의되는 차이점이 있는 클래스를 의미한다. (+ 즉,
 * 지역 내부 클래스는 메서드와 같은 지역에 정의 된다는 것을 알 수 있다.)
 *
 * 단, 지역 내부 클래스는 멤버 내부 클래스와 달리 외부 클래스에서 직접 접근하는 것이 불가능하며
 * 부모 클래스나 인터페이스를 통해 접근이 가능하다는 특징이 존재한다. (+ 즉, 클래스가 지역에 구현 되어 있기 때문에
 * 해당 클래스를 직접적으로 참조 할 방법이 없다는 것을 알 수 있다.)
 *
 * 또한 지역 내부 클래스는 특정 지역에 정의 된 클래스이기 때문에 지역 내부 클래스 객체 생성은 해당 클래스를
 * 정의 한 지역 내부에서만 가능하다. (+ 즉, 외부에서는 생성이 불가능하다는 것을 알 수 있다.)
 *
 * Ex)
 * interface ISomeInterface {
 * 		public void someMethod();
 * }
 *
 * class COuter {
 * 		private int m_nVal = 0;
 *
 * 		public ISomeInterface getInner() {
 * 			class CInner implements ISomeInterface {
 * 				public void someMethod() {
 * 					System.out.println(m_nVal);
 * 				}
 * 			}
 *
 * 			return new CInner();
 * 		}
 * }
 *
 * COuter oOuter = new COuter();
 *
 * ISomeInterface oInner = oOuter.getInner();
 * oInner.someMethod();
 *
 * 위와 같이 지역 내부 클래스는 멤버 내부 클래스와 달리 생성 된 객체를 직접적으로 참조하는 것이 불가능하다.
 *
 * 익명 내부 클래스 (Anonymous Inner Class) 란?
 * - 익명 내부 클래스는 지역 내부 클래스와 유사하지만 이름이 존재하지 않는 차이점이 존재한다. (+ 즉,
 * 익명 내부 클래스는 추후 람다를 다루기 위해 필요한 기능이라는 것을 알 수 있다.)
 *
 * Ex)
 * interface ISomeInterface {
 * 		public void someMethod();
 * }
 *
 * class COuter {
 * 		private int m_nVal = 0;
 *
 * 		public ISomeInterface getInner() {
 * 			return new ISomeInterface() {
 * 				public void someMethod() {
 * 					System.out.println(m_nVal);
 * 				}
 * 			}
 * 		}
 * }
 *
 * COuter oOuter = new COuter();
 *
 * ISomeInterface oInner = oOuter.getInner();
 * oInner.someMethod();
 *
 * 위와 같이 익명 내부 클래스는 클래스 정의와 객체 생성이 동시에 이루어진다는 것을 알 수 있다.
 */

/**
 * Example 10 (중첩 클래스 - 2)
 */
public class CE01Example_10 {
	/** 초기화 */
	public static void main(String[] args) {
		COuter oOuterA = new COuter();
		COuter oOuterB = new COuter();
		
		/*
		 * 아래와 같이 멤버 내부 클래스는 외부 클래스 객체 내부에 생성 된다는 것을 알 수 있다. (+ 즉,
		 * 멤버 내부 클래스는 단독으로 생성이 불가능하다는 것을 의미한다.)
		 */
		COuter.CInner_Member oInner_MemberA = oOuterA.new CInner_Member();
		COuter.CInner_Member oInner_MemberB = oOuterA.new CInner_Member();
		COuter.CInner_Member oInner_MemberC = oOuterB.new CInner_Member();
		
		oInner_MemberA.incrVal(10);
		oInner_MemberB.incrVal(10);
		oInner_MemberC.incrVal(10);
		
		System.out.println("\n=====> 멤버 내부 클래스 - A <=====");
		oInner_MemberA.showInfo();
		
		System.out.println("\n=====> 멤버 내부 클래스 - B <=====");
		oInner_MemberB.showInfo();
		
		System.out.println("\n=====> 멤버 내부 클래스 - C <=====");
		oInner_MemberC.showInfo();
		
		/*
		 * 아래와 같이 지역 내부 클래스는 특정 지역에 정의 되어 있기 때문에 해당 클래스를 통해 생성 된 객체를
		 * 직접적으로 참조가 불가능하며 부모 클래스나 인터페이스를 통해 간접적으로 참조가 가능하다.
		 */
		INested oInner_LocalA = oOuterA.getInner_Local();
		INested oInner_LocalB = oOuterA.getInner_Local();
		INested oInner_LocalC = oOuterB.getInner_Local();
		
		oInner_LocalA.incrVal(10);
		oInner_LocalB.incrVal(10);
		oInner_LocalC.incrVal(10);
		
		System.out.println("\n=====> 지역 내부 클래스 - A <=====");
		oInner_LocalA.showInfo();
		
		System.out.println("\n=====> 지역 내부 클래스 - B <=====");
		oInner_LocalB.showInfo();
		
		System.out.println("\n=====> 지역 내부 클래스 - C <=====");
		oInner_LocalC.showInfo();
		
		/*
		 * 아래와 같이 익명 내부 클래스 또한 지역 내부 클래스와 마찬가지로 해당 클래스로 생성 된 객체를 직접적으로
		 * 참조하는 것이 불가능하다. (+ 즉, 클래스 이름이 존재하지 않기 때문에 직접적인 참조가 불가능하다는 것을
		 * 알 수 있다.)
		 */
		INested oInner_AnonymousA = oOuterA.getInner_Anonymous();
		INested oInner_AnonymousB = oOuterA.getInner_Anonymous();
		INested oInner_AnonymousC = oOuterB.getInner_Anonymous();
		
		oInner_AnonymousA.incrVal(10);
		oInner_AnonymousB.incrVal(10);
		oInner_AnonymousC.incrVal(10);
		
		System.out.println("\n=====> 익명 내부 클래스 - A <=====");
		oInner_AnonymousA.showInfo();
		
		System.out.println("\n=====> 익명 내부 클래스 - B <=====");
		oInner_AnonymousB.showInfo();
		
		System.out.println("\n=====> 익명 내부 클래스 - C <=====");
		oInner_AnonymousC.showInfo();
	}
}
