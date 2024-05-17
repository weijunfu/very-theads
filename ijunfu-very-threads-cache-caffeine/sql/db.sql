create database if not exists `i_cache` character set utf8mb4 collate utf8mb4_bin;

use `i_cache`;

drop table if exists `sys_user`;
create table `sys_user` (
    user_id bigint primary key comment '主键',
    username varchar(20) not null unique comment '用户名',
    age int not null default 0 comment '年龄',
    birthday varchar(10) not null comment '生日'
) comment '系统用户';