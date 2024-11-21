select * from nhan_vien
where ho_ten like 'H%' 
   or ho_ten like 'T%' 
   or ho_ten like 'K%' 
   and length(ho_ten) <= 15;
   
select * from khach_hang
where cast(ngay_sinh as date) between curdate() - interval 50 year and curdate() - interval 18 year
and (dia_chi = 'Đà Nẵng' OR dia_chi = 'Quảng Trị');

SELECT kh.id_khach_hang, kh.ho_ten, COUNT(hd.id_khach_hang) AS so_lan_dat_phong
FROM khach_hang kh
JOIN hop_dong hd ON kh.id_khach_hang = hd.id_khach_hang
JOIN loai_khach lk ON kh.id_loai_khach = lk.id_loai_khach
WHERE lk.ten_loai_khach = 'Diamond'
GROUP BY kh.id_khach_hang
ORDER BY so_lan_dat_phong ASC;

select 