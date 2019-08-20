package Package;
///////////////////////////////////////////////물품 인수인계 창 //////////////////////////////////////////
/////////////////////////////////////////라이더가 물품을 받으러 갈때 뜨는 창////////////////////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.awt.*;

public class progress extends JFrame {
	Container contentPane;

	progress() {
		setTitle("배달 진행중");
		contentPane = getContentPane();
		contentPane.setLayout(null);

		JLabel label1 = new JLabel("가게명");
		JLabel label2 = new JLabel("고객위치");
		JLabel label3 = new JLabel("결제방식");
		JLabel label4 = new JLabel("가격");
		//JLabel label5 = new JLabel("고객 주문번호");
		
		JTextField tf1 = new JTextField(20);
		JTextField tf2 = new JTextField(60);
		JTextField tf3 = new JTextField(10);
		JTextField tf4 = new JTextField(10);
		
		label1.setBounds(30, 50, 50, 50);
		label2.setBounds(100, 50, 100, 50);
		label3.setBounds(220, 50, 100, 50);
		label4.setBounds(290, 50, 80, 50);
		
		tf1.setBounds(30, 95, 50, 20);
		tf2.setBounds(100, 95, 100, 20);
		tf3.setBounds(220, 95, 50, 20);
		tf4.setBounds(290, 95, 50, 20);
		///////////////////////////////물건을 받으면 인수 완료//////////////////////
		JButton button1 = new JButton("인수 완료");
		JTextField tf5 = new JTextField(20);

		
		button1.setBounds(140, 280, 100, 30);
		tf5.setBounds(150, 150, 100, 20);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(label4);
		
		contentPane.add(tf1);
		contentPane.add(tf2);
		contentPane.add(tf3);
		contentPane.add(tf4);


		contentPane.add(button1);


		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);

		button1.addActionListener(new ActionListener() {//인계 완료 버튼 클릭시
			public void actionPerformed(ActionEvent e) {
				JButton button1 = (JButton) e.getSource();
				dataorder.setcarrier(request.requestId, Carrier.id);
				dataorder.setstatus(request.requestId, "배달중");////////////order 데이터를 바꾼다

				new comple();
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
		new progress();
	}
}
