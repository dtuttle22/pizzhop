DROP TABLE IF EXISTS ingredients_pizzas;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS ingredients;

CREATE TABLE ingredients (
	id bigint auto_increment PRIMARY KEY,
	name VARCHAR(40)	
);

CREATE TABLE pizzas (
	id bigint auto_increment PRIMARY key,
	name VARCHAR(40)
);

CREATE TABLE ingredients_pizzas(
	pizza_id bigint,
	ingredient_id bigint,
	PRIMARY KEY(pizza_id,ingredient_id),
	FOREIGN KEY (pizza_id)
		REFERENCES pizzas (id),
	FOREIGN KEY (ingredient_id)
		REFERENCES ingredients (id)
);