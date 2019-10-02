/*建立学生表*/
create table s
(
sno char(9)primary key,
sname char(20) unique,
sex char(2),
age smallint,
dept char(20)
);


/*建立课程表 c*/
create table c
(
cno char(4) primary key,
cname char (40) not null,
cpno char(4),
ccredit smallint,
foreign key (cpno)references c (cno)
);


/*建立学生选课表sc*/
create table sc
(
sno char(9),
cno char(4),
grade smallint,
primary key(sno,cno),
foreign key(cno)references c(cno)
);


/*给c表增加字段teacher类型为char(10),增加 cpno字段*/
alter table c add teacher char(10),
alter table c add cpno char,


/*为s表的sname字段建立唯一索引，并删除s表的唯一索引*/
create unique index ssname on s(sname);
drop index ssname on s;


/*为s表的sdept建立聚簇索引*/
create cluster index ssdept on s(sdept);


/*建立一个计算机系学生基本信息试图 csv(sno,sname,sex,age),在视图中
查询1983年以后出生的计算机系学生的基本信息，最后删除该视图*/
create view csv(sno,sname,sex,age)
as
select 
from s
where dept = 'cs' and age <36;
drop view csv;


/*建立一个计算机系学生成绩视图jsgv(sno,cno,grade),在视图中查询计算机
系学生选课多于3门的学生学号。查询计算机系学生2号课程不及格的学号和成绩*/
create view jsgv
as
select sno
from sc
group by sno
having count(*)>3;

select sno,grade
from jsgv
where cno='2' and grade<60;


/*实验三*/
1、查询学生的学号和所在系
select sno,dept
from s

2、查询管理系的学生所选修的课程和成绩 //考虑用嵌套查询的写法
select cname,grade
from s,sc,c
where c.cno=sc.cno and s.sno=sc.sno and s.dept='管理系'

3 统计有学生选修的课程门数。

select count(distinct cname)
from c

?4 统计HU老师所授每门课程的学生平均成绩。
select avg(grade)
from s
where teacher in
	(
	select teacher
	from c
	where teacher='HU'
	);

select avg(grade)
from s,c
group by cname
having teacher='HU'

?5 统计所有选修人数多于20的课程号和选课人数，
  并按人数降序排列，若人数相等，则按课程号升序排列。

select cno,count(sno)
from sc
group by cno desc
having count(sno)>20;

6 






实验四
1 在学生表中插入一新生信息
(‘200213808’,’HUJING’,’女’,22,’计算机’)

insert
into s
values('200213808','HUJING','女','22','cs');

2新建一个学生平均成绩表spjcj,
   将学生的平均成绩插入到spjcj表中
create table spjcj
average smallint,
sno char(9),
insert 
into spjcj(average)

3 删除数据库中学号为’200213801’的退学学生有关信息。
delete
from s
where sno='200213801';


4  将计算机系学生2号课成绩全部提高5%。
update sc
set grade=grade*0.15
where cno=2;

5   删除没有成绩的学生选课记录


delete 
from s,sc
where s.sno=sc.sno and grade=null



实验五

1)定义一个表变量，用来存储学生的学号，姓名，所在系，
用以存储‘计算机系’的学生信息。

declare @tableVar table
(sno char(9)	primary key
name char(40)
dept char(20))
insert into @tableVar (dept,'计算机系')

2)判断学生表中是否有“李宁”同学，如查到，则显示
该生的基本信息和选修的课程信息及成绩；若没有查到
则显示“该生不存在”提示信息。

select @name ='李宁'
from s


3)编写一个自定义的函数，该函数接受一个学生姓名，
返回该生选修课程的平均成绩。

4)试用CASE语句输出学生中各年龄段的学生人数。

5)编写存储过程，以系别作为参数，统计指定系别的人数，
并作为存储过程的输出。

为每个学生选修课程的平均成绩定义游标对象，并判断如果
平均成绩低于70，则输出“考核不合格”，否则输出“通过考核”。





实验六
/*
2)	在C表中增加cpno字段，cpno字段为先修课号，定义cpno为外码，
参照C表的cno，并定义当删除被参照表中相关记录时，要求违约处理方式为置空，
当发生修改操作时，违约处理方式为级联
*/

alter table C
add cpno char(10) 
foreign key(cpno) references c(cno)
on delete null
on update cascade

/*
3)	定义SC表的实体集参照完整性约束，要求当其被参照表发生删除操作时，
S表违约处理的方式为级联，当其被参照表发生修改操作时，违约处理的方式为拒绝。
*/

create table sc
(
sno char(9),
cno char(4),
grade smallint,
primary key(sno,cno)
foreign key(sno) references s(sno),
on delete cascade,
on update no action
foreign key(cno) references c(cno)

);

/*
4)	触发器
☆	建立一DML触发器，每当学生的成绩发生更新时，将更新的学号，成绩存入g-log表内
☆	建立一个INSTEAD OF触发器，每当删除课程表中记录时，先检查此课程是否已被选修，
	如选修则不允许删除，且给出提示信息“此课程已有学生已选修，无法删除

*/

create trigger Grade_Update
after update
on sc
referencing
new table as insert
for each statement
insert into g-log


create trigger Delete_Message
before delete on c 
referencing
new table as delete
for each statement
begin
	if exists (select* 
	from c
	where cno=c,cno and sc.cno);
	then ('此课程已有学生已选修，无法删除')
	else
	delete


实验七：	

定义登陆用户log1，log2，log3
(截图体现步骤)
点击“安全性”右击鼠标，选择新建登陆在弹出的窗口中新建用户 log1，log2，log3
在建好的用户名上右击鼠标选择属性。
	
/*将查询SC表和修改GRADE属性的权限授予用户user1。*/

grant select,update
on table sc
to u1;

/*将对表S的插入权限授予用户user2，并允许他将此权限授予其他用户。*/

grant insert 
on table s
to user2
with grant option;

/* 允许用户user3拥有对cs系学生的查询权限*/
grant select(dept)
on table s
to user3;

/*创建角色R1，授予R1 课程表查询和插入的权限，并授予用户user3*/

create role R1
grant select ,insert
on table c
to R1,user3;

/* 删除角色R1课程表的插入权限*/

revoke insert 
on table c
to R1;

/*收回所有用户对表S的插入权限。*/

revoke insert 
on table s


实验八































