package useoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserStatementMain {

	public static void main(String[] args) {
		// 데이터베이스 드라이버 클래스 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe", "user10", "user10");
			Statement stmt = con.createStatement();
			// SQL을 작성할 때 예약어는 대소문자 구분을 안하고 앞 뒤에 공백을 추가
			int r = stmt.executeUpdate("insert into dept(deptno, dname, loc) " + "values(99, '비서', '서울')");
			// 삽입일 때는 0이면 실패
			if(r > 0) {
				System.out.printf("삽입성공\n");
			}else {
				System.out.printf("삽입실패\n");
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
