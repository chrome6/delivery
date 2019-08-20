package Package;
//////////////////////////대행업체에서 결제 내역/////////////////
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;

public class paylist extends JFrame {
	String columNames[] = { "가게이름", "결제횟수" };
	Object Data[][] = { { null, null} };

	JTable jtable = new JTable(Data, columNames);
	JScrollPane jscrollPane = new JScrollPane(jtable);

	public void refresh() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columNames);
		
		for (String i : logincustomerprocess.customers()) {
			model.addRow(new Object[] { logincustomerprocess.name(i), compcountprocess.count(i) });
		}
		jtable.setModel(model);
		   
	}
	paylist() {
		JLayeredPane layoutPane = new JLayeredPane();
		layoutPane.setBounds(0, 0, 1600, 900);
		layoutPane.setLayout(null);
		
		layoutPane.add(jscrollPane);
		jscrollPane.setBounds(0, 0, 300, 300);

		add(layoutPane);// 레이아웃 추가
		
		setTitle("결제내역");
		setSize(300, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		refresh();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new paylist();
	}
}
