package tuan01.bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai02 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// ===========================================
	// init component
	JPanel p1 = new JPanel();
	JTextField t1 = new JTextField(30);
	JButton b1 = new JButton("Generate");
	JTextArea ta1 = new JTextArea();
	JList<String> list = new JList<>();
	
	public Bai02() {
		super("Primes");
		
		// add component to Panel
		p1.add(t1);
		p1.add(b1);
		b1.addActionListener(this);
		p1.add(ta1);
		ta1.setLineWrap(true); // Wrap text to fit the width of the JTextArea
		ta1.setWrapStyleWord(true); // Wrap text at word boundaries
		ta1.setRows(10); // Set the number of rows
		ta1.setColumns(30);
		
		add(p1);
		
		
		// create app
		setSize(500, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// ===========================================
	// handle function 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				generate();
			}
		});
	}
	
	private void generate() {
		double a = Double.parseDouble(t1.getText());
		String result = null;
		if (a > 0) {
			ta1.setText(result);			
		}
	}
	
	// ===========================================
	// run app
	public static void main(String[] args) {
		new Bai02();
	}
}
