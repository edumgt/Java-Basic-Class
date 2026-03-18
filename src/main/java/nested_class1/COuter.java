package Example.Example_09;

/**
 * 외부 클래스
 */
public class COuter {
	/**
	 * 정적 중첩 클래스
	 */
	public static class CNested_Static {
		private static int m_nVal = 0;
		
		/** 값을 증가시킨다 */
		public static void incrVal(int a_nVal) {
			m_nVal += a_nVal;
			COuter.m_nVal_Outer += a_nVal;
		}
		
		/** 정보를 출력한다 */
		public static void showInfo() {
			COuter.showInfo();
			System.out.printf("정수 (내부) : %d\n", m_nVal);
		}
	}
	
	private static int m_nVal_Outer = 0;
	
	/** 값을 증가시킨다 */
	public static void incrVal(int a_nVal) {
		m_nVal_Outer += a_nVal;
	}
	
	/** 정보를 출력한다 */
	public static void showInfo() {
		System.out.printf("정수 : %d\n", m_nVal_Outer);
	}
}
