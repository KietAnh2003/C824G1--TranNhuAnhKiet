create database book_management;
use book_management;

create table books (
id int ,
name_book varchar(50),
page_size int,
author varchar(50)
);

insert into books values
(1,'Toán',45,'Nguyễn Thái Học'),
(2,'Văn',34,'Trần Mình Hoàng'),
(3,'Sử',76,'Lê Văn Hiến'),
(4,'Địa',43,'Hà Văn Minh'),
(5,'Hoá',56,'Dương Trung Quốc');

SET SQL_SAFE_UPDATES = 0;
update books set page_size = 50 where name_book = 'Sử';

delete from books where id = 5;
SET SQL_SAFE_UPDATES = 1;
drop table books;
drop database book_management

