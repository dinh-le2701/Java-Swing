package tuan04.bai01;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class QLSach_GUI extends JFrame{
	
	JPanel pn, pc, ps;
	
	
	public QLSach_GUI() {
		pn = new JPanel();
		
		Border recordseditor = BorderFactory.createTitledBorder("Records Editor");
		pn.setBorder(recordseditor);
		
		
		// panel south for program
		ps = new JPanel();
		Border dscuonsach = BorderFactory.createTitledBorder("Danh sách các cuốn sách");
		pn.setBorder(dscuonsach);
		
		add(pn);
		add(ps);
		
		
		setVisible(true);
		setLocation(500, 300);
		setSize(550, 400);
	}
	
	
	// main function for program
	public static void main(String[] args) {
		new QLSach_GUI();
	}
}
