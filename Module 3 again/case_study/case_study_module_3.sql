create database order_food;
use order_food;

-- Bảng khách hàng
create table customers (
    customer_id int auto_increment primary key,
    customer_name varchar(50) not null,
    customer_email varchar(100) unique not null,
    customer_password varchar(255) not null,
    customer_phone varchar(15),
    customer_address varchar(100)
);

-- Bảng nhà hàng
create table restaurants (
    restaurant_id int auto_increment primary key,
    restaurant_name varchar(100) not null,
    restaurant_address varchar(100) not null,
    restaurant_phone varchar(15) not null,
    restaurant_email varchar(100) not null
);

-- Bảng thực đơn món ăn
create table food_menu (
    food_id int auto_increment primary key,
    restaurant_id int not null,
    food_name varchar(100) not null,
    food_description varchar(255),
    food_price decimal(10, 2) not null,
    foreign key (restaurant_id) references restaurant(restaurant_id) on delete cascade
);

-- Bảng đơn hàng
create table order_table (
    order_id int auto_increment primary key,
    customer_id int not null,
    restaurant_id int not null,
    order_date datetime not null,
    order_total_price decimal(10, 2) not null,
    order_status varchar(50) not null default 'pending',
    foreign key (customer_id) references customer(customer_id) on delete cascade,
    foreign key (restaurant_id) references restaurant(restaurant_id)
);

-- Bảng chi tiết đơn hàng
create table order_detail (
    detail_id int auto_increment primary key,
    order_id int not null,
    food_id int not null,
    detail_quantity int not null,
    detail_price decimal(10, 2) not null,
    foreign key (order_id) references order_table(order_id) on delete cascade,
    foreign key (food_id) references food_menu(food_id) on delete cascade
);


insert into users (name, email, password, phone, address) values
('nguyen van a', 'a@gmail.com', 'password123', '0123456789', '123 nguyen trai, ha noi'),
('tran thi b', 'b@gmail.com', 'password456', '0987654321', '456 le loi, da nang');
insert into restaurants (name, location, phone, email) values
('pho ngon', '123 phan xich long, hcm', '0901234567', 'info@phongon.com'),
('com tam binh dan', '456 ba trieu, ha noi', '0912345678', 'contact@comtam.com');
insert into menu_items (restaurant_id, name, description, price) values
(1, 'pho dac biet', 'pho bo dac biet voi thit bo tuoi', 50000),
(1, 'pho ga', 'pho ga tuoi ngon', 45000),
(2, 'com tam suon bi', 'com tam voi suon va bi', 40000),
(2, 'com tam dac biet', 'com tam dac biet voi suon, trung', 55000);
insert into orders (user_id, restaurant_id, order_date, total_price, status) values
(1, 1, '2024-12-15 10:30:00', 95000, 'delivered'),
(2, 2, '2024-12-16 11:45:00', 95000, 'pending');
insert into order_details (order_id, menu_item_id, quantity, price) values
(1, 1, 1, 50000),
(1, 2, 1, 45000),
(2, 3, 2, 80000),
(2, 4, 1, 55000);
