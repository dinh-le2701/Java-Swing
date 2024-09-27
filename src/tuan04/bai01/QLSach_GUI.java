package tuan04.bai01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		TmaSach = new JTextField("");
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
        TmaSach = new JTextField(10);
        row1.add(TmaSach);
        row1.add(Box.createHorizontalStrut(500));
        
        fieldBox.add(row1);
        fieldBox.add(Box.createVerticalStrut(10));

        // Box chứa dòng 2: Tựa sách và Tác giả
        Box row2 = Box.createHorizontalBox();
        row2.add(new JLabel("Tựa sách: "));
        row2.add(Box.createHorizontalStrut(45));
        TtuaSach = new JTextField(10);
        row2.add(TtuaSach);
        row2.add(Box.createHorizontalStrut(50));
        row2.add(new JLabel("Tác giả: "));
        row2.add(Box.createHorizontalStrut(5));
        TtacGia = new JTextField(10);
        row2.add(TtacGia);
        fieldBox.add(row2);
        fieldBox.add(Box.createVerticalStrut(10));

        // Box chứa dòng 3: Năm xuất bản và Nhà xuất bản
        Box row3 = Box.createHorizontalBox();
        row3.add(new JLabel("Năm xuất bản: "));
        row3.add(Box.createHorizontalStrut(20));
        TnamXB = new JTextField(15);
        row3.add(TnamXB);
        row3.add(Box.createHorizontalStrut(50));
        row3.add(new JLabel("Nhà xuất bản: "));
        row3.add(Box.createHorizontalStrut(5));
        TnhaXB = new JTextField(10);
        row3.add(TnhaXB);
        fieldBox.add(row3);
        fieldBox.add(Box.createVerticalStrut(10));

        // Box chứa dòng 4: Số trang và ISBN
        Box row4 = Box.createHorizontalBox();
        row4.add(new JLabel("Số trang: "));
        row4.add(Box.createHorizontalStrut(5));
        TsoTrang = new JTextField(10);
        row4.add(TsoTrang);
        row4.add(Box.createHorizontalStrut(20));
        row4.add(new JLabel("Đơn giá: "));
        row4.add(Box.createHorizontalStrut(5));
        TdonGia = new JTextField(10);
        row4.add(TdonGia);
        row4.add(Box.createHorizontalStrut(20));
        
        fieldBox.add(row4);
        fieldBox.add(Box.createVerticalStrut(10));
        
        Box row5 = Box.createHorizontalBox();
        row5.add(new JLabel("International Standard Book Number: "));
        row5.add(Box.createHorizontalStrut(5));
        TISBN = new JTextField(10);
        row5.add(TISBN);
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
		setLocation(450, 200);
		setSize(800, 500);
	}
	
	// validate data function before add book
	private boolean validateData() {
	    String maSach = TmaSach.getText().trim();
	    String tuaSach = TtuaSach.getText().trim(); 
	    String namXB = TnamXB.getText().trim(); 
	    String soTrang = TsoTrang.getText().trim(); 
	    String tacGia = TtacGia.getText().trim(); 
	    String nhaXB = TnhaXB.getText().trim(); 
	    String donGia = TdonGia.getText().trim(); 
	    String ISBN = TISBN.getText().trim();
	    
	    // Regex patterns
	    String maSachPattern = "^[A-Z]{3}\\d{3}$";  // 3 uppercase letters + 3 digits
	    String yearPattern = "^(19|20)\\d{2}$";  // Accepts years from 1900-2099
	    String pagesPattern = "^\\d+$";  // Only digits, positive number
	    String pricePattern = "^\\d+(\\.\\d{1,2})?$";  // Digits with optional 2 decimal places
	    String isbnPattern = "^(\\d+\\-){3,4}\\d+$";  // ISBN pattern like X-X-X-X or X-X-X-X-X
	    
	    // Validate if all required fields are filled in
	    if (maSach.isEmpty() || tuaSach.isEmpty() || namXB.isEmpty() || soTrang.isEmpty() || 
	        tacGia.isEmpty() || nhaXB.isEmpty() || donGia.isEmpty() || ISBN.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "All fields must be filled.");
	        return false;
	    }

	    // Validate maSach (Book Code)
	    if (!maSach.matches(maSachPattern)) {
	        JOptionPane.showMessageDialog(null, "Invalid book code format. Must be 3 uppercase letters followed by 3 digits.");
	        return false;
	    }

	    // Validate year of publication using regex
	    if (!namXB.matches(yearPattern)) {
	        JOptionPane.showMessageDialog(null, "Invalid year of publication. Year must be between 1900 and the current year.");
	        return false;
	    }

	    // Validate number of pages using regex
	    if (!soTrang.matches(pagesPattern) || Integer.parseInt(soTrang) <= 0) {
	        JOptionPane.showMessageDialog(null, "Number of pages must be a positive number.");
	        return false;
	    }

	    // Validate price using regex
	    if (!donGia.matches(pricePattern) || Double.parseDouble(donGia) <= 0) {
	        JOptionPane.showMessageDialog(null, "Price must be a positive number with up to 2 decimal places.");
	        return false;
	    }

	    // Validate ISBN using regex
	    if (!ISBN.matches(isbnPattern)) {
	        JOptionPane.showMessageDialog(null, "Invalid ISBN format. Example: 978-3-16-148410-0");
	        return false;
	    }

	    // All validations passed
	    return true;
	}
	
	// main function for program
	public static void main(String[] args) {
		new QLSach_GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Kiểm tra xem nút nào được nhấn
	    if (e.getSource() == them) {
	        // Thêm sách vào danh sách
	        if (validateData()) {
	            // Thực hiện thêm sách nếu dữ liệu hợp lệ
	            JOptionPane.showMessageDialog(this, "Sách đã được thêm thành công!");
	        }
	    } else if (e.getSource() == xoa) {
	        // Xóa sách
	        JOptionPane.showMessageDialog(this, "Đã xóa sách!");
	    } else if (e.getSource() == xoaRong) {
	        // Xóa rỗng các trường thông tin
	        clearField();
	    } else if (e.getSource() == sua) {
	        // Sửa thông tin sách
	        JOptionPane.showMessageDialog(this, "Thông tin sách đã được sửa!");
	    } else if (e.getSource() == luu) {
	        // Lưu thông tin sách
	    	saveData();
	        JOptionPane.showMessageDialog(this, "Thông tin sách đã được lưu!");
	    }
	}
	
	
	// ham tao moi du lieu
	private void createData() {
		if (validateData()) {
            // Lấy dữ liệu từ các JTextField
            String maSach = TmaSach.getText().trim();
            String tuaSach = TtuaSach.getText().trim(); 
            String namXB = TnamXB.getText().trim(); 
            String soTrang = TsoTrang.getText().trim(); 
            String tacGia = TtacGia.getText().trim(); 
            String nhaXB = TnhaXB.getText().trim(); 
            String donGia = TdonGia.getText().trim(); 
            String ISBN = TISBN.getText().trim();
            
            // Tạo đối tượng sách mới
            Sach sachMoi = new Sach(maSach, tuaSach, namXB, soTrang, tacGia, nhaXB, donGia, ISBN);
            
            // Thêm sách vào danh sách
            danhSachSach.add(sachMoi);
            
            // Hiển thị thông báo
            JOptionPane.showMessageDialog(null, "Thêm sách thành công!");

            // Xóa rỗng các trường sau khi thêm thành công
            clearField();
            
            // In ra danh sách sách (hoặc cập nhật giao diện JTable nếu cần)
            for (Sach s : danhSachSach) {
                System.out.println(s);
            }
        }
	}
	
	
	// ham sua du lieu
	private void updateData() {
		
	}
	
	// ham xoa du lieu
	private void deleteData() {
		
	}
	
	
	// ham luu du lieu
	private void saveData() {
		try {
            // Tạo file output để ghi sách
            FileWriter writer = new FileWriter("danhsachsach.txt");
            for (Sach sach : danhSachSach) {
                writer.write(sach.toString() + "\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Lưu danh sách sách thành công!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi lưu danh sách sách: " + ex.getMessage());
        }
	}
	
	
	// ham xoa rong du lieu
	private void clearField() {
		TmaSach.setText("");
		TtuaSach.setText("");
		TnamXB.setText("");
		TsoTrang.setText("");
		TtacGia.setText("");
		TnhaXB.setText("");
		TdonGia.setText(""); 
		TISBN.setText("");
		
	}
}
