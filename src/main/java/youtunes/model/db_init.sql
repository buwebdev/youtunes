/*
    Title: db_init.sql
    Author: Professor Krasso
    Date: 25 June 2021
    Description: youtunes database initialization script.
*/

-- drop test user if exists 
DROP USER IF EXISTS 'youtunes_user'@'localhost';


-- create pysports_user and grant them all privileges to the pysports database 
CREATE USER 'youtunes_user'@'localhost' IDENTIFIED WITH mysql_native_password BY 'MySQL5IsGreat!';


-- grant all privileges to the pysports database to user pysports_user on localhost 
GRANT ALL PRIVILEGES ON youtunes.* TO'youtunes_user'@'localhost';


-- Drop the foreign key
ALTER TABLE album DROP FOREIGN KEY fk_artist;


-- drop tables if they are present
DROP TABLE IF EXISTS artist; 
DROP TABLE IF EXISTS album; 


-- create artist table 
CREATE TABLE artist (
	artist_id 		INT 			NOT NULL		AUTO_INCREMENT,
	first_name		VARCHAR(75)		NOT NULL,
	last_name		VARCHAR(75)		NOT NULL,
	PRIMARY KEY(artist_id)
);

-- create album table 
CREATE TABLE album (
	album_id		INT 			NOT NULL 		AUTO_INCREMENT,
	title			VARCHAR(150)	NOT NULL,
	price			DECIMAL(5, 2)	NOT NULL,
	genre			VARCHAR(75)		NOT NULL,
	img_url			VARCHAR(150)	NOT NULL,
	artist_id		INT				NOT NULL,
	PRIMARY KEY(album_id),
	CONSTRAINT fk_artist
	FOREIGN KEY(artist_id)
		REFERENCES artist(artist_id)
); 


-- insert artist statements 
INSERT INTO artist(first_name, last_name)
	VALUES('Ludwig van', 'Beethoven');

INSERT INTO artist(first_name, last_name)
	VALUES('Johann', 'Bach');
	
INSERT INTO artist(first_name, last_name)
	VALUES('Wolfgang', 'Mozart');
	
INSERT INTO artist(first_name, last_name)
	VALUES('Johannes', 'Brahms');
	
INSERT INTO artist(first_name, last_name)
	VALUES('Richard', 'Wagner');
	
	
-- insert album statements
INSERT INTO album(title, price, genre, img_url, artist_id)
	VALUES('Beethoven Complete Edition', 119.99, 'Classical', '', (SELECT artist_id FROM artist WHERE last_name = 'Beethoven'));
	
INSERT INTO album(title, price, genre, img_url, artist_id)
	VALUES('J.S Bach Complete Edition', 141.59, 'Classical', '', (SELECT artist_id FROM artist WHERE last_name = 'Bach'));
	
INSERT INTO album(title, price, genre, img_url, artist_id)
	VALUES('Mozart: The Symphonies', 32.18, 'Classical', '', (SELECT artist_id FROM artist WHERE last_name = 'Mozart'));
	
INSERT INTO album(title, price, genre, img_url, artist_id)
	VALUES('Brahms: Symphony 1 In C Minor', 19.90, 'Classical', '', (SELECT artist_id FROM artist WHERE last_name = 'Brahms'));
	
INSERT INTO album(title, price, genre, img_url, artist_id)
	VALUES('Best of Wagner', 10.89, 'Classical', '', (SELECT artist_id FROM artist WHERE last_name = 'Wagner'));
	