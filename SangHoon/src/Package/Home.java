package Package;
/////////////////////////�����ü�� ȭ���Դϴ�//////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Home extends JFrame {
	Home() {
		setTitle("�����ü");
		ImageIcon image = new ImageIcon("images/background.jpg");
		JLabel imlb = new JLabel();
		imlb.setIcon(image);
		add(imlb);
		createMenu();
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	void createMenu() { // �޴��� ����� �����ӻ���
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("�޴�");
		JMenuItem jMenuItem = new JMenuItem("���� ��� ��Ȳ");
		jMenuItem.addActionListener(new MenuActionListener());
		fileMenu.add(jMenuItem); // ��޸�� �޴��� �޴������� ��������
		fileMenu.addSeparator(); // �и��� ����
		JMenuItem jMenuItem2 = new JMenuItem("���� ��������");
		jMenuItem2.addActionListener(new MenuActionListener());
		fileMenu.add(jMenuItem2);
		fileMenu.addSeparator();
		JMenuItem jMenuItem3 = new JMenuItem("���̴� �˻��ϱ�");
		jMenuItem3.addActionListener(new MenuActionListener());
		fileMenu.add(jMenuItem3);
		
		mb.add(fileMenu); // �޴��ٿ� �޴� ����

		setJMenuBar(mb); // �޴��� �����ӿ� ����
		mb.setBackground(Color.LIGHT_GRAY);

		setResizable(false);// ȭ�� ũ�� ���� �Ұ���!
	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals("���� ��������"))
				new paylist();
			if (cmd.equals("���̴� �˻��ϱ�"))
				new search();
			if (cmd.equals("���� ��� ��Ȳ"))
				new statuslist();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home();

	}
}