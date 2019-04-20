/*--------------------------------------*/
/*--------------- SCHEMA ---------------*/
/*--------------------------------------*/

/*-----------------*/
/*----- USERS -----*/
/*-----------------*/
DROP DATABASE IF EXISTS DB_USERS;
CREATE DATABASE IF NOT EXISTS DB_USERS DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE DB_USERS;

DROP TABLE IF EXISTS USERS;
CREATE TABLE IF NOT EXISTS USERS(
     id INT PRIMARY KEY,
     username VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     password VARCHAR(255) NOT NULL
)ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO USERS(id, username, email, password) VALUES (1, 'franferrerrodriguez', 'franferrerrodriguez@gmail.com', '123456');
INSERT INTO USERS(id, username, email, password) VALUES (2, 'alexferrerrodriguez', 'alexferrerrodriguez@gmail.com', '1234');

SELECT * FROM USERS;

/*-----------------*/
/*---- CLIENTS ----*/
/*-----------------*/
DROP DATABASE IF EXISTS DB_CLIENTS;
CREATE DATABASE IF NOT EXISTS DB_CLIENTS DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE DB_CLIENTS;

DROP TABLE IF EXISTS CLIENTS;
CREATE TABLE IF NOT EXISTS CLIENTS(
     id INT PRIMARY KEY,
     firstname VARCHAR(255) NOT NULL,
     lastname VARCHAR(255) NOT NULL,
     nifnie VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     country VARCHAR(255) NOT NULL
)ENGINE=INNODB CHARACTER SET utf8 COLLATE utf8_general_ci;

INSERT INTO CLIENTS(id, firstname, lastname, nifnie, email, country) VALUES (1, 'Jesús', 'Ferrer Tortosa', '58384737J', 'jft@gmail.com', 'Spain');
INSERT INTO CLIENTS(id, firstname, lastname, nifnie, email, country) VALUES (2, 'María', 'García Belmonte', '86394345X', 'mgb@gmail.com', 'Spain');

SELECT * FROM CLIENTS;