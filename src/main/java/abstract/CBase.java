package Example.Example_03;

/**
 * 부모 클래스
 */
public abstract class CBase {
	private int nVal = 0;
	private float fVal = 0.0f;
	
	/** 생성자 */
	public CBase(int a_nVal, float a_fVal) {
		this.nVal = a_nVal;
		this.fVal = a_fVal;
	}
	
	/** 추상 메서드 */
	public abstract void abstractMethod();
	
	/** 정보를 출력한다 */
	public void showInfo() {
		System.out.printf("정수 : %d\n", nVal);
		System.out.printf("실수 : %f\n", fVal);
	}
}
