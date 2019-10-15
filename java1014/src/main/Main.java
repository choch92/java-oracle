package main;

import dao.BuyDao;
import view.BuyView;

public class Main {

	public static void main(String[] args) {
		BuyDao dao = new BuyDao();
		/** 삽입
		Buy buy = new Buy();
		buy.setItemname("커피");
		buy.setCustomerid("ggangpae1");
		buy.setCount(3);
		
		int r = dao.insertBuy(buy);
		if(r>0) {
			System.out.printf("삽입성공\n");
		}else {
			System.out.printf("삽입실패\n");
		}
		**/
		/** 수정
		Buy buy = new Buy();
		buy.setBuycode(1);
		buy.setItemname("과일");
		buy.setCustomerid("jessica72");
		buy.setCount(5);
		
		int r = dao.updateBuy(buy);
		if(r>0) {
			System.out.printf("수정성공\n");
		}else {
			System.out.printf("수정실패\n");
		}
		**/
		/** 삭제
		int r = dao.deleteBuy(1);
		if(r>0) {
			System.out.printf("삭제성공\n");
		}else {
			System.out.printf("삭제실패\n");
		}
		**/
		
		//System.out.printf("%s\n", dao.getList());
		//System.out.printf("%s\n", dao.getBuy(21));
		new BuyView();
	}
}
