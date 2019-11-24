------------------------ ORDER MANAGEMENT SYSTEM SpringBoot Application---------------------------------

1. Implement the core services Customer and Item
2. Implement the composite service sales order
3. Ensure to have implemented the following components.
   a. Eureka - Service Registry and Discovery
   b. Ribbon- Client side load balancing 
   c. Fault tolerance- Hystrix Circuit Breaker
   d. Centralized Configuration - Spring Config Server
   e. Asynchronous processing - Rabbit MQ
   
   
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

