package preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrepareStatementMain {

	public static void main(String[] args) {

		try {
			// 오라클 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스 접속
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe",
					  "user10", "user10");
			// SQL 실행 객체 만들기
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM EMP");
			// SQL 실행
			ResultSet rs = pstmt.executeQuery();
			// SELECT 구문의 결과 읽기
			while(rs.next()) {
				int EMPNO = rs.getInt("EMPNO");
				String ENAME = rs.getString("ENAME");
				// null 데이터를 자바에서 처리하고자 할 때는 문자열로 받아서 null인 경우를 비교해서 작업
				// 오라클에서 처리할 때는 NVL(컬럼이름, 대체값)
				String COMM = rs.getString("COMM");
				System.out.printf("사원번호:%d 사원이름:%s 상여금:%s\n", EMPNO, ENAME, COMM);			
			}		
			System.out.printf("접속성공\n");
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}
}
