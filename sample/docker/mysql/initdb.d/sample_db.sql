CREATE DATABASE sample_db;
CREATE TABLE users (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO users(id, name, email) VALUES(1, 'ishii', 'ishii@ishii.tech');