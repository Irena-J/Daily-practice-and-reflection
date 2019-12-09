use class_1206db;

create table stu_score(
	name varchar(20),
	sn int,
	Chinese int,
	Math int,
	English int,
	datas_tructure int,
	data_base int
);

全列插入：
insert into stu_score values("jokseia",417100,100,100,100,100,100);
insert into stu_score values("jacklove",417101,66,99,100,10,100);
insert into stu_score values("ning",417102,46,100,100,100,100);
insert into stu_score values("rookie",417103,39,79,43,23,55);
指定字段插入：
insert into stu_score(name,sn,datas_tructure,data_base) values("ahoj",417104,90,100);
insert into stu_score(name,sn,datas_tructure,data_base) values("baolan",417105,80,100);
insert into stu_score(name,sn,datas_tructure,data_base) values("theshy",417106,100,100);

查询表里所有的数据：
select * from stu_score;
查询学生总成绩
select name,Chinese+English+Math+data_base+datas_tructure total from stu_score;
按照总分排序
select Chinese+ENglish+Math+data_base+datas_tructure total from stu_score order by total desc;
按照英语成绩排序
select name,English from stu_score
order by English desc;
查询英语成绩，数学成绩都小于60分的同学
select English,name,Math from stu_score
	where English < 60 and Math <60;
查询数学成绩在80-90分内的同学
select name,Math from stu_score
	where Math between 80 and 90;
查询数学没有成绩的同学(提示：可以给某些同学不插入数学成绩，通过null，not null来查询)
select name,Math from stu_score
	where Math is null;
练习limit分页查询
从第0号开始，筛选2条结果
select name,Chinese,Math,English,datas_tructure,data_base from stu_score
order by name limit 2;
从1号开始，筛选3条结果
select name,Chinese,Math,English,datas_tructure,data_base from stu_score limit 1,3;
从第3号开始，筛选1条结果
select name,Chinese,Math,English,datas_tructure,data_base from stu_score
order by name limit 1 offset 3;

将theshy的数学成绩变为100
update stu_score set math = 100 where name = "theshy";

将总成绩倒数前3的位同学的数学成绩减去6分
update stu_score set math =math-6 order by  Chinese+English+Math+data_base+datas_tructure limit 3;
将所有同学的语文成绩加上1分
update stu_score set chinese = chinese * 2;
将倒数第1的同学的英语成绩加4
update stu_score set english = english - 1 limit 0;
删除baolan的考试成绩
delete from stu_score where name = "baolan";
删除整张表的成绩,再创建score表
drop table if exists score;
create table score(
	id int,
	name varcahr(20)
);
