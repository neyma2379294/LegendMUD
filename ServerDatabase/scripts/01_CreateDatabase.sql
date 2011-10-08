-- Grab the variables passed in from the batch file.
source variables.sql;

-- Create and execute the CREATE DATABASE statement.
SET @stmnt = CONCAT('CREATE DATABASE ', @DATABASE_NAME);
PREPARE create_db FROM @stmnt;
EXECUTE create_db