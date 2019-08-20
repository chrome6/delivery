package Package;
/////////////////////////대행업체의 화면입니다//////////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Home extends JFrame {
	Home() {
		setTitle("대행업체");
		ImageIcon image = new ImageIcon("images/background.jpg");
		JLabel imlb = new JLabel();
		imlb.setIcon(image);
		add(imlb);
		createMenu();
		setSize(500, 200);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	void createMenu() { // 메뉴를 만들어 프레임삽입
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("메뉴");
		JMenuItem jMenuItem = new JMenuItem("현재 배달 상황");
		jMenuItem.addActionListener(new MenuActionListener());
		fileMenu.add(jMenuItem); // 배달목록 메뉴에 메뉴아이템 생성삽입
		fileMenu.addSeparator(); // 분리선 삽입
		JMenuItem jMenuItem2 = new JMenuItem("가게 결제내역");
		jMenuItem2.addActionListener(new MenuActionListener());
		fileMenu.add(jMenuItem2);
		fileMenu.addSeparator();
		JMenuItem jMenuItem3 = new JMenuItem("라이더 검색하기");
		jMenuItem3.addActionListener(new MenuActionListener());
		fileMenu.add(jMenuItem3);
		
		mb.add(fileMenu); // 메뉴바에 메뉴 삽입

		setJMenuBar(mb); // 메뉴바 프레임에 삽입
		mb.setBackground(Color.LIGHT_GRAY);

		setResizable(false);// 화면 크기 조절 불가능!
	}

	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();

			if (cmd.equals("가게 결제내역"))
				new paylist();
			if (cmd.equals("라이더 검색하기"))
				new search();
			if (cmd.equals("현재 배달 상황"))
				new statuslist();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home();

	}
}