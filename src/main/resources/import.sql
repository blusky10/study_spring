INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (1, 'admin@spring.com', 1, 'admin', '{noop}admin1!', 'admin');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (2, 'user01@spring.com', 1, 'auser01', '{noop}user01!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (3, 'guest@spring.com', 1, 'guest', '{noop}guest!', 'guest');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (4, 'user02@spring.com', 1, 'buser02', '{noop}user02!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (5, 'user03@spring.com', 1, 'cuser03', '{noop}user03!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (6, 'user04@spring.com', 1, 'duser04', '{noop}user04!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (7, 'user05@spring.com', 1, 'euser05', '{noop}user05!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (8, 'user06@spring.com', 1, 'fuser06', '{noop}user06!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (9, 'user07@spring.com', 1, 'guser07', '{noop}user07!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (10, 'user08@spring.com', 1, 'huser08', '{noop}user08!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (11, 'user09@spring.com', 1, 'iuser09', '{noop}user09!', 'user');
INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (12, 'user10@spring.com', 1, 'juser10', '{noop}user10!', 'user');

INSERT INTO role (id, name, enable ) VALUES  (1, 'ADMIN', 1),  (2, 'USER', 1), (3, 'GUEST', 1);
--
-- INSERT INTO account_roles (account_id, roles_id) VALUES (1, 1);
-- INSERT INTO account_roles (account_id, roles_id) VALUES (1, 2);
-- INSERT INTO account_roles (account_id, roles_id) VALUES (2, 2);
-- INSERT INTO account_roles (account_id, roles_id) VALUES (3, 3);
