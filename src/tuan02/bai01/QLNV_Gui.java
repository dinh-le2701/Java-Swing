package tuan02.bai01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QLNV_Gui extends JFrame implements ActionListener{
	
	JPanel pn, pc, ps;
	JTextField txtManv, txtHo, txtTennv, txtTuoi, txtTienluong;
	JLabel LTitle, lManv, lHo, lTennv, lTuoi, lPhai, lTienluong;
	JButton them, xoa, xoaRong, luu, tim;
	JRadioButton rbtn;
	JTable table;
	JScrollPane jc;
	
	public QLNV_Gui() {
		super("QUẢN LÝ NHÂN VIÊN");
		// north panel
		pn = new JPanel();
		
		// add component to panel 1
		LTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		Font lb = new Font("Time New Roman", Font.BOLD, 20);
		LTitle.setFont(lb);
		pn.add(LTitle);
		
		
		// center panel
		pc = new JPanel();
		lManv = new JLabel("Mã nhân viên: ");
		txtManv = new JTextField(30);
		
		lHo = new JLabel("Họ: ");
		txtHo = new JTextField(13);
		
		lTennv = new JLabel("Tên nhân viên: ");
		txtTennv = new JTextField(13);
		
		lTuoi = new JLabel("Tuổi: ");
		txtTuoi = new JTextField(25);
		
		lPhai = new JLabel("Phái: ");
		rbtn = new JRadioButton("nữ");
		
		lTienluong = new JLabel("Tiền lương: ");
		txtTienluong = new JTextField(30);
		
//		String[] colnames = {"Mã nhân viên", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
//		Object[][] data = {
//				{"123", "3", "3", "4", "4", "6"}
//		};
		
		String data[][] = { { "101", "Tran Van Minh", "6000" }, 
                { "102", "Phan Van Tai", "8000" }, 
                { "101", "Do Cao Hoc", "7000" } };
        String column[] = { "ID", "NAME", "SALARY" };
		
		// DefaultTableModel model = new DefaultTableModel(colnames, 0);
		

		table = new JTable(data, column);
		jc = new JScrollPane(table);
		table.setBounds(2000, 200, 200, 200);
		
		// add component to panel
		pn.add(lManv); pn.add(txtManv);
		pn.add(lHo); pn.add(txtHo);
		pn.add(lTennv); pn.add(txtTennv);
		pn.add(lTuoi); pn.add(txtTuoi);
		pn.add(lPhai); pn.add(rbtn);
		pn.add(lTienluong); pn.add(txtTienluong);
		pc.add(table);
		pc.add(jc);
		
		
		// add panel to frame
		add(pn, BorderLayout.NORTH);
		add(pc, BorderLayout.CENTER);
		
		// config gui
		setLocation(550, 200);
		setSize(460, 400);
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// main method
	public static void main(String[] args) {
		new QLNV_Gui();
	}
}
