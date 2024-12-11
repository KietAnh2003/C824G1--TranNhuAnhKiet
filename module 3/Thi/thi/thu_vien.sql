create database thu_vien;
use thu_vien;

create table books(
book_code int, primary key(book_code),
book_name varchar(100),
author varchar(50),
book_description varchar(150),
quantity int
);
create table students(
student_code int ,primary key(student_code),
student_name varchar(100),
class varchar (50)
);
create table book_borrow_cards(
code_borrow_book int, primary key(code_borrow_book),
book_code int,
student_code int,
status boolean,
start_day date,
end_day date
); 
insert into books (book_code, book_name, author, book_description, quantity)
values
(1, 'The Catcher in the Rye', 'J.D. Salinger', 'A novel about adolescent angst and alienation', 10),
(2, 'To Kill a Mockingbird', 'Harper Lee', 'A novel about racial inequality and justice', 5),
(3, '1984', 'George Orwell', 'A dystopian novel about totalitarianism and surveillance', 7),
(4, 'The Great Gatsby', 'F. Scott Fitzgerald', 'A story of the American dream and its disillusionment', 8),
(5, 'Moby-Dick', 'Herman Melville', 'A novel about obsession and the sea', 6);

insert into students (student_code, student_name, class)
values
(1, 'Nguyen Van A', 'Class 10A'),
(2, 'Tran Thi B', 'Class 10B'),
(3, 'Le Quang C', 'Class 11A'),
(4, 'Pham Minh D', 'Class 11B'),
(5, 'Hoang Thi E', 'Class 12A');

insert intobook_borrow_cards (code_borrow_book, book_code, student_code, status, start_day, end_day)
values
(1, 1, 1, TRUE, '2024-12-01', '2024-12-15'),
(2, 2, 2, TRUE, '2024-12-02', '2024-12-16'),
(3, 3, 3, FALSE, '2024-12-03', '2024-12-17'),
(4, 4, 4, TRUE, '2024-12-04', '2024-12-18'),
(5, 5, 5, FALSE, '2024-12-05', '2024-12-19');

