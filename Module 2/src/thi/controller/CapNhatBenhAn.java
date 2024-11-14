package thi.controller;

import thi.entity.BenhAn;
import thi.entity.BenhAnThuong;
import thi.entity.BenhAnVIP;
import thi.repository.LuuTruBenhAn;

import java.util.List;
import java.util.Scanner;

import static thi.input.InputValidate.nhapMaBenhAn;

public class CapNhatBenhAn {
    private LuuTruBenhAn luuTruBenhAn;

    public CapNhatBenhAn() {
        this.luuTruBenhAn = new LuuTruBenhAn();
    }

    public void themBenhAn() {
        List<BenhAn> danhSachBenhAn = luuTruBenhAn.docDanhSachBenhAn();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thứ tự: ");
        int soThuTu = scanner.nextInt();
        String maBenhAn = nhapMaBenhAn();
        scanner.nextLine();
        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine();
        System.out.print("Nhập ngày nhập viện: ");
        String ngayNhapVien = scanner.nextLine();
        System.out.print("Nhập ngày ra viện: ");
        String ngayRaVien = scanner.nextLine();
        System.out.print("Nhập lý do nhập viện: ");
        String lyDoNhapVien = scanner.nextLine();
        System.out.print("Nhập lọai bệnh án: ");
        System.out.print("1. Thường ");
        System.out.print("2. VIP");
        String loai = scanner.nextLine();

        if (loai.equalsIgnoreCase("1")) {
            System.out.print("Nhập phí: ");
            double phi = scanner.nextDouble();
            danhSachBenhAn.add(new BenhAnThuong(soThuTu, maBenhAn, ten, ngayNhapVien, ngayRaVien, lyDoNhapVien, phi));
        } else if (loai.equalsIgnoreCase("2")) {
            System.out.print("Nhập loại VIP: ");
            String loaiVip = scanner.nextLine();
            danhSachBenhAn.add(new BenhAnVIP(soThuTu, maBenhAn, ten, ngayNhapVien, ngayRaVien, lyDoNhapVien, loaiVip));
        }
        luuTruBenhAn.ghiDanhSachBenhAn(danhSachBenhAn);
    }

    public void xoaBenhAn() {
        List<BenhAn> danhSachBenhAn = luuTruBenhAn.docDanhSachBenhAn();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã bệnh án cần xóa: ");
        String maXoa = scanner.nextLine();

        for (BenhAn benhAn : danhSachBenhAn) {
            if (benhAn.getMaBenhAn() == maXoa) {
                danhSachBenhAn.remove(benhAn);
                break;
            }
        }
        luuTruBenhAn.ghiDanhSachBenhAn(danhSachBenhAn);
    }

    public void xemDanhSachBenhAn() {
        List<BenhAn> danhSachBenhAn = luuTruBenhAn.docDanhSachBenhAn();
        for (BenhAn benhAn : danhSachBenhAn) {
            System.out.println(benhAn);
        }
    }
}