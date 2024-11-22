CREATE DATABASE IF NOT EXISTS bai1ss2;
USE bai1ss2;

-- Bảng nhà cung cấp
CREATE TABLE nha_cung_cap (
    ma_nha_cung_cap INT PRIMARY KEY,
    ten_nha_cung_cap VARCHAR(100),
    dia_chi VARCHAR(100)
) ENGINE=InnoDB;

-- Bảng đơn đặt hàng
CREATE TABLE don_dat_hang (
    so_dat_hang INT PRIMARY KEY,
    ngay_dat_hang DATE,
    ma_nha_cung_cap INT,
    FOREIGN KEY (ma_nha_cung_cap) REFERENCES nha_cung_cap(ma_nha_cung_cap)
) ENGINE=InnoDB;

-- Bảng phiếu xuất
CREATE TABLE phieu_xuat (
    so_phieu_xuat INT PRIMARY KEY,
    ngay_xuat DATE
) ENGINE=InnoDB;

-- Bảng vật tư
CREATE TABLE vat_tu (
    ma_vat_tu INT PRIMARY KEY,
    ten_vat_tu VARCHAR(100)
) ENGINE=InnoDB;

-- Bảng phiếu nhập
CREATE TABLE phieu_nhap (
    so_phieu_nhap INT PRIMARY KEY,
    ngay_nhap DATE
) ENGINE=InnoDB;

-- Bảng phiếu xuất - vật tư (liên kết phiếu xuất và vật tư)
CREATE TABLE phieu_xuat_vat_tu (
    so_phieu_xuat INT,
    ma_vat_tu INT,
    don_gia_xuat DECIMAL(10, 2),
    so_luong_xuat INT,
    PRIMARY KEY (so_phieu_xuat, ma_vat_tu),
    FOREIGN KEY (so_phieu_xuat) REFERENCES phieu_xuat(so_phieu_xuat),
    FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
) ENGINE=InnoDB;

-- Bảng phiếu nhập - vật tư (liên kết phiếu nhập và vật tư)
CREATE TABLE phieu_nhap_vat_tu (
    so_phieu_nhap INT,
    ma_vat_tu INT,
    don_gia_nhap DECIMAL(10, 2),
    so_luong_nhap INT,
    PRIMARY KEY (so_phieu_nhap, ma_vat_tu),
    FOREIGN KEY (so_phieu_nhap) REFERENCES phieu_nhap(so_phieu_nhap),
    FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
) ENGINE=InnoDB;

-- Bảng đơn đặt hàng - vật tư (liên kết đơn đặt hàng và vật tư)
CREATE TABLE don_dat_hang_vat_tu (
    so_dat_hang INT,
    ma_vat_tu INT,
    PRIMARY KEY (so_dat_hang, ma_vat_tu),
    FOREIGN KEY (so_dat_hang) REFERENCES don_dat_hang(so_dat_hang),
    FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
) ENGINE=InnoDB;

-- Bảng số điện thoại nhà cung cấp (liên kết nhiều số điện thoại cho một nhà cung cấp)
CREATE TABLE so_dien_thoai_nha_cung_cap (
    ma_nha_cung_cap INT,
    so_dien_thoai VARCHAR(15),
    PRIMARY KEY (ma_nha_cung_cap, so_dien_thoai),
    FOREIGN KEY (ma_nha_cung_cap) REFERENCES nha_cung_cap(ma_nha_cung_cap)
) ENGINE=InnoDB;
