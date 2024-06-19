
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP DATABASE IF EXISTS mi_car;
CREATE DATABASE mi_car;
USE mi_car;

-- ----------------------------
-- Table structure for car_info
-- ----------------------------
DROP TABLE IF EXISTS `car_info`;
CREATE TABLE `car_info`  (
  `vid` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '车辆识别码',
  `carframe_id` int(0) NULL DEFAULT NULL COMMENT '车架编号',
  `battery_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电池类型：三元电池，铁锂电池',
  `mileage` int(0) NULL DEFAULT NULL COMMENT '总里程（km）',
  `battery_health_status` int(0) NULL DEFAULT NULL COMMENT '电池健康状态(%)',
  PRIMARY KEY (`vid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '车辆信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_info
-- ----------------------------
INSERT INTO `car_info` VALUES ('A293HD2SFA3D9G20', 1, '三元电池', 100, 100);
INSERT INTO `car_info` VALUES ('G3H2JSF823KLFD45', 3, '三元电池', 300, 98);
INSERT INTO `car_info` VALUES ('S102YYYY384762BA', 2, '铁锂电池', 600, 95);

-- ----------------------------
-- Table structure for rule_info
-- ----------------------------
DROP TABLE IF EXISTS `rule_info`;
CREATE TABLE `rule_info`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `rule_id` int(0) NULL DEFAULT NULL COMMENT '规则编号',
  `rule_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '规则名称',
  `battery_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电池类型',
  `voltage_diff` double NULL DEFAULT NULL COMMENT '最高电压与最小电压之差',
  `current_diff` double NULL DEFAULT NULL COMMENT '最高电流与最小电流之差',
  `alert_level` int(0) NULL DEFAULT NULL COMMENT '报警等级：0-4，0等级最高',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统预警规则表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rule_info
-- ----------------------------
INSERT INTO `rule_info` VALUES (1, 1, '电压差报警', '三元电池', 5, NULL, 0);
INSERT INTO `rule_info` VALUES (2, 1, '电压差报警', '三元电池', 3, NULL, 1);
INSERT INTO `rule_info` VALUES (3, 1, '电压差报警', '三元电池', 1, NULL, 2);
INSERT INTO `rule_info` VALUES (4, 1, '电压差报警', '三元电池', 0.6, NULL, 3);
INSERT INTO `rule_info` VALUES (5, 1, '电压差报警', '三元电池', 0.2, NULL, 4);
INSERT INTO `rule_info` VALUES (6, 1, '电压差报警', '三元电池', -1, NULL, 5);
INSERT INTO `rule_info` VALUES (7, 1, '电压差报警', '铁锂电池', 2, NULL, 0);
INSERT INTO `rule_info` VALUES (8, 1, '电压差报警', '铁锂电池', 1, NULL, 1);
INSERT INTO `rule_info` VALUES (9, 1, '电压差报警', '铁锂电池', 0.7, NULL, 2);
INSERT INTO `rule_info` VALUES (10, 1, '电压差报警', '铁锂电池', 0.4, NULL, 3);
INSERT INTO `rule_info` VALUES (11, 1, '电压差报警', '铁锂电池', 0.2, NULL, 4);
INSERT INTO `rule_info` VALUES (12, 1, '电压差报警', '铁锂电池', -1, NULL, 5);
INSERT INTO `rule_info` VALUES (13, 2, '电流差报警', '三元电池', NULL, 3, 0);
INSERT INTO `rule_info` VALUES (14, 2, '电流差报警', '三元电池', NULL, 1, 1);
INSERT INTO `rule_info` VALUES (15, 2, '电流差报警', '三元电池', NULL, 0.2, 2);
INSERT INTO `rule_info` VALUES (16, 2, '电流差报警', '三元电池', NULL, -1, 5);
INSERT INTO `rule_info` VALUES (17, 2, '电流差报警', '铁锂电池', NULL, 1, 0);
INSERT INTO `rule_info` VALUES (18, 2, '电流差报警', '铁锂电池', NULL, 0.5, 1);
INSERT INTO `rule_info` VALUES (19, 2, '电流差报警', '铁锂电池', NULL, 0.2, 2);
INSERT INTO `rule_info` VALUES (20, 2, '电流差报警', '铁锂电池', NULL, -1, 5);

SET FOREIGN_KEY_CHECKS = 1;
