use student_management;
create table class (
id int auto_increment primary key,  
name_class varchar(100) not null        
);
create table teacher (
id int auto_increment primary key, 
name_teacher varchar(100) NOT NULL,  
age int,                           
country varchar(50)             
);