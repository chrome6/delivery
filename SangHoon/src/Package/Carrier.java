package Package;
////////////////////////////////////////////��ޱ�� â///////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Carrier extends JFrame {

	public static String id;


	Carrier(String id) {
		Carrier.id = id;
		setTitle("���̴�");
		createMenu();
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		ImageIcon image = new ImageIcon("images/background.jpg");
		JLabel imlb = new JLabel();
		imlb.setIcon(image);
		add(imlb);
	}

	void createMenu() { // �޴��� ����� �����ӻ���
		JMenuBar mb = new JMenuBar();
		JMenuItem[] menuItem = new JMenuItem[2];
		String[] itemTitle = { "��� ���� ���", "��� �Ϸ� ���" };
		JMenuItem[] menuItem1 = new JMenuItem[1];
		String[] itemTitle1 = { "��� ��û Ȯ��" };
		JMenu fileMenu = new JMenu("��޸��");
		JMenu fileMenu1 = new JMenu("��û Ȯ��");

		// ��޸�� �޴��� �޴������� ��������

		for (int i = 0; i < menuItem.length; i++) {//��� ���� ���,��� �Ϸ� ���
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new MenuActionListener());
			fileMenu.add(menuItem[i]);
		}
		for (int i = 0; i < menuItem1.length; i++) {//��� ��ûȮ��
			menuItem1[i] = new JMenuItem(itemTitle1[i]);
			menuItem1[i].addActionListener(new MenuActionListener());
			fileMenu1.add(menuItem1[i]);
		}
		mb.add(fileMenu); // �޴��ٿ� �޴� ����
		mb.add(fileMenu1);

		setJMenuBar(mb); // �޴��� �����ӿ� ����
		mb.setBackground(Color.LIGHT_GRAY);
		setResizable(false);// ȭ�� ũ�� ���� �Ұ���!

	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("��� ���� ���"))
				new prelist();
			else if (cmd.equals("��� �Ϸ� ���"))
				new comlist();

			String cmd1 = e.getActionCommand();
			if (cmd1.equals("��� ��û Ȯ��"))
				new request();
		}
	}

}
