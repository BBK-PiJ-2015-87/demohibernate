CREATE TABLE users(id INT PRIMARY KEY NOT NULL, username TEXT NOT NULL, email TEXT NOT NULL, password TEXT NOT NULL);

CREATE SEQUENCE users_id_seq start 1 increment 1;

CREATE INDEX email_index ON users (email);

INSERT INTO users VALUES (nextval('users_id_seq'), 'user1', 'user1@email.com', 'pass1');
INSERT INTO users VALUES (nextval('users_id_seq'), 'user2', 'user2@email.com', 'pass2');
INSERT INTO users VALUES (nextval('users_id_seq'), 'user3', 'user3@email.com', 'pass3');

DELETE FROM users WHERE id=7;

