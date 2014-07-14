INSERT INTO user (id, email, password) VALUES (1, 'user', 'user');
INSERT INTO role (id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO user_roles VALUES (1, 1);