package Example.Example_17;

/**
 * 카운터
 */
public class CCounter {
	private int m_nCount = 0;
	
	/** 카운트를 반환한다 */
	public int getCount() {
		return m_nCount;
	}
	
	/** 카운트를 증가 시킨다 */
	public void incrCount(int a_nCount) {
		m_nCount += a_nCount;
	}
}
