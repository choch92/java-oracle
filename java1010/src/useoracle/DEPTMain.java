package useoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DEPTMain {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스 연결
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe",
										  "user10", "user10");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from sample ");
			while(rs.next()) {
				String cname = rs.getString("cname");
				String vname = rs.getString("vname");
				con.setAutoCommit(false);
				// cname 같은 경우는 뒤에 공백이 생성이 되어서 false 리턴, vname은 공백이 없음
				// 그래서 true로 리턴받기 위해서 trim()을 추가
				System.out.printf("%b\n", cname.trim().equals("HELLO"));
				System.out.printf("%b\n", vname.equals("HELLO"));
				/**
				// int DEPTNO = rs.getInt(1);
				// String으로 해도 정상 출력 됨
				String DEPTNO = rs.getString(1);
				String DNAME = rs.getString("DNAME");
				String LOC = rs.getString("LOC");
				System.out.printf("부서번호:%s 부서이름:%s 지역:%s\n", DEPTNO,DNAME,LOC);
				**/
			}
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
