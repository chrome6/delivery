package Package;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class search extends JFrame {
	Container contentPane;

	search() {
		setTitle("���̴� �˻�â");
		contentPane = getContentPane();
		contentPane.setLayout(null);

		JLabel label1 = new JLabel("��ȣ");
		JLabel label2 = new JLabel("�̸�");
		JButton button1 = new JButton("�˻�");
		JTextField tf1 = new JTextField(20);
		JTextField tf2 = new JTextField(60);

		label1.setBounds(50, 10, 50, 50);
		label2.setBounds(200, 10, 100, 50);
		button1.setBounds(150, 150, 80, 20);
		tf1.setBounds(50, 60, 100, 50);
		tf2.setBounds(200, 60, 150, 50);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(button1);
		contentPane.add(tf1);
		contentPane.add(tf2);
		
		

		setSize(400, 250);
		setVisible(true);
		setLocationRelativeTo(null);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button1 = (JButton) e.getSource();
				if (button1.getText().equals("�˻�")){
					String result = "����";
					for(String id : logincarrierprocess.carriers()){
	
						if(logincarrierprocess.phoneTwo(id).equals(tf1.getText()) && logincarrierprocess.name(id).equals(tf2.getText())){
							result = id;
						}
					}
					new searchresult(result);
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new search();
	}

}
