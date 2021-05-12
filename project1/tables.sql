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
	user_first_name varchar(100) NOT NULL,
	user_last_name varchar(100) NOT NULL,
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

INSERT INTO ers.reimbursement_status (reimb_status_id, reimb_status) VALUES(1, 'PENDING');
INSERT INTO ers.reimbursement_status (reimb_status_id, reimb_status) VALUES(2, 'APPROVED');
INSERT INTO ers.reimbursement_status (reimb_status_id, reimb_status) VALUES(3, 'DENIED');

INSERT INTO ers.reimbursement_type (reimb_type_id, reimb_type) VALUES(1, 'LODGING');
INSERT INTO ers.reimbursement_type (reimb_type_id, reimb_type) VALUES(2, 'TRAVEL');
INSERT INTO ers.reimbursement_type (reimb_type_id, reimb_type) VALUES(3, 'FOOD');
INSERT INTO ers.reimbursement_type (reimb_type_id, reimb_type) VALUES(4, 'OTHER');

INSERT INTO ers.user_roles (ers_user_role_id, user_role) VALUES(1, 'EMPLOYEE');
INSERT INTO ers.user_roles (ers_user_role_id, user_role) VALUES(2, 'MANAGER');

insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('sbesant0', 'DOFPnfAghU', 'Shanna', 'Besant', 'sbesant0@de.vu', 1);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('nselway1', '3wyVd44U5Io', 'Nadia', 'Selway', 'nselway1@oaic.gov.au', 1);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('srapley2', 'DL5jXRtLReX', 'Sabra', 'Rapley', 'srapley2@berkeley.edu', 1);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('rwilleson3', 'aMyaLbaS', 'Ruthann', 'Willeson', 'rwilleson3@house.gov', 1);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('efontaine4', 'cOmpNUwGF', 'Euphemia', 'Fontaine', 'efontaine4@utexas.edu', 1);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('pleven5', 'QkUrH6vB', 'Petey', 'Leven', 'pleven5@reddit.com', 1);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('mspalton6', 'jKzZB6mAt', 'Marcie', 'Spalton', 'mspalton6@rediff.com', 2);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('ksmeed7', 'KD1efe8Crnw', 'Kathryn', 'Smeed', 'ksmeed7@webs.com', 2);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('fhuckleby8', 'j4GTNx', 'Fredrika', 'Huckleby', 'fhuckleby8@google.es', 1);
insert into ers.users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id) values ('mmarle9', 'aoH9buIb', 'Maurice', 'Marle', 'mmarle9@yale.edu', 1);

INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(2572.9100, '2020-12-30 07:49:00.000', '2021-01-05 06:40:26.000', 'volutpat dui maecenas tristique est et tempus semper est quam pharetra magna', NULL, 3, 7, 3, 2);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(7420.0500, '2020-12-06 06:05:03.000', NULL, 'ligula pellentesque ultrices phasellus id sapien in sapien iaculis congue vivamus metus arcu adipiscing molestie hendrerit', NULL, 5, NULL, 1, 4);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(7589.9800, '2020-12-08 10:02:38.000', '2021-01-09 17:39:16.000', NULL, NULL, 10, 7, 3, 2);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(3588.9500, '2020-12-13 22:18:01.000', '2021-01-06 20:31:08.000', 'elementum nullam varius nulla facilisi cras non velit nec nisi vulputate nonummy maecenas tincidunt lacus at', NULL, 6, 8, 2, 2);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(6940.0000, '2020-12-19 19:51:06.000', '2021-01-30 04:24:32.000', 'felis ut at dolor quis odio consequat varius integer ac leo pellentesque', NULL, 1, 7, 3, 1);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(1888.7900, '2020-12-02 05:34:17.000', '2021-01-27 06:49:47.000', 'magna ac consequat metus sapien ut nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere', NULL, 6, 8, 2, 3);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(5125.3600, '2020-12-26 14:59:48.000', '2021-01-27 18:27:00.000', NULL, NULL, 2, 7, 3, 1);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(2082.0400, '2020-12-06 10:27:51.000', '2021-01-09 10:47:46.000', 'lobortis ligula sit amet eleifend pede libero quis orci nullam', NULL, 10, 8, 2, 4);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(2533.6400, '2020-12-29 13:41:37.000', NULL, 'ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam erat volutpat in congue etiam', NULL, 4, NULL, 1, 4);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(4525.5400, '2020-12-25 20:58:10.000', NULL, NULL, NULL, 9, NULL, 1, 3);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(4926.4100, '2020-12-21 11:47:41.000', NULL, 'diam id ornare imperdiet sapien urna pretium nisl ut volutpat sapien arcu sed augue aliquam', NULL, 6, NULL, 1, 3);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(8051.2000, '2020-12-15 19:51:10.000', '2021-01-03 23:40:04.000', 'est risus auctor sed tristique in tempus sit amet sem fusce consequat nulla nisl', NULL, 1, 8, 2, 3);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(1440.9500, '2020-12-07 08:18:58.000', '2021-01-21 10:41:09.000', 'in eleifend quam a odio in hac habitasse platea dictumst maecenas ut massa quis augue luctus tincidunt nulla mollis molestie', NULL, 9, 7, 2, 3);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(2143.2400, '2020-12-18 10:19:39.000', '2021-01-09 07:47:57.000', 'ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae', NULL, 6, 8, 3, 3);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(4295.1200, '2020-12-15 02:46:32.000', NULL, 'luctus nec molestie sed justo pellentesque viverra pede ac diam cras pellentesque volutpat', NULL, 2, NULL, 1, 2);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(2784.1100, '2020-12-03 05:21:43.000', NULL, NULL, NULL, 6, NULL, 1, 4);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(7976.3800, '2020-12-28 05:52:57.000', NULL, 'in quam fringilla rhoncus mauris enim leo rhoncus sed vestibulum sit amet', NULL, 9, NULL, 1, 2);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(9329.6000, '2020-12-18 15:21:29.000', NULL, NULL, NULL, 5, NULL, 1, 4);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(3631.8600, '2020-12-30 13:20:46.000', NULL, 'fusce posuere felis sed lacus morbi sem mauris laoreet ut rhoncus aliquet pulvinar sed', NULL, 6, NULL, 1, 3);
INSERT INTO ers.reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id) VALUES(8960.1800, '2020-12-25 12:01:30.000', '2021-01-29 16:41:28.000', 'amet consectetuer adipiscing elit proin interdum mauris non ligula pellentesque ultrices phasellus id sapien in sapien', NULL, 3, 7, 3, 2);