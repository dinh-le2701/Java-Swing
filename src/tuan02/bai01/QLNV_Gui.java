package tuan02.bai01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QLNV_Gui extends JFrame{
	
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
		
		String[] colnames = {"Mã nhân viên", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
//		Object[][] data = {
//				{"123", "3", "3", "4", "4", "6"}
//		};
		
		DefaultTableModel model = new DefaultTableModel(colnames, 0);
		

		table = new JTable(model);
		jc = new JScrollPane(table);
		table.setBounds(30, 40, 200, 200);
		
		// add component to panel
		pc.add(lManv); pc.add(txtManv);
		pc.add(lHo); pc.add(txtHo);
		pc.add(lTennv); pc.add(txtTennv);
		pc.add(lTuoi); pc.add(txtTuoi);
		pc.add(lPhai); pc.add(rbtn);
		pc.add(lTienluong); pc.add(txtTienluong);
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
	
	public static void main(String[] args) {
		new QLNV_Gui();
	}
}
