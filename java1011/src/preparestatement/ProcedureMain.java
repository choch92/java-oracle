package preparestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ProcedureMain {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe",
					  "user10", "user10");
			// 프로시저를 실행할 수 있는 객체를 생성
			CallableStatement call = con.prepareCall("{call myproc(?,?,?)}");
			call.setInt(1, 77);
			call.setString(2, "회계");
			call.setString(3, "영월");
			call.executeUpdate();
			call.close();
			con.close();			
		}catch(Exception e) {
			System.out.printf("프로시저 실행 예외 : %s\n", e.getMessage());
			e.printStackTrace();
		}
	}
}
