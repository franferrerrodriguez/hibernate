/*--------------------------------------*/
/*--------------- SCHEMA ---------------*/
/*--------------------------------------*/

DROP DATABASE IF EXISTS USERS_DB;
CREATE DATABASE IF NOT EXISTS USERS_DB DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE USERS_DB;

DROP TABLE IF EXISTS USERS;
CREATE TABLE IF NOT EXISTS USERS(
     id INT PRIMARY KEY,
     username VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     password VARCHAR(255) NOT NULL
)ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO USERS(id, username, email, password) VALUES (1, 'franferrerrodriguez', 'franferrerrodriguez@gmail.com', '123456');
INSERT INTO USERS(id, username, email, password) VALUES (2, 'alexferrerrodriguez', 'alexferrerrodriguez@gmail.com', '1234');