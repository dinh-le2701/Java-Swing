package book;

import java.io.*;
import java.util.ArrayList;

public class DanhSachSach {
    private ArrayList<Sach> dsSach;

    public DanhSachSach() {
        dsSach = new ArrayList<>();
    }

    public void themSach(Sach sach) {
        dsSach.add(sach);
    }

    public void xoaSach(String maSach) {
        dsSach.removeIf(s -> s.getMaSach().equals(maSach));
    }

    public Sach timSach(String maSach) {
        for (Sach s : dsSach) {
            if (s.getMaSach().equals(maSach)) {
                return s;
            }
        }
        return null;
    }

    public void suaSach(Sach sachMoi) {
        Sach sachCu = timSach(sachMoi.getMaSach());
        if (sachCu != null) {
            sachCu.setTenSach(sachMoi.getTenSach());
            sachCu.setNhaXuatBan(sachMoi.getNhaXuatBan());
            sachCu.setLoaiSach(sachMoi.getLoaiSach());
        }
    }

    // Lưu danh sách sách vào file văn bản book.txt, tự động tạo file nếu chưa có
    public void luuFile(String filePath) throws IOException {
        File file = new File(filePath);
        // Tự động tạo file nếu nó chưa tồn tại
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Sach sach : dsSach) {
            writer.write(sach.getMaSach() + "," + sach.getTenSach() + "," +
                         sach.getNhaXuatBan() + "," + sach.getLoaiSach());
            writer.newLine();
        }
        writer.close();
    }

    // Đọc danh sách sách từ file văn bản book.txt
    public void docFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return; // Nếu file chưa tồn tại, không làm gì cả
        }

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        dsSach.clear();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 4) {
                Sach sach = new Sach(data[0], data[1], data[2], data[3]);
                dsSach.add(sach);
            }
        }
        reader.close();
    }

    public ArrayList<Sach> getDsSach() {
        return dsSach;
    }
}