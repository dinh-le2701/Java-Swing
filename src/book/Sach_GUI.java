package book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sach_GUI extends JFrame {
    private JTextField txtMaSach, txtTenSach, txtNhaXuatBan;
    private JComboBox<String> cbLoaiSach;
    private JTable table;
    private DefaultTableModel tableModel;
    private DanhSachSach danhSachSach;
    private final String FILE_PATH = "book.txt";

    public Sach_GUI() {
        danhSachSach = new DanhSachSach();
        initGUI();
    }

    private void initGUI() {
        setTitle("Quản lý Sách");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel nhập dữ liệu
        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Mã Sách:"));
        txtMaSach = new JTextField();
        panel.add(txtMaSach);

        panel.add(new JLabel("Tên Sách:"));
        txtTenSach = new JTextField();
        panel.add(txtTenSach);

        panel.add(new JLabel("Nhà Xuất Bản:"));
        txtNhaXuatBan = new JTextField();
        panel.add(txtNhaXuatBan);

        panel.add(new JLabel("Loại Sách:"));
        cbLoaiSach = new JComboBox<>(new String[]{"Sách Giáo Khoa", "Sách Điện Tử"});
        panel.add(cbLoaiSach);

        // Bảng hiển thị sách
        String[] columns = {"Mã Sách", "Tên Sách", "Nhà Xuất Bản", "Loại Sách"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Các nút chức năng
        JButton btnThem = new JButton("Thêm");
        JButton btnXoa = new JButton("Xóa");
        JButton btnSua = new JButton("Sửa");
        JButton btnXoaRong = new JButton("Xóa Rỗng");
        JButton btnLuu = new JButton("Lưu File");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnThem);
        buttonPanel.add(btnXoa);
        buttonPanel.add(btnSua);
        buttonPanel.add(btnXoaRong);
        buttonPanel.add(btnLuu);

        // Xử lý sự kiện
        btnThem.addActionListener(e -> themSach());
        btnXoa.addActionListener(e -> xoaSach());
        btnSua.addActionListener(e -> suaSach());
        btnXoaRong.addActionListener(e -> xoaRong());
        btnLuu.addActionListener(e -> luuFile());

        // Sắp xếp layout
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Phương thức kiểm tra toàn bộ dữ liệu đầu vào
    private boolean kiem(String maSach, String tenSach, String nhaXuatBan) {
        // Kiểm tra mã sách: bắt đầu bằng 'S' và theo sau là 3 chữ số
        String regexMaSach = "^S\\d{3}$";
        Pattern patternMaSach = Pattern.compile(regexMaSach);
        Matcher matcherMaSach = patternMaSach.matcher(maSach);
        if (!matcherMaSach.matches()) {
            JOptionPane.showMessageDialog(this, "Mã sách phải bắt đầu bằng 'S' và theo sau là 3 chữ số (ví dụ: S001).");
            return false;
        }

        // Kiểm tra tên sách không được rỗng
        if (tenSach.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên sách không được để trống.");
            return false;
        }

        // Kiểm tra nhà xuất bản không được rỗng
        if (nhaXuatBan.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhà xuất bản không được để trống.");
            return false;
        }

        return true;
    }

    private void themSach() {
        String maSach = txtMaSach.getText();
        String tenSach = txtTenSach.getText();
        String nhaXuatBan = txtNhaXuatBan.getText();
        String loaiSach = cbLoaiSach.getSelectedItem().toString();

        // Kiểm tra toàn bộ thông tin sách trước khi thêm
        if (!kiem(maSach, tenSach, nhaXuatBan)) {
            return;
        }

        Sach sach = new Sach(maSach, tenSach, nhaXuatBan, loaiSach);
        danhSachSach.themSach(sach);

        tableModel.addRow(new Object[]{maSach, tenSach, nhaXuatBan, loaiSach});
        xoaRong();
    }

    private void suaSach() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String maSach = txtMaSach.getText();
            String tenSach = txtTenSach.getText();
            String nhaXuatBan = txtNhaXuatBan.getText();
            String loaiSach = cbLoaiSach.getSelectedItem().toString();

            // Kiểm tra toàn bộ thông tin sách trước khi sửa
            if (!kiem(maSach, tenSach, nhaXuatBan)) {
                return;
            }

            Sach sachMoi = new Sach(maSach, tenSach, nhaXuatBan, loaiSach);
            danhSachSach.suaSach(sachMoi);

            tableModel.setValueAt(tenSach, selectedRow, 1);
            tableModel.setValueAt(nhaXuatBan, selectedRow, 2);
            tableModel.setValueAt(loaiSach, selectedRow, 3);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần sửa.");
        }
    }

    private void xoaSach() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            String maSach = tableModel.getValueAt(selectedRow, 0).toString();
            danhSachSach.xoaSach(maSach);
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách cần xóa.");
        }
    }

    private void xoaRong() {
        txtMaSach.setText("");
        txtTenSach.setText("");
        txtNhaXuatBan.setText("");
        cbLoaiSach.setSelectedIndex(0);
    }

    private void luuFile() {
        try {
            danhSachSach.luuFile(FILE_PATH);
            JOptionPane.showMessageDialog(this, "Lưu thành công vào file: " + FILE_PATH);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Lưu thất bại: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Sach_GUI().setVisible(true));
    }
}
