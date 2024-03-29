CREATE DATABASE jaegers_db;

\c jaegers_db;

CREATE TABLE jaegers (
    id SERIAL PRIMARY KEY,
    modelName VARCHAR(30),
    mark VARCHAR(6),
    height DECIMAL(4,2),
    weight DECIMAL(4,3),
    status VARCHAR(13),
    origin VARCHAR(20),
    launch DATE,
    kaijuKill INT
);

\ir init_db.sql;
\ir queries.sql;