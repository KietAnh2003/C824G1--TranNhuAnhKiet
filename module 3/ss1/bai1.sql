use student_management;
create table classes (
id int auto_increment primary key,  
name_class varchar(100) not null        
);
create table teachers (
id int auto_increment primary key, 
name_teacher varchar(100) not null,  
age int not null,                           
country varchar(50)             
);