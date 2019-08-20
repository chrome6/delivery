package Package;
/////////////////////////////////////////물건을 인계 받은후 배달을진행합니다////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class comple extends JFrame {
	Container contentPane;

	comple() {
		setTitle("배달 진행중");
		contentPane = getContentPane();
		contentPane.setLayout(null);
		JButton button1 = new JButton("배달완료");////////////////////////배달을 진행하기때문에 배달완료시 배달완료버튼을 클릭///////////////
		
		JLabel label1 = new JLabel("가게명");
		JLabel label2 = new JLabel("고객위치");
		JLabel label3 = new JLabel("결제방식");
		JLabel label4 = new JLabel("가격");
		JLabel label5 = new JLabel("고객 주문번호");/////////가게에서 물건을 받았기때문에 이제는 도착해야할 곳의 (물건을 배달시킨사람의 번호가 보임)전화번호가 보임//////////////
		
		JTextField tf1 = new JTextField(20);
		JTextField tf2 = new JTextField(60);
		JTextField tf3 = new JTextField(10);
		JTextField tf4 = new JTextField(10);
		JTextField tf5 = new JTextField(20);
		
		label1.setBounds(30, 50, 50, 50);
		label2.setBounds(100, 50, 100, 50);
		label3.setBounds(220, 50, 100, 50);
		label4.setBounds(290, 50, 80, 50);
		label5.setBounds(60, 150, 100, 20);
		
		tf1.setBounds(30, 95, 50, 20);
		tf2.setBounds(100, 95, 100, 20);
		tf3.setBounds(220, 95, 50, 20);
		tf4.setBounds(290, 95, 50, 20);
		tf5.setBounds(150, 150, 100, 20);
		
		button1.setBounds(140, 280, 100, 30);

		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(label4);
		
		contentPane.add(tf1);
		contentPane.add(tf2);
		contentPane.add(tf3);
		contentPane.add(tf4);

		contentPane.add(label5);
		contentPane.add(button1);
		contentPane.add(tf5);

		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button1 = (JButton) e.getSource();

				dataorder.setcarrier(request.requestId, Carrier.id);
				dataorder.setstatus(request.requestId, "배달 완료");//배달완료로 바꿈

				setVisible(false);
				dispose();
				
			}
		});
		
		tf5.setText(dataorder.phone(request.requestId));
		tf1.setText(logincustomerprocess.name(dataorder.customerid(request.requestId)));
		tf2.setText(dataorder.addr(request.requestId));
		tf3.setText(dataorder.method(request.requestId));
		tf4.setText(dataorder.price(request.requestId));
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new comple();
	}
}
