/*
 Navicat Premium Data Transfer

 Source Server         : itcast
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : hotel

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 04/06/2022 18:41:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `categoryId` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`categoryId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '岳麓区');
INSERT INTO `category` VALUES (2, '开福区');
INSERT INTO `category` VALUES (3, '雨花区');
INSERT INTO `category` VALUES (4, '天心区');
INSERT INTO `category` VALUES (5, '芙蓉区');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `roomId` int(4) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `roomId`(`roomId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (21, 18, 'guest', '男', '15273124437', '25', '湖南长沙');
INSERT INTO `client` VALUES (22, 24, 'admin', '男', '13467608847', '30', '湖南宁乡');
INSERT INTO `client` VALUES (23, 19, '李龙生大', '男', '15273125564', '30', '湖南宁乡');

-- ----------------------------
-- Table structure for myfile
-- ----------------------------
DROP TABLE IF EXISTS `myfile`;
CREATE TABLE `myfile`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fileUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of myfile
-- ----------------------------
INSERT INTO `myfile` VALUES (10, '', 'F:\\JavaEE-Vue\\pro-server\\out\\artifacts\\GraduationPro_war_exploded\\upload');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `roomId` int(5) NOT NULL AUTO_INCREMENT,
  `price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roomDescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `categoryId` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`roomId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (18, '18', '三室一厅', '130平', '15', '岳麓区青山镇', '是的！房子在出租的时候可以通过广告纸的形式去宣传,但这个广告纸上写的内容是五花八门各种各样的,如果想详细的去介绍你们家的这个房子,可以把房子的一些细节都写上去。', 1);
INSERT INTO `room` VALUES (24, '20000/平', '三室一厅', '130平', '20', '雨花区奥园世家三期', '是的！房子在出租的时候可以通过广告纸的形式去宣传,但这个广告纸上写的内容是五花八门各种各样的,如果想详细的去介绍你们家的这个房子,可以把房子的一些细节都写上去。', 3);
INSERT INTO `room` VALUES (25, '60000/平', '三室一厅', '130平', '12', '芙蓉区安置小区', '在出租的时候可以通过广告纸的形式去宣传,但这个广告纸上写的内容是五花八门各种各样的,如果想详细的去介绍你们家的这个房子,可以把房子的一些细节都写上去。', 5);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(3) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '112233');
INSERT INTO `user` VALUES (2, '李龙生', '123456');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `passWord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (18, 'admin', '123456');
INSERT INTO `users` VALUES (19, 'guest', '112233');
INSERT INTO `users` VALUES (20, '15273124437', '123456');
INSERT INTO `users` VALUES (21, '15273124456', '123456');
INSERT INTO `users` VALUES (22, '13467608845', '123456');

SET FOREIGN_KEY_CHECKS = 1;
