create database if not exists `db_security` charset utf8mb4 collate utf8mb4_bin;

drop table if exists `db_security`.`sys_user`;
create table `db_security`.`sys_user` (
    user_id bigint auto_increment primary key comment '主键',
    username varchar(32) not null comment '用户名',
    password varchar(128) not null comment '密码',
    enabled tinyint not null default 1 comment '是否启用'
) comment '用户表';

alter table `db_security`.`sys_user` add unique index `idx_username` (`username`);

insert into `db_security`.`sys_user` (username, password)
values ('admin', '$2y$10$7Je4NZ2Y3waUsbescWGHa.kkD5xvRkcaAJfLUMqjdITQeoECcxN6e'),   -- admin/123456
       ('user', '$2y$10$7D4Hwkb7mqygoie3P4exr.Ypwnscxkn7J92N7/LXDaUL/HpHkw4pS'),    -- user/123456
       ('ijunfu', '$2y$10$O2TuNJb.wWHramNJmJm.GuPhEwGC0J3US0iGQ8fpuNKJs9ahrAhUK');  -- ijunfu/123456
