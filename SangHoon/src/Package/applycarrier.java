package Package;
///////////////////////////////////////////���Կ��� Ƚ�� ���� �ϴ� â///////////////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class applycarrier extends JFrame {
	Container contentPane;
	applycarrier() {
		setTitle("�̿� Ƚ�� ����");
		setSize(800, 110);
		setVisible(true);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 60, 10));// �г� ũ��
		ButtonGroup g = new ButtonGroup();// ��ư �׷� ����
		JRadioButton radio1 = new JRadioButton("10ȸ 20000��");//���� ��ư���� Ƚ���� �Է¹���
		JRadioButton radio2 = new JRadioButton("30ȸ 55000��");
		JRadioButton radio3 = new JRadioButton("100ȸ 190000��");
		JRadioButton radio4 = new JRadioButton("200ȸ 350000��");
		radio1.setSelected(true);
		g.add(radio1);
		g.add(radio2);
		g.add(radio3);
		g.add(radio4);
		
		panel.add(radio1);
		panel.add(radio2);
		panel.add(radio3);
		panel.add(radio4);//�г� �߰��Ϸ�
		
		JButton button = new JButton("����");
		add(panel);
		add(button, BorderLayout.PAGE_END);//������ �Ʒ��� �������� ����â�� ����
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {  //���� ��ư Ŭ����
				if(radio1.isSelected()){
					countprocess.saveuser(Customer.id, countprocess.count(Customer.id) + 10); //�ش� ������ ����Ƚ���� "�ش� ������ ����Ƚ�� + 10"��ŭ ����.
					compcountprocess.saveuser(Customer.id, compcountprocess.count(Customer.id) + 10);  //���ο��� �� ����Ƚ���� ����ϱ����ؼ� ���� �߰��� �κ�.
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
				//Customer��� Ŭ������ �����Ǹ� me��� static������ �ڱ� �ڽ��� ��Ե˴ϴ�. JTable�� ������ ������Ʈ�ϰ� ����Ƚ�� Lable�� ������Ʈ�ϴ°��Դϴ�.

				JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
				applycarrier.this.setVisible(false);
				applycarrier.this.dispose();
			}
		});
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);// ũ������ �Ұ���
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new applycarrier();
	}
}
