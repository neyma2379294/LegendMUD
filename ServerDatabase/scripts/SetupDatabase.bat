@echo off
title LegendMUD Database Creator

REM ****************
REM Set Up Variables
REM ****************

call Variables.bat
echo SET @DATABASE_NAME = '%DATABASE_NAME%'; >> variables.sql
echo SET @ADMIN_NAME = '%ADMIN_NAME%'; >> variables.sql
echo SET @ADMIN_PWD = '%ADMIN_PWD%'; >> variables.sql
echo SET @USER_NAME = '%USER_NAME%'; >> variables.sql
echo SET @USER_PWD = '%USER_PWD%'; >> variables.sql

:menu
echo.
echo =============
echo Select a Task
echo =============
echo (Executing as %ADMIN_USER%/%ADMIN_PWD%)
echo. 
echo 1) Create Database (%DATABASE_NAME%)
echo 2) Create User (%USER_NAME%/%USER_PWD%)
echo 3) Create Tables
echo 4) Populate Test Data
echo 5) Drop Tables
echo 6) Quit
echo.
set /p choice=Choice:

if "%choice%"=="1" goto create_db
if "%choice%"=="2" goto create_user
if "%choice%"=="3" goto create_tables
if "%choice%"=="4" goto populate_test_data
if "%choice%"=="5" goto drop_tables
if "%choice%"=="6" goto exit
goto menu

:create_db
mysql --user=%ADMIN_USER% --password=%ADMIN_PWD% < 01_CreateDatabase.sql
goto menu

:create_user
mysql --user=%ADMIN_USER% --password=%ADMIN_PWD% legendmud < 02_CreateDatabaseUser.sql
goto menu

:create_tables
mysql --user=%ADMIN_USER% --password=%ADMIN_PWD% legendmud < 03_CreateTables.sql
goto menu

:populate_test_data
mysql --user=%ADMIN_USER% --password=%ADMIN_PWD% legendmud < 04_PopulateTestData.sql
goto menu

:drop_tables
mysql --user=%ADMIN_USER% --password=%ADMIN_PWD% legendmud < 05_DropTables.sql
goto menu

:exit
del variables.sql