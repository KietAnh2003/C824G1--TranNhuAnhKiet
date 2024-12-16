create database library;
use library;

create table students (
id_student int primary key,
name_student varchar(50),
birthday date,
class_name varchar(50)
);
create table authors (
id_author int primary key,
name_author varchar(50)
);
create table category (
id_category int primary key,
name_category varchar(50)
);
create table books (
id_book int primary key,
title varchar(50),
page_size int, 
id_author int,
id_category int,
foreign key (id_author) references authors(id_author),
foreign key (id_category) references category(id_category)
);
create table borrows (
id_student int,
id_book int,
borrow_date date,
return_date date,
primary key (id_student,id_book),
foreign key (id_student) references students(id_student),
foreign key (id_book) references books(id_book)
);
INSERT INTO category (id_category, name_category) VALUES
(1, 'Tự nhiên'),
(2, 'Xã Hội'),
(3, 'Truyện'),
(4, 'Tiểu Thuyết'),
(5, 'Khác');
INSERT INTO authors (id_author, name_author) VALUES
(1, 'Nguyễn Thái Học'),
(2, 'Trần Mình Hoàng'),
(3, 'Dương Trung Quốc'),
(4, 'Lê Văn Hiến'),
(5, 'Hà Văn Minh');
INSERT INTO students (id_student, name_student, birthday, class_name) VALUES
(1, 'Nguyễn Văn A', '1999-12-12', 'C0822G1'),
(2, 'Nguyễn Văn B', '1999-12-13', 'C0822G1'),
(3, 'Nguyễn Văn C', '1999-12-14', 'C0822G1'),
(4, 'Nguyễn Văn D', '1999-12-15', 'C0922G1'),
(5, 'Nguyễn Văn E', '1999-12-16', 'C1022G1');
INSERT INTO books (id_book, title, page_size, id_author, id_category) VALUES
(1, 'Toán', 45, 1, 1),
(2, 'Văn', 34, 2, 2),
(3, 'Sử', 56, 3, 2),
(4, 'Địa', 76, 4, 2),
(5, 'Hoá', 32, 5, 1);
INSERT INTO borrows (id_student, id_book, borrow_date, return_date) VALUES
(1, 1, '2022-12-12', '2022-12-13'),
(2, 2, '2022-12-12', '2022-12-15'),
(3, 3, '2022-12-12', '2022-12-15'),
(4, 4, '2022-12-12', '2022-12-12'),
(1, 5, '2022-12-13', '2022-12-15'),
(1, 5, '2022-12-14', '2022-12-14'),
(3, 4, '2022-12-15', '2022-12-29'),
(3, 3, '2022-12-08', '2022-12-14'),
(1, 2, '2022-12-06', '2022-12-30');
select  title from books 
