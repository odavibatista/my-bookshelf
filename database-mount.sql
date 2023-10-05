DROP DATABASE my_bookshelf_test;

-- Database creation
CREATE DATABASE my_bookshelf_test;

-- Using the database
USE my_bookshelf_test;

-- Genres table creation
CREATE TABLE genres (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(30) NOT NULL
);

-- Genres registering
INSERT INTO genres (genre_name) VALUES
    ("Romance"),
    ("Ficção"),
    ("Técnico");

-- User table creation
CREATE TABLE users	(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL,
    email VARCHAR(200) UNIQUE NOT NULL,
    age INTEGER NOT NULL,
    gender VARCHAR(9) NOT NULL,
    user_password VARCHAR(30) NOT NULL,
    favorite_gender INTEGER NOT NULL, FOREIGN KEY (id) REFERENCES genres(id),
    second_favorite_gender INTEGER NOT NULL, FOREIGN KEY (id) REFERENCES genres(id)
);

-- Admin user register
INSERT INTO users (
    first_name, 
    last_name, 
    email, 
    age, 
    gender, 
    user_password,
    favorite_gender,
    second_favorite_gender
) 
VALUES (
    "admin",
    "",
    "admin",
    21,
    "Masculino",
    "admin",
    1,
    2
);
