package Example.Example_19;

/*
 * DB (Database) 란?
 * - 여러 사람이 공유하고 사용 할 수 있도록 체계적으로 정리한 데이터의 집합을 의미한다. (즉,
 * DB 는 데이터를 체계화하여 통합하고 관리하는 데이터의 집합이라는 것을 알 수 있다.)
 *
 * DBMS (Database Management System) 란?
 * - 데이터를 저장하고 제어 할 수 있도록 해주는 시스템을 의미한다. (+ 즉,
 * DBMS 는 DB 에 데이터를 저장하고 제어 할 수 있도록 도와주는 소프트웨어라는 것을 알 수 있다.)
 *
 * DB 의 필요성
 * - 정확하고 빠른 정보 제공
 * - 효율적인 데이터 관리와 분석 가능
 * - 기업 운영 자동화 및 의사결정 지원
 * - 데이터 중복 제거 및 일관성 유지
 *
 * SQLite 란?
 * - SQLite 는 서버가 필요 없는 경량형 관계형 데이터베이스 관리 시스템 (RDBMS) 으로 데이터를
 * 하나의 파일에 저장하며 임베디드 (내장형) 시스템에 적합합니다. (+ 즉, SQLite 는 파일 기반 DB 라는 것을
 * 알 수 있다.)
 *
 * Java 에서 SQLite 와 같은 DB 를 연동하기 위해서는 JDBC (Java Database Connectivity) 를 활용해야한다.
 *
 * JDBC (Java Database Connectivity) 란?
 * - Java 에서 DB 와 연결하고 SQL 을 실행하기 위한 표준 API 입니다. (+ 즉, JDBC 를 활용하면 다양한 DB 를
 * 손쉽게 제어하는 것이 가능하다.)
 *
 * JDBC 는 인터페이스의 집합이며 각 DB 벤더 (Oracle, MySQL, SQLite 등등...) 는 이 인터페이스를 구현한
 * 드라이버를 제공합니다.
 *
 * Java 프로그램은 JDBC API 를 사용해 DB 연결, SQL 실행, 결과 조회 등의 작업을 처리하는 것이 가능하다.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Example 19 (DB)
 */
public class CE01Example_19 {
	/** 초기화 */
	public static void main(String[] args) {
		/*
		 * DriverManager 클래스란?
		 * - DB 드라이버를 관리하고 연결을 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉, 
		 * DriverManager 클래스를 활용하면 SQLite 와 같은 DB 를 손쉽게 제어하는 것이 가능하다.)
		 *
		 * Connection 클래스란?
		 * - DB 를 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉, Connection 클래스를 활용하면
		 * DB 에 SQL 구문을 실행하는 등의 작업을 처리하는 것이 가능하다.)
		 */
		try(Connection oConnection = DriverManager.getConnection("jdbc:sqlite:P_E01Example_19_01.db")) {
			String oSQL_CreateTable = "CREATE TABLE IF NOT EXISTS MemberTable(Name TEXT PRIMARY KEY, PNumber TEXT)";
			
			/*
			 * Statement 클래스란?
			 * - SQL 구문을 실행하고 실행에 대한 결과를 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉,
			 * Statement 클래스를 활용하면 DB 에 테이블을 생성하는 등의 명령을 실행하는 것이 가능하다.)
			 */
			try(Statement oStatement = oConnection.createStatement()) {
				/*
				 * execute 메서드란?
				 * - SQL 구문을 실행하는 역할을 수행하는 메서드를 의미한다. (+ 즉, execute 메서드를 활용하면
				 * DB 에 SQL 구문을 전달해서 실행 시키는 것이 가능하다.)
				 *
				 * Primary Key 란?
				 * - 레코드 (Record) 를 식별 할 수 있는 필드를 의미한다. (+ 즉, Primary Key 는
				 * 데이터를 식별하기 위한 식별자이기 때문에 중복이 허용 되지 않는다.)
				 *
				 * 일반적으로 DB 는 Primary Key 설정을 강제 하지 않지만 가능하면 Primary Key 를
				 * 설정 해주는 것이 좋다. (+ 즉, Primary Key 를 설정하면 데이터를 명확하게 식별하는 것이
				 * 가능하다.)
				 */
				oStatement.execute(oSQL_CreateTable);
			}
			
			String oSQL_InsertMember = "INSERT OR IGNORE INTO MemberTable(Name, PNumber) VALUES(?, ?)";
			
			/*
			 * PreparedStatement 클래스란?
			 * - 미리 컴파일 된 SQL 구문을 실행하고 실행에 대한 결과를 제어하는 역할을 수행하는 클래스를 의미한다.
			 * (+ 즉, PreparedStatement 클래스를 활용하면 Statement 클래스보다 좀 더 빠르게 SQL 구문을
			 * 처리하는 것이 가능하다.)
			 */
			try(PreparedStatement oStatement = oConnection.prepareStatement(oSQL_InsertMember)) {
				oStatement.setString(1, "회원 A");
				oStatement.setString(2, "1234");
				
				/*
				 * executeUpdate 메서드란?
				 * - execute 메서드와 같이 SQL 구문을 실행하는 역할을 수행하는 메서드를 의미한다.
				 *
				 * 단, executeUpdate 메서드는 execute 메서드와 달리 ? 구문으로 데이터를 바인딩하는 SQL 구문을
				 * 처리하는 것이 가능하다. (+ 즉, executeUpdate 메서드는 데이터와 SQL 구문을
				 * 동적으로 바인딩하는 기능을 제공한다는 것을 알 수 있다.)
				 */
				oStatement.executeUpdate();
				
				oStatement.setString(1, "회원 B");
				oStatement.setString(2, "1234");
				
				oStatement.executeUpdate();
			}
			
			String oSQL_Query = "SELECT * FROM MemberTable";
			
			try(Statement oStatement = oConnection.createStatement()) {
				/*
				 * ResultSet 클래스란?
				 * - SQL 구문 중 SELECT 명령문을 실행 한 결과를 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉,
				 * ResultSet 클래스를 활용하면 DB 로부터 가져온 데이터의 필드를 가져오는 것이 가능하다.)
				 *
				 * ResetSet 은 열거 가능한 객체이기 때문에 반복문을 활용하면 쿼리 결과로 가져 온 모든 데이터에
				 * 접근하는 것이 가능하다.
				 *
				 * executeQuery 메서드란?
				 * - SQL 구문 중 SELECT 명령문을 실행하고 실행에 대한 결과를 반환하는 메서드를 의미한다. (+ 즉,
				 * executeQuery 메서드를 활용하면 DB 로부터 데이터를 가져오는 것이 가능하다.)
				 */
				ResultSet oResult = oStatement.executeQuery(oSQL_Query);
				
				System.out.println("=====> 모든 회원 정보 <=====");
				
				while(oResult.next()) {
					System.out.printf("이름 : %s\n", oResult.getString(1));
					System.out.printf("전화 번호 : %s\n\n", oResult.getString(2));
				}
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
