package Example.Example_02;

/*
 * 자료형 (Data Type) 이란?
 * - 데이터를 해석하는 방법을 의미한다. (+ 즉, 동일한 형태의 데이터라고 하더라도 자료형에 따라 처리 방식이
 * 달라진다는 것을 알 수 있다.)
 *
 * 또한 자료형은 데이터가 표현 할 수 있는 최대 범위를 제한하는 역할을 수행한다. (+ 즉, 자료형마다 데이터의
 * 최대 표현 범위가 다르다는 것을 알 수 있다.)
 *
 * Java 의 자료형은 데이터를 처리하는 방법에 따라 값 형식 자료형과 참조 형식 자료형으로 구분된다.
 *
 * Java 자료형 종류 - 정수 (Integer)
 * - byte : 1 Byte
 * - short : 2 Byte
 * - int : 4 Byte
 * - long : 8 Byte
 *
 * Java 자료형 종류 - 실수 (Floating Point)
 * - float : 4 Byte
 * - double : 8 Byte
 *
 * Java 자료형 종류 - 문자
 * - char : 2 Byte
 * - String				<- 참조 형식
 *
 * Java 자료형 종류 - 기타
 * - boolean : 1 Byte
 * - class				<- 참조 형식
 * - interface			<- 참조 형식
 *
 * 정수 (Integer) vs 실수 (Floating Point)
 * - 정수는 실수에 비해서 연산 속도가 빠르고 수를 정확하게 표현하는 것이 가능하지만 소수점을 표현하는 것이 불가능하다는
 * 단점이 존재한다.
 *
 * 반면 실수는 소수점이 존재하는 수를 표현하는 것이 가능하지만 정수에 비해 연산 속도와 정밀도가 떨어지는 단점이
 * 존재한다. (+ 즉, 실수는 특정 수를 정확하게 표현하는 것이 불가능하다는 것을 알 수 있다.)
 *
 * 이는 소수점이 존재하는 수를 정확하게 표현하기 위해서는 많은 데이터 (비트) 가 필요하기 때문에 대부분의 컴퓨터는
 * 소수점이 존재하는 수를 표현하기 위해서 부동 소수점 방식을 사용하기 때문이다.
 *
 * 부동 소수점 방식은 적은 데이터 (비트) 를 가지고도 넓은 범위의 수를 표현하기 위해서 특별한 공식을 활용하며
 * 해당 공식에 의해 오차가 발생한다는 것을 알 수 있다. (+ 즉, 부동 소수점 방식은 비트를 바로 수로 변환하는 것이 아니라
 * 공식을 통해 산출 된 결과를 통해 수를 표현하기 때문에 정수에 비해서 처리 속도가 떨어진다는 것을 알 수 있다.)
 *
 * 변수 (Variable) 란?
 * - 데이터를 저장하거나 읽어들일 수 있는 공간을 의미한다. (+ 즉, 변수를 활용하면 특정 데이터를 저장 후 필요 할 때
 * 재사용하는 것이 가능하다.)
 *
 * 변수는 메모리 (주 기억 장치) 에 위치하기 때문에 변수에 접근하기 위한 수단이 필요하며 이때 활용되는 것이
 * 변수의 이름이다. (+ 즉, 변수 이름을 통해 특정 변수를 제어하는 것이 가능하다.)
 *
 * Java 변수 선언 방법
 * - 자료형 + 변수 이름
 *
 * Ex)
 * int nVal = 0;
 * float fVal = 0.0f;
 *
 * 상수 (Constant) 란?
 * - 데이터를 저장하거나 읽어들일 수 있는 공간을 의미한다. (+ 즉, 변수와 유사하다는 것을 알 수 있다.)
 *
 * 단, 데이터를 자유롭게 변경 할 수 있는 변수와 달리 상수는 한번 데이터가 저장되고 나면 이 후 더이상 데이터를
 * 변경하는 것은 불가능하며 읽어들이는 것만 가능하다는 차이점이 존재한다.
 *
 * 따라서 상수에는 데이터를 저장하는 시점이 중요하며 해당 시점은 상수를 선언과 동시에 초기화하는 단계이다. (+ 즉,
 * 상수를 선언과 동시에 데이터를 할당하는 것으로 특정 상수에 데이터를 저장하는 것이 가능하다.)
 *
 * Java 상수 종류
 * - 리터널 상수 (Literal Constant)			<- 이름이 없는 상수 (+ Ex. 'A', 10 등등...)
 * - 심볼릭 상수 (Symbolic Constant)			<- 이름이 존재하는 상수
 *
 * Java 심볼릭 상수 선언 방법
 * - const + 자료형 + 상수 이름
 *
 * Ex)
 * const int nVal = 0;
 * const float fVal = 0.0f;
 *
 * 위와 같이 상수를 선언하고 나면 이후 해당 상수에 저장 된 데이터를 변경하는 것은 불가능하다. (+ 즉, 상수 선언 이후에
 * 데이터를 할당하면 컴파일 에러가 발생한다는 것을 의미한다.)
 *
 * Java 이름 작성 규칙
 * - Java 는 다국어를 지원하기 때문에 영어를 비롯한 다양한 문자를 가지고 이름을 작성하는 것이 가능하다. (+ 단,
 * 대부분의 특수 문자는 사용이 불가능하다.)
 *
 * 단, 전통적으로 이름에 사용 할 수 있는 문자 종류는 알파벳 대/소문자, _ (언더 스코어), 숫자 만을
 * 사용하는 것이기 때문에 가능하면 해당 문자만을 사용하는 것을 추천한다.
 *
 * 따라서 다양한 문자를 조합해서 이름을 작성하는 것이 가능하지만 첫 문자는 숫자가 될 수 없다. (+ 즉, 이름의 첫 문자를
 * 숫자로 명시 할 경우 컴파일 에러가 발생한다는 것을 알 수 있다.)
 *
 * 또한 이름은 대/소문자를 구분하기 때문에 같은 단어라 하더라도 대/소문자 조합이 다르면 서로 다른 이름으로 구분된다.
 *
 * Ex)
 * int nval = 0;
 * int nVal = 0;
 *
 * int nVal_01 = 0;
 * int 01_nVal = 0;			<- 컴파일 에러
 *
 * 위와 같이 nval 변수와 nVal 변수는 동일한 단어지만 V 문자가 서로 다르기 때문에 서로 다른 변수라는 것을 알 수 있다.
 * (+ 즉, 대/소문자를 구별한다는 것을 알 수 있다.)
 *
 * nVal_01 변수와 01_nVal 변수는 변수 이름에 숫자가 들어갔지만 nVal_01 변수는 첫 문자가 숫자가 아니기 때문에
 * 정상적으로 동작하는 반면 01_nVal 변수는 첫 이름이 숫자이기 때문에 컴파일 에러가 발생한다는 것을 알 수 있다.
 */

/**
 * Example 2 (자료형)
 */
public class CE01Example_02 {
	/** 초기화 */
	public static void main(String[] args) {
		byte nByte = Byte.MAX_VALUE;
		short nShort = Short.MAX_VALUE;
		int nInt = Integer.MAX_VALUE;
		long nLong = Long.MAX_VALUE;
		
		/*
		 * System.out.printf 메서드란?
		 * - 형식화 된 문장을 출력 할 수 있는 기능을 제공하는 메서드이다. (+ 즉, 해당 메서드를 활용하면
		 * println 메서드보다 좀 더 다양한 문장을 콘솔 창에 출력하는 것이 가능하다.)
		 *
		 * 형식화 된 문장을 출력하기 위해서는 서식 문자라는 개념이 필요하며 해당 문자는 자료형에 따라 다양한 종류가
		 * 존재한다.
		 *
		 * Java 서식 문자 종류
		 * - %c : char
		 * - %d : integer
		 * - %f : floating point
		 * - %s : string
		 *
		 * Ex)
		 * int nVal = 10;
		 * System.out.printf("정수 : %d\n", nVal);			<- "정수 : 10" 문장 출력
		 *
		 * 위와 같이 서식 문자는 문장이 과정에서 데이터로 치환되서 출력된다는 것을 알 수 있다. (+ 즉, 서식 문자를
		 * 활용하면 문장의 일부 or 전체를 특정 데이터를 조합해서 작성하는 것이 가능하다.)
		 */
		System.out.println("=====> 자료형 - 정수 <=====");
		System.out.printf("Byte : %d\n", nByte);
		System.out.printf("Short : %d\n", nShort);
		System.out.printf("Int : %d\n", nInt);
		System.out.printf("Long : %d\n", nLong);
		
		float fFloat = Float.MAX_VALUE;
		double dblDouble = Double.MAX_VALUE;
		
		System.out.println("\n=====> 자료형 - 실수 <=====");
		System.out.printf("Float : %f\n", fFloat);
		System.out.printf("Double : %f\n", dblDouble);
		
		char chLetterA = 'A';
		char chLetterB = 'B';
		char chLetterC = 'C';
		
		String oStr = "Hello, World!";
		
		System.out.println("\n=====> 자료형 - 문자 <=====");
		System.out.printf("Char : %c%c%c\n", chLetterA, chLetterB, chLetterC);
		System.out.printf("String : %s\n", oStr);
		
		boolean bIsTrue = true;
		
		/*
		 * boolean 자료형 데이터를 출력하기 위한 서식 문자는 별도로 존재하지 않지만 %s 서식 문자를 사용하면
		 * 자동으로 문자열로 변환되서 출력된다.
		 *
		 * 이는 boolean 자료형 데이터 뿐만 아니라 서식 문자가 별도로 존재하지 않는 다른 자료형 데이터도 해당 규칙을
		 * 따른다. (+ 즉, 서식 문자가 별도로 존재하는 데이터 이외에는 모두 %s 서식 문자를 사용하면 된다.)
		 */
		System.out.println("\n=====> 자료형 - 기타 <=====");
		System.out.printf("Boolean : %s\n", bIsTrue);
	}
}
