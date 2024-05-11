/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 100422
 Source Host           : localhost:3306
 Source Schema         : friends_house

 Target Server Type    : MySQL
 Target Server Version : 100422
 File Encoding         : 65001

 Date: 17/12/2021 02:49:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for deposit
-- ----------------------------
DROP TABLE IF EXISTS `deposit`;
CREATE TABLE `deposit`  (
  `depositId` int(11) NOT NULL AUTO_INCREMENT,
  `mId` int(11) NULL DEFAULT NULL,
  `amount` double(4, 0) NULL DEFAULT NULL,
  `paymentDate` date NULL DEFAULT NULL,
  `forMonth` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `forYear` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`depositId`) USING BTREE,
  INDEX `f1`(`mId`) USING BTREE,
  CONSTRAINT `f1` FOREIGN KEY (`mId`) REFERENCES `member` (`mId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of deposit
-- ----------------------------
INSERT INTO `deposit` VALUES (5, 13, 2000, '2021-12-16', '11', '2021');
INSERT INTO `deposit` VALUES (6, 11, 4000, '2021-12-14', '10', '2021');

-- ----------------------------
-- Table structure for fixedexpense
-- ----------------------------
DROP TABLE IF EXISTS `fixedexpense`;
CREATE TABLE `fixedexpense`  (
  `fixedExpenseId` int(11) NOT NULL AUTO_INCREMENT,
  `fixedExpenseName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `amount` double(10, 2) NULL DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`fixedExpenseId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of fixedexpense
-- ----------------------------
INSERT INTO `fixedexpense` VALUES (2, 'House Rent', 12000.00, 'Active');
INSERT INTO `fixedexpense` VALUES (3, 'Gas Bill', 975.00, 'Active');
INSERT INTO `fixedexpense` VALUES (4, 'Electricity', 1200.00, 'Active');

-- ----------------------------
-- Table structure for foodshopping
-- ----------------------------
DROP TABLE IF EXISTS `foodshopping`;
CREATE TABLE `foodshopping`  (
  `RegularShoppingId` int(11) NOT NULL AUTO_INCREMENT,
  `mId` int(11) NULL DEFAULT NULL,
  `amount` double(5, 2) NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`RegularShoppingId`) USING BTREE,
  INDEX `f2`(`mId`) USING BTREE,
  CONSTRAINT `f2` FOREIGN KEY (`mId`) REFERENCES `member` (`mId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 104 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of foodshopping
-- ----------------------------
INSERT INTO `foodshopping` VALUES (101, 11, 200.00, '2021-12-16');
INSERT INTO `foodshopping` VALUES (102, 13, 200.00, '2021-12-02');

-- ----------------------------
-- Table structure for meal
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal`  (
  `mealId` int(11) NOT NULL AUTO_INCREMENT,
  `mId` int(11) NULL DEFAULT NULL,
  `mealNum` int(3) NULL DEFAULT 0,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`mealId`) USING BTREE,
  INDEX `f7`(`mId`) USING BTREE,
  CONSTRAINT `f7` FOREIGN KEY (`mId`) REFERENCES `member` (`mId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of meal
-- ----------------------------
INSERT INTO `meal` VALUES (1, 11, 1, '2021-12-06');
INSERT INTO `meal` VALUES (2, 12, 2, '2021-12-16');
INSERT INTO `meal` VALUES (3, 13, 3, '2021-12-14');
INSERT INTO `meal` VALUES (4, 12, 4, '2021-12-15');
INSERT INTO `meal` VALUES (5, 11, 1, '2021-11-15');
INSERT INTO `meal` VALUES (6, 13, 2, '2021-11-14');
INSERT INTO `meal` VALUES (7, 11, 0, '2021-11-09');
INSERT INTO `meal` VALUES (8, 13, 1, '2021-11-02');
INSERT INTO `meal` VALUES (9, 14, 2, '2021-11-01');
INSERT INTO `meal` VALUES (10, 14, 1, '2021-10-19');
INSERT INTO `meal` VALUES (11, 14, 3, '2021-11-14');
INSERT INTO `meal` VALUES (12, 13, 1, '2021-10-07');
INSERT INTO `meal` VALUES (13, 14, 3, '2022-10-06');
INSERT INTO `meal` VALUES (14, 11, 1, '2021-10-04');
INSERT INTO `meal` VALUES (15, 12, 3, '2021-10-02');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `mId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'active',
  `NID` varchar(17) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`mId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (11, 'Shahanaz ', '01700000000', 'Shahanaz@diu.edu.bd', '1234', 'Dhaka', 'manager', 'active', 'ir2345678');
INSERT INTO `member` VALUES (12, 'Halima Islam', '01800000000', 'Halima@diu.edu.bd', '1234', 'Dhaka', 'regular', 'active', 'dfh456321');
INSERT INTO `member` VALUES (13, 'Sadia Akter', '014789654785', 'Sadia@diu.edu.bd', '1234', 'Dhaka', 'guest', 'active', '495mm877');
INSERT INTO `member` VALUES (14, 'Jita Shanti Rani', '01540000004', 'Jita@diu.edu.bd', '1234', 'Dhaka', 'regular', 'Inactive', '984jk123');
INSERT INTO `member` VALUES (15, 'Kazi Ilma', '01444444444444', 'Kazi@diu.edu.bd', '1234', 'Dhaka', 'guest', 'active', '4353455');
INSERT INTO `member` VALUES (16, 'Tamim', '0160000000000', 'Tamim@diu.edu.bd', '1234', 'Dhaka', 'regular member', 'active', '214315346nvbn');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `paymentId` int(11) NOT NULL AUTO_INCREMENT,
  `mId` int(11) NULL DEFAULT NULL,
  `amount` double(6, 2) NULL DEFAULT NULL,
  `paymentDate` date NULL DEFAULT NULL,
  `forMonth` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `forYear` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`paymentId`) USING BTREE,
  INDEX `f4`(`mId`) USING BTREE,
  CONSTRAINT `f4` FOREIGN KEY (`mId`) REFERENCES `member` (`mId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of payment
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
