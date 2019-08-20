package Package;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//jtable스크롤?
//jtable
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Package.Carrier.MenuActionListener;

public class Customer extends JFrame {
	public static Customer me;
	JLabel address = new JLabel("고객 주소");// 라벨생성
	JLabel number = new JLabel("고객 번호");
	JLabel payway = new JLabel("결제방법");
	JLabel howmuch = new JLabel("결제금액");
	JLabel won = new JLabel("원");
	JLabel count = new JLabel("잔여횟수:");

	JTextField addresstextField, numberField, howmuchField;// 입력칸 및 라디오버튼
	JRadioButton cash = new JRadioButton();
	JRadioButton card = new JRadioButton();
	JButton send = new JButton("신청");
	JButton resend = new JButton("재신청");

	
	public static String id;

	String columNames[] = { "id", "주소", "번호", "결제방법", "결제금액", "현재상황", "라이더" };
	Object Data[][] = { {null, null, null, null, null, null, null } };

	JTable jtable = new JTable(Data, columNames);
	JScrollPane jscrollPane = new JScrollPane(jtable);

	public void refresh() {
		count.setText("잔여횟수: " + countprocess.count(id));
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columNames);
		
		for (String i : dataorder.ordercustomer(id)) {
			model.addRow(new Object[] { i, dataorder.addr(i), dataorder.phone(i), dataorder.method(i), dataorder.price(i),
					dataorder.status(i), dataorder.carrier(i) });
		}
		jtable.setModel(model);

		jtable.getColumnModel().getColumn(0).setMinWidth(0);
		jtable.getColumnModel().getColumn(0).setMaxWidth(0);
		jtable.getColumnModel().getColumn(0).setWidth(0);
		   
	}

	Customer(String id) {
		Customer.id = id;
		me = this;
		setSize(500, 800);
		setTitle("가게");

		//////////////////////////////////////////
		// 레이아웃 설정하기
		JLayeredPane layoutPane = new JLayeredPane();
		layoutPane.setBounds(0, 0, 1600, 900);
		layoutPane.setLayout(null);
		JPanel panel = new JPanel();
		ImageIcon cashIcon = new ImageIcon("images/cash.jpg");
		ImageIcon cashIcon2 = new ImageIcon("images/cash2.jpg");
		ImageIcon cardIcon = new ImageIcon("images/card.jpg");
		ImageIcon cardIcon2 = new ImageIcon("images/card2.jpg");

		////// 글씨 and 입력칸/////
		panel.setBounds(0, 0, 500, 800);
		address.setBounds(50, 50, 200, 30);// 글씨:주소
		number.setBounds(50, 90, 200, 30);// 글씨:번호
		payway.setBounds(50, 130, 200, 30);// 글씨:결제 방법
		howmuch.setBounds(50, 200, 200, 30);// 글씨:가격
		won.setBounds(210, 200, 100, 30);
		count.setBounds(50, 260, 200, 30);
		count.setForeground(Color.red);

		layoutPane.add(payway);
		layoutPane.add(address);
		layoutPane.add(number);
		layoutPane.add(howmuch);
		layoutPane.add(won);
		layoutPane.add(count);
		addresstextField = new JTextField();// 주소입력
		numberField = new JTextField();// 번호입력
		howmuchField = new JTextField();
		cash = new JRadioButton(cashIcon);// 현금
		card = new JRadioButton(cardIcon);// 카드
		ButtonGroup g = new ButtonGroup();// 버튼 그룹생성
		cash.setSelectedIcon(cashIcon2);
		card.setSelectedIcon(cardIcon2);
		g.add(card);
		g.add(cash);

		layoutPane.add(addresstextField);
		layoutPane.add(numberField);
		layoutPane.add(cash);
		layoutPane.add(card);
		layoutPane.add(howmuchField);
		layoutPane.add(send);
		layoutPane.add(resend);
		layoutPane.add(jscrollPane);

		addresstextField.setBounds(110, 50, 250, 30);
		numberField.setBounds(110, 90, 200, 30);
		cash.setBounds(110, 130, 80, 60);
		card.setBounds(190, 130, 100, 60);
		howmuchField.setBounds(110, 200, 100, 30);
		send.setBounds(150, 700, 70, 30);
		resend.setBounds(230, 700, 100, 30);
		jscrollPane.setBounds(50, 300, 350, 300);

		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (countprocess.count(id) > 0) {
					dataorder.saveorder(id, addresstextField.getText(), numberField.getText(),
							card.isSelected() ? "카드" : "현금", howmuchField.getText());

					// 텍스트 필드 의 문자 길이가 모두 0보다 커야지 회원가입이 완료됨, cash || card 가 true 여야지 넘어감
					if (addresstextField.getText().length() > 0 && numberField.getText().length() > 0 && howmuchField.getText().length() > 0 && (cash.isSelected() || card.isSelected()))
					{
						JOptionPane.showMessageDialog(null, "배달 신청이 완료되었습니다.");
						countprocess.saveuser(Customer.id, countprocess.count(Customer.id) - 1);
						refresh();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "양식을 다 채워주세요.", "오류", JOptionPane.ERROR_MESSAGE);
					}			
					
					addresstextField.setText("");
					numberField.setText("");
					cash.setSelected(false);
					card.setSelected(false);
					howmuchField.setText("");

				
					
				} else {
					JOptionPane.showMessageDialog(null, "결제 후 이용해 주십시오.");
				}
			}
		});

		resend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtable.getSelectedRow() != -1){//jtable 클릭
					String valueAt = (String) jtable.getValueAt(jtable.getSelectedRow(), 0);
					{
					if(dataorder.status(valueAt).equals("대기중")||dataorder.status(valueAt).equals("배달거절"))
						{
						dataorder.setstatus(valueAt, "대기중");
						 dataorder.setcarrier(valueAt, "없음");
						 JOptionPane.showMessageDialog(null, "재신청이 되었습니다.");
							refresh();
						}//거절이나 대기중이 너무길때 사용
					else{ 
						JOptionPane.showMessageDialog(null, "이미 진행중입니다.");
						}
					}
					}
				else{
					JOptionPane.showMessageDialog(null, "재신청할 요청을 선택해주십시오.");
				}
			}
		});

		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("배달 횟수 결제");

		JMenuItem eMenuItem = new JMenuItem("결제");
		eMenuItem.addActionListener((ActionEvent event) -> {
			new applycarrier();
		});

		menu1.add(eMenuItem);

		menubar.add(menu1);

		setJMenuBar(menubar);

		// layoutPane.add(new JButton("신청").setBounds(250, 700, 200, 30));

		add(layoutPane);// 레이아웃 추가
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);// 크기조절 불가능

		refresh();

	}
}