package Package;
///////////////////////////////////////////////��ǰ �μ��ΰ� â //////////////////////////////////////////
/////////////////////////////////////////���̴��� ��ǰ�� ������ ���� �ߴ� â////////////////////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.awt.*;

public class progress extends JFrame {
	Container contentPane;

	progress() {
		setTitle("��� ������");
		contentPane = getContentPane();
		contentPane.setLayout(null);

		JLabel label1 = new JLabel("���Ը�");
		JLabel label2 = new JLabel("����ġ");
		JLabel label3 = new JLabel("�������");
		JLabel label4 = new JLabel("����");
		//JLabel label5 = new JLabel("�� �ֹ���ȣ");
		
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
		///////////////////////////////������ ������ �μ� �Ϸ�//////////////////////
		JButton button1 = new JButton("�μ� �Ϸ�");
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

		button1.addActionListener(new ActionListener() {//�ΰ� �Ϸ� ��ư Ŭ����
			public void actionPerformed(ActionEvent e) {
				JButton button1 = (JButton) e.getSource();
				dataorder.setcarrier(request.requestId, Carrier.id);
				dataorder.setstatus(request.requestId, "�����");////////////order �����͸� �ٲ۴�

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
