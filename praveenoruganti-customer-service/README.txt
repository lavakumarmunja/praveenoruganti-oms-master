------------------------ CUSTOMER SERVICE---------------------------------

1. Get customers - return all the customer details in the table
http://localhost:6070/customerservice/customers
2. Create a customer by sending the customer details
http://localhost:6070/customerservice/customers
a. when a create customer method is invoked. Insert the details in customer table 
and publish "CustomerCreated" event along with customer details.
b. sales order service has to subscribe to "CustomerCreated" event 

Table- Customer(id,email,first_name,last_name,creation_date)

omscustomerdb
Hibernate: create table customer (id bigint not null, creation_date varchar(20) not null, email varchar(50) not null, first_name varchar(50) not null, last_name varchar(50) not null, primary key (id)) engine=MyISAM
Hibernate: create table hibernate_sequence (next_val bigint) engine=MyISAM
Hibernate: insert into hibernate_sequence values ( 1 )