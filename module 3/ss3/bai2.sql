create database bai2ss3;
use bai2ss3; 

create table customers(
id int primary key auto_increment,
name_customer  varchar(50) not null,
age int
);
create table orders(
id int primary key auto_increment,
id_customer int,
date_order datetime,
total_price double,
foreign key (id_customer) references customers(id)
);
create table products(
id int primary key auto_increment,
name_product varchar(50),
price double
);
create table orderdetails (
	id_order int, 
    id_product int,
    quantity_order int,
    primary key (id_order, id_product),
    foreign key (id_order) references orders(id),
    foreign key (id_product) references products(id)
    );
    
insert into customers values
(null, 'Minh Quan', 10),
(null, 'Ngoc Oanh', 20),
(null, 'Hong Ha', 50);
insert into orders values
(null, 1, '2006-03-21', null),
(null, 2, '2006-03-23', null),
(null, 1, '2006-03-16', null);
insert into products values 
(null, 'May Giat', 3),
(null, 'Tu Lanh', 5),
(null, 'Dieu Hoa',7),
(null, 'Quat', 1),
(null, 'Bep Dien', 2);
insert into orderdetails values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select * from orders;

select c.name_customer as name_customer,
		p.name_product as name_product
from customers c 
join orders o on c.id = o.id_customer
join orderdetails od on o.id = od.id_order
join products p on od.id_product = p.id;

select name_cus
from customers c
where id not in ( select id_customer from orders);
select o.id, o.date_order,
sum(od.quantity_order * p.price)
from orders o
join orderdetails od on o.id = od.id_order
join products p on od.id_product = p.id
group by o.id, o.date_order;