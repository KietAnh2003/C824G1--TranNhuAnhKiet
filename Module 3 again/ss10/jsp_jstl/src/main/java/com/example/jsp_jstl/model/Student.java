package com.example.jsp_jstl.model;

public class Student {
    private String maHocVien;
    private String ten;
    private String gioiTinh;
    private double diemSo;
    private String xepLoai;

    public Student() {
    }

    public Student(String maHocVien, String ten, String gioiTinh, double diemSo) {
        this.maHocVien = maHocVien;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.diemSo = diemSo;
    }

    public String getMaHocVien() {
        return maHocVien;
    }

    public void setMaHocVien(String maHocVien) {
        this.maHocVien = maHocVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(double diemSo) {
        this.diemSo = diemSo;
    }
    public String getXepLoai() {
        if (diemSo >= 90) {
            return "Giỏi";
        } else if (diemSo >= 80) {
            return "Khá";
        } else if (diemSo >= 60) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }
}
