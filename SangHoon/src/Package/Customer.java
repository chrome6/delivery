package Package;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//jtable��ũ��?
//jtable
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Package.Carrier.MenuActionListener;

public class Customer extends JFrame {
	public static Customer me;
	JLabel address = new JLabel("�� �ּ�");// �󺧻���
	JLabel number = new JLabel("�� ��ȣ");
	JLabel payway = new JLabel("�������");
	JLabel howmuch = new JLabel("�����ݾ�");
	JLabel won = new JLabel("��");
	JLabel count = new JLabel("�ܿ�Ƚ��:");

	JTextField addresstextField, numberField, howmuchField;// �Է�ĭ �� ������ư
	JRadioButton cash = new JRadioButton();
	JRadioButton card = new JRadioButton();
	JButton send = new JButton("��û");
	JButton resend = new JButton("���û");

	
	public static String id;

	String columNames[] = { "id", "�ּ�", "��ȣ", "�������", "�����ݾ�", "�����Ȳ", "���̴�" };
	Object Data[][] = { {null, null, null, null, null, null, null } };

	JTable jtable = new JTable(Data, columNames);
	JScrollPane jscrollPane = new JScrollPane(jtable);

	public void refresh() {
		count.setText("�ܿ�Ƚ��: " + countprocess.count(id));
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columNames);
		
		for (String i : dataorder.ordercustomer(id)) {
			model.addRow(new Object[] { i, dataorder.addr(i), dataorder.phone(i), dataorder.method(i), dataorder.price(i),
					dataorder.status(i), dataorder.carrier(i) });
		}
		jtable.setModel(model);

		jtable.getColumnModel().getColumn(0).setMinWidth(0);
		jtable.getColumnModel().getColumn(0).setMaxWidth(0);
		jtable.getColumnModel().getColumn(0).setWidth(0);
		   
	}

	Customer(String id) {
		Customer.id = id;
		me = this;
		setSize(500, 800);
		setTitle("����");

		//////////////////////////////////////////
		// ���̾ƿ� �����ϱ�
		JLayeredPane layoutPane = new JLayeredPane();
		layoutPane.setBounds(0, 0, 1600, 900);
		layoutPane.setLayout(null);
		JPanel panel = new JPanel();
		ImageIcon cashIcon = new ImageIcon("images/cash.jpg");
		ImageIcon cashIcon2 = new ImageIcon("images/cash2.jpg");
		ImageIcon cardIcon = new ImageIcon("images/card.jpg");
		ImageIcon cardIcon2 = new ImageIcon("images/card2.jpg");

		////// �۾� and �Է�ĭ/////
		panel.setBounds(0, 0, 500, 800);
		address.setBounds(50, 50, 200, 30);// �۾�:�ּ�
		number.setBounds(50, 90, 200, 30);// �۾�:��ȣ
		payway.setBounds(50, 130, 200, 30);// �۾�:���� ���
		howmuch.setBounds(50, 200, 200, 30);// �۾�:����
		won.setBounds(210, 200, 100, 30);
		count.setBounds(50, 260, 200, 30);
		count.setForeground(Color.red);

		layoutPane.add(payway);
		layoutPane.add(address);
		layoutPane.add(number);
		layoutPane.add(howmuch);
		layoutPane.add(won);
		layoutPane.add(count);
		addresstextField = new JTextField();// �ּ��Է�
		numberField = new JTextField();// ��ȣ�Է�
		howmuchField = new JTextField();
		cash = new JRadioButton(cashIcon);// ����
		card = new JRadioButton(cardIcon);// ī��
		ButtonGroup g = new ButtonGroup();// ��ư �׷����
		cash.setSelectedIcon(cashIcon2);
		card.setSelectedIcon(cardIcon2);
		g.add(card);
		g.add(cash);

		layoutPane.add(addresstextField);
		layoutPane.add(numberField);
		layoutPane.add(cash);
		layoutPane.add(card);
		layoutPane.add(howmuchField);
		layoutPane.add(send);
		layoutPane.add(resend);
		layoutPane.add(jscrollPane);

		addresstextField.setBounds(110, 50, 250, 30);
		numberField.setBounds(110, 90, 200, 30);
		cash.setBounds(110, 130, 80, 60);
		card.setBounds(190, 130, 100, 60);
		howmuchField.setBounds(110, 200, 100, 30);
		send.setBounds(150, 700, 70, 30);
		resend.setBounds(230, 700, 100, 30);
		jscrollPane.setBounds(50, 300, 350, 300);

		send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (countprocess.count(id) > 0) {
					dataorder.saveorder(id, addresstextField.getText(), numberField.getText(),
							card.isSelected() ? "ī��" : "����", howmuchField.getText());

					// �ؽ�Ʈ �ʵ� �� ���� ���̰� ��� 0���� Ŀ���� ȸ�������� �Ϸ��, cash || card �� true ������ �Ѿ
					if (addresstextField.getText().length() > 0 && numberField.getText().length() > 0 && howmuchField.getText().length() > 0 && (cash.isSelected() || card.isSelected()))
					{
						JOptionPane.showMessageDialog(null, "��� ��û�� �Ϸ�Ǿ����ϴ�.");
						countprocess.saveuser(Customer.id, countprocess.count(Customer.id) - 1);
						refresh();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "����� �� ä���ּ���.", "����", JOptionPane.ERROR_MESSAGE);
					}			
					
					addresstextField.setText("");
					numberField.setText("");
					cash.setSelected(false);
					card.setSelected(false);
					howmuchField.setText("");

				
					
				} else {
					JOptionPane.showMessageDialog(null, "���� �� �̿��� �ֽʽÿ�.");
				}
			}
		});

		resend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(jtable.getSelectedRow() != -1){//jtable Ŭ��
					String valueAt = (String) jtable.getValueAt(jtable.getSelectedRow(), 0);
					{
					if(dataorder.status(valueAt).equals("�����")||dataorder.status(valueAt).equals("��ް���"))
						{
						dataorder.setstatus(valueAt, "�����");
						 dataorder.setcarrier(valueAt, "����");
						 JOptionPane.showMessageDialog(null, "���û�� �Ǿ����ϴ�.");
							refresh();
						}//�����̳� ������� �ʹ��涧 ���
					else{ 
						JOptionPane.showMessageDialog(null, "�̹� �������Դϴ�.");
						}
					}
					}
				else{
					JOptionPane.showMessageDialog(null, "���û�� ��û�� �������ֽʽÿ�.");
				}
			}
		});

		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("��� Ƚ�� ����");

		JMenuItem eMenuItem = new JMenuItem("����");
		eMenuItem.addActionListener((ActionEvent event) -> {
			new applycarrier();
		});

		menu1.add(eMenuItem);

		menubar.add(menu1);

		setJMenuBar(menubar);

		// layoutPane.add(new JButton("��û").setBounds(250, 700, 200, 30));

		add(layoutPane);// ���̾ƿ� �߰�
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);// ũ������ �Ұ���

		refresh();

	}
}