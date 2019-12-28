CREATE SCHEMA IF NOT EXISTS users;
CREATE TABLE IF NOT EXISTS users.users(
    id bigserial not null constraint users_pk primary key,
    username text unique not null ,
    password text not null ,
    email text unique not null
);
