create database product;
use product;

create table products (
    id int auto_increment primary key,
    name varchar(255) not null,
    price double not null,
    discount_rate double not null,
    stock_quantity int not null
);

create table employees (
    id int auto_increment primary key,
    name_employee varchar(255) not null,
    dob_employee date not null,
    address_employee varchar(255) not null
);

create table customers (
    id int auto_increment primary key,
    name_customer varchar(255) not null,
    dob_customer date not null,
    phone varchar(20) not null,
    address_customer varchar(255) not null,
    email varchar(255) unique not null
);

create table orders (
    id int auto_increment primary key,
    payment_method varchar(50) not null,
    customer_id int not null,
    employee_id int not null,
    order_date date not null,
    delivery_date date,
    delivery_address varchar(255) not null,
    foreign key (customer_id) references customers(id),
    foreign key (employee_id) references employees(id)
);

create table order_details (
    id int auto_increment primary key,
    order_id int not null,
    product_id int not null,
    quantity int not null,
    price decimal(10, 2) not null, 
    foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id)
);
insert into products (name, price, discount_rate, stock_quantity) values
('Laptop A', 1500.00, 10.0, 50),
('Smartphone B', 800.00, 5.0, 100),
('Headphone C', 120.00, 15.0, 200),
('Smartwatch D', 250.00, 20.0, 75),
('Tablet E', 400.00, 8.0, 90),
('Keyboard F', 60.00, 12.0, 300),
('Monitor G', 220.00, 18.0, 120),
('Printer H', 350.00, 7.0, 60),
('Router I', 80.00, 10.0, 150),
('Mouse J', 40.00, 5.0, 500);
insert into employees (name_employee, dob_employee, address_employee) values
('John Doe', '1985-03-15', '123 Elm Street'),
('Jane Smith', '1990-07-21', '456 Oak Avenue'),
('Robert Brown', '1982-11-05', '789 Pine Lane'),
('Emily Davis', '1995-06-10', '321 Maple Drive'),
('Michael Wilson', '1988-09-12', '654 Birch Road'),
('Jessica Johnson', '1992-02-25', '876 Cedar Court'),
('Daniel Lee', '1983-08-30', '234 Spruce Street'),
('Laura Clark', '1991-12-01', '567 Fir Boulevard'),
('James Allen', '1986-04-18', '789 Willow Way'),
('Sarah White', '1993-05-22', '890 Poplar Path');
insert into customers (name_customer, dob_customer, phone, address_customer, email) values
('Alice Green', '1990-01-15', '0123456789', '111 River Road', 'alice.green@example.com'),
('Bob Taylor', '1987-03-20', '0987654321', '222 Lake Street', 'bob.taylor@example.com'),
('Catherine Hill', '1995-07-30', '0112233445', '333 Mountain Lane', 'catherine.hill@example.com'),
('David King', '1983-05-12', '0556677889', '444 Valley Avenue', 'david.king@example.com'),
('Eleanor Moore', '1991-09-08', '0887766554', '555 Forest Drive', 'eleanor.moore@example.com'),
('Frank Harris', '1989-02-24', '0665544332', '666 Meadow Road', 'frank.harris@example.com'),
('Grace Adams', '1994-06-18', '0778899001', '777 Orchard Street', 'grace.adams@example.com'),
('Henry Baker', '1986-10-10', '0998877665', '888 Hilltop Boulevard', 'henry.baker@example.com'),
('Irene Scott', '1992-03-05', '0334455667', '999 Plainview Path', 'irene.scott@example.com'),
('Jack Young', '1985-12-25', '0223344556', '101 Sunrise Lane', 'jack.young@example.com');
insert into orders (payment_method, customer_id, employee_id, order_date, delivery_date, delivery_address) values
('Credit Card', 1, 1, '2025-01-01', '2025-01-05', '111 River Road'),
('PayPal', 2, 2, '2025-01-02', '2025-01-06', '222 Lake Street'),
('Cash', 3, 3, '2025-01-03', '2025-01-07', '333 Mountain Lane'),
('Credit Card', 4, 4, '2025-01-04', '2025-01-08', '444 Valley Avenue'),
('Bank Transfer', 5, 5, '2025-01-05', '2025-01-09', '555 Forest Drive'),
('Credit Card', 6, 6, '2025-01-06', '2025-01-10', '666 Meadow Road'),
('PayPal', 7, 7, '2025-01-07', '2025-01-11', '777 Orchard Street'),
('Cash', 8, 8, '2025-01-08', '2025-01-12', '888 Hilltop Boulevard'),
('Credit Card', 9, 9, '2025-01-09', '2025-01-13', '999 Plainview Path'),
('Bank Transfer', 10, 10, '2025-01-10', '2025-01-14', '101 Sunrise Lane');
insert into order_details (order_id, product_id, quantity, price) values
(1, 1, 2, 1500.00),
(2, 2, 1, 800.00),
(3, 3, 4, 120.00),
(4, 4, 1, 250.00),
(5, 5, 3, 400.00),
(6, 6, 5, 60.00),
(7, 7, 2, 220.00),
(8, 8, 1, 350.00),
(9, 9, 2, 80.00),
(10, 10, 10, 40.00);

