CREATE TABLE customer
(
	id SERIAL PRIMARY KEY,
	surname varchar(30) NOT NULL,
	home varchar(50) NOT NULL,
	discount INTEGER CHECK (discount >= 0 AND discount <=100)
);


CREATE TABLE shop
(
	id SERIAL PRIMARY KEY,
	name varchar(30) NOT NULL,
	area varchar(50) NOT NULL,
	commissary INTEGER CHECK (commissary >= 0 AND commissary <=100)
);


CREATE TABLE books
(
	id SERIAL PRIMARY KEY,
	name varchar(30) NOT NULL,
	price INTEGER NOT NULL,
	stock varchar(50) NOT NULL,
	count INTEGER CHECK (count >= 0)
);


CREATE TABLE buy
(
	id SERIAL PRIMARY KEY,
	date TIMESTAMP NOT NULL,
	shop_id INTEGER REFERENCES shop(id),
	customer_id INTEGER REFERENCES customer(id),
	book_id INTEGER REFERENCES books(id),
	quanity INTEGER,
	price INTEGER NOT NULL CHECK(price > 0)
);