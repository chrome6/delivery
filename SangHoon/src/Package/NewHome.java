package Package;
////////////////////////////대행업체 회원가입 막음////////////////
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class NewHome extends JFrame{
	JLabel NewHomeerror=new JLabel("         관리자 계정 생성 불가능");
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
