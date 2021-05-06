CREATE SCHEMA shop;

CREATE TABLE shop.users (
	id serial NOT NULL,
	user_type int2 CHECK (user_type >= 0 AND user_type <= 2) NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE shop.credentials (
	id int4 NOT NULL,
	user_pass char(64) NOT NULL,
	CONSTRAINT credentials_pk PRIMARY KEY (id)
);

CREATE TABLE shop.customers (
	id int4 NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	CONSTRAINT customers_pk PRIMARY KEY (id)
);

CREATE TABLE shop.employees (
	id int4 NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	CONSTRAINT employees_pk PRIMARY KEY (id)
);

CREATE TABLE shop.managers (
	id int4 NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	CONSTRAINT managers_pk PRIMARY KEY (id)
);

CREATE TABLE shop.items (
	id serial NOT NULL,
	item_name varchar(20) NOT NULL,
	price numeric(5,2) NOT NULL,
	status int2 NOT NULL DEFAULT 0,
	owner_id int4 NULL DEFAULT null,
	CONSTRAINT items_pk PRIMARY KEY (id),
	CONSTRAINT items_price_check CHECK ((price > (0)::numeric)),
	CONSTRAINT items_status_check CHECK (((status >= 0) AND (status <= 1)))
);

CREATE TABLE shop.offers (
	id serial NOT NULL,
	customer_id int4 NOT NULL,
	item_id int4 NOT NULL,
	amount numeric(5, 2) CHECK (amount > 0) NOT NULL,
	status int2 CHECK (status >= 0 AND status <= 2) NOT NULL,
	date_time timestamp(0) NOT NULL,
	has_plan bool NULL,
	CONSTRAINT offers_pk PRIMARY KEY (id)
);

CREATE TABLE shop.payments (
	offer_id int4 NOT NULL,
	payment_plan int2 null default NULL,
	weekly_payment numeric(5,2) null default NULL,
	remaining_payments int2 null default null,
	CONSTRAINT payments_payment_plan_check CHECK (((payment_plan >= 0) AND (payment_plan <= 2))),
	CONSTRAINT payments_pk PRIMARY KEY (offer_id)
);

ALTER TABLE shop.credentials ADD CONSTRAINT credentials_fk FOREIGN KEY (id) REFERENCES shop.users(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE shop.customers ADD CONSTRAINT customers_fk FOREIGN KEY (id) REFERENCES shop.users(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE shop.employees ADD CONSTRAINT employees_fk FOREIGN KEY (id) REFERENCES shop.users(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE shop.items ADD CONSTRAINT items_fk FOREIGN KEY (owner_id) REFERENCES shop.customers(id) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE shop.managers ADD CONSTRAINT managers_fk FOREIGN KEY (id) REFERENCES shop.users(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE shop.offers ADD CONSTRAINT offers_fk FOREIGN KEY (customer_id) REFERENCES shop.customers(id) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE shop.offers ADD CONSTRAINT offers_fk_1 FOREIGN KEY (item_id) REFERENCES shop.items(id) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE shop.payments ADD CONSTRAINT payments_fk FOREIGN KEY (offer_id) REFERENCES shop.offers(id) ON DELETE CASCADE ON UPDATE CASCADE;