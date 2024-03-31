CREATE DATABASE easybank;

USE easybank;

SELECT * FROM users;
SELECT * FROM authorities;
SELECT * FROM customer;

CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    enabled INT NOT NULL
);

CREATE TABLE authorities(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) NOT NULL,
    `authority` VARCHAR(45) NOT NULL
);

CREATE TABLE customer(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL,
    pwd VARCHAR(50) NOT NULL,
    `role` VARCHAR(45) NOT NULL
);

INSERT IGNORE INTO users VALUES(NULL, 'happy', '12345', '1');
INSERT IGNORE INTO authorities VALUES(NULL, 'happy', 'write');
INSERT INTO customer (email, pwd, `role`) VALUES('adnan@gmail.com', '12345@', 'admin');


