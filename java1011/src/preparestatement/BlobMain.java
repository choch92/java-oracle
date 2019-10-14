package preparestatement;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BlobMain {

	public static void main(String[] args) {
		// 2.blob 읽어보기
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe",
					  "user10", "user10");
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM blobsample");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String filename = rs.getString("filename");
				// BLOB 가져오기
				InputStream is = rs.getBinaryStream("filecontent");
				// 현재 디렉토리에 filename을 갖는 파일 기록 객체를 생성
				FileOutputStream fos = new FileOutputStream("./" + filename);
				// is의 내용을 fos에 기록
				while(true) {
					// 한번에 읽을 배열을 생성
					byte [] b = new byte[1024];
					// is의 내용을 읽어서 b에 저장
					// 읽은 개수를 len에 저장
					int len = is.read(b);
					// 읽은 데이터가 없으면 그만 읽기
					if(len <= 0) {
						break;
					}
					// 읽은 내용을 fos에 기록
					fos.write(b, 0, len);					
				}
				// 기록을 하게 되면 버퍼에 기록합니다.
				// flush 와 close 를 호출해야만 기록이 완료
				fos.close();
				fos.close();
			}
			rs.close();
			pstmt.close();
			con.close();			
		}catch(Exception e) {
			System.out.printf("blob 저장 예외 : %s\n", e.getMessage());
			e.printStackTrace();
		}
		/**
		// 1. blob 저장하기
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe",
					  "user10", "user10");
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO blobsample(filename, filecontent) "
					+ "values(?, ?)");
			String filepath = "/Users/503a2/Desktop/02.png";
			FileInputStream fis = new FileInputStream(filepath);
			
			// 파일 경로에서 이름만 가져오기
			// /로 분할 한 후 가장 마지막 문자열
			String [] ar = filepath.split("/");
			String filename = ar[ar.length-1];
			System.out.println(filename);
			pstmt.setString(1, filename);
			// blob 바인딩
			pstmt.setBinaryStream(2, fis);
			// 실행
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		}catch(Exception e) {
			System.out.printf("blob 저장 예외 : %s\n", e.getMessage());
			e.printStackTrace();
		}
		**/
	}
}
