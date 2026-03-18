package Example.Example_06;

/**
 * 캐릭터
 */
public class CCharacter {
	private int m_nLv = 0;
	private int m_nHp = 0;
	private int m_nAtk = 0;
	
	/** 생성자 */
	public CCharacter(int a_nLv, int a_nHp, int a_nAtk) {
		this.m_nLv = a_nLv;
		this.m_nHp = a_nHp;
		this.m_nAtk = a_nAtk;
	}
	
	/** 레벨을 변경한다 */
	public void setLv(int a_nLv) {
		m_nLv = a_nLv;
	}
	
	/** 체력을 변경한다 */
	public void setHp(int a_nHp) {
		m_nHp = a_nHp;
	}
	
	/** 공격력을 변경한다 */
	public void setAtk(int a_nAtk) {
		m_nAtk = a_nAtk;
	}
	
	/** 사본을 반환한다 */
	@Override
	public Object clone() {
		return new CCharacter(m_nLv, m_nHp, m_nAtk);
	}
	
	/** 문자열을 반환한다 */
	@Override
	public String toString() {
		return String.format("레벨 : %d, 체력 : %d, 공격력 : %d", m_nLv, m_nHp, m_nAtk);
	}
}
