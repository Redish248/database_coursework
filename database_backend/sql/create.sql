CREATE TABLE animals (
   uid serial PRIMARY KEY,
   name varchar(50) NOT NULL,
   amount integer CHECK (amount >= 0) default 0
);

CREATE TABLE feed (
    uid serial PRIMARY KEY,
    name varchar(50) NOT NULL,
    description text,
    price integer CHECK (price >= 0),
    amount integer CHECK (amount >= 0) default 0
);

CREATE TABLE objects (
     uid serial PRIMARY KEY,
     name varchar(50) NOT NULL,
     description text,
     price integer CHECK (price >= 0),
     amount integer CHECK (amount >= 0) default 0
);

CREATE TABLE position (
  uid serial PRIMARY KEY,
  name varchar(50) NOT NULL,
  description text
);

CREATE TABLE staff (
   uid serial PRIMARY KEY,
   name varchar(30) NOT NULL,
   surname varchar(30) NOT NULL,
   patronymic varchar(30),
   date_of_birth date,
   gender varchar(10),
   position bigint REFERENCES position,
   salary integer CHECK (salary >= 0)
);

CREATE TABLE transactions_budget (
     uid serial PRIMARY KEY,
     amount bigint CHECK (amount >= 0),
     transaction_owner varchar(50),
     purpose text,
     date timestamp
);

CREATE TABLE user_type (
   uid serial PRIMARY KEY,
   name varchar(30) NOT NULL,
   description text
);

CREATE TABLE users (
   uid serial PRIMARY KEY,
   name varchar(30) NOT NULL,
   surname varchar(30) NOT NULL,
   date_of_birth date,
   gender varchar(10),
   nick varchar(50) UNIQUE NOT NULL,
   email varchar(50) UNIQUE NOT NULL,
   password text NOT NULL,
   user_type bigint NOT NULL REFERENCES user_type
);