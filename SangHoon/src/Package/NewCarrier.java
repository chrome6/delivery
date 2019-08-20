package Package;
///////////////////////러이더 회원가입창/////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class NewCarrier extends JFrame
{
	JLabel NewuserID = new JLabel("ID(번호판):");
	JLabel NewuserPassword = new JLabel("PASSWORD:");
	JLabel Name = new JLabel("이름:");
	JLabel Phone = new JLabel("전화번호:");

	JTextField NewusertextField = new JTextField();
	JTextField NewuserPasswordtextField = new JTextField();
	JTextField NametextField = new JTextField();
	JTextField PhonetextField = new JTextField();

	JButton NewuserComplete = new JButton("회원 가입");

	NewCarrier()
	{
		setSize(300, 400);
		setTitle("회원가입");

		JLayeredPane layoutPane = new JLayeredPane();
		layoutPane.setBounds(0, 0, 300, 400);
		layoutPane.setLayout(null);
		JPanel panel = new JPanel();

		panel.setBounds(0, 0, 300, 400);
		NewuserID.setBounds(50, 50, 100, 30);
		NewuserPassword.setBounds(50, 90, 100, 30);
		Name.setBounds(50, 130, 50, 30);
		Phone.setBounds(50, 170, 100, 30);

		NewusertextField.setBounds(115, 50, 100, 30);
		NewuserPasswordtextField.setBounds(125, 90, 100, 30);
		NametextField.setBounds(80, 130, 100, 30);
		PhonetextField.setBounds(110, 170, 100, 30);

		NewuserComplete.setBounds(95, 300, 100, 30);

		NewuserComplete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (!logincarrierprocess.userex(NewusertextField.getText()))
				{// 텍스트 필드 의 문자 길이가 모두 0보다 커야지 회원가입이 완료됨
					if (NewusertextField.getText().length() > 0 && NewuserPasswordtextField.getText().length() > 0 && NametextField.getText().length() > 0 && PhonetextField.getText().length() > 0)
					{
						logincarrierprocess.saveuser(NewusertextField.getText(), NewuserPasswordtextField.getText(), NametextField.getText(), PhonetextField.getText());

						JOptionPane.showMessageDialog(null, "회원가입 완료");
						NewCarrier.this.setVisible(false);
						NewCarrier.this.dispose(); // 새로 뜨는창 꺼짐 완전히 지우기위해 추가
					}
					else
					{
						JOptionPane.showMessageDialog(null, "양식을 다 채워주세요.", "회원가입 오류", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "이미 같은 아이디가 존재합니다.");
				}
			}
		});
		layoutPane.add(NewuserID);
		layoutPane.add(NewuserPassword);
		layoutPane.add(Name);
		layoutPane.add(Phone);

		layoutPane.add(NewusertextField);
		layoutPane.add(NewuserPasswordtextField);
		layoutPane.add(NametextField);
		layoutPane.add(PhonetextField);

		layoutPane.add(NewuserComplete);

		add(layoutPane);// 레이아웃 추가
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);// 크기조절 불가능

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		NewCarrier newcarrier = new NewCarrier();

	}

}
