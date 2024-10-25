
create database fu_pdf character set utf8mb4 collate utf8mb4_bin;
use fu_pdf;

drop table if exists student;
create table student(
    id int primary key auto_increment,
    name varchar(20) not null comment '学生姓名'
) comment '学生表';

drop table if exists teacher;
create table teacher(
    id int primary key auto_increment,
    name varchar(20) not null comment '教师姓名'
) comment '教师表';

drop table if exists course;
create table course(
    id int primary key auto_increment,
    id_teacher int not null comment '教师',
    name varchar(20) not null comment '课程名称'
) comment '课程表';

drop table if exists course_score;
create table course_score(
    id_student int not null comment '学生',
    id_course int not null comment '课程',
    score int not null default 0 comment '成绩'
) comment '课程分数';

insert into student values(1, '张三'), (2, '李四'), (3, '王五');
insert into teacher values(1, '张老师'), (2, '李老师'), (3, '王老师');
insert into course values(1, 1, '语文'), (2, 2, '数学'), (3, 3, '英语');
insert into course_score values
                             (1, 1, 100),
                             (1, 2, 90),
                             (1, 3, 80),
                             (2, 1, 80),
                             (2, 2, 90),
                             (2, 3, 100),
                             (3, 1, 90),
                             (3, 2, 80),
                             (3, 3, 90);

insert into student
values (4, '赵六'), (5, '钱七'), (6, '孙八'), (7, '周九'), (8, '吴十'), (9, '郑一'), (10, '王二'),
       (11, '李三'), (12, '孙四'), (13, '周五'), (14, '吴六'), (15, '郑七'), (16, '王八'), (17, '李九'),
       (18, '孙十'), (19, '周一'), (20, '吴二'), (21, '郑三'), (22, '王四'), (23, '李五'), (24, '孙六');