INSERT INTO account (id, email, enable, login_id, password, username) VALUES  (1, 'admin@spring.com', 1, 'admin', 'admin1!', 'admin user');

INSERT INTO role (id, description, enable, name) VALUES  (1, NULL, 1, 'ADMIN'),   (2, NULL, 1, 'GUEST');

INSERT INTO account_roles (account_id, roles_id) VALUES (1, 1);