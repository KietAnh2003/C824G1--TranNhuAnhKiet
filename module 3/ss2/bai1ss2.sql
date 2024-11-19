create database bai1ss2;
use bai1ss2;

create table phieu_xuat(
    so_phieu_xuat int primary key,
    ngay_xuat date
);
create table vat_tu(
    ma_vat_tu int primary key,
    ten_vat_tu varchar(100)
);
create table phieu_nhap(
    so_phieu_nhap int primary key,
    ngay_nhap date
);
create table nha_cung_cap (
    ma_nha_cung_cap int primary key,
    ten_nha_cung_cap varchar(100),
    dia_chi varchar(100)
);
create table don_dat_hang(
    so_dat_hang int primary key,
    ngay_dat_hang date,
    ma_nha_cung_cap int,
    foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
create table phieu_xuat_vat_tu(
    so_phieu_xuat int,
    ma_vat_tu int,
    don_gia_xuat decimal(10, 2),
    so_luong_xuat int,
    primary key (so_phieu_xuat, ma_vat_tu),
    foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
    foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table phieu_nhap_vat_tu(
    so_phieu_nhap int,
    ma_vat_tu int,
    don_gia_nhap decimal(10, 2),
    so_luong_nhap int,
    primary key (so_phieu_nhap, ma_vat_tu),
    foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
    foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table don_dat_hang_vat_tu(
    so_dat_hang int,
    ma_vat_tu int,
    primary key (so_dat_hang, ma_vat_tu),
    foreign key (so_dat_hang) references don_dat_hang(so_dat_hang),
    foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table so_dien_thoai_nha_cung_cap(
    ma_nha_cung_cap int,
    so_dien_thoai varchar(15),
    primary key (ma_nha_cung_cap, so_dien_thoai),
    foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);