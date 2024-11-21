create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;

create table students (
    id int auto_increment primary key,
    ho_ten varchar(100),
    ngay_sinh date,
    dia_chi varchar(255)
);
create table subjects (
    id int auto_increment primary key,
    ten_mon_hoc varchar(100),
    credit int
);
create table marks (
    id int auto_increment primary key,
    student_id int,
    subject_id int,
    diem decimal(5,2),
    foreign key (student_id) references students(id),
    foreign key (subject_id) references subjects(id)
);

insert into students (ho_ten, ngay_sinh, dia_chi) values
('nguyễn văn a', '2000-01-01', 'hà nội'),
('trần thị b', '1999-05-22', 'đà nẵng'),
('phạm minh c', '2001-07-10', 'tp hồ chí minh'),
('lê thị d', '1998-03-15', 'quảng trị'),
('hoàng văn e', '1997-09-09', 'nha trang');
insert into subjects (ten_mon_hoc, credit) values
('toán', 3),
('lý', 4),
('hóa', 3),
('tin học', 2),
('anh văn', 2);
insert into marks (student_id, subject_id, diem) values
(1, 1, 8.5),
(1, 2, 9.0),
(2, 3, 7.5),
(2, 4, 6.0),
(3, 5, 8.0),
(3, 1, 6.5),
(4, 2, 7.0),
(4, 3, 6.5),
(5, 4, 9.5),
(5, 5, 7.0);

select * from subjects where credit = (select max(credit) from subjects);

select subjects.id, subjects.ten_mon_hoc, subjects.credit, marks.diem 
from subjects 
join marks on subjects.id = marks.subject_id 
where marks.diem = (select max(diem) from marks);

select students.id, students.ho_ten, avg(marks.diem) as diem_trung_binh 
from students 
join marks on students.id = marks.student_id 
group by students.id, students.ho_ten 
order by diem_trung_binh desc;

