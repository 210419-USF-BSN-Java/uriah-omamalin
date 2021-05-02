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

insert into shop.items (item_name, price, status, owner_id) values ('pede', 89.89, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('consequat', 60.23, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('in', 71.04, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('pellentesque', 19.97, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('ante', 47.58, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('tristique', 89.38, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('ipsum', 81.55, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('in', 38.03, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('ligula', 37.59, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('ut', 93.91, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('orci', 67.5, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('luctus', 67.78, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('nulla', 92.83, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('congue', 44.28, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('nam', 98.32, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('in', 77.94, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('velit', 16.63, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('lorem', 25.41, 1, 2);
insert into shop.items (item_name, price, status, owner_id) values ('quam', 15.51, 0, null);
insert into shop.items (item_name, price, status, owner_id) values ('duis', 73.44, 0, null);