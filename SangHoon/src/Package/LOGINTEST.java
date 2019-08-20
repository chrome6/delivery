package Package;
//////////////////////////////////////////////�α��� â////////////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LOGINTEST extends JFrame {
	Container contentPane;
	JRadioButton[] radio = new JRadioButton[3];
	String[] text = { "����", "����", "���̴�" };

	ImageIcon[] image = { new ImageIcon("images/home.jpg"), new ImageIcon("images/Customer.jpg"),
			new ImageIcon("images/Carrier.jpg") };
	JLabel imageLabel = new JLabel();
	JButton login = new JButton("�α���");
	JButton newuser = new JButton("ȸ������");

	LOGINTEST() {

		setTitle("�α���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 60, 10));// �г� ũ��
		Container ID = getContentPane();// ID PASSWORD ��ġ�����ϱ�

		ButtonGroup g = new ButtonGroup();
		for (int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			panel.add(radio[i]);
			radio[i].addItemListener(new MyItemListener());
		}

		radio[0].setSelected(true);

		contentPane.add(imageLabel, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

		ID.add(new JLabel("ID: "));
		JTextField pw = new JTextField(10);
		JTextField id = new JTextField(10);
		ID.add(id);
		ID.add(new JLabel("PASSWORD: "));
		ID.add(pw);

		// ���ο�â �߰�

		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// ���⼭ ���̵� ��� �ؽ�Ʈ �ʵ尡 ������� ���̵� ����� �����ϴ���
				// Ȯ�� �ϰ� public boolean check(){ return bool;}
				// if �� �б� ������
				if (radio[0].isSelected()) {
					if(id.getText().equals("donghyuk")&&pw.getText().equals("handsome"))
					{
						new Home();
						LOGINTEST.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Hint:�ӵ��� �������� �߻���̴�.",
								"�����ü �α��ο���",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (radio[1].isSelected()) {
					if (logincustomerprocess.userex(id.getText())) {
						if (logincustomerprocess.password(id.getText()).equals(pw.getText())) {
							Customer customer = new Customer(id.getText());
						} else {
							JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "���̵� �������� �ʽ��ϴ�.");
					}
				}
				else if (radio[2].isSelected()) {
					if (logincarrierprocess.userex(id.getText())) {
						if (logincarrierprocess.password(id.getText()).equals(pw.getText())) {
							Carrier carrier = new Carrier(id.getText());
						} else {
							JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "���̵� �������� �ʽ��ϴ�.");
					}
				}

			}
		});

		newuser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (radio[0].isSelected()) {
					new NewHome();
				} else if (radio[1].isSelected()) {
					new NewCustomer();
				} else if (radio[2].isSelected()) {
					new NewCarrier();
				}
			}
		});
		// end

		add(login);
		add(newuser);
		setVisible(true);
		setResizable(false);// ȭ�� ũ�� ���� �Ұ���!

	}

	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.DESELECTED)
				return;
			if (radio[0].isSelected())
				imageLabel.setIcon(image[0]);
			else if (radio[1].isSelected())
				imageLabel.setIcon(image[1]);
			else
				imageLabel.setIcon(image[2]);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LOGINTEST frame = new LOGINTEST();
		frame.setSize(400, 450);
		frame.setLocationRelativeTo(null);// �̰� ȭ�� �߾ӿ� �߱����
	}
}
