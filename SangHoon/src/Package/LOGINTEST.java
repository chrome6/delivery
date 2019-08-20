package Package;
//////////////////////////////////////////////로그인 창////////////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class LOGINTEST extends JFrame {
	Container contentPane;
	JRadioButton[] radio = new JRadioButton[3];
	String[] text = { "본부", "가게", "라이더" };

	ImageIcon[] image = { new ImageIcon("images/home.jpg"), new ImageIcon("images/Customer.jpg"),
			new ImageIcon("images/Carrier.jpg") };
	JLabel imageLabel = new JLabel();
	JButton login = new JButton("로그인");
	JButton newuser = new JButton("회원가입");

	LOGINTEST() {

		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 60, 10));// 패널 크기
		Container ID = getContentPane();// ID PASSWORD 위치설정하기

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

		// 새로운창 추가

		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기서 아이디 비번 텍스트 필드가 비었는지 아이디 비번이 존재하는지
				// 확인 하고 public boolean check(){ return bool;}
				// if 로 분기 나누기
				if (radio[0].isSelected()) {
					if(id.getText().equals("donghyuk")&&pw.getText().equals("handsome"))
					{
						new Home();
						LOGINTEST.this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Hint:임동혁 교수님은 잘생기셨다.",
								"대행업체 로그인오류",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if (radio[1].isSelected()) {
					if (logincustomerprocess.userex(id.getText())) {
						if (logincustomerprocess.password(id.getText()).equals(pw.getText())) {
							Customer customer = new Customer(id.getText());
						} else {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
					}
				}
				else if (radio[2].isSelected()) {
					if (logincarrierprocess.userex(id.getText())) {
						if (logincarrierprocess.password(id.getText()).equals(pw.getText())) {
							Carrier carrier = new Carrier(id.getText());
						} else {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
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
		setResizable(false);// 화면 크기 조절 불가능!

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
		frame.setLocationRelativeTo(null);// 이게 화면 중앙에 뜨기헤기
	}
}
