package preparestatement;

import javax.swing.JOptionPane;

import dao.EMPDAO;

public class EMPMain {

	public static void main(String[] args) {
		// Static 코드는 클래스 이름이 처음 사용될 때 호출
		EMPDAO dao = new EMPDAO();
		int r = JOptionPane.showConfirmDialog(null, "정말로 삭제", "데이터 삭제?", JOptionPane.YES_NO_CANCEL_OPTION);
		if(r == JOptionPane.YES_OPTION) {
			dao.deleteEMP(9999);
			JOptionPane.showMessageDialog(null, "삭제성공");
		}else {
			JOptionPane.showConfirmDialog(null, "삭제하지않음");
		}
		/** 데이터 삽입
		//System.out.printf("%s\n", dao.getList());
		// 7788 인 데이터가 존재해서 출력
		//System.out.printf("%s\n", dao.getEMP(7788));
		// 1000번인 데이터는 존재하지 않아서 null이 리턴되서 출력되지 않음
		//System.out.printf("%s\n", dao.getEMP(1000));
		EMP emp = new EMP();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.printf("사원번호입력 : ");
			int empno = sc.nextInt();
			// 사원번호에 해당하는 데이터를 조회
			EMP temp = dao.getEMP(empno);
			// 데이터가 없다면 다음 작업을 진행			
			if(temp==null)
			{
				// 사원번호 설정
				emp.setEMPNO(empno);
				break;
			}
			System.out.printf("중복된 번호입니다.\n");
		}
		sc.close();
		emp.setENAME("CHO");
		emp.setJOB("STUDENT");
		emp.setMGR(7788);
		Calendar cal = new GregorianCalendar(2019, 9, 11);
		emp.setHIREDATE(new Date(cal.getTimeInMillis()));
		emp.setSAL(5000);
		emp.setCOMM(1000);
		emp.setDEPTNO(20);
		
		int r = dao.insertEMP(emp);
		if(r >= 0) {
			System.out.printf("삽입성공\n");
		}else {
			System.out.printf("삽입실패\n");
		}
		**/
	}
}
