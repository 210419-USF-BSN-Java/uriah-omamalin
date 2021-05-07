create schema ers;

CREATE TABLE ers.reimbursement (
	reimb_id serial NOT NULL,
	reimb_amount numeric(19,4) NOT NULL,
	reimb_submitted timestamp(0) NOT NULL,
	reimb_resolved timestamp(0) NULL,
	reimb_description varchar(250) NULL,
	reimb_receipt bytea NULL,
	reimb_author int4 NOT NULL,
	reimb_resolver int4 NULL,
	reimb_status_id int2 NOT NULL,
	reimb_type_id int2 NOT NULL,
	CONSTRAINT reimbursement_pk PRIMARY KEY (reimb_id)
);

CREATE TABLE ers.users (
	ers_users_id serial NOT NULL,
	ers_username varchar(50) NOT NULL UNIQUE,
	ers_password varchar(50) NOT NULL,
	user_first_name varchar(100) NULL,
	user_last_name varchar(100) NULL,
	user_email varchar(150) NOT NULL UNIQUE,
	user_role_id int2 NOT NULL,
	CONSTRAINT users_pk PRIMARY KEY (ers_users_id)
);

CREATE TABLE ers.reimbursement_status (
	reimb_status_id int2 NOT NULL,
	reimb_status varchar(10) NOT NULL,
	CONSTRAINT reimbursement_status_pk PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers.reimbursement_type (
	reimb_type_id int2 NOT NULL,
	reimb_type varchar(10) NOT NULL,
	CONSTRAINT reimbursement_type_pk PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers.user_roles (
	ers_user_role_id int2 NOT NULL,
	user_role varchar(10) NOT NULL,
	CONSTRAINT user_roles_pk PRIMARY KEY (ers_user_role_id)
);

ALTER TABLE ers.reimbursement ADD CONSTRAINT reimbursement_fk FOREIGN KEY (reimb_author) REFERENCES ers.users(ers_users_id) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE ers.reimbursement ADD CONSTRAINT reimbursement_fk_1 FOREIGN KEY (reimb_resolver) REFERENCES ers.users(ers_users_id) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE ers.reimbursement ADD CONSTRAINT reimbursement_fk_2 FOREIGN KEY (reimb_status_id) REFERENCES ers.reimbursement_status(reimb_status_id) ON DELETE SET NULL ON UPDATE CASCADE;
ALTER TABLE ers.reimbursement ADD CONSTRAINT reimbursement_fk_3 FOREIGN KEY (reimb_type_id) REFERENCES ers.reimbursement_type(reimb_type_id) ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE ers.users ADD CONSTRAINT users_fk FOREIGN KEY (user_role_id) REFERENCES ers.user_roles(ers_user_role_id) ON DELETE SET NULL ON UPDATE CASCADE;
