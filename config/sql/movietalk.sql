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
drop table if exists m_list;
drop table if exists m_attention;
drop table if exists m_notice;
drop table if exists m_pnotice;
drop table if exists m_store;
drop table if exists m_actor;
drop table if exists m_mactor;
drop table if exists m_picactor;
drop table if exists m_access;
drop table if exists m_ppt;
drop table if exists m_type;
drop table if exists m_tag;
drop table if exists m_mtype;
drop table if exists m_mtag;
drop table if exists m_filmpic;
drop table if exists m_short_review;
drop table if exists m_long_review;
drop table if exists m_review_anti;
drop table if exists m_review_reply;
drop table if exists m_advice;
drop table if exists m_suggestion;
drop table if exists m_realise_dairy

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
image varchar(200) default '/pic/default.jpg',
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
constraint mood_user_uid foreign key(uid) references m_user(id)
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
constraint m_dairy_uid foreign key(uid) references m_user(id)
);

# 关注表
create table m_attention(
id int(11) primary key auto_increment,
myid int(11),
heid int(11),
constraint m_attention_myid foreign key(myid) references m_user(id),
constraint m_attention_heid foreign key(heid) references m_user(id)
);

# 公告通知表
create table m_notice(
id int(11) primary key auto_increment,
title varchar(255),
content text,
addtime varchar(15)
);

# 公告关系表
# status: 0代表未读
create table m_pnotice(
id int(11) primary key auto_increment,
nid int(11),
uid int(11),
status tinyint default 0,
constraint m_pnotice_uid foreign key(uid) references m_user(id),
constraint m_pnotice_nid foreign key(nid) references m_notice(id)
);

# 影片信息表
# duration: 片长
# snum: 想要观看的数量
# rate: 综合评分(10分制)
# mtype: 影片类型,0表示上映,1表示预告片
# status: 影片状态,0表示正在展示,1表示已经下架
create table m_list(
id int(11) primary key auto_increment,
filname varchar(150) default "",
petname varchar(150) default "",
director varchar(50) default "",
editor varchar(50) default "",
nation varchar(50) default "",
voice varchar(50) default "",
showtime varchar(15),
addtime varchar(15),
duration int(11),
content text default "",
collectnum int(11) default 0,
clicknum  int(11) default 0,
snum int(11) default 0,
rate tinyint,
mtype tinyint,
status tinyint default 0
);

# 收藏表
create table m_store(
id int(11) primary key auto_increment,
mid int(11),
uid int(11),
constraint m_store_uid foreign key(uid) references m_user(id),
constraint m_store_mid foreign key(mid) references m_list(id)
);

# 演员表
# sex: 性别,0表示男,1表示女,2表示不详
# constellation: 星座
create table m_actor(
id int(11) primary key auto_increment,
cname varchar(50),
ename varchar(50),
sex tinyint,
constellation varchar(20) default "",
birthday varchar(15),
bornaddress varchar(120) default "",
profession varchar(120) default "",
addtime varchar(15)
);

# 电影演员
create table m_mactor(
id int(11) primary key auto_increment,
mid int(11),
aid int(11),
constraint m_actor_mid foreign key(mid) references m_list(id),
constraint m_actor_aid foreign key(aid) references m_actor(id)
);

# 演员相关图片
create table m_picactor(
id int(11) primary key auto_increment,
aid int(11),
picname varchar(255),
constraint m_picactor_aid foreign key(aid) references m_actor(id)
);

# 演员评价表
create table m_access(
id int(11) primary key auto_increment,
aid int(11),
uid int(11),
content text,
rtime varchar(15),
usenum int(11),
unuse int(11),
constraint m_access_aid foreign key(aid) references m_actor(id),
constraint m_access_uid foreign key(uid) references m_user(id)
);

# 幻灯片表
# display: 展示状态：0表示正在展示，1表示已经下架
create table m_ppt(
id int(11) primary key auto_increment,
mid int(11),
title varchar(80),
descr varchar(160),
picname varchar(160),
display tinyint,
addtime varchar(15),
constraint m_ppt_mid foreign key(mid) references m_list(id)
);

# 影片类型
create table m_type(
id int(11) primary key auto_increment,
typename varchar(20)
);

# 影片标签
create table m_tag(
id int(11) primary key auto_increment,
tagname varchar(20)
);

# 影片类型
create table m_mtype(
id int(11) primary key auto_increment,
mid int(11),
tid int(11),
constraint m_mtype_mid foreign key(mid) references m_list(id),
constraint m_mtype_tid foreign key(tid) references m_type(id)
);

# 影片标签
create table m_mtag(
id int(11) primary key auto_increment,
mid int(11),
tagid int(11),
constraint m_mtag_mid foreign key(mid) references m_list(id),
constraint m_mtag_tagid foreign key(tagid) references m_tag(id)
);

# 影片图片
create table m_filmpic(
id int(11) primary key auto_increment,
mid int(11),
picname varchar(120),
constraint m_filmpic_mid foreign key(mid) references m_list(id)
);

# 影片短评
create table m_short_review(
id int(11) primary key auto_increment,
mid int(11),
uid int(11),
content text,
rtime varchar(15),
usenum int(11) default 0,
constraint m_short_review_mid foreign key(mid) references m_list(id),
constraint m_short_review_uid foreign key(uid) references m_user(id)
);

# 影片长评
create table m_long_review(
id int(11) primary key auto_increment,
mid int(11),
uid int(11),
title varchar(255),
content text,
rtime varchar(15),
usenum int(11) default 0,
unuse int(11) default 0,
constraint m_long_review_mid foreign key(mid) references m_list(id),
constraint m_long_review_uid foreign key(uid) references m_user(id)
);

# 长短评举报
# sid: 长短评论的id
# uid: 被举报者id
# rid： 举报者id
# status: 0表示未审批，1表示审批
# stype： 0表示短评，1表示长评
create table m_review_anti(
id int(11) primary key auto_increment,
sid int(11),
uid int(11),
reason text,
status tinyint default 0,
stype tinyint,
rid int(11),
constraint m_review_anti_uid foreign key(uid) references m_user(id),
constraint m_review_anti_rid foreign key(rid) references m_user(id)
);

# 长评回复
create table m_review_reply(
id int(11) primary key auto_increment,
lid int(11),
uid int(11),
content text,
rtime varchar(15),
constraint m_review_reply_lid foreign key(lid) references m_long_review(id),
constraint m_review_reply_uid foreign key(uid) references m_user(id)
);

# 智能推荐
# status: 用户接收状态，如果已经接受，则是1
create table m_advice(
id int(11) primary key auto_increment,
aname varchar(150) default "admin",
mid int(11),
uid int(11),
adate varchar(15),
status tinyint default 0,
constraint m_advice_mid foreign key(mid) references m_list(id),
constraint m_advice_uid foreign key(uid) references m_user(id)
);

# 用户吐槽区
create table m_suggestion(
id int(11) primary key auto_increment,
uid int(11),
content text,
adate varchar(15),
constraint m_suggestion_uid foreign key(uid) references m_user(id)
);

# 用户登录记录
# isp:运营商
create table m_realise_dairy(
id int(11) primary key auto_increment,
ip varchar(50),
logintime varchar(15),
country varchar(255),
area varchar(255),
region varchar(255),
city varchar(255),
county varchar(255),
isp varchar(255),
uid int(11),
constraint m_realise_dairy_uid foreign key(uid) references m_user(id)
);

# 初始化数据表
insert into m_admin(uname,pword,is_super) values ("admin","admin123",1);
INSERT INTO `movietalk`.`m_user` (`id`, `uname`, `realname`, `pword`, `disable`, `sex`, `email`, `score`, `image`, `addtime`, `login_time`, `login_ip`, `status`, `repnum`, `rewrong`) VALUES ('1', 'xiaoming', '小明', '12345678', '0', '1', '1823889319@qq.com', '0', '/pic/default.jpg', '20170206101423', '20170206101423', '192.168.56.1', '0', '0', '0');
INSERT INTO `movietalk`.`m_user` (`id`, `uname`, `realname`, `pword`, `disable`, `sex`, `email`, `score`, `image`, `addtime`, `login_time`, `login_ip`, `status`, `repnum`, `rewrong`) VALUES ('2', 'xiaohong', '小红', '12345678', '0', '0', '1823889319@qq.com', '1', '/pic/default.jpg', '20170206101423', '20170205101423', '192.168.56.1', '0', '0', '0');
INSERT INTO `movietalk`.`m_realise_dairy` (`id`, `ip`, `logintime`, `country`, `area`, `region`, `city`, `county`, `isp`, `uid`) VALUES ('1', '192.168.86.1', '20170206101423', '中国', '华南', '广东', '深圳', '深圳', '联通', '1');
INSERT INTO `movietalk`.`m_realise_dairy` (`id`, `ip`, `logintime`, `country`, `area`, `region`, `city`, `county`, `isp`, `uid`) VALUES ('2', '192.168.56.1', '20170205101423', '中国', '华南', '广东', '汕尾', '陆丰', '电信', '2');
INSERT INTO `movietalk`.`m_realise_dairy` (`id`, `ip`, `logintime`, `country`, `area`, `region`, `city`, `county`, `isp`, `uid`) VALUES ('3', '192.168.56.1', '20170205151423', '中国', '华南', '广东', '汕尾', '陆丰', '电信', '2');
