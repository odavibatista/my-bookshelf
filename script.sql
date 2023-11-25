USE defaultdb;

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
);
