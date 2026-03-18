package Example.Example_05;

/**
 * 예외
 */
public class CException extends Exception {
	/** 생성자 */
	public CException(String a_oMsg) {
		/*
		 * Exception 클래스에 구현 된 문자열을 전달 받는 생성자를 호출하면 이 후 getMessage 메서드를 통해서
		 * 해당 문자열을 가져오는 것이 가능하다. (+ 즉, Exception 생성자를 활용하면 예외가 발생 한 이유 등을
		 * 저장하는 것이 가능하다.)
		 */
		super(a_oMsg);
	}
}
