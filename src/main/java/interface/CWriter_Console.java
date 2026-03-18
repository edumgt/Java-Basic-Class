package Example.Example_04;

/**
 * 콘솔 출력자
 */
public class CWriter_Console implements IWriter {
	/** 문자열을 출력한다 */
	@Override
	public void writeStr(String a_oStr) {
		System.out.println(a_oStr);
	}
}
