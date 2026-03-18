package Example.Example_03;

/**
 * 자식 클래스
 */
public class CDerived extends CBase {
	private String oStr = "";
	
	/** 생성자 */
	public CDerived(int a_nVal, float a_fVal, String a_oStr) {
		super(a_nVal, a_fVal);
		this.oStr = a_oStr;
	}
	
	/** 추상 메서드 */
	@Override
	public void abstractMethod() {
		System.out.println("자식 클래스에서 추상 메서드를 구현했습니다.");
	}
	
	/** 정보를 출력한다 */
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.printf("문자열 : %s\n", oStr);
	}
}
