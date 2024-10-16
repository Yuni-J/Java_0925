create user 'javaUser'@'localhost' identified by 'mysql';

create database javadb;

grant all privileges on javadb.* to 'javaUser'@'localhost' with grant option;
flush privileges;

use javadb;

create table student(
sno int auto_increment,
sname varchar(50) not null,
snum varchar(50),
sbirth varchar(50),
sphone varchar(50),
saddr varchar(50),
regdate datetime default now(),
primary key(sno));

-- int -> 실제 연산할때