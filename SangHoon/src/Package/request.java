package Package;
//////////////처음 수락 거절 화면//////////////
import javax.swing.*;
import java.awt.event.*;
import java.util.List;
import java.awt.*;

public class request extends JFrame {
	Container contentPane;
	static String requestId;
	request() {
		setTitle("배달요청");
		contentPane = getContentPane();
		contentPane.setLayout(null);

		JLabel label1 = new JLabel("가게명");
		JLabel label2 = new JLabel("고객위치");
		JLabel label3 = new JLabel("결제방식");
		JLabel label4 = new JLabel("가격");
		
		JButton button1 = new JButton("수락");
		JButton button2 = new JButton("거절");
		JTextField tf1 = new JTextField(20);
		JTextField tf2 = new JTextField(60);
		JTextField tf3 = new JTextField(10);
		JTextField tf4 = new JTextField(10);
		
		
		label1.setBounds(30, 50, 50, 50);
		label2.setBounds(100, 50, 100, 50);
		label3.setBounds(220, 50, 100, 50);
		label4.setBounds(290, 50, 80, 50);
		
		button1.setBounds(90, 300, 80, 50);
		button2.setBounds(220, 300, 80, 50);
		tf1.setBounds(30, 95, 50, 20);
		tf2.setBounds(100, 95, 100, 20);
		tf3.setBounds(220, 95, 50, 20);
		tf4.setBounds(290, 95, 50, 20);
		
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(label4);
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(tf1);
		contentPane.add(tf2);
		contentPane.add(tf3);
		contentPane.add(tf4);

		setSize(400, 400);
		setVisible(true);
		setLocationRelativeTo(null);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button1 = (JButton) e.getSource();
				if (button1.getText().equals("수락")){
					new progress();
					dataorder.setcarrier(requestId, Carrier.id);
					dataorder.setstatus(requestId, "배달 대기 중");
					setVisible(false);
				}
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton button2 = (JButton) e.getSource();
				if (button2.getText().equals("거절")){
					setVisible(false);
					dataorder.setcarrier(requestId, Carrier.id);
					dataorder.setstatus(requestId, "배달거절");
				}
			}
		});
		
		List<String> notordercarriers = dataorder.notordercarriers();
		if(notordercarriers.size() == 0){
			JOptionPane.showMessageDialog(null, "배달 요청이 존재하지 않습니다.");
			request.this.setVisible(false);
			request.this.dispose();
		}else{
			requestId = notordercarriers.get(0);
			
			tf1.setText(logincustomerprocess.name(dataorder.customerid(requestId)));
			tf2.setText(dataorder.addr(requestId));
			tf3.setText(dataorder.method(requestId));
			tf4.setText(dataorder.price(requestId));
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new request();
	}
}
