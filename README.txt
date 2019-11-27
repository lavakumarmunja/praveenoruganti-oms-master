------------------------ ORDER MANAGEMENT SYSTEM SpringBoot Application---------------------------------

We need to implement the below services for  Order Management System

A. Implement customer service

1. Get customers - return all the customer details in the table
http://localhost:6070/customerservice/customers
2. Create a customer by sending the customer details
http://localhost:6070/customerservice/customers
a. when a create customer method is invoked. Insert the details in customer table 
and publish "CustomerCreated" event along with customer details.
b. sales order service has to subscribe to "CustomerCreated" event 

Table- Customer(id,email,first_name,last_name,creation_date)

B. Implement item service

1. Get items - return all the items details in the table
http://localhost:6072/itemservice/items
2. Get item detail if item name is sent as a parameter
http://localhost:6072/itemservice/items/{itemname}

Table- Item(id,item_name,description,price,creationdate)

C. Implement Sales Order service

1. Sales order customer- event subscription
a. When a "Customer Created" event is published, sales order service needs to 
subscribe to it. Fetch the customer details(customer id,email,first_name,last_name) 
and insert into the local customer table

Table-Customer_SOS(cust_id,cust_first_name,cust_last_name,cust_email)

2. Create Order- create an order and return an order id
http://localhost:6071/salesorderservice/orders
Input: Order Description, Order Date, customer id, list of item names
Output: Order Id
a. validate customer by verifying the table "customer_sos" with cust_id
b. validate the items by calling item service with item name
http://localhost:6072/itemservice/items/{itemname}
c. create order by inserting the order details in  order table and items 
for the order details in order_line_item table

Table-
1. sales_order(id,order_date,cust_id,order_desc,total_price)
2. order_line_item(id,item_name,item_quantity,order_id)

  
How to install RabbitMQ in your local ?
1. Download supporting ERLANG component from here  and install.
2. Download Rabbit MQ from here and install
3. Enable management plugin using below command
C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.17\sbin  > rabbitmq-plugins enable rabbitmq_management
4. Login into Rabbit MQ browser using URL http://localhost:15672 using userid: guest and password: guest.
5. Follow the above steps mentioned for PCF service RabbitMQ and create Queue named CustomerCreatedMQ and Exchange named CustomerCreatedExchange.


How to install MYSQL DB in your local?
Download from https://dev.mysql.com/downloads/file/?id=489911 and proceed with default installation

Here with the database creation and queries for all 3 services.

customer service:

create database omscustomerdb;
use omscustomerdb;
create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
create table customer (id bigint not null, creation_date varchar(20) not null, email varchar(50) not null, first_name varchar(50) not null, last_name varchar(50) not null, primary key (id)) engine=MyISAM;

item service:

create database omsitemdb;
use omsitemdb;
create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
create table item (id bigint not null, creation_date varchar(20) not null, description varchar(100) not null, item_name varchar(50) not null, price double precision, primary key (id)) engine=MyISAM;

salesorder service:

create database omssalesorderdb;
use omssalesorderdb;
create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
create table customer_sos (cust_id bigint not null, cust_creation_date varchar(20) not null, email varchar(50) not null, cust_first_name varchar(50) not null, cust_last_name varchar(50) not null, primary key (cust_id)) engine=MyISAM;
create table order_line_item (id bigint not null, item_name varchar(50) not null, item_quantity double precision, order_id bigint, primary key (id)) engine=MyISAM;
create table sales_order (id bigint not null, cust_id bigint, order_date varchar(20) not null, order_desc varchar(100) not null, total_price double precision, primary key (id)) engine=MyISAM;



Select Queries:

select * from omscustomerdb.customer;
select * from omsitemdb.item;
select * from omssalesorderdb.customer_sos;
select * from omssalesorderdb.sales_order;
select * from omssalesorderdb.order_line_item;


if you like my group you can provide your funds and for more details you can check my repo.

https://github.com/praveenoruganti/praveenoruganti-repo-funding
