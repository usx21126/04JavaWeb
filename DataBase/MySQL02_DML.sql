
-- DML : 数据操作语言
-- DML : 插入数据 - insert
-- 1. 为 emp 表的 username, password, name, gender, phone 字段插入值
insert into emp (username, password,name,gender,phone) values('Tom','666888','汤姆','男','13100001111');

-- 2. 为 emp 表的 所有字段插入值
insert into emp (id, username, name, gender, phone, creat_time, update_time, job, salary, image, entrydate, department, password)
values (null,'kunkun','坤坤','男','13201011100',now(),now(),1,6000,'001.jpg','2000-10-01',null,'101010');

-- 3. 批量为 emp 表的 username, password, name, gender, phone  字段插入数据



-- DML : 更新数据 - update
-- 1. 将 emp 表的ID为1员工 姓名name字段更新为 '张三'
update emp set name = '张三' where id = 1;

-- 2. 将 emp 表的所有员工的入职日期更新为 '2010-01-01'

update emp set entrydate = '2010-01-01';


-- DML : 删除数据 - delete
-- 1. 删除 emp 表中 ID为1的员工
delete from emp where id = 3;

-- 2. 删除 emp 表中的所有员工
delete from emp;
drop table emp;
