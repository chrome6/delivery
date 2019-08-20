package Package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.awt.*;
//////////////////////////////////////////배달 완료 목록/////////////////////////
public class comlist extends JFrame {
	String columNames[] = { "id", "주소", "번호", "결제방법", "결제금액", "현재상황", "라이더" };
	Object Data[][] = { { null, null, null, null, null, null, null } };

	JTable jtable = new JTable(Data, columNames);
	JScrollPane jscrollPane = new JScrollPane(jtable);

	public void refresh() {
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columNames);
		
		for (String i : dataorder.ordercarriers()) {
			if(dataorder.status(i).equals("배달 완료")){//배달완료된것들을 테이블에 추가한다
				model.addRow(new Object[] { i, dataorder.addr(i), dataorder.phone(i), dataorder.method(i), dataorder.price(i),
						dataorder.status(i), dataorder.carrier(i) });
			}
		}
		jtable.setModel(model);

		jtable.getColumnModel().getColumn(0).setMinWidth(0);  //선택한 요청건에 대한 ID를 첫번째 칸에 넣어놓고 가로 폭을 0으로 바꿈으로서 숨겨놓음
		jtable.getColumnModel().getColumn(0).setMaxWidth(0);
		jtable.getColumnModel().getColumn(0).setWidth(0);
		   
	}
	comlist() {
		JLayeredPane layoutPane = new JLayeredPane();
		layoutPane.setBounds(0, 0, 1600, 900);
		layoutPane.setLayout(null);
		
		layoutPane.add(jscrollPane);
		jscrollPane.setBounds(0, 0, 350, 300);

		add(layoutPane);// 레이아웃 추가
		
		setTitle("배달 완료 목록");
		setSize(350, 300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		refresh();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new comlist();
	}
}
