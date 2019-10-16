package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.BuyDao;
import domain.Buy;
import service.BuyEventHandler;

public class BuyView extends JFrame {
	
	public JTextField txtItemName, txtCustomerId, txtCount, txtBuyDate;
	public JLabel lblItemName, lblCustomerId, lblCount, lblBuyDate;
	// 데이터 조회를 위한 컴포넌트
	public JButton btnLast, btnPrev, btnNext, btnFirst;
	public JLabel lblNum;
	
	// 데이터 작업을 수행할 컴포넌트
	public JButton btnInsert, btnDelete, btnUpdate, btnSearch, btnClear;
	
	// 데이터를 저장할 변수를 선언
	public List<Buy> list;
	// 현재 보여지는 데이터의 인덱스를 저장할 변수
	public int idx;
	
	public BuyView() {
		// 4줄 2칸으로 만들고 여백을 가로 3 세로 3으로 설정
		JPanel p1 = new JPanel(new GridLayout(4,2,3,3));
		lblItemName = new JLabel("아이템이름", JLabel.RIGHT);
		txtItemName = new JTextField();
		lblCustomerId = new JLabel("구매자아이디", JLabel.RIGHT);
		txtCustomerId = new JTextField();
		lblCount = new JLabel("구매수량", JLabel.RIGHT);
		txtCount = new JTextField();
		txtCount.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				// 0에서 9사이의 키가 아닌 것을 누르면 
				if(e.getKeyCode() < KeyEvent.VK_0 || e.getKeyCode() > KeyEvent.VK_9) {
					String imsi = "";
					int len = txtCount.getText().length();
					for(int i=0; i<len-1; i=i+1) {
						char ch = txtCount.getText().charAt(i);
						imsi = imsi + ch;
					}
					txtCount.setText(imsi);
				}
			}		
		});
		lblBuyDate = new JLabel("구매날짜", JLabel.RIGHT);
		txtBuyDate = new JTextField();
		txtBuyDate.setEditable(false);
			
		p1.add(lblItemName);
		p1.add(txtItemName);
		p1.add(lblCustomerId);
		p1.add(txtCustomerId);
		p1.add(lblCount);
		p1.add(txtCount);
		p1.add(lblBuyDate);
		p1.add(txtBuyDate);
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add("Center", p1);
		
		btnNext = new JButton("다음");
		btnPrev = new JButton("이전");
		btnFirst = new JButton("처음");
		btnLast = new JButton("끝");
		lblNum = new JLabel("", JLabel.CENTER);
		
		BuyEventHandler eventhandler = new BuyEventHandler(this);
		btnNext.addActionListener(eventhandler);
		btnPrev.addActionListener(eventhandler);
		btnFirst.addActionListener(eventhandler);
		btnLast.addActionListener(eventhandler);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,5,3,3));
		p2.add(btnFirst);
		p2.add(btnPrev);
		p2.add(lblNum);
		p2.add(btnNext);
		p2.add(btnLast);
		centerPanel.add("South", p2);
		add(centerPanel);
		
		btnInsert = new JButton("삽입");
		btnDelete = new JButton("삭제");
		btnUpdate = new JButton("수정");
		btnSearch = new JButton("조회");
		btnClear = new JButton("지움");
		
		btnInsert.addActionListener(eventhandler);
		btnDelete.addActionListener(eventhandler);
		btnUpdate.addActionListener(eventhandler);
		btnSearch.addActionListener(eventhandler);
		btnClear.addActionListener(eventhandler);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,5,3,3));
		southPanel.add(btnInsert);
		southPanel.add(btnDelete);
		southPanel.add(btnUpdate);
		southPanel.add(btnSearch);
		southPanel.add(btnClear);
		add("South",southPanel);

		setTitle("구매");
		// 위치와 크기를 한번에 설정
		setBounds(200,100,400,400);
		// 종료 기능 부여
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		// 전체 데이터 가져와서 list에 저장
		BuyDao dao = new BuyDao();
		list = dao.getList();
		// 데이터 출력하는 메소드 호출
		display();
	}
	
	// list에서 idx번째 데이터를 가져와서 화면에 출력하는 메소드
	public void display() {
		// 배열이나 List에서 데이터를 꺼낼 때 ArrayIndexOutOfBoundsException에 주의
		if(list == null || list.size() == 0) {
			JOptionPane.showMessageDialog(null, "출력할 데이터가 없습니다.");
			return;
		}
		Buy buy = list.get(idx);
		this.txtItemName.setText(buy.getItemname());
		this.txtCustomerId.setText(buy.getCustomerid());
		// 숫자나 날짜는 문자열로 변환해서 출력
		// 문자열이 들어가야되는데 숫자여서 숫자 + ""(문자)로 해서 문자열 생성
		String disp = String.format("%d개", buy.getCount());
		this.txtCount.setText(disp);
		// this.txtCount.setText(buy.getCount() + "");
		// 날짜는 toString()을 붙여주면 문자열로 변경됨
		this.txtBuyDate.setText(buy.getBuydate().toString());
		this.lblNum.setText((idx+1)+"");
	}
}
