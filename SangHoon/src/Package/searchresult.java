package Package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;

public class searchresult extends JFrame {
	String columNames[] = { "id", "�ּ�", "��ȣ", "�������", "�����ݾ�", "�����Ȳ", "���̴�" };
	Object Data[][] = { { null, null, null, null, null, null, null } };

	JTable jtable = new JTable(Data, columNames);
	JScrollPane jscrollPane = new JScrollPane(jtable);

	public void refresh() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columNames);
		
		for (String i : dataorder.ordercarriers()) {
			System.out.println(i);
			if(c.equals(dataorder.carrier(i))){
				model.addRow(new Object[] { i, dataorder.addr(i), dataorder.phone(i), dataorder.method(i), dataorder.price(i),
						dataorder.status(i), dataorder.carrier(i) });
			}
		}
		jtable.setModel(model);

		jtable.getColumnModel().getColumn(0).setMinWidth(0);
		jtable.getColumnModel().getColumn(0).setMaxWidth(0);
		jtable.getColumnModel().getColumn(0).setWidth(0);
		   
	}
	String c;
	searchresult(String result) {
		c = result;
		JLayeredPane layoutPane = new JLayeredPane();
		layoutPane.setBounds(0, 0, 1600, 900);
		layoutPane.setLayout(null);
		
		JLabel jLabel = new JLabel("�˻���� : " + (result.equals("����") ? "����" : logincarrierprocess.name(result)) );
		jLabel.setBounds(0, 0, 100, 20);
		layoutPane.add(jLabel);
		layoutPane.add(jscrollPane);
		jscrollPane.setBounds(0, 20, 350, 300);

		add(layoutPane);// ���̾ƿ� �߰�
		
		setTitle("�˻����");
		setSize(350, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		if(!result.equals("����"))
		refresh();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new searchresult();
	}
}
