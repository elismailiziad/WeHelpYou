

-- Drop the tables if they exist

DROP TABLE IF EXISTS INVOICE;
DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS ITEM;
DROP TABLE IF EXISTS MANAGER;
DROP TABLE IF EXISTS CASHIER;
DROP TABLE IF EXISTS LOG_REGISTER;
DROP TABLE IF EXISTS SUPPLIER;
DROP TABLE IF EXISTS AOUINATI_STORE;

-- Create MANAGER table

CREATE TABLE MANAGER (
 user_ID    smallint PRIMARY KEY,
 user_password          varchar(100) not null,
 user_fname varchar(100) not null,
 user_lname varchar(100) not null,
 user_email varchar(100) not null,
 user_phone varchar(100) not null
);

-- Create CASHIER table

CREATE TABLE CASHIER (
 user_ID    smallint PRIMARY KEY,
 user_password          varchar(100) not null,
 user_fname varchar(100) not null,
 user_lname varchar(100) not null,
 user_email varchar(100) not null,
 user_phone varchar(100) not null,
 salary smallint NOT null
);

-- Create LOG_REGISTER table

CREATE TABLE LOG_REGISTER(
	in_time varchar(100),
	out_time varchar(100),
	working_hours smallint,
	_date date
);

-- Create CUSTOMER table

CREATE TABLE CUSTOMER (
 cus_ID    smallint PRIMARY KEY,
 cus_fname varchar(100) not null,
 cus_lname varchar(100) not null,
 cus_city varchar(100) not null,
 cus_address varchar(100) not null,
 cus_discount varchar(100) not null
);

-- Create SUPPLIER table

CREATE TABLE SUPPLIER (
 supplier_ID    smallint PRIMARY KEY,
 supplier_name varchar(100) not null,
 supplier_city varchar(100) not null,
 supplier_phone varchar(100) not null,
 supplier_country varchar(100) not null,
 supplier_address varchar(100) not null
);

-- Create ITEM table

CREATE TABLE ITEM (
 item_code           varchar(100) PRIMARY KEY,
 description           varchar(100) not null,
 in_date                date not null,
 qoh        smallint not null,
 price                 decimal(10, 2),
 discount_rate          decimal(2, 2) not null DEFAULT 0.00,
 supplier_ID            int,
 CONSTRAINT supplies FOREIGN KEY (supplier_ID) REFERENCES SUPPLIER (supplier_ID) ON UPDATE CASCADE ON DELETE SET NULL
 );

-- Create INVOICE table

CREATE TABLE INVOICE (
 invoice_num smallint PRIMARY KEY,
 inv_date date not null,
	cus_id int,
 CONSTRAINT has FOREIGN KEY (cus_ID) REFERENCES CUSTOMER (cus_ID) ON UPDATE CASCADE ON DELETE CASCADE
 );

