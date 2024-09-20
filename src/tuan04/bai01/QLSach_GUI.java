package tuan04.bai01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class QLSach_GUI extends JFrame implements ActionListener{
	
	JLabel maSach, tuaSach, namXB, soTrang, tacGia, nhaXB, donGia, ISBN;
	
	JTextField TmaSach, TtuaSach, TnamXB, TsoTrang, TtacGia, TnhaXB, TdonGia, TISBN;
	
	JPanel pn, pc, ps;
	
	JButton them, xoaRong, xoa, sua, luu;
	
	Box boxm = Box.createHorizontalBox();
	
	
	public QLSach_GUI() {
		// panel north for program
		pn = new JPanel();
		Border recordseditor = BorderFactory.createTitledBorder("Records Editor");
		boxm.setBorder(recordseditor);
		
		//// component for box north
		maSach = new JLabel("Mã Sách: "); 
		tuaSach = new JLabel("Tựa Sách: ");
		namXB = new JLabel("Năm Xuất Bản: ");
		soTrang = new JLabel("Số Trang: ");
		tacGia = new JLabel("Tác Giả: ");
		nhaXB = new JLabel("Nhà Xuất Bản: ");
		donGia = new JLabel("Đơn Giá: ");
		ISBN = new JLabel("ISBN: ");
		
		TmaSach = new JTextField();
		TtuaSach = new JTextField();
		TnamXB = new JTextField();
		TsoTrang = new JTextField();
		TtacGia = new JTextField();
		TnhaXB = new JTextField();
		TdonGia = new JTextField(); 
		TISBN = new JTextField();
		
		//// add component into box
		// Tạo Box để chứa các trường thông tin sách
        Box fieldBox = Box.createVerticalBox();

     // Box chứa dòng 1: Mã sách
        Box row1 = Box.createHorizontalBox();
        row1.add(new JLabel("Mã sách: "));
        row1.add(Box.createHorizontalStrut(50));
        row1.add(new JTextField(1));
        row1.add(Box.createHorizontalStrut(500));
        
        fieldBox.add(row1);
        fieldBox.add(Box.createVerticalStrut(10));

        // Box chứa dòng 2: Tựa sách và Tác giả
        Box row2 = Box.createHorizontalBox();
        row2.add(new JLabel("Tựa sách: "));
        row2.add(Box.createHorizontalStrut(45));
        row2.add(new JTextField(10));
        row2.add(Box.createHorizontalStrut(50));
        row2.add(new JLabel("Tác giả: "));
        row2.add(Box.createHorizontalStrut(5));
        row2.add(new JTextField(10));
        fieldBox.add(row2);
        fieldBox.add(Box.createVerticalStrut(10));

        // Box chứa dòng 3: Năm xuất bản và Nhà xuất bản
        Box row3 = Box.createHorizontalBox();
        row3.add(new JLabel("Năm xuất bản: "));
        row3.add(Box.createHorizontalStrut(20));
        row3.add(new JTextField(15));
        row3.add(Box.createHorizontalStrut(50));
        row3.add(new JLabel("Nhà xuất bản: "));
        row3.add(Box.createHorizontalStrut(5));
        row3.add(new JTextField(10));
        fieldBox.add(row3);
        fieldBox.add(Box.createVerticalStrut(10));

        // Box chứa dòng 4: Số trang và ISBN
        Box row4 = Box.createHorizontalBox();
        row4.add(new JLabel("Số trang: "));
        row4.add(Box.createHorizontalStrut(5));
        row4.add(new JTextField(10));
        row4.add(Box.createHorizontalStrut(20));
        row4.add(new JLabel("Đơn giá: "));
        row4.add(Box.createHorizontalStrut(5));
        row4.add(new JTextField(10));
        row4.add(Box.createHorizontalStrut(20));
        
        fieldBox.add(row4);
        fieldBox.add(Box.createVerticalStrut(10));
        
        Box row5 = Box.createHorizontalBox();
        row5.add(new JLabel("International Standard Book Number: "));
        row5.add(Box.createHorizontalStrut(5));
        row5.add(new JTextField(10));
        row5.add(Box.createHorizontalStrut(300));
        fieldBox.add(row5);
        fieldBox.add(Box.createVerticalStrut(10));
		
        
        
        boxm.add(fieldBox);
		
		
		// panel center for program
		pc = new JPanel();
		them = new JButton("Thêm");
		xoaRong = new JButton("Xóa Rỗng");
		xoa = new JButton("Xóa");
		sua = new JButton("Sửa");
		luu = new JButton("Lưu");
		
		pc.add(them);
		them.addActionListener(this);
		pc.add(xoaRong);
		xoaRong.addActionListener(this);
		pc.add(xoa);
		xoa.addActionListener(this);
		pc.add(sua);
		sua.addActionListener(this);
		pc.add(luu);
		luu.addActionListener(this);
		
		
		
		// panel south for program
		ps = new JPanel();
		Border dscuonsach = BorderFactory.createTitledBorder("Danh sách các cuốn sách");
		ps.setBorder(dscuonsach);
		
		add(boxm, BorderLayout.NORTH);
		add(pc, BorderLayout.CENTER);
		add(ps, BorderLayout.SOUTH);
		
		
		setVisible(true);
		setLocation(500, 300);
		setSize(800, 500);
	}
	
	// validate data function before add book
//	private boolean validateData() {
//		String maSach = TmaSach.getText().trim();
//		String tuaSach = TtuaSach.getText().trim(); 
//		String namXB = TnamXB.getText().trim(); 
//		String soTrang = TsoTrang.getText().trim(); 
//		String tacGia = TtacGia.getText().trim(); 
//		String nhaXB = TnhaXB.getText().trim(); 
//		String donGia = TdonGia.getText().trim(); 
//		String ISBN = TISBN.getText().trim();
//		
//		if() {
//			
//			return false;
//		}
//	}
	
	// main function for program
	public static void main(String[] args) {
		new QLSach_GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		xoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TmaSach.setText("");
			}
		});
		
		sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		luu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
