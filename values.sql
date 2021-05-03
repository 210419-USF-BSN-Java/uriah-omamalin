-- users

insert into shop.users (user_type) values (2); insert into shop.managers (id, first_name, last_name) values (1, 'Chantal', 'Dyte');
insert into shop.users (user_type) values (0); insert into shop.customers (id, first_name, last_name) values (2, 'Clair', 'McGuiness');
insert into shop.users (user_type) values (2); insert into shop.managers (id, first_name, last_name) values (3, 'Garreth', 'Beedie');
insert into shop.users (user_type) values (0); insert into shop.customers (id, first_name, last_name) values (4, 'Vitoria', 'Beckson');
insert into shop.users (user_type) values (1); insert into shop.employees (id, first_name, last_name) values (5, 'Virgie', 'Vevers');
insert into shop.users (user_type) values (0); insert into shop.customers (id, first_name, last_name) values (6, 'Sherye', 'Matula');
insert into shop.users (user_type) values (1); insert into shop.employees (id, first_name, last_name) values (7, 'Elisha', 'Jankovic');
insert into shop.users (user_type) values (0); insert into shop.customers (id, first_name, last_name) values (8, 'Craig', 'Clinkard');
insert into shop.users (user_type) values (1); insert into shop.employees (id, first_name, last_name) values (9, 'Kari', 'Marchment');
insert into shop.users (user_type) values (0); insert into shop.customers (id, first_name, last_name) values (10, 'Alyosha', 'Aim');

-- credentials

insert into shop.credentials (id, user_pass) values (1, 'vDulUhPn1W');
insert into shop.credentials (id, user_pass) values (2, 'customer');
insert into shop.credentials (id, user_pass) values (3, '8BcBUmz');
insert into shop.credentials (id, user_pass) values (4, 'customer');
insert into shop.credentials (id, user_pass) values (5, 'employee');
insert into shop.credentials (id, user_pass) values (6, 'dYWkJiMHv0');
insert into shop.credentials (id, user_pass) values (7, 'DO3GOC');
insert into shop.credentials (id, user_pass) values (8, 'MbO4JGQY');
insert into shop.credentials (id, user_pass) values (9, 'p4wDQgUX');
insert into shop.credentials (id, user_pass) values (10, 'DJkNpy');

-- items

insert into shop.items (item_name, price, status, owner_id) values ('Slippery', 89.89, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Bubbly', 60.23, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Scented', 71.04, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Fancy', 19.97, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Plain', 47.58, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Liquid', 89.38, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Big', 81.55, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Tasty', 38.03, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Shampoo', 37.59, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Body', 93.91, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Soft', 67.5, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Small', 67.78, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Dish', 92.83, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Triangle', 44.28, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Small', 98.32, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Hand', 77.94, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Default', 16.63, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Bar', 25.41, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Used', 15.51, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('Complimentary', 73.44, 0, null);

-- offers

INSERT INTO shop.offers (customer_id, item_id, amount, status, date_time) VALUES(2, 1, 90.00, 0, '2021-05-02 18:50:51.000');
INSERT INTO shop.offers (customer_id, item_id, amount, status, date_time) VALUES(2, 2, 70.00, 0, '2021-05-02 18:50:56.000');
INSERT INTO shop.offers (customer_id, item_id, amount, status, date_time) VALUES(2, 3, 50.00, 0, '2021-05-02 18:51:00.000');
INSERT INTO shop.offers (customer_id, item_id, amount, status, date_time) VALUES(4, 1, 22.00, 0, '2021-05-02 18:52:33.000');
INSERT INTO shop.offers (customer_id, item_id, amount, status, date_time) VALUES(4, 2, 90.05, 0, '2021-05-02 18:52:58.000');
INSERT INTO shop.offers (customer_id, item_id, amount, status, date_time) VALUES(4, 3, 55.97, 0, '2021-05-02 18:53:05.000');


