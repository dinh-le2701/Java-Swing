package tuan01.bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai01 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// init component
	JPanel pt, pc, ps, pw;
	JLabel l, l1, l2, l3, l4;
	Font lb;
	JTextField t1, t2, t3, t4;
	JButton b1, b2, b3;
	
	public Bai01() {
		super("Giai Phuong Trinh Bac Hai");
		
		// add component to panel 1
		pt = new JPanel();
		l = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		Font lb = new Font("Time New Roman", Font.BOLD, 30);
		l.setFont(lb);
		pt.add(l);
		pt.setBackground(Color.CYAN);
		
		// add component to panel 2
		pc = new JPanel();
		t1 = new JTextField(60);
		t2 = new JTextField(60);
		t3 = new JTextField(60);
		t4 = new JTextField(60);
		t4.setEditable(false);
		pc.add(t1);
		pc.add(t2);
		pc.add(t3);
		pc.add(t4);
		pc.setLayout(new BoxLayout(pc, BoxLayout.Y_AXIS));
		
		// add component to panel 3
		pw = new JPanel();
		l1 = new JLabel("Nhập a: ");
		l2 = new JLabel("Nhập b: ");
		l3 = new JLabel("Nhập c: ");
		l4 = new JLabel("Kết quả: ");
		pw.add(l1);
		pw.add(Box.createRigidArea(new Dimension(0, 10)));
		pw.add(l2);
		pw.add(Box.createRigidArea(new Dimension(0, 10)));
		pw.add(l3);
		pw.add(Box.createRigidArea(new Dimension(0, 10)));
		pw.add(l4);
		pw.setLayout(new BoxLayout(pw, BoxLayout.Y_AXIS));
		
		// add component to panel 4
		ps = new JPanel();
		ps.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		b1 = new JButton("Giải");
		b2 = new JButton("Xoá Rỗng");
		b3 = new JButton("Thoát");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		ps.add(b1);
		ps.add(b2);
		ps.add(b3);
		
		// add panel to frame
		add(pt, BorderLayout.NORTH);
		add(pw, BorderLayout.WEST);
		add(pc, BorderLayout.CENTER);
		add(ps, BorderLayout.SOUTH);
		
		// init application
		setSize(600, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	// =============================================	

	// handle function - Way 1
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				giaiPhuongTrinh();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xoaRongPT();
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thoat();
			}
		});
	}
	// handle function - Way 2
//	@Override
//    public void actionPerformed(ActionEvent e) {
//        // Xử lý sự kiện dựa trên nguồn sự kiện
//        if (e.getSource() == b1) {
//            giaiPhuongTrinh();
//        } else if (e.getSource() == b2) {
//            xoaRongPT();
//        } else if (e.getSource() == b3) {
//            thoat();
//        }
//    }
	
	private void giaiPhuongTrinh() {
		double a = Double.parseDouble(t1.getText());
        double b = Double.parseDouble(t2.getText());
        double c = Double.parseDouble(t3.getText());
        
        double delta = b * b - 4 * a * c; 
        String result = null;
        
		if (delta < 0) {
			result = "Phương trình vô nghiệm";
		} else if (delta == 0) {
			double x = -b / (2 * a);
            result = "Phương trình có nghiệm kép: x = " + x;
		} else {
			double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            result = "Phương trình có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2;
		}
		t4.setText(result);
	}
	
	private void xoaRongPT() {
		t1.setText("");
		t2.setText("");
		t3.setText("");
	}
	
	private void thoat() {
		System.exit(1);
	}
	// =============================================	
	
	public static void main(String [] args) {
		new Bai01();
	}
}
