package Package;
///////////////////////���̴� ȸ������â/////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class NewCarrier extends JFrame
{
	JLabel NewuserID = new JLabel("ID(��ȣ��):");
	JLabel NewuserPassword = new JLabel("PASSWORD:");
	JLabel Name = new JLabel("�̸�:");
	JLabel Phone = new JLabel("��ȭ��ȣ:");

	JTextField NewusertextField = new JTextField();
	JTextField NewuserPasswordtextField = new JTextField();
	JTextField NametextField = new JTextField();
	JTextField PhonetextField = new JTextField();

	JButton NewuserComplete = new JButton("ȸ�� ����");

	NewCarrier()
	{
		setSize(300, 400);
		setTitle("ȸ������");

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
				{// �ؽ�Ʈ �ʵ� �� ���� ���̰� ��� 0���� Ŀ���� ȸ�������� �Ϸ��
					if (NewusertextField.getText().length() > 0 && NewuserPasswordtextField.getText().length() > 0 && NametextField.getText().length() > 0 && PhonetextField.getText().length() > 0)
					{
						logincarrierprocess.saveuser(NewusertextField.getText(), NewuserPasswordtextField.getText(), NametextField.getText(), PhonetextField.getText());

						JOptionPane.showMessageDialog(null, "ȸ������ �Ϸ�");
						NewCarrier.this.setVisible(false);
						NewCarrier.this.dispose(); // ���� �ߴ�â ���� ������ ��������� �߰�
					}
					else
					{
						JOptionPane.showMessageDialog(null, "����� �� ä���ּ���.", "ȸ������ ����", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "�̹� ���� ���̵� �����մϴ�.");
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

		add(layoutPane);// ���̾ƿ� �߰�
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);// ũ������ �Ұ���

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		NewCarrier newcarrier = new NewCarrier();

	}

}
