package useoracle;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserOracleMain {

	public static void main(String[] args) {
		// 데이터베이스 드라이버 클래스 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe", "user10", "user10");
			System.out.printf("데이터베이스 연결 성공\n");
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
