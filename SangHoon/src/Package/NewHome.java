package Package;
////////////////////////////�����ü ȸ������ ����////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class NewHome extends JFrame{
	JLabel NewHomeerror=new JLabel("         ������ ���� ���� �Ұ���");
	NewHome() {
		setLayout(new BorderLayout());
		add(NewHomeerror,BorderLayout.CENTER);
		
		setSize(200,100);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewHome newhome=new NewHome();
	}

}
