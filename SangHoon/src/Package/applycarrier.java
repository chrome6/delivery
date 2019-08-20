package Package;
///////////////////////////////////////////가게에서 횟수 결제 하는 창///////////////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class applycarrier extends JFrame {
	Container contentPane;
	applycarrier() {
		setTitle("이용 횟수 결제");
		setSize(800, 110);
		setVisible(true);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 60, 10));// 패널 크기
		ButtonGroup g = new ButtonGroup();// 버튼 그룹 생성
		JRadioButton radio1 = new JRadioButton("10회 20000원");//라디오 버튼으로 횟수를 입력받음
		JRadioButton radio2 = new JRadioButton("30회 55000원");
		JRadioButton radio3 = new JRadioButton("100회 190000원");
		JRadioButton radio4 = new JRadioButton("200회 350000원");
		radio1.setSelected(true);
		g.add(radio1);
		g.add(radio2);
		g.add(radio3);
		g.add(radio4);
		
		panel.add(radio1);
		panel.add(radio2);
		panel.add(radio3);
		panel.add(radio4);//패널 추가완료
		
		JButton button = new JButton("결제");
		add(panel);
		add(button, BorderLayout.PAGE_END);//페이지 아래쪽 마지막에 결제창을 생성
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  //결제 버튼 클릭시
				if(radio1.isSelected()){
					countprocess.saveuser(Customer.id, countprocess.count(Customer.id) + 10); //해당 가게의 결제횟수를 "해당 가게의 결제횟수 + 10"만큼 설정.
					compcountprocess.saveuser(Customer.id, compcountprocess.count(Customer.id) + 10);  //본부에서 총 결제횟수를 기록하기위해서 따로 추가한 부분.
				}else if(radio2.isSelected()){
					countprocess.saveuser(Customer.id, countprocess.count(Customer.id) + 30);
					compcountprocess.saveuser(Customer.id, compcountprocess.count(Customer.id) + 30);
				}else if(radio3.isSelected()){
					countprocess.saveuser(Customer.id, countprocess.count(Customer.id) + 100);
					compcountprocess.saveuser(Customer.id, compcountprocess.count(Customer.id) + 100);
				}else if(radio4.isSelected()){
					countprocess.saveuser(Customer.id, countprocess.count(Customer.id) + 200);
					compcountprocess.saveuser(Customer.id, compcountprocess.count(Customer.id) + 200);
				}
				Customer.me.refresh(); 
				//Customer라는 클래스가 생성되면 me라는 static변수에 자기 자신을 담게됩니다. JTable에 정보를 업데이트하고 결제횟수 Lable을 업데이트하는것입니다.

				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다.");
				applycarrier.this.setVisible(false);
				applycarrier.this.dispose();
			}
		});
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);// 크기조절 불가능
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new applycarrier();
	}
}
