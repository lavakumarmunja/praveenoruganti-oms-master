------------------------ ITEM SERVICE---------------------------------

1. Get items - return all the items details in the table
http://localhost:6072/itemservice/items
2. Get item detail if item name is sent as a parameter
http://localhost:6072/itemservice/items/{itemname}

Table- Item(id,item_name,description,price,creationdate)



create database omsitemdb
Hibernate: create table hibernate_sequence (next_val bigint) engine=MyISAM
Hibernate: insert into hibernate_sequence values ( 1 )
Hibernate: create table item (id bigint not null, creation_date varchar(20) not null, description varchar(100) not null, item_name varchar(50) not null, price double precision, primary key (id)) engine=MyISAM