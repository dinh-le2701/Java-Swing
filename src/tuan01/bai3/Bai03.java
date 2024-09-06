package tuan01.bai3;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Bai03 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ===========================================
	// init component
	JPanel pn, pw, pc, ps;
	Box box;
	JLabel ltitle, la, lb, lk;
	JTextField ta, tb, tk;
	JButton bGiai, bXoa, bThoat, bBlue, bRed, bYellow;
	JRadioButton rcong, rtru, rnhan, rchia;
	public Bai03() {
		super("Cong - Tru - Nhan - Chia");
		
		// create north panel
		pn = new JPanel();
		ltitle = new JLabel("CỘNG - TRỪ - NHÂN - CHIA");
		Font lbold = new Font("Time New Roman", Font.BOLD, 30);
		ltitle.setFont(lbold);
		pn.add(ltitle);
		
		// create west panel
		pw = new JPanel();
		box = Box.createVerticalBox();
		pw.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		bGiai = new JButton("Giải");
		bXoa = new JButton("Xóa");
		bThoat = new JButton("Thoát");
		box.add(bGiai);
		box.add(bXoa);
		box.add(bThoat);
		pw.add(box);
		
		// create center panel
		pc = new JPanel();
		pc.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		la = new JLabel("Nhập a: ");
		ta = new JTextField(35);
		
		lb = new JLabel("Nhập b: ");
		tb = new JTextField(35);
		
		lk = new JLabel("Kết quả: ");
		tk = new JTextField(35);
		tk.setEditable(false);
		
		pc.add(la);
		pc.add(ta);
		pc.add(lb);
		pc.add(tb);
		pc.add(lk);
		pc.add(tk);
		
		// create south panel
		ps = new JPanel();
		ps.setBackground(Color.PINK);
		bBlue = new JButton();
		bBlue.setBackground(Color.BLUE);
		bRed = new JButton();
		bRed.setBackground(Color.RED);
		bYellow = new JButton();
		bYellow.setBackground(Color.YELLOW);
		ps.add(bBlue);
		ps.add(bRed);
		ps.add(bYellow);
		
		// add panel into frame
		add(pn, BorderLayout.NORTH);
		add(pc, BorderLayout.CENTER);
		add(pw, BorderLayout.WEST);
		add(ps, BorderLayout.SOUTH);
		setSize(600, 400);
		setVisible(true);
	}

	// ===========================================
	// handle function
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	// ===========================================
	// run app
	public static void main(String[] args) {
		new Bai03();
	}
}
