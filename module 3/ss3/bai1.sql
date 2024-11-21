create database bai1ss3;
use bai1ss3; 

create table classes(
id int primary key auto_increment,
class_name varchar(50),
start_date datetime,
status_class bit
);
create table subjects(
id int primary key auto_increment,
sub_name varchar(30) ,
credit tinyint default 1 check (credit >=1),
status_sub bit default 1
);
create table students(
id int primary key auto_increment,
name_student varchar(30) not null,
address varchar(50),
phone varchar(20),
status_student bit,
id_class int,
foreign key (id_class) references classes(id)
);
create table marks(
id int primary key auto_increment,
id_sub int,
id_student int,
mark float default 0 check (mark >=0 and mark <= 100),
exam_times tinyint default 1,
foreign key (id_sub) references subjects(id),
foreign key (id_student) references students(id)
);

insert into classes values 
(null, 'A', '2024-12-10 08:30:00', 1),
(null, 'B', '2024-12-20 09:15:00', 1),
(null, 'C', '2024-11-05 07:45:00', 0);
insert into students values
(null, 'Hung', 'Hanoi', '0912345678', 1, 1),
(null, 'Ngoc', 'HCM', '0965432100', 1, 2),
(null, 'Duc', 'Danang', '0932123456', 1, 3),
(null, 'Hanh', 'Hue', '0987654322', 1, 2);
insert into subjects values
(null, 'Biology', 3, 1),
(null, 'Literature', 4, 1),
(null, 'Geography', 5, 1),
(null, 'Art', 2, 1);
insert into marks values
(null, 1, 1, 88, 1),
(null, 2, 2, 95, 1),
(null, 3, 3, 77, 2),
(null, 1, 4, 82, 1);

select * from students where name_student like 'H%';
         
select * from classes where month(start_date) = 12;
         
select * from subjects where credit >=3 and credit <=5;

set SQL_SAFE_UPDATES = 0;
update students 
set id_class = 2
where name_student = 'Hung';
set SQL_SAFE_UPDATES = 1;

select s.name_student as name_student,sub.sub_name as name_subject,m.mark as mark
from marks
join students on marks.id_student = student.id
join subjects on marks.id_sub = subjects.id
order by mark.mark desc, studnet.name_student asc;