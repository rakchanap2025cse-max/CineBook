CREATE DATABASE cinebook_db;
USE cinebook_db;
CREATE TABLE bookings (
  booking_id VARCHAR(50) PRIMARY KEY,
  customer_name VARCHAR(100),
  movie_name VARCHAR(100) NOT NULL,
  theatre_name VARCHAR(100),
  seats VARCHAR(200) NOT NULL,
  total_price DOUBLE NOT NULL,
  booking_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE shows (
  show_id INT PRIMARY KEY AUTO_INCREMENT,
  movie_name VARCHAR(100),
  show_time VARCHAR(20)
);
INSERT INTO shows (movie_name, show_time) VALUES 
('Interstellar', '7:30 PM'),
('Avengers', '5:00 PM'),
('Inception', '9:00 PM');

SHOW TABLES;
SELECT * FROM bookings;
SELECT * FROM SHOWS;
delete from bookings;
-- or truncate bookings;
CREATE DATABASE IF NOT EXISTS cinebook_db;
USE cinebook_db;
SHOW TABLES;
SHOW DATABASES;
SELECT * FROM bookings;
SELECT * FROM cinebook_db.bookings;

