CREATE DATABASE hamburgers;
USE hamburgers;
CREATE TABLE products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  price DECIMAL(8, 2),
  stock INT
);
INSERT INTO products (name, price, stock)
VALUES
  ('Classic Burger', 5.99, 100),
  ('Cheeseburger', 6.99, 80),
  ('Bacon Burger', 7.99, 60),
  ('Vegetarian Burger', 6.49, 70),
  ('Chicken Burger', 6.99, 90),
  ('French Fries', 2.99, 150),
  ('Onion Rings', 3.49, 120),
  ('Soda', 1.99, 200),
  ('Mineral Water', 1.49, 100),
  ('House Dessert', 4.99, 40);
  
  SELECT *
  FROM products p
  WHERE p.name='Soda'
  ;
  
  SELECT * FROM products;