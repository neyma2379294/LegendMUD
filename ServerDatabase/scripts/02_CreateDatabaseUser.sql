-- Grab the variables passed in from the batch file.
source variables.sql;

-- Create and execute the CREATE USER statement.
SET @stmnt = CONCAT('CREATE USER \'', @USER_NAME, '\'@\'localhost\' IDENTIFIED BY \'', @USER_PWD, '\'');
PREPARE create_db_user FROM @stmnt;
EXECUTE create_db_user;

-- Create and execute the GRANT statement.
SET @stmnt = CONCAT('GRANT SELECT, INSERT, UPDATE, DELETE ON ', @DATABASE_NAME, '.* TO ', @USER_NAME, '@localhost;');
PREPARE create_db_user FROM @stmnt;
EXECUTE create_db_user;
