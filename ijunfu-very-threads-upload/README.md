# 第一章 分片上传

## 1. 什么是普通上传？
> 调用接口一次完成一个文件的上传。

### 1.1 存在的缺点
1. 文件无法续传：比如上传了一个比较大的文件，若网络异常导致上传中断，那么需要重新上传。
2. 大文件上传较慢：因为需要等待服务器响应，然后才能继续上传。

### 1.2 解决方案
> 分片上传

## 2. 什么是分片上传？
> 将一个文件分成多个片段，然后分别上传，最后将片段合并。

### 2.1 分片上传的优点
> 断点续传：如果上传过程中出现异常，可以断点续传。

### 2.2 分片上传的过程
1. 创建分配上传任务（分片数量、每个分片文件大小，文件MD5值）
2. 上传所有分片
3. 待确认所有分片上传成功，才合并分片，便可得到源文件

### 2.3 分片上传涉及的数据表

#### 2.3.1 分片上传任务表
> 每个分片任务会再此表创建一条记录
```sql
drop table if exists `upload_task`;
create table `upload_task` (
    task_id bigint(20) primary key comment '任务ID',
    file_name varchar(255) not null comment '文件名',
    part_nums int(11) not null comment '分片数量',
    file_md5 varchar(128) not null comment '文件MD5',
    file_path varchar(255) not null comment '文件路径'
) comment '分片上传任务表';
```

#### 2.3.2 分片上传分片表
> 每个分片任务会在此表创建多条记录。与任务表是一对多的关系，即一个任务对应多个分片。
```sql
drop table if exists `upload_task_part`;
create table `upload_task_part` (
    task_part_id bigint(20) primary key comment '分片ID',
    task_id bigint(20) not null comment '任务ID',
    part_index int(11) not null comment '分片索引',
    part_path varchar(255) not null comment '分片路径'
) comment '分片上传分片表';
```

### 2.4 后台接口

#### 2.4.1 创建分片上传任务`/upload/task`
> 返回分片任务ID，后续的三个接口均需要传入此ID。

#### 2.4.2 上传分片文件`/upload/part`

#### 2.4.3 合并分片文件`/upload/merge`

#### 2.4.4 获取分片任务详细信息`/upload/detail`
> 可以获取分片任务的状态信息。比如分片上传是否完成、分片上传是否成功、分片上传是否失败等。
> 如果分片上传失败，则可以通过此接口获取失败的分片信息，然后进行重试。


