package Package;
////////////////////////////////////////////배달기사 창///////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Carrier extends JFrame {

	public static String id;


	Carrier(String id) {
		Carrier.id = id;
		setTitle("라이더");
		createMenu();
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null);
		ImageIcon image = new ImageIcon("images/background.jpg");
		JLabel imlb = new JLabel();
		imlb.setIcon(image);
		add(imlb);
	}

	void createMenu() { // 메뉴를 만들어 프레임삽입
		JMenuBar mb = new JMenuBar();
		JMenuItem[] menuItem = new JMenuItem[2];
		String[] itemTitle = { "배달 예정 목록", "배달 완료 목록" };
		JMenuItem[] menuItem1 = new JMenuItem[1];
		String[] itemTitle1 = { "배달 요청 확인" };
		JMenu fileMenu = new JMenu("배달목록");
		JMenu fileMenu1 = new JMenu("신청 확인");

		// 배달목록 메뉴에 메뉴아이템 생성삽입

		for (int i = 0; i < menuItem.length; i++) {//배달 예정 목록,배달 완료 목록
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new MenuActionListener());
			fileMenu.add(menuItem[i]);
		}
		for (int i = 0; i < menuItem1.length; i++) {//배달 요청확인
			menuItem1[i] = new JMenuItem(itemTitle1[i]);
			menuItem1[i].addActionListener(new MenuActionListener());
			fileMenu1.add(menuItem1[i]);
		}
		mb.add(fileMenu); // 메뉴바에 메뉴 삽입
		mb.add(fileMenu1);

		setJMenuBar(mb); // 메뉴바 프레임에 삽입
		mb.setBackground(Color.LIGHT_GRAY);
		setResizable(false);// 화면 크기 조절 불가능!

	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("배달 예정 목록"))
				new prelist();
			else if (cmd.equals("배달 완료 목록"))
				new comlist();

			String cmd1 = e.getActionCommand();
			if (cmd1.equals("배달 요청 확인"))
				new request();
		}
	}

}
