package tuan01.bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class QuadraticEquationSolver extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtA, txtB, txtC, txtResult;
    private JButton btnSolve, btnClear, btnExit;

    public QuadraticEquationSolver() {
        // Tạo JFrame
        setTitle("Giải Phương Trình Bậc Hai");
        setSize(850, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo JPanel chính
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Tiêu đề
        JLabel lblTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setBackground(Color.CYAN);
        lblTitle.setOpaque(true);
        panel.add(lblTitle, BorderLayout.NORTH);

        // Tạo JPanel cho các trường nhập liệu và nhãn
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblA = new JLabel("Nhập a:");
        txtA = new JTextField();
        txtA.setPreferredSize(new Dimension(20, 30)); // Đặt kích thước cho JTextField

        JLabel lblB = new JLabel("Nhập b:");
        txtB = new JTextField();
        txtB.setPreferredSize(new Dimension(200, 30)); // Đặt kích thước cho JTextField

        JLabel lblC = new JLabel("Nhập c:");
        txtC = new JTextField();
        txtC.setPreferredSize(new Dimension(200, 30)); // Đặt kích thước cho JTextField

        JLabel lblResult = new JLabel("Kết quả:");
        txtResult = new JTextField();
        txtResult.setPreferredSize(new Dimension(200, 30)); // Đặt kích thước cho JTextField
        txtResult.setEditable(false);

        inputPanel.add(lblA);
        inputPanel.add(txtA);
        inputPanel.add(lblB);
        inputPanel.add(txtB);
        inputPanel.add(lblC);
        inputPanel.add(txtC);
        inputPanel.add(lblResult);
        inputPanel.add(txtResult);

        panel.add(inputPanel, BorderLayout.CENTER);

        // Tạo JPanel cho các nút chức năng
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        btnSolve = new JButton("Giải");
        btnSolve.setPreferredSize(new Dimension(90, 40)); // Đặt kích thước cho JButton
        btnClear = new JButton("Xóa rỗng");
        btnClear.setPreferredSize(new Dimension(90, 40)); // Đặt kích thước cho JButton
        btnExit = new JButton("Thoát");
        btnExit.setPreferredSize(new Dimension(90, 40)); // Đặt kích thước cho JButton

        buttonPanel.add(btnSolve);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);

        panel.add(buttonPanel, BorderLayout.SOUTH);

//        // Thêm hành động cho các nút
//        btnSolve.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                solveEquation();
//            }
//        });
//
//        btnClear.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                clearFields();
//            }
//        });
//
//        btnExit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//
        // Thêm panel chính vào JFrame
        add(panel);
    }

    private void solveEquation() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            double delta = b * b - 4 * a * c;
            String result;

            if (delta < 0) {
                result = "Phương trình vô nghiệm.";
            } else if (delta == 0) {
                double x = -b / (2 * a);
                result = "Phương trình có nghiệm kép: x = " + x;
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                result = "Phương trình có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2;
            }

            txtResult.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        txtResult.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuadraticEquationSolver().setVisible(true);
        });
    }
}
