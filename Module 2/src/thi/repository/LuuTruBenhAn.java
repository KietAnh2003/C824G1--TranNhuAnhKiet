package thi.repository;

import thi.entity.BenhAn;
import thi.entity.BenhAnThuong;
import thi.entity.BenhAnVIP;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LuuTruBenhAn {
    public List<BenhAn> docDanhSachBenhAn() {
        List<BenhAn> danhSachBenhAn = new ArrayList<>();
        try (FileReader reader = new FileReader("src/thi/data/medical_records.csv")) {
            StringBuilder stringBuilder = new StringBuilder();
            int i;
            reader.read();
            while ((i = reader.read()) != -1) {
                if (i == '\n') {
                    String[] data = stringBuilder.toString().split(",");
                    int soThuTu = Integer.parseInt(data[0]);
                    String maBenhAn = data[1];
                    String ten = data[2];
                    String ngayNhapVien = data[3];
                    String ngayRaVien = data[4];
                    String lyDoNhapVien = data[5];
                    if (!data[6].isEmpty()) {
                        double phi = Double.parseDouble(data[6]);
                        danhSachBenhAn.add(new BenhAnThuong(soThuTu, maBenhAn, ten, ngayNhapVien, ngayRaVien, lyDoNhapVien, phi));
                    } else if (!data[7].isEmpty()) {
                        String loaiVip = data[7];
                        danhSachBenhAn.add(new BenhAnVIP(soThuTu, maBenhAn, ten, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVip));
                    }
                    stringBuilder = new StringBuilder();
                } else {
                    stringBuilder.append((char) i);
                }
            }
        } catch (IOException e) {
            System.out.println("lỗi đọc file");
        }
        return danhSachBenhAn;
    }

    public void ghiDanhSachBenhAn(List<BenhAn> danhSachBenhAn) {
        try (FileWriter writer = new FileWriter("src/thi/data/medical_records.csv")) {
            writer.write("soThuTu,maBenhAn,ten,ngayNhapVien,ngayRaVien,lyDoNhapVien,phi,loaiVip\n");
            for (BenhAn benhAn : danhSachBenhAn) {
                if (benhAn instanceof BenhAnThuong) {
                    BenhAnThuong benhAnThuong = (BenhAnThuong) benhAn;
                    writer.write(benhAnThuong.getSoThuTu() + ","
                            + benhAnThuong.getMaBenhAn() + ","
                            + benhAnThuong.getTen() + ","
                            + benhAnThuong.getNgayNhapVien() + ","
                            + benhAnThuong.getNgayRaVien() + ","
                            + benhAnThuong.getLyDoNhapVien() + ","
                            + benhAnThuong.getPhi());
                } else if (benhAn instanceof BenhAnVIP) {
                    BenhAnVIP benhAnVIP = (BenhAnVIP) benhAn;
                    writer.write(benhAnVIP.getSoThuTu() + ","
                            + benhAnVIP.getMaBenhAn() + ","
                            + benhAnVIP.getTen() + ","
                            + benhAnVIP.getNgayNhapVien() + ","
                            + benhAnVIP.getNgayRaVien() + ","
                            + benhAnVIP.getLyDoNhapVien() + ","
                            + benhAnVIP.getLoaiVip());
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file.");
        }
    }
}
