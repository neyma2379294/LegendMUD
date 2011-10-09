-- Grab the variables passed in from the batch file.
source variables.sql;

CREATE TABLE account (
	id INT NOT NULL AUTO_INCREMENT,
	user_name NVARCHAR(64),
	password NVARCHAR(64),
	email NVARCHAR(64),
	PRIMARY KEY (id));
	
CREATE TABLE player_character (
	id INT NOT NULL AUTO_INCREMENT,
	account_id INT NOT NULL,
	name VARCHAR(32),
	PRIMARY KEY (id));
	