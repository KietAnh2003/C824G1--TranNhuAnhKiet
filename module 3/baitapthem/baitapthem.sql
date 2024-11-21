create database baitapthem;
use baitapthem; 

create table vi_tri(
id_vi_tri int unique,primary key(id_vi_tri),
ten_vi_tri varchar(45)
);
create table trinh_do(
id_trinh_do int unique,primary key(id_trinh_do),
trinh_do varchar(45)
);
create table bo_phan(
id_bo_phan int unique,primary key (id_bo_phan),
ten_bo_phan varchar(45)
);
create table nhan_vien(
id_nhan_vien int unique,primary key(id_nhan_vien),
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(11),
email varchar(45),
dia_chi varchar(45),
foreign key (id_vi_tri) references vi_tri(id_vi_tri),
foreign key(id_trinh_do) references trinh_do(id_trinh_do),
foreign key(id_bo_phan) references bo_phan(id_bo_phan)
);

create table loai_khach(
id_loai_khach int unique,primary key (id_loai_khach),
ten_loaikhach varchar(45)
);

create table khach_hang(
id_khach_hang int unique,primary key (id_khach_hang),
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmtnd varchar(45),
sdt varchar(11),
email varchar(45),
dia_chi varchar(45),
foreign key(id_loai_khach) references loai_khach(id_loai_khach)
);

create table kieu_thue(
id_kieu_thue int unique,primary key (id_kieu_thue),
ten_kieu_thue varchar(45),
gia int
);

create table loai_dich_vu(
id_loai_dich_vu int unique,primary key (id_loai_dich_vu),
ten_loai_dich_vu varchar(45)
);

create table dich_vu(
id_dich_vu int unique,primary key (id_dich_vu),
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue int,
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(45),
foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table hop_dong(
id_hop_dong int unique,primary key (id_hop_dong),
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien),
foreign key (id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int unique,primary key (id_dich_vu_di_kem),
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi varchar(5),
trang_thai_kha_dung varchar(45)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int unique,primary key (id_hop_dong_chi_tiet),
id_hop_dong int,
id_dich_vu_di_kem int,
soluong int,
foreign key (id_hop_dong) references hop_dong(id_hop_dong),
foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

INSERT INTO vi_tri (id_vi_tri, ten_vi_tri) VALUES
(1, 'Quản lý'),
(2, 'Nhân viên'),
(3, 'Thực tập sinh'),
(4, 'Trưởng phòng'),
(5, 'Phó phòng');
INSERT INTO trinh_do (id_trinh_do, trinh_do) VALUES
(1, 'Đại học'),
(2, 'Cao đẳng'),
(3, 'Trung cấp'),
(4, 'Thạc sĩ'),
(5, 'Tiến sĩ');
INSERT INTO bo_phan (id_bo_phan, ten_bo_phan) VALUES
(1, 'Nhân sự'),
(2, 'Kế toán'),
(3, 'Kỹ thuật'),
(4, 'Kinh doanh'),
(5, 'Hành chính');
INSERT INTO nhan_vien (id_nhan_vien, ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmtnd, sdt, email, dia_chi) VALUES
(1, 'Nguyễn Văn A', 1, 1, 1, '1990-01-01', '123456789', '0912345678', 'nva@example.com', 'Hà Nội'),
(2, 'Trần Thị B', 2, 2, 2, '1992-03-15', '987654321', '0987654321', 'ttb@example.com', 'Đà Nẵng'),
(3, 'Phạm Văn C', 3, 3, 3, '1985-07-22', '555555555', '0966666666', 'pvc@example.com', 'TP HCM'),
(4, 'Lê Thị D', 4, 4, 4, '1998-11-11', '444444444', '0944444444', 'ltd@example.com', 'Quảng Trị'),
(5, 'Hoàng Văn E', 5, 5, 5, '1995-06-10', '333333333', '0933333333', 'hve@example.com', 'Nha Trang');
INSERT INTO loai_khach (id_loai_khach, ten_loaikhach) VALUES
(1, 'Cá nhân'),
(2, 'Doanh nghiệp'),
(3, 'Nhà đầu tư'),
(4, 'Khách VIP'),
(5, 'Khách thường xuyên');
INSERT INTO khach_hang (id_khach_hang, id_loai_khach, ho_ten, ngay_sinh, so_cmtnd, sdt, email, dia_chi) VALUES
(1, 1, 'Nguyễn Văn X', '1985-02-10', '123456789', '0911223344', 'nvx@example.com', 'Hà Nội'),
(2, 2, 'Lê Thị Y', '1990-05-22', '987654321', '0933445566', 'lty@example.com', 'Đà Nẵng'),
(3, 3, 'Phạm Minh Z', '1978-11-30', '456789123', '0966778899', 'pmz@example.com', 'TP Hồ Chí Minh'),
(4, 4, 'Hoàng Gia K', '1990-05-22', '741852963', '0977223311', 'hgk@example.com', 'Quảng Trị'),
(5, 5, 'Trần Thị M', '1995-03-08', '369258147', '0944556677', 'ttm@example.com', 'Đà Nẵng');
INSERT INTO kieu_thue (id_kieu_thue, ten_kieu_thue, gia) VALUES
(1, 'Thuê theo giờ', 50000),
(2, 'Thuê theo ngày', 300000),
(3, 'Thuê theo tuần', 2000000),
(4, 'Thuê theo tháng', 8000000),
(5, 'Thuê dài hạn', 10000000);
INSERT INTO loai_dich_vu (id_loai_dich_vu, ten_loai_dich_vu) VALUES
(1, 'Phòng họp'),
(2, 'Nhà ở'),
(3, 'Biệt thự'),
(4, 'Chung cư'),
(5, 'Nhà nghỉ');
INSERT INTO dich_vu (id_dich_vu, ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, trang_thai) VALUES
(1, 'Villa Beach', 200, 2, 10, 20000000, 3, 3, 'Có sẵn'),
(2, 'Meeting Room', 50, 1, 20, 5000000, 1, 1, 'Có sẵn'),
(3, 'Apartment 1', 100, 3, 6, 10000000, 4, 4, 'Đã thuê'),
(4, 'House Garden', 150, 1, 8, 15000000, 4, 2, 'Có sẵn'),
(5, 'Motel Simple', 30, 1, 2, 2000000, 2, 5, 'Có sẵn');
INSERT INTO hop_dong (id_hop_dong, id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, tong_tien) VALUES
(1, 1, 1, 1, '2024-01-01', '2024-01-10', 5000000, 15000000),
(2, 2, 2, 2, '2024-01-05', '2024-01-06', 1000000, 5000000),
(3, 3, 3, 3, '2024-02-01', '2024-02-15', 2000000, 8000000),
(4, 4, 4, 4, '2024-03-01', '2024-03-31', 3000000, 12000000),
(5, 5, 5, 5, '2024-04-01', '2024-04-05', 500000, 2500000);
INSERT INTO dich_vu_di_kem (id_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung) VALUES
(1, 'Xe đưa đón', 500, 'lượt', 'Có'),
(2, 'Dịch vụ spa', 1000, 'buổi', 'Có'),
(3, 'Ăn sáng miễn phí', 200, 'bữa', 'Có'),
(4, 'Thuê xe đạp', 100, 'giờ', 'Không'),
(5, 'Hồ bơi', 300, 'ngày', 'Có');
INSERT INTO hop_dong_chi_tiet (id_hop_dong_chi_tiet, id_hop_dong, id_dich_vu_di_kem, soluong) VALUES
(1, 1, 1, 3),
(2, 2, 2, 2),
(3, 3, 3, 4),
(4, 4, 4, 1),
(5, 5, 5, 2);
SELECT * FROM nhan_vien
WHERE ho_ten LIKE 'H%' 
   OR ho_ten LIKE 'T%' 
   OR ho_ten LIKE 'K%' 
   AND LENGTH(ho_ten) <= 15;
SELECT * FROM khach_hang
WHERE CAST(ngay_sinh AS DATE) BETWEEN CURDATE() - INTERVAL 50 YEAR AND CURDATE() - INTERVAL 18 YEAR
AND (dia_chi = 'Đà Nẵng' OR dia_chi = 'Quảng Trị');


