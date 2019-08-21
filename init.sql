CREATE DATABASE hello;

\c hello

CREATE TABLE hello(id serial PRIMARY KEY,name varchar(255));

INSERT INTO hello (name) VALUES ('hello world');
