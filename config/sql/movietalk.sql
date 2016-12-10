# 清库
drop database if exists movietalk;

# 创建数据库
create database movietalk;

# 使用刚刚创建的数据库movietalk
use movietalk;

# 清表
drop table if exists m_admin;
drop table if exists m_role;
drop table if exists m_role_admin;
drop table if exists m_friendlink;
drop table if exists m_user;
drop table if exists m_pmood;
drop table if exists m_dairy;


# 创建后台管理员表
# status:0表示该用户废除，1表示该用户的状态是激活, default 1   
# loginmethod:0表示其是系统用户，1表示qq登录用户, default 0
create table m_admin(
id int(11) primary key auto_increment,
uname varchar(32) unique not null,
fullname varchar(50),
email varchar(64),
phone varchar(16),
pword varchar(50),
login_time varchar(15),
login_ip varchar(50),
status tinyint(1) default 1,
loginmethod tinyint(1) default 0,
is_super tinyint(1) default 0
);

# 后台权限表
# rname: 权限名
# remark: 权限描述
# pid: 父级权限id
create table m_role(
id int(11) primary key auto_increment,
rname varchar(20),
remark varchar(255),
pid tinyint(1) default 0,
status tinyint(1) default 1
);

# 用户_权限对应表
create table m_role_admin(
id int(11) primary key auto_increment,
admin_id int(11),
role_id int(11),
constraint role_admin_admin_id foreign key(admin_id) references m_admin(id),
constraint role_admin_role_id foreign key(role_id) references m_role(id)
);

# 友情链接表
# listway:展示方式,1表示网站名称显示，0表示网站logo显示
# picname:只允许上传一张图片
create table m_friendlink(
id int(11) primary key auto_increment,
linkname varchar(60),
linkurl varchar(160) not null,
picname varchar(255),
dtime varchar(15),
msg varchar(200),
listway tinyint(1)
);

# 用户表
# disable: 禁用开关,禁用的字段有: sex,realname,email
# sex: 0表示女 1表示男  2表示保密
# status: 0表示有效,1表示冻结，可能是用户有非法操作
# repnum: 被举报数目
# rewrong: 举报错误次数
create table m_user(
id int(11) primary key auto_increment,
uname varchar(32) not null unique,
realname varchar(50),
pword varchar(50),
disable tinyint(1) default 0,
sex int(10),
email varchar(64),
score int(11) default 0,
image varchar(200) '/pic/default.jpg',
addtime varchar(15),
login_time varchar(15),
login_ip varchar(50),
status tinyint(1) default 0,
repnum int(11),
rewrong int(11) default 0
);

# 心情签名表
create table m_pmood(
id int(11) primary key auto_increment,
uid int(11),
content varchar(255),
addtime varchar(15),
constraint mood_user_id foreign key(uid) references m_user(id)
);

# 日志表 
# apname: 点赞人名(以逗号分割)
create table m_dairy(
id int(11) primary key auto_increment,
uid int(11),
title varchar(255),
content text,
addtime varchar(15),
apname text,
constraint mood_user_id foreign key(uid) references m_user(id)
);

# 初始化数据表
insert into m_admin(uname,pword,is_super) values ("admin","admin123",1);

