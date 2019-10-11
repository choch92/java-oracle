package useoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserStatementMain2 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe",
										  "user10", "user10");
			Statement stmt = con.createStatement();
			int r = stmt.executeUpdate("update DEPT " + "set LOC = '종로' "
			+ "where DEPTNO = 10");
			if(r > 0) {
				System.out.printf("수정 성공\n");
			}else {
				System.out.printf("10번이 없음\n");
			}
			stmt.close();
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
