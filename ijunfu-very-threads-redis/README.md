
# Redis 7 学习笔记

## 目录

### <a href="#intro">1. Redis介绍</a>

### <a href="#settings">2. 安装 & 配置</a>

### <a href="#dataType">3. 数据类型</a>

### 4. 持久化

### 5. 事务

### 6. 管道

### 7. 发布订阅

### 8. 复制

### 9. 哨兵

### 10. 集群

### 11. SpringBoot集成Redis

### 12. 案例

+ 高并发Redis缓存队列-实现防微信抢红包
+ 淘宝聚划算功能 - 实现防止缓存击穿
+ 手写Redis分布式锁
+ 美团推送附近的酒店-GEO命令附近功能
+ 自研手写布隆过滤器，Bitmap实战钉钉签到落地
+ RedLock算法之MultiLock多重锁，解决分布式锁多机案例
+ mysql-canal-redis 双写一致性
+ 淘宝网站首页亿级UV的Redis统计方案
+ BigKey案例，如何发现BigKey，如何定位BigKey，如何删除BigKey
+ SpringBoot整合Redis，搭建多级缓存架构及连接集群操作


## <h2 id="intro">1. Redis介绍</h2>

### 什么是Redis？
Redis(Remote Dictionary Server) 远程字典服务器，使用ANSIC语言编写，遵守BSD协议的开源框架；拥有高性能的Key-Value数据库，提供了丰富的数据结构，例如String、Hash、List、Set、SortedSet等等。同时Redis，支持事务、持久化、Lua脚本、发布/订阅、缓存淘汰、流技术等多种功能特性提供了主从模式、哨兵和集群架构。
Redis是一个内存数据库，它将数据保存在内存中，所以它非常快。

### Redis有哪些用途？

#### 主流功能与应用
应用场景：
+ 缓存加速
+ 分布式（会话、计数器、锁）
+ 排行榜
+ 事务
+ 持久化
+ Lua脚本
+ 发布/订阅
+ 缓存淘汰
+ 流技术等

数据结构：
+ String
+ Hash
+ List
+ Set
+ SortedSet

持久化：
+ RDB
+ AOF

### 参考文档
+ [源码地址](https://github.com/redis/redis)
+ [Redis在线测试](https://try.redis.io/)
+ [Redis中文文档](http://doc.redisfans.com/)

### 怎么下载Redis？

[Redis Download](https://redis.io/download)



## <h2 id="settings">2. 安装 & 配置</h2>
#### 安装步骤
+ 下载Redis压缩包
+ 解压到任意目录下
+ 进入目录
+ 执行命令`mask & mask install`
+ 修改`redis.conf`
  + `daemonize no`：默认为no，设置为yes，则Redis以守护进程方式启动
  + `bind 127.0.0.1`：设置为127.0.0.1，则只能通过本机访问
  + `protected-mode yes`：默认为yes，设置为no，则允许远程访问
  + `port 6379`：默认为6379，修改为任意端口
  + `requirepass`: 设置密码，默认为空
+ 启动服务`redis-server redis.conf`
+ 连接服务
+ 连接服务
  + `redis-cli -h 127.0.0.1 -p 6379`
  + `auth password`
+ 退出 & 关闭
  + 退出：`quit`
  + 关闭：
    + 单实例：`redis-cli -a password shutdown`
    + 多实例：`redis-cli -p 6379 shutdown`

#### 卸载Redis
+ 停止redis-server
+ 删除`usr/local/lib`目录下与redis相关文件

#### Redis安装文件介绍
+ redis-benchmark：性能测试工具，服务器启动后运行该命令，可查看本机性能
+ redis-check-aof：修复错误的AOF文件
+ redis-check-dump：修复错误的RDB文件
+ redis-cli：Redis客户端，操作入口
+ redis-sentinel：Redis集群监控工具
+ redis-server：Redis服务器启动命令

## <h2 id="dataType">3. 数据类型</h2>
> 我们这里说的数据类型是Value的数据类型，Key的类型是String（字符串）。

[Data Type | https://redis.io/docs/data-types](https://redis.io/docs/data-types)

### 3.1 String - 字符串
`String`是redis中最基本的类型，一个Key对应一个Value。
`String`类型是`二进制安全的`, 即Redis中可以包含任何数据，比如`图片、音频、视频、文档、序列化对象等。
`String`类型是Redis最基本的数据类型，一个redis中字符串value最大可以存储512M。

示例：
```shell
set author ijunfu
get author
```


