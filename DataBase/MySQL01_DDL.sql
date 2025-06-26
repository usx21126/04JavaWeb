-- DDL 数据库操作
-- 创建数据库
create database  java_db01;
-- 查看数据库
select database();
-- 使用数据库
use java_db01;

-- DDL 表操作
drop table if exists user;
create table user(
    id int primary key auto_increment comment '唯一标识',
    username varchar(20) unique not null comment '用户名',
    name varchar(20) not null comment '姓名',
    age int comment '年龄',
    gender char(1) default '男' comment '性别'
)comment '用户表';

drop table if exists emp;
create table emp(
    id int unsigned primary key auto_increment comment '主键id',
    username varchar(20) not null unique comment '用户名',
    name varchar(10) not null comment '姓名',
    gender char(1) not null comment '性别',
    phone char(11) not null unique comment '手机号',
    creat_time datetime not null comment '创建时间',
    update_time datetime not null comment '更新时间',
    job tinyint comment '职位:1-班主任 2-讲师 3-学工主管 4-教研主管 5-咨询师',
    salary decimal(9,2) comment '薪资',
    image varchar(100) comment '图片路径',
    entrydate date comment '入职日期',
    department int comment '归属部门'
)comment '员工表';

show tables;
desc emp;
show create table emp;