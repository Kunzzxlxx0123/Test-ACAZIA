CREATE DATABASE test-acazia;

CREATE TABLE categories(
	name varchar(255) NOT NULL,
	tag varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY(tag)
);

CREATE TABLE products(
	name varchar(255) NOT NULL,
	category_tag varchar(255) NOT NUll,
	FOREIGN KEY (category_tag) REFERENCES categories(tag)
);

INSERT INTO categories(name, tag) 
VALUES	('may tinh', 'mt'),
		('dien lanh', 'dl');
		
INSERT INTO products(name, category_tag)
VALUES	('tulanh e', 'dl'),
		('dieu hoa nhiet do b', 'dl'),
		('ultrabook EZ', 'mt'),
		('pc 2', 'mt'),
		('laptop X', 'mt'),
		('may tinh xach tay A', 'mt');
		
SELECT * FROM categories;
SELECT * FROM products;
SELECT * FROM products WHERE products.category_tag = 'dl' ORDER BY products.name ASC; 
