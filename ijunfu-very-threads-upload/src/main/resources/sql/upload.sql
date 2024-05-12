# 【MySQL】数据库初始化脚本
create database if not exists `upload` character set utf8mb4 collate utf8mb4_bin;

drop table if exists `upload`.`upload_task`;
create table `upload`.`upload_task` (
   task_id bigint(20) primary key comment '任务ID',
   file_name varchar(255) not null comment '文件名',
   part_nums int(11) not null comment '分片数量',
   file_md5 varchar(128) not null comment '文件MD5',
   file_path varchar(255) default '' comment '文件路径',
   del_status tinyint(1) default 0 comment '删除状态：0-未删除，1-已删除'
) comment '分片上传任务表';

drop table if exists `upload`.`upload_task_part`;
create table `upload`.`upload_task_part` (
    task_part_id bigint(20) primary key comment '分片ID',
    task_id bigint(20) not null comment '任务ID',
    part_index int(11) not null comment '分片索引',
    part_path varchar(255) default '' comment '分片路径',
    del_status tinyint(1) default 0 comment '删除状态：0-未删除，1-已删除'
) comment '分片上传分片表';

alter table `upload`.`upload_task_part` add index `idx_task_id`(`task_id`);
