-- Grab the variables passed in from the batch file.
source variables.sql;

-- Create test accounts.
INSERT INTO account (user_name, password, email) VALUES ("Chris", "password", "chris@ffs.com");
INSERT INTO account (user_name, password, email) VALUES ("Mike", "password", "mike@ffs.com");
INSERT INTO account (user_name, password, email) VALUES ("Brian", "password", "brian@ffs.com");

-- Creat test player characters.
INSERT INTO player_character (account_id, name) VALUES (1, "Saro");
INSERT INTO player_character (account_id, name) VALUES (1, "Deren");
INSERT INTO player_character (account_id, name) VALUES (2, "Gabriel");
