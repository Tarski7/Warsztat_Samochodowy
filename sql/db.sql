CREATE DATABASE Warsztat_Samochodowy
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

-- Table EMPLOYEE schema
CREATE TABLE EMPLOYEE(
id INT AUTO_INCREMENT,
name VARCHAR(255),
surname VARCHAR(255),
address VARCHAR(255),
phone_number INT(9),
note TEXT,
cost_of_operating_hour DECIMAL(4,2),
PRIMARY KEY(id));

-- Table CUSTOMER schema
CREATE TABLE CUSTOMER(
id INT AUTO_INCREMENT,
name VARCHAR(255),
surname VARCHAR(255),
date_of_birth DATE,
PRIMARY_KEY(id));

-- Table VEHICLE schema
CREATE TABLE VEHICLE(
id INT AUTO_INCREMENT,
model VARCHAR(255),
brand VARCHAR(255),
year_of_production DATE,
registration_number VARCHAR(255),
date_of_next_technical_inspection DATE,
customer_id INT,
PRIMARY KEY(id),
FOREIGN KEY(customer_id) REFERENCES CUSTOMER(id));

-- Table ORDERS schema
CREATE TABLE ORDERS(
id INT AUTO_INCREMENT,
date_of_acceptance_for_repair DATE,
planned_date_of_start_repair DATE,
date_of_start_repair DATE,
description_of_the_problem TEXT,
description_of_the_repair TEXT,
status INT,
cost_of_repair DECIMAL(6,2),
cost_of_used_parts DECIMAL(6,2),
cost_of_operating_hour_of_employee DECIMAL(4,2),
number_of_operating_hours INT,
employee_id INT,
vehicle_id INT,
PRIMARY KEY(id),
FOREIGN KEY(employee_id) REFERENCES EMPLOYEE(id),
FOREIGN KEY(vehicle_id) REFERENCES VEHICLE(id));