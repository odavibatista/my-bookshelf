CREATE DATABASE db;
USE db;

-- Genres table creation
CREATE TABLE genres (
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(30) NOT NULL
);

-- Users table creation
CREATE TABLE users	(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    age INTEGER NOT NULL,
    gender VARCHAR(9) NOT NULL,
    user_password VARCHAR(30) NOT NULL,
    favorite_gender INTEGER NOT NULL, FOREIGN KEY (favorite_gender) REFERENCES genres(id),
    second_favorite_gender INTEGER NOT NULL, FOREIGN KEY (second_favorite_gender) REFERENCES genres(id),
    super_user BOOLEAN NOT NULL DEFAULT (FALSE)
);


-- Books table creation
CREATE TABLE books(
	id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    genre_id INTEGER NOT NULL,
	FOREIGN KEY (genre_id) REFERENCES genres (id)
);

-- Ratings table creation
CREATE TABLE ratings(
    id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    rating INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (book_id) REFERENCES books (id)
);
-- Genres registering
INSERT INTO genres (genre_name) VALUES
    ('Romance'),
    ('Ficção'),
    ('Técnico'),
    ('História'),
    ('Filosofia');
    
-- Admin user register
INSERT INTO users (
    first_name, 
    last_name, 
    email, 
    age, 
    gender, 
    user_password,
    favorite_gender,
    second_favorite_gender,
    super_user
) 
VALUES (
    'admin',
    '',
    'admin',
    21,
    'Masculino',
    'admin',
    1,
    2,
    1
),
(
'João', 
'Silva', 
'joão@email.com', 
45, 
'Masculino',
'1234',
2, 
4, 
0
)
;

INSERT INTO books (title, author, genre_id)
VALUES 
("O Antropoteísmo - A Religião do Homem", "Orlando Fedeli", 1), 
("História dos Estados Unidos - sem mitos", "Marcelo Andrade", 4),
("Sob a Máscara - As Polêmicas de Orlando Fedeli e Fernando Schlithler contra Olavo de Carvalho", "Fernando Schlithler", 5),
("O Marxismo Exposto", "Marcelo Andrade", 4),
("Segunda Guerra Mundial - uma guerra contra os povos", "Marcelo Andrade", 4),
("Lutero", "Frantz Funck-Brentano", 4),
("A Metafísica da Gastronomia - Santo Tomás de Aquino à Mesa", "Marcelo Andrade", 5),
("Conversas à Mesa", "Martinho Lutero", 4),
("Televisão - um 'fast-food' envenenado para a alma", "Marcelo Andrade", 3),
("1822 - a Separação do Brasil", "Marcelo Andrade", 4),
("Impérios Coloniais", "Marcelo Andrade", 4),
("Monsieur de Charette - O Rei da Vendeia", "Georges Lenotre", 4),
("Nos Labirintos de Eco - um guia de leitura para 'O Nome da Rosa'", "Orlando Fedeli", 1),
("Elementos Esotéricos e Cabalísticos nas Visões de Anna Katharina Emmerick", "Orlando Fedeli", 3);

INSERT INTO ratings (user_id, book_id, rating)
VALUES
(1, 6, 10),
(1, 4, 10),
(1, 13, 6),
(1, 3, 7),
(2, 9, 8),
(2, 4, 10),
(2, 13, 9),
(2, 3, 8);
