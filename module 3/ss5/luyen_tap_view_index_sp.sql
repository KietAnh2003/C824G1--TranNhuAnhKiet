create database products_manager;
use products_manager; 

create table products (
id int primary key ,
product_code int,
product_name varchar(100),
product_price double,
product_amount int,
product_description varchar(200) ,
product_status bit
);	
INSERT INTO products (id, product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES 
(1, 101, 'Laptop Acer Nitro 5', 1500.99, 10, 'Gaming laptop with Core i5 and GTX 1650', 1),
(2, 102, 'Smartphone Samsung Galaxy S23', 999.99, 20, 'High-end smartphone with AMOLED display', 1),
(3, 103, 'Wireless Mouse Logitech', 25.50, 50, 'Ergonomic wireless mouse with long battery life', 1),
(4, 104, 'Mechanical Keyboard Razer', 129.99, 15, 'RGB mechanical keyboard with programmable keys', 1),
(5, 105, 'Gaming chair', 299.99, 5, 'Comfortable gaming chair with adjustable height', 0),
(6, 106, '4K Monitor LG UltraFine', 499.99, 8, '4K resolution monitor for professional editing', 1);

Create Unique Index index_product_code on products(product_code);
Create Unique Index index_product_name_price on products(product_name, product_price);
SHOW INDEX FROM products;
Explain Select * from products where product_name = 'Laptop Acer Nitro 5' and product_price > 20;

create view products_view as 
select product_code, product_name, product_price, product_status 
from products ;
update products_view 
set product_name = 'Laptop Acer Nitro 6' where product_name = 'Laptop Acer Nitro 5';
drop view products_view;

delimiter //
create procedure all_records ()
begin 
	select * from products;
end //

create procedure add_product(
	p_id int, 
	p_code int, 
	p_name varchar(100), 
	p_price double,
	p_amount int, 
	p_description varchar(200), 
	p_status bit)
begin 
	insert into products(id, product_code, product_name, product_price, product_amount, product_description, product_status)
	values (p_id, p_code, p_name, p_price, p_amount, p_description, p_status);
end //

create procedure edit_product_by_id (
	p_id int, 
	p_code int, 
	p_name varchar(100), 
	p_price double,
	p_amount int, 
	p_description varchar(200), 
	p_status bit)
begin 
	update products
	set product_code = p_code,
     product_name = p_name,
     product_price = p_price,
     product_amount = p_amount,
     product_description = p_description,
     product_status = p_status
	where id = p_id;		
end //

create procedure delete_product_by_id (p_id int)
begin 
	delete from products 
    where id = p_id;
end //

delimiter ;

call all_records;
call add_product(7,109, 'abc', 209.23, 200, 'VIPPP',1 );
call all_records;
SET SQL_SAFE_UPDATES = 0;
call edit_product_by_id(3, 200,'XYZ', 100000.100, 10, 'VIPRO',0);
SET SQL_SAFE_UPDATES = 1;
call all_records;
call delete_product_by_id(1);
call all_records;