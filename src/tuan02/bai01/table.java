package tuan02.bai01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class table extends JFrame implements ActionListener{
	JPanel pn, pc, ps;
	JTable table;
	JScrollPane sp;
	
	public table() {
		
		pn = new JPanel();
		
		
		String[] colnames = {"Mã nhân viên", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
//		
		
		DefaultTableModel model = new DefaultTableModel(colnames, 0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		pn.add(sp);
		
		add(pn);
		setLocation(550, 200);
		setSize(460, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String [] args) {
		new table();
	}
	
}
