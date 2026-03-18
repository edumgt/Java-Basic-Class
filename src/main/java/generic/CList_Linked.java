package Example.Example_13;

/**
 * 연결 리스트
 */
public class CList_Linked<T extends Comparable<T>> {
	/**
	 * 노드
	 */
	private class CNode {
		public T m_tVal;
		public CNode m_oNode_Next = null;
	}
	
	private int m_nNumValues = 0;
	private CNode m_oNode_Head = null;
	
	/** 생성자 */
	public CList_Linked() {
		m_oNode_Head = new CNode();
	}
	
	/** 값 개수를 반환한다 */
	public int getNumValues() {
		return m_nNumValues;
	}
	
	/** 값을 반환한다 */
	public T getVal(int a_nIdx) {
		CNode oNode = m_oNode_Head.m_oNode_Next;
		
		for(int i = 0; i < a_nIdx; ++i) {
			oNode = oNode.m_oNode_Next;
		}
		
		return oNode.m_tVal;
	}
	
	/** 값을 추가한다 */
	public void addVal(T a_tVal) {
		CNode oNode_Tail = m_oNode_Head;
		
		while(oNode_Tail.m_oNode_Next != null) {
			oNode_Tail = oNode_Tail.m_oNode_Next;
		}
		
		oNode_Tail.m_oNode_Next = this.createNode(a_tVal);
		m_nNumValues += 1;
	}
	
	/** 노드를 생성한다 */
	private CNode createNode(T a_tVal) {
		CNode oNode = new CNode();
		oNode.m_tVal = a_tVal;
		
		return oNode;
	}
}
