create database baitapthem1;
use baitapthem1; 

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
	so_cmnd varchar(45),
	so_dien_thoai varchar(11),
	email varchar(45),
	dia_chi varchar(45),
	foreign key (id_vi_tri) references vi_tri(id_vi_tri),
	foreign key(id_trinh_do) references trinh_do(id_trinh_do),
	foreign key(id_bo_phan) references bo_phan(id_bo_phan)
);

create table loai_khach(
	id_loai_khach int unique,primary key (id_loai_khach),
	ten_loai_khach varchar(45)
);

create table khach_hang(
	id_khach_hang int unique,primary key (id_khach_hang),
	id_loai_khach int,
	ho_ten varchar(45),
	ngay_sinh date,
	so_cmnd varchar(45),
	so_dien_thoai varchar(11),
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

create table dich_vu_di_kem (
    id_dich_vu_di_kem int primary key ,
    ten_dich_vu_di_kem varchar(45),
    gia int,
    don_vi varchar(5),
    trang_thai_kha_dung varchar(45),
    so_luong int 
);

create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int unique,primary key (id_hop_dong_chi_tiet),
	id_hop_dong int,
	id_dich_vu_di_kem int,
	so_luong int,
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
INSERT INTO nhan_vien (id_nhan_vien, ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, so_dien_thoai, email, dia_chi) VALUES
(1, 'Nguyễn Văn A', 1, 1, 1, '1990-01-01', '123456789', '0912345678', 'nva@example.com', 'Hà Nội'),
(2, 'Trần Thị B', 2, 2, 2, '1992-03-15', '987654321', '0987654321', 'ttb@example.com', 'Đà Nẵng'),
(3, 'Phạm Văn C', 3, 3, 3, '1985-07-22', '555555555', '0966666666', 'pvc@example.com', 'TP HCM'),
(4, 'Lê Thị D', 4, 4, 4, '1998-11-11', '444444444', '0944444444', 'ltd@example.com', 'Quảng Trị'),
(5, 'Hoàng Văn E', 5, 5, 5, '1995-06-10', '333333333', '0933333333', 'hve@example.com', 'Nha Trang');
INSERT INTO loai_khach (id_loai_khach, ten_loai_khach) VALUES
(1,'Diamond'),
(2,'Diamond'),
(3, 'Nhà đầu tư'),
(4, 'Tài trơ'),
(5, 'Khách thường xuyên');
INSERT INTO khach_hang (id_khach_hang, id_loai_khach, ho_ten, ngay_sinh, so_cmnd, so_dien_thoai, email, dia_chi) VALUES
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
(1, 2, 2, 1, '2019-01-01', '2024-01-10', 5000000, 15000000),
(2, 2, 2, 2, '2018-01-05', '2024-01-06', 1000000, 5000000),
(3, 4, 2, 3, '2018-02-01', '2024-02-15', 2000000, 8000000),
(4, 4, 4, 4, '2019-03-01', '2024-03-31', 3000000, 12000000),
(5, 5, 5, 5, '2018-04-01', '2024-04-05', 500000, 2500000);
INSERT INTO dich_vu_di_kem (id_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung, so_luong) values
(1, 'Xe đưa đón', 500, 'lượt', 'Có', 1),
(2, 'Dịch vụ spa', 1000, 'buổi', 'Có', 2),
(3, 'Ăn sáng miễn phí', 200, 'bữa', 'Có', 3),
(4, 'Thuê xe đạp', 100, 'giờ', 'Không', 1),
(5, 'Hồ bơi', 300, 'ngày', 'Có', 5);
INSERT INTO hop_dong_chi_tiet (id_hop_dong_chi_tiet, id_hop_dong, id_dich_vu_di_kem, so_luong) VALUES
(1, 1, 1, 1),
(2, 2, 2, 1),
(3, 3, 3, 4),
(4, 4, 4, 1),
(5, 5, 5, 2);

-- Câu 2
select * from nhan_vien
where ho_ten like 'H%' 
   or ho_ten like 'T%' 
   or ho_ten like 'K%' 
   and length(ho_ten) <= 15;
   
-- Câu 3
select * from khach_hang
where cast(ngay_sinh as date) between curdate() - interval 50 year and curdate() - interval 18 year
and (dia_chi = 'Đà Nẵng' OR dia_chi = 'Quảng Trị');

-- Câu 4
select
	kh.id_khach_hang, 
	kh.ho_ten,  
	count(hd.id_khach_hang) as so_lan_dat_phong
from khach_hang kh
join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
where lk.ten_loai_khach = 'Diamond'
group by kh.id_khach_hang, kh.ho_ten
order by so_lan_dat_phong asc;

-- câu 5: hiển thị thông tin khách hàng đã từng đặt phòng, bao gồm tổng tiền (chi phí thuê + số lượng * giá dịch vụ)
select 
    kh.id_khach_hang, 
    kh.ho_ten, 
    lk.ten_loai_khach, 
    hd.id_hop_dong, 
    dv.ten_dich_vu, 
    hd.ngay_lam_hop_dong, 
    hd.ngay_ket_thuc, 
    (dv.chi_phi_thue + dvk.so_luong * dvk.gia) as tong_tien
from khach_hang kh
left join hop_dong hd on kh.id_khach_hang = hd.id_khach_hang
left join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
left join dich_vu_di_kem dvk on dv.id_dich_vu = dvk.id_dich_vu_di_kem
left join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach;

-- câu 6: dịch vụ chưa được khách hàng đặt từ quý 1 năm 2019
select 
	dv.id_dich_vu, 
	dv.ten_dich_vu, 
	dv.dien_tich, 
	dv.chi_phi_thue, 
	ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
where dv.id_dich_vu not in (
    select distinct hd.id_dich_vu
    from hop_dong hd
    where year(hd.ngay_lam_hop_dong) = 2019
      and month(hd.ngay_lam_hop_dong) in (1, 2, 3)
);

-- câu 7: dịch vụ đã được khách hàng đặt trong năm 2018 nhưng chưa đặt trong năm 2019
select 
	dv.id_dich_vu, 
	dv.ten_dich_vu, 
	dv.dien_tich, 
	dv.so_nguoi_toi_da, 
	dv.chi_phi_thue, 
	ldv.ten_loai_dich_vu
from dich_vu dv
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
where dv.id_dich_vu in (
    select hd.id_dich_vu
    from hop_dong hd
    where year(hd.ngay_lam_hop_dong) = 2018
)
and dv.id_dich_vu not in (
    select hd.id_dich_vu
    from hop_dong hd
    where year(hd.ngay_lam_hop_dong) = 2019
);

-- câu 8: hiển thị thông tin không trùng lặp của khách hàng
select distinct ho_ten as hotenkhachhang from khach_hang;
select ho_ten as hotenkhachhang from khach_hang group by ho_ten;
select ho_ten as hotenkhachhang from khach_hang union select ho_ten as hotenkhachhang from khach_hang;

-- câu 9: thống kê số lượng khách hàng đặt phòng theo tháng năm 2019
select month(hd.ngay_lam_hop_dong) as thang, 
	count(distinct kh.id_khach_hang) as so_luong_khach_hang
from hop_dong hd
left join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
where year(hd.ngay_lam_hop_dong) = 2019
group by month(hd.ngay_lam_hop_dong)
order by thang;

-- câu 10: hiển thị thông tin hợp đồng với số lượng dịch vụ đi kèm
select 
	hd.id_hop_dong, 
	hd.ngay_lam_hop_dong, 
	hd.ngay_ket_thuc, 
	hd.tien_dat_coc,
	count(hdct.id_hop_dong_chi_tiet) as soluongdichvudikem
from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
group by hd.id_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc;

-- câu 11: dịch vụ đi kèm được sử dụng bởi khách hàng có loại khách hàng 'Diamond' và địa chỉ 'Vinh' hoặc 'Quảng Ngãi'
select 
	dvk.id_dich_vu_di_kem,
	dvk.ten_dich_vu_di_kem, 
	kh.ho_ten, 
	lk.ten_loai_khach, 
	kh.dia_chi
from dich_vu_di_kem dvk
join hop_dong_chi_tiet hdct on dvk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach
where lk.ten_loai_khach = 'Diamond'
  and (kh.dia_chi = 'Vinh' or kh.dia_chi = 'Quảng Ngãi');

-- câu 12: hiển thị thông tin hợp đồng và dịch vụ đi kèm trong 3 tháng cuối năm 2019 nhưng không có trong 6 tháng đầu năm 2019
select
	hd.id_hop_dong, 
	nv.ho_ten, 
	kh.ho_ten as ten_khach_hang, 
	kh.so_dien_thoai as so_dien_thoai_khach_hang, 
	dv.ten_dich_vu, 
	count(hdct.id_hop_dong_chi_tiet) as so_luong_dich_vu_di_kem, 
	hd.tien_dat_coc
from hop_dong hd
join nhan_vien nv on hd.id_nhan_vien = nv.id_nhan_vien
join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
join dich_vu dv on hdct.id_dich_vu_di_kem = dv.id_dich_vu
where year(hd.ngay_lam_hop_dong) = 2019
  and month(hd.ngay_lam_hop_dong) between 10 and 12
  and hd.id_hop_dong not in (
      select hd1.id_hop_dong
      from hop_dong hd1
      where year(hd1.ngay_lam_hop_dong) = 2019
        and month(hd1.ngay_lam_hop_dong) between 1 and 6
  )
group by hd.id_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, hd.tien_dat_coc;

-- câu 13: dịch vụ đi kèm được sử dụng nhiều nhất
select dv.ten_dich_vu_di_kem, 
	   count(hdct.id_hop_dong_chi_tiet) as so_lan_su_dung
from hop_dong_chi_tiet hdct
join dich_vu_di_kem dv on hdct.id_dich_vu_di_kem = dv.id_dich_vu_di_kem
join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
where hd.ngay_lam_hop_dong is not null
group by dv.ten_dich_vu_di_kem
having count(hdct.id_hop_dong_chi_tiet) = (
    select max(so_lan_su_dung)
    from (
        select count(hdct.id_hop_dong_chi_tiet) as so_lan_su_dung
        from hop_dong_chi_tiet hdct
        join dich_vu_di_kem dv on hdct.id_dich_vu_di_kem = dv.id_dich_vu_di_kem
        join hop_dong hd on hdct.id_hop_dong = hd.id_hop_dong
        where hd.ngay_lam_hop_dong is not null
        group by dv.ten_dich_vu_di_kem
    ) as subquery
);

-- câu 14: hiển thị dịch vụ đi kèm chỉ mới được sử dụng một lần
select 
    hd.id_hop_dong as idhopdong,
    ldv.ten_loai_dich_vu as tenloaidichvu,
    dvdk.ten_dich_vu_di_kem as tendichvudikem,
    sum(hdct.so_luong) as solansudung
from hop_dong hd
join hop_dong_chi_tiet hdct on hd.id_hop_dong = hdct.id_hop_dong
join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
join loai_dich_vu ldv on dv.id_loai_dich_vu = ldv.id_loai_dich_vu
group by hd.id_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem
having sum(hdct.so_luong) = 1;

-- câu 15: hiển thị nhân viên đã lập tối đa 3 hợp đồng từ năm 2018 đến 2019
select 
    nv.id_nhan_vien as idnhanvien,
    nv.ho_ten as hoten,
    td.trinh_do as trinhdo,
    bp.ten_bo_phan as tenbophan,
    nv.so_dien_thoai as sodienthoai,
    nv.dia_chi as diachi
from nhan_vien nv
join hop_dong hd on nv.id_nhan_vien = hd.id_nhan_vien
join bo_phan bp on nv.id_bo_phan = bp.id_bo_phan
left join trinh_do td on nv.id_trinh_do = td.id_trinh_do
where year(hd.ngay_lam_hop_dong) between 2018 and 2019
group by nv.id_nhan_vien, nv.ho_ten, td.trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
having count(hd.id_hop_dong) <= 3;
 