package tuan04.bai01;

import java.util.ArrayList;
import java.util.List;

public class DSSach {
	// Danh sách lưu trữ các sách
    private List<Sach> danhSach;

    // Constructor khởi tạo danh sách sách
    public DSSach() {
        this.danhSach = new ArrayList<>();
    }

    // Thêm sách vào danh sách
    public void themSach(Sach sach) {
        danhSach.add(sach);
    }

    // Xóa sách khỏi danh sách theo mã sách
    public void xoaSach(String maSach) {
        danhSach.removeIf(s -> s.getMaSach().equals(maSach));
    }

    // Lấy danh sách tất cả các sách
    public List<Sach> layDanhSach() {
        return danhSach;
    }

    // Tìm sách theo mã sách
    public Sach timSachTheoMa(String maSach) {
        for (Sach sach : danhSach) {
            if (sach.getMaSach().equals(maSach)) {
                return sach;
            }
        }
        return null;
    }

    

    // Hiển thị thông tin của tất cả sách
    public void hienThiDanhSach() {
        for (Sach sach : danhSach) {
            System.out.println(sach);
        }
    }
}
