/*
Navicat MySQL Data Transfer

Source Server         : master
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : master

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-03-17 17:54:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_perms_group`
-- ----------------------------
DROP TABLE IF EXISTS `sys_perms_group`;
CREATE TABLE `sys_perms_group` (
  `name` varchar(50) NOT NULL,
  `id` varchar(32) NOT NULL,
  `uid` varchar(40) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_perms_group
-- ----------------------------
INSERT INTO `sys_perms_group` VALUES ('模块管理', 'SYS_PERMS_GROUP', '3e545880-e3b5-4cbb-b212-ec9bfe46e347');
INSERT INTO `sys_perms_group` VALUES ('系统属性', 'SYS_SETTING_PROPERTIES', '447ca946-56cb-40f9-acde-24860de3f10b');
INSERT INTO `sys_perms_group` VALUES ('用户管理', 'SYS_SETTING_USERS', '4ea4a780-9986-459c-86ce-55f3bac90081');
INSERT INTO `sys_perms_group` VALUES ('角色管理', 'SYS_PERMS_ROLE', '62d8c1e4-5011-49b5-9d98-6bc2df2bbc76');

-- ----------------------------
-- Table structure for `sys_perms_group_urls`
-- ----------------------------
DROP TABLE IF EXISTS `sys_perms_group_urls`;
CREATE TABLE `sys_perms_group_urls` (
  `id` varchar(40) NOT NULL,
  `perms_group_id` varchar(40) DEFAULT NULL,
  `perms_group_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_perms_group_urls
-- ----------------------------
INSERT INTO `sys_perms_group_urls` VALUES ('047c0e43-2d24-4e36-b75f-025aacd31e36', '62d8c1e4-5011-49b5-9d98-6bc2df2bbc76', '/sys_perms_role_manager/list');
INSERT INTO `sys_perms_group_urls` VALUES ('063a6cd1-9fa3-4a9f-ab4e-9d5267fd5c66', '3e545880-e3b5-4cbb-b212-ec9bfe46e347', '/sys_perms_group_manager/save');
INSERT INTO `sys_perms_group_urls` VALUES ('51878764-0c5a-41e8-a4ed-777f009b6356', '62d8c1e4-5011-49b5-9d98-6bc2df2bbc76', '/sys_perms_role/getPermsRoleInfo');
INSERT INTO `sys_perms_group_urls` VALUES ('567729e3-b3e9-4be8-8268-0effa42bdf6e', '4ea4a780-9986-459c-86ce-55f3bac90081', '/sys_user/del');
INSERT INTO `sys_perms_group_urls` VALUES ('5b2c67ca-4ed2-4c7b-a36f-f666873fb1d1', '4ea4a780-9986-459c-86ce-55f3bac90081', '/sys_user/getUserinfo');
INSERT INTO `sys_perms_group_urls` VALUES ('5e676487-1656-4272-9917-7d78c4bb080d', '4ea4a780-9986-459c-86ce-55f3bac90081', '/sys_user/list');
INSERT INTO `sys_perms_group_urls` VALUES ('732970f9-7354-4007-aa4d-17a5a35d86e2', '62d8c1e4-5011-49b5-9d98-6bc2df2bbc76', '/sys_perms_role/addOrEdit');
INSERT INTO `sys_perms_group_urls` VALUES ('7a7872cb-b8e2-4672-9e2a-9b7f6e6f0566', '62d8c1e4-5011-49b5-9d98-6bc2df2bbc76', '/sys_perms_role_manager/save');
INSERT INTO `sys_perms_group_urls` VALUES ('90542cbb-d003-4849-a02e-5412bb6601ca', '3e545880-e3b5-4cbb-b212-ec9bfe46e347', '/sys_perms_group/getPermsGroupInfo');
INSERT INTO `sys_perms_group_urls` VALUES ('a9faf865-2e25-40e5-9cc8-bb3c900efdeb', '4ea4a780-9986-459c-86ce-55f3bac90081', '/sys_user/addOrEdit');
INSERT INTO `sys_perms_group_urls` VALUES ('bfec8e6c-9335-48c9-9cd6-f1445a3c54d0', '62d8c1e4-5011-49b5-9d98-6bc2df2bbc76', '/sys_perms_role/list');
INSERT INTO `sys_perms_group_urls` VALUES ('f6eb23a0-3aeb-4e15-94c5-9eef6569d065', '3e545880-e3b5-4cbb-b212-ec9bfe46e347', '/sys_perms_group_manager/list');
INSERT INTO `sys_perms_group_urls` VALUES ('f8d1c01b-d6ac-4581-bffc-729d90ab30f0', '3e545880-e3b5-4cbb-b212-ec9bfe46e347', '/sys_perms_group/del');

-- ----------------------------
-- Table structure for `sys_perms_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_perms_role`;
CREATE TABLE `sys_perms_role` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_perms_role
-- ----------------------------
INSERT INTO `sys_perms_role` VALUES ('2bf4e3d3-3241-42d4-9cf9-40c932415508', 'CHARGE_MAN', '收费员');
INSERT INTO `sys_perms_role` VALUES ('8e83e34d-62e2-4699-aba4-1c26db0765c4', 'SUPER_ADMIN', '超级管理员');
INSERT INTO `sys_perms_role` VALUES ('da38dd9d-e2d9-41a6-8758-9abae8739ee1', 'SUB_ADMIN', '子管理员');

-- ----------------------------
-- Table structure for `sys_perms_role_urls`
-- ----------------------------
DROP TABLE IF EXISTS `sys_perms_role_urls`;
CREATE TABLE `sys_perms_role_urls` (
  `id` varchar(40) NOT NULL,
  `role_id` varchar(40) NOT NULL,
  `url` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_perms_role_urls
-- ----------------------------
INSERT INTO `sys_perms_role_urls` VALUES ('0143754a-fa04-4e7a-8827-68d7ab96a5f6', '2bf4e3d3-3241-42d4-9cf9-40c932415508', '/sys_user/list');
INSERT INTO `sys_perms_role_urls` VALUES ('080f0541-7e5c-4da3-a220-cae8ba612b5e', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_user/list');
INSERT INTO `sys_perms_role_urls` VALUES ('0d66b71e-b9fb-408a-9969-9501b9b9193a', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_role/getPermsRoleInfo');
INSERT INTO `sys_perms_role_urls` VALUES ('1179c607-4ee7-4771-bfa7-1f8b3b868639', '2bf4e3d3-3241-42d4-9cf9-40c932415508', '/sys_user/getUserinfo');
INSERT INTO `sys_perms_role_urls` VALUES ('1353b724-0a75-4f04-866c-560fcdd7d71e', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_user/del');
INSERT INTO `sys_perms_role_urls` VALUES ('2292be62-c728-45cc-b2c9-b52f1b12712f', '2bf4e3d3-3241-42d4-9cf9-40c932415508', '/sys_user/addOrEdit');
INSERT INTO `sys_perms_role_urls` VALUES ('2b130d45-23e4-40a7-82f2-23ede486367a', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_role/addOrEdit');
INSERT INTO `sys_perms_role_urls` VALUES ('2c2bf593-303e-4bcc-87fa-782f538d1ec4', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_role/list');
INSERT INTO `sys_perms_role_urls` VALUES ('372db38c-93ca-4af0-bb34-61504ba65a78', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_user/addOrEdit');
INSERT INTO `sys_perms_role_urls` VALUES ('6659343b-a669-4202-a9be-b21ff49497b1', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_user/getUserinfo');
INSERT INTO `sys_perms_role_urls` VALUES ('78c68ee5-867f-4566-a56b-6885af73007a', '2bf4e3d3-3241-42d4-9cf9-40c932415508', '/sys_user/del');
INSERT INTO `sys_perms_role_urls` VALUES ('80197976-2fb7-4810-ad6b-bd09b28ea5c6', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_user/addOrEdit');
INSERT INTO `sys_perms_role_urls` VALUES ('8b5dde8f-370e-49f9-ae47-6048b1b86e30', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_role_manager/save');
INSERT INTO `sys_perms_role_urls` VALUES ('97cc0600-f187-4139-88d7-b0f5047e2b4c', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_group_manager/list');
INSERT INTO `sys_perms_role_urls` VALUES ('a1a366f3-b710-4a74-9473-963920aa4c08', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_user/del');
INSERT INTO `sys_perms_role_urls` VALUES ('a88ae916-5c7c-479e-b947-642fcb8d4f41', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_role/getPermsRoleInfo');
INSERT INTO `sys_perms_role_urls` VALUES ('aabe45e3-c2cc-45c7-a748-8bd4ec4fe605', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_user/list');
INSERT INTO `sys_perms_role_urls` VALUES ('ae3dc278-1053-4e0f-b6fe-a141cece8a1c', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_group/del');
INSERT INTO `sys_perms_role_urls` VALUES ('b4c05fd0-f9e2-443b-8830-89f51b3b7113', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_group/getPermsGroupInfo');
INSERT INTO `sys_perms_role_urls` VALUES ('b6b4d774-e230-4525-9145-42a492886b98', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_user/getUserinfo');
INSERT INTO `sys_perms_role_urls` VALUES ('bdd5f630-2e30-4d85-aa38-22e6826a7c62', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_role_manager/list');
INSERT INTO `sys_perms_role_urls` VALUES ('c8f20548-07af-4157-87e5-9003ff4f46c5', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_group/del');
INSERT INTO `sys_perms_role_urls` VALUES ('ce07003c-153e-40ac-91c5-0654b5ebf30c', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_group/getPermsGroupInfo');
INSERT INTO `sys_perms_role_urls` VALUES ('d17c5b1a-fc4b-4eb9-a1fc-d3264db66668', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_role/list');
INSERT INTO `sys_perms_role_urls` VALUES ('d1e3d6c0-bcc9-42cc-8126-046987087ab2', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_role/addOrEdit');
INSERT INTO `sys_perms_role_urls` VALUES ('db5061f3-f75b-4f21-abaf-14bd5b5875fa', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_role_manager/list');
INSERT INTO `sys_perms_role_urls` VALUES ('db92f6ca-421b-4700-81b5-b93069fe8985', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_role_manager/save');
INSERT INTO `sys_perms_role_urls` VALUES ('dc11d5dc-44ec-4ba3-9026-23ac022ba396', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1', '/sys_perms_group_manager/save');
INSERT INTO `sys_perms_role_urls` VALUES ('e1292ecb-b451-42cf-acf0-2a00bceab5ae', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_group_manager/list');
INSERT INTO `sys_perms_role_urls` VALUES ('fb2e6dd1-3b77-433a-b5f8-a38c58e66e8a', '8e83e34d-62e2-4699-aba4-1c26db0765c4', '/sys_perms_group_manager/save');

-- ----------------------------
-- Table structure for `sys_perms_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_perms_user_role`;
CREATE TABLE `sys_perms_user_role` (
  `id` varchar(40) NOT NULL,
  `user_id` varchar(40) NOT NULL,
  `role_id` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_perms_user_role
-- ----------------------------
INSERT INTO `sys_perms_user_role` VALUES ('5dc1d1c7-a280-471e-94fe-b2bd67faffca', '9ae69f5d-4fa9-4af4-ae81-3f0ad0922a21', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1');
INSERT INTO `sys_perms_user_role` VALUES ('7cb339d0-8514-4e50-9aac-ebae5bc32b51', 'd6b4d96d-8b2f-419c-abd1-8083cb51ddbd', '2bf4e3d3-3241-42d4-9cf9-40c932415508');
INSERT INTO `sys_perms_user_role` VALUES ('8f762b39-6969-472c-ade1-4f5af81297c6', '01e1084a-1e70-4795-be8f-edc913a471e6', '8e83e34d-62e2-4699-aba4-1c26db0765c4');
INSERT INTO `sys_perms_user_role` VALUES ('bb705e06-9179-4ced-a55d-ba258cdad876', '81fdbfd2-4c6f-43f7-a6e8-8e703e9cbef0', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1');
INSERT INTO `sys_perms_user_role` VALUES ('cbde2116-50bd-4e5e-ac6e-ab6d972649d7', 'a87d9a81-bcdf-4e3b-ba23-2e2e083b34ed', '8e83e34d-62e2-4699-aba4-1c26db0765c4');
INSERT INTO `sys_perms_user_role` VALUES ('e09d6c5e-a9cc-4dc0-965a-3eede5c4aac4', '9ae69f5d-4fa9-4af4-ae81-3f0ad0922a21', '2bf4e3d3-3241-42d4-9cf9-40c932415508');
INSERT INTO `sys_perms_user_role` VALUES ('ef755eee-f82f-452d-8df2-3dfdb6a1f7ac', 'd6b4d96d-8b2f-419c-abd1-8083cb51ddbd', 'da38dd9d-e2d9-41a6-8758-9abae8739ee1');
INSERT INTO `sys_perms_user_role` VALUES ('fee2f321-80ff-4c1e-85c2-80a3bbdce602', '867e701e-f089-4321-99ea-7bc957149b5b', '8e83e34d-62e2-4699-aba4-1c26db0765c4');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(40) NOT NULL,
  `username` varchar(32) NOT NULL,
  `nickname` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `date` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `index_id` (`id`),
  KEY `index_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('01e1084a-1e70-4795-be8f-edc913a471e6', 'admin', '系统管理员', '96e79218965eb72c92a549dd5a330112', '2019-03-16 19:56:16');
