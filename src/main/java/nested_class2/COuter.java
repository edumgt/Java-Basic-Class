package Example.Example_10;

/**
 * 외부 클래스
 */
public class COuter {
	/**
	 * 멤버 내부 클래스
	 */
	public class CInner_Member {
		private int m_nVal = 0;
		
		/** 값을 증가시킨다 */
		public void incrVal(int a_nVal) {
			m_nVal += a_nVal;
			m_nVal_Outer += a_nVal;
		}
		
		/** 정보를 출력한다 */
		public void showInfo() {
			/*
			 * 아래와 같이 외부 클래스 이름과 this 키워드를 조합하면 동일한 이름의 외부 클래스 멤버에
			 * 접근하는 것이 가능하다.
			 */
			COuter.this.showInfo();
			
			System.out.printf("정수 (내부) : %d\n", m_nVal);
		}
	}
	
	private int m_nVal_Outer = 0;
	
	/** 정보를 출력한다 */
	public void showInfo() {
		System.out.printf("정수 : %d\n", m_nVal_Outer);
	}
	
	/** 지역 내부 클래스 객체를 반환한다 */
	public INested getInner_Local() {
		/**
		 * 지역 내부 클래스
		 */
		class CNested implements INested {
			private int m_nVal = 0;
			
			/** 값을 증가시킨다 */
			@Override
			public void incrVal(int a_nVal) {
				m_nVal += a_nVal;
				COuter.this.m_nVal_Outer += a_nVal;
			}
			
			/** 정보를 출력한다 */
			@Override
			public void showInfo() {
				COuter.this.showInfo();
				System.out.printf("정수 (내부) : %d\n", m_nVal);
			}
		}
		
		/*
		 * 아래와 같이 지역 내부 클래스는 해당 클래스가 정의 된 지역을 벗어나면 더이상 접근이 불가능하기 때문에
		 * 지역 내부 클래스 객체는 해당 클래스가 정의 된 지역에서만 생성이 가능하다는 것을 알 수 있다.
		 */
		return new CNested();
	}
	
	/** 익명 내부 클래스 객체를 반환한다 */
	public INested getInner_Anonymous() {
		/*
		 * 아래와 같이 익명 내부 클래스는 클래스 정의와 객체 생성이 동시에 이루어진다는 것을 알 수 있다. (+ 즉,
		 * 이름이 존재하지 않기 때문에 정의 후 생성이 불가능하다는 것을 알 수 있다.)
		 */
		
		/**
		 * 익명 내부 클래스
		 */
		return new INested() {
			private int m_nVal = 0;
			
			/** 값을 증가시킨다 */
			@Override
			public void incrVal(int a_nVal) {
				m_nVal += a_nVal;
				COuter.this.m_nVal_Outer += a_nVal;
			}
			
			/** 정보를 출력한다 */
			@Override
			public void showInfo() {
				COuter.this.showInfo();
				System.out.printf("정수 (내부) : %d\n", m_nVal);
			}
		};
	}
}
