#自动初始化种子数据

#系统配置表
#insert into sys_config(`config_key`,`config_value`,`create_time`,`summary`)values ();

#用户信息表
INSERT INTO sys_user(`id`, `user_name`, `password`, `password_salt`, `create_time`, `is_account_enabled`, `is_account_non_expired`, `is_account_non_locked`, `is_credentials_non_expired`) VALUES (1000, 'admin', '$2a$10$umAi5X/Qt501sOjuANT11eEinLGnU7qeanbOIKCO9m1tLhg3Zywsq', '000000', 1552541683000, 1, 1, 1, 1);
INSERT INTO sys_user(`id`, `user_name`, `password`, `password_salt`, `create_time`, `is_account_enabled`, `is_account_non_expired`, `is_account_non_locked`, `is_credentials_non_expired`) VALUES (1001, 'guest', '$2a$10$umAi5X/Qt501sOjuANT11eEinLGnU7qeanbOIKCO9m1tLhg3Zywsq', '000000', 1552541683000, 1, 1, 1, 1);

#角色信息表
INSERT INTO sys_role(`id`, `role_code`, `role_name`, `summary`, `available`, `create_time`) VALUES (10000, 'IGNORE', '默认角色', '', 1, 1552541683000);
INSERT INTO sys_role(`id`, `role_code`, `role_name`, `summary`, `available`, `create_time`) VALUES (10001, 'LOGIN', '登陆角色', '', 1, 1552541683000);
INSERT INTO sys_role(`id`, `role_code`, `role_name`, `summary`, `available`, `create_time`) VALUES (10002, 'DOC', '文档角色', '', 1, 1552541683000);
INSERT INTO sys_role(`id`, `role_code`, `role_name`, `summary`, `available`, `create_time`) VALUES (10003, 'ADMIN', '管理角色', '', 1, 1552541683000);
INSERT INTO sys_role(`id`, `role_code`, `role_name`, `summary`, `available`, `create_time`) VALUES (10004, 'MEMBER', '会员角色', '', 1, 1552541683000);

#权限信息表
#默认角色
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (10000,'/passport/login','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (10001,'/passport/unauthorized','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (10002,'/passport/nopermission','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (10003,'/passport/uninitpermission','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (10004,'/error/index','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (10005,'/error','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (10006,'/','','','glyphicon-signal',0,0,1,1552541683000,0);
#仅登录注销角色
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (11001,'/profile/index','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (11002,'/profile/modifyPassword','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (11003,'/home/index','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (11004,'/home/error','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (11005,'/passport/loginoutok','','','glyphicon-signal',0,0,1,1552541683000,0);
#系统管理员角色
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (12001,'/root/sysuser/list','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (12002,'/root/sysuser/view','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (12003,'/root/sysuser/add','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (12004,'/root/sysuser/del','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (12005,'/root/sysuser/put','','','glyphicon-signal',0,0,1,1552541683000,0);
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (12006,'/root/urlmapping/index','','','glyphicon-signal',0,0,1,1552541683000,0);
#查看帮助文档角色
INSERT INTO sys_permission(id,url,name,summary,icon,sort,parent_id,available,create_time,type) VALUES (13001,'/help/helpcenter/index','','','glyphicon-signal',0,0,1,1552541683000,0);

#用户角色信息表
INSERT INTO sys_user_role_list(`sys_user_id`, `role_list_id`) VALUES (1000, 10000);
INSERT INTO sys_user_role_list(`sys_user_id`, `role_list_id`) VALUES (1000, 10001);
INSERT INTO sys_user_role_list(`sys_user_id`, `role_list_id`) VALUES (1000, 10002);
INSERT INTO sys_user_role_list(`sys_user_id`, `role_list_id`) VALUES (1000, 10003);
INSERT INTO sys_user_role_list(`sys_user_id`, `role_list_id`) VALUES (1001, 10000);
INSERT INTO sys_user_role_list(`sys_user_id`, `role_list_id`) VALUES (1001, 10001);
INSERT INTO sys_user_role_list(`sys_user_id`, `role_list_id`) VALUES (1001, 10002);
INSERT INTO sys_user_role_list(`sys_user_id`, `role_list_id`) VALUES (1001, 10004);

#角色权限信息报
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10000, 10000);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10000, 10001);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10000, 10002);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10000, 10003);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10000, 10004);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10000, 10005);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10000, 10006);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10001, 11001);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10001, 11002);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10001, 11003);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10001, 11004);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10001, 11005);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10002, 13001);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10003, 12001);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10003, 12002);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10003, 12003);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10003, 12004);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10003, 12005);
insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10003, 12006);

#insert INTO sys_role_permission_list(`sys_role_id`,`permission_list_id`)values (10004, 0);


