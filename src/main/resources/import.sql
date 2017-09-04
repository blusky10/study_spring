INSERT INTO account (loing_id, email, enable, password, username) VALUES ('admin', 'admin@test.com', b'1', 'admin1!', 'admin');
INSERT INTO role (id, description, enable, name) VALUES (1, NULL, b'1', 'CLIENT');
INSERT INTO account_roles (account_loing_id, roles_id) VALUES ('admin', 1);