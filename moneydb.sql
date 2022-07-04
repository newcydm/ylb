/*
 Navicat Premium Data Transfer

 Source Server         : 成语代码
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : moneydb

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 04/07/2022 14:39:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_bid_info
-- ----------------------------
DROP TABLE IF EXISTS `b_bid_info`;
CREATE TABLE `b_bid_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '投标记录ID',
  `loan_id` int(11) NOT NULL COMMENT '产品ID',
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `bid_money` double NOT NULL COMMENT '投标金额',
  `bid_time` datetime NOT NULL COMMENT '投标时间',
  `bid_status` int(11) NOT NULL COMMENT '投标状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3252 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '投资记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_bid_info
-- ----------------------------
INSERT INTO `b_bid_info` VALUES (1, 1, 11, 10000, '2022-06-16 00:00:00', 1);
INSERT INTO `b_bid_info` VALUES (2, 1, 12, 20000, '2022-06-16 00:00:00', 1);
INSERT INTO `b_bid_info` VALUES (3, 1, 13, 30000, '2022-06-16 00:00:00', 1);
INSERT INTO `b_bid_info` VALUES (4, 1, 14, 40000, '2022-06-16 00:00:00', 1);
INSERT INTO `b_bid_info` VALUES (3027, 7, 1, 1, '2017-08-20 15:04:54', 1);
INSERT INTO `b_bid_info` VALUES (3028, 7, 5, 8084, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3029, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3030, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3031, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3032, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3033, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3034, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3035, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3036, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3037, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3038, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3039, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3040, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3041, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3042, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3043, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3044, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3045, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3046, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3047, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3048, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3049, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3050, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3051, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3052, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3053, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3054, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3055, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3056, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3057, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3058, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3059, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3060, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3061, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3062, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3063, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3064, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3065, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3066, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3067, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3068, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3069, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3070, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3071, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3072, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3073, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3074, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3075, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3076, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3077, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3078, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3079, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3080, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3081, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3082, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3083, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3084, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3085, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3086, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3087, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3088, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3089, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3090, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3091, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3092, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3093, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3094, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3095, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3096, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3097, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3098, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3099, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3100, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3101, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3102, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3103, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3104, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3105, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3106, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3107, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3108, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3109, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3110, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3111, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3112, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3113, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3114, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3115, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3116, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3117, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3118, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3119, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3120, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3121, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3122, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3123, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3124, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3125, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3126, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3127, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3128, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3129, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3130, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3131, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3132, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3133, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3134, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3135, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3136, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3137, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3138, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3139, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3140, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3141, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3142, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3143, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3144, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3145, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3146, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3147, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3148, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3149, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3150, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3151, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3152, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3153, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3154, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3155, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3156, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3157, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3158, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3159, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3160, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3161, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3162, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3163, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3164, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3165, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3166, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3167, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3168, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3169, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3170, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3171, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3172, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3173, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3174, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3175, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3176, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3177, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3178, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3179, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3180, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3181, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3182, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3183, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3184, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3185, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3186, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3187, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3188, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3189, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3190, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3191, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3192, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3193, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3194, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3195, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3196, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3197, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3198, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3199, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3200, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3201, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3202, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3203, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3204, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3205, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3206, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3207, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3208, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3209, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3210, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3211, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3212, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3213, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3214, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3215, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3216, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3217, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3218, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3219, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3220, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3221, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3222, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3223, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3224, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3225, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3226, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3227, 1, 1, 100, '2017-08-20 15:09:56', 1);
INSERT INTO `b_bid_info` VALUES (3229, 1310699, 1, 200, '2022-06-15 10:54:36', 1);
INSERT INTO `b_bid_info` VALUES (3230, 1310699, 1, 2000, '2022-06-15 11:01:59', 1);
INSERT INTO `b_bid_info` VALUES (3231, 1310699, 1, 500, '2022-06-15 11:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3232, 1310699, 1, 400, '2022-06-15 11:18:02', 1);
INSERT INTO `b_bid_info` VALUES (3233, 1310699, 1, 500, '2022-06-15 11:31:25', 1);
INSERT INTO `b_bid_info` VALUES (3234, 1310699, 1, 200, '2022-06-15 11:41:18', 1);
INSERT INTO `b_bid_info` VALUES (3235, 1310699, 1, 500, '2022-06-15 11:44:04', 1);
INSERT INTO `b_bid_info` VALUES (3236, 1310699, 1, 200, '2022-06-15 12:49:00', 1);
INSERT INTO `b_bid_info` VALUES (3237, 1310699, 1, 200, '2022-06-15 12:49:07', 1);
INSERT INTO `b_bid_info` VALUES (3238, 1310699, 1, 500, '2022-06-15 12:49:12', 1);
INSERT INTO `b_bid_info` VALUES (3239, 1310699, 1, 200, '2022-06-15 14:00:45', 1);
INSERT INTO `b_bid_info` VALUES (3240, 1310699, 1, 200, '2022-06-15 14:00:57', 1);
INSERT INTO `b_bid_info` VALUES (3241, 1310699, 23, 10000, '2022-06-18 11:38:18', 1);
INSERT INTO `b_bid_info` VALUES (3242, 1310699, 23, 400, '2022-06-18 21:19:53', 1);
INSERT INTO `b_bid_info` VALUES (3243, 1310699, 23, 1000, '2022-06-19 12:39:12', 1);
INSERT INTO `b_bid_info` VALUES (3244, 1310699, 23, 1100, '2022-06-19 12:39:24', 1);
INSERT INTO `b_bid_info` VALUES (3245, 1310699, 23, 200, '2022-06-20 19:11:07', 1);
INSERT INTO `b_bid_info` VALUES (3246, 1310695, 23, 100, '2022-06-20 19:21:56', 1);
INSERT INTO `b_bid_info` VALUES (3247, 1310695, 23, 100, '2022-06-20 19:22:02', 1);
INSERT INTO `b_bid_info` VALUES (3248, 1310699, 23, 800, '2022-06-20 19:29:25', 1);
INSERT INTO `b_bid_info` VALUES (3249, 1310699, 23, 1000, '2022-06-20 19:36:35', 1);
INSERT INTO `b_bid_info` VALUES (3250, 1310699, 23, 600, '2022-06-20 20:33:59', 1);
INSERT INTO `b_bid_info` VALUES (3251, 1310699, 23, 500, '2022-06-20 20:40:20', 1);

-- ----------------------------
-- Table structure for b_income_record
-- ----------------------------
DROP TABLE IF EXISTS `b_income_record`;
CREATE TABLE `b_income_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `loan_id` int(11) NOT NULL COMMENT '产品ID',
  `bid_id` int(11) NOT NULL COMMENT '投标记录ID',
  `bid_money` double NOT NULL COMMENT '投资金额',
  `income_date` date NOT NULL COMMENT '收益时间',
  `income_money` double NOT NULL COMMENT '收益金额',
  `income_status` int(11) NOT NULL COMMENT '收益状态（0未返，1已返）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 313 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收益记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_income_record
-- ----------------------------
INSERT INTO `b_income_record` VALUES (203, 1, 6, 214, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (204, 1, 6, 215, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (205, 1, 6, 216, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (206, 1, 6, 217, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (207, 1, 6, 218, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (208, 1, 6, 219, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (209, 1, 6, 220, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (210, 1, 6, 221, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (211, 1, 6, 222, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (212, 1, 6, 223, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (213, 1, 6, 224, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (214, 1, 6, 225, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (215, 1, 6, 226, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (216, 1, 6, 227, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (217, 1, 6, 228, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (218, 1, 6, 229, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (219, 1, 6, 230, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (220, 1, 6, 231, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (221, 1, 6, 232, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (222, 1, 6, 233, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (223, 1, 6, 234, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (224, 1, 6, 235, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (225, 1, 6, 236, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (226, 1, 6, 237, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (227, 1, 6, 238, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (228, 1, 6, 239, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (229, 1, 6, 240, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (230, 1, 6, 241, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (231, 1, 6, 242, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (232, 1, 6, 243, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (233, 1, 6, 244, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (234, 1, 6, 245, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (235, 1, 6, 246, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (236, 1, 6, 247, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (237, 1, 6, 248, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (238, 1, 6, 249, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (239, 1, 6, 250, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (240, 1, 6, 251, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (241, 1, 6, 252, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (242, 1, 6, 253, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (243, 1, 6, 254, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (244, 1, 6, 255, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (245, 1, 6, 256, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (246, 1, 6, 257, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (247, 1, 6, 258, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (248, 1, 6, 259, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (249, 1, 6, 260, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (250, 1, 6, 261, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (251, 1, 6, 262, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (252, 1, 6, 263, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (253, 1, 6, 264, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (254, 1, 6, 265, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (255, 1, 6, 266, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (256, 1, 6, 267, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (257, 1, 6, 268, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (258, 1, 6, 269, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (259, 1, 6, 270, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (260, 1, 6, 271, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (261, 1, 6, 272, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (262, 1, 6, 273, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (263, 1, 6, 274, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (264, 1, 6, 275, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (265, 1, 6, 276, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (266, 1, 6, 277, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (267, 1, 6, 278, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (268, 1, 6, 279, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (269, 1, 6, 280, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (270, 1, 6, 281, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (271, 1, 6, 282, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (272, 1, 6, 283, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (273, 1, 6, 284, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (274, 1, 6, 285, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (275, 1, 6, 286, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (276, 1, 6, 287, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (277, 1, 6, 288, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (278, 1, 6, 289, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (279, 1, 6, 290, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (280, 1, 6, 291, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (281, 1, 6, 292, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (282, 1, 6, 293, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (283, 1, 6, 294, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (284, 1, 6, 295, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (285, 1, 6, 296, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (286, 1, 6, 297, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (287, 1, 6, 298, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (288, 1, 6, 299, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (289, 1, 6, 300, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (290, 1, 6, 301, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (291, 1, 6, 302, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (292, 1, 6, 303, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (293, 1, 6, 304, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (294, 1, 6, 305, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (295, 1, 6, 306, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (296, 1, 6, 307, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (297, 1, 6, 308, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (298, 1, 6, 309, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (299, 1, 6, 310, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (300, 2, 6, 311, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (301, 1, 6, 312, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (302, 1, 6, 313, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (307, 1, 1, 3227, 100, '2022-12-16', 3, 0);
INSERT INTO `b_income_record` VALUES (308, 11, 1, 1, 10000, '2022-06-16', 242, 1);
INSERT INTO `b_income_record` VALUES (309, 12, 1, 2, 20000, '2022-06-16', 484, 1);
INSERT INTO `b_income_record` VALUES (310, 13, 1, 3, 30000, '2022-06-16', 725, 1);
INSERT INTO `b_income_record` VALUES (311, 14, 1, 4, 40000, '2022-06-16', 967, 1);
INSERT INTO `b_income_record` VALUES (312, 1, 1, 3227, 100, '2022-12-16', 3, 0);

-- ----------------------------
-- Table structure for b_loan_info
-- ----------------------------
DROP TABLE IF EXISTS `b_loan_info`;
CREATE TABLE `b_loan_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `rate` double NOT NULL COMMENT '产品利率',
  `cycle` int(11) NOT NULL COMMENT '产品期限',
  `release_time` date NOT NULL COMMENT '产品发布时间',
  `product_type` int(11) NOT NULL COMMENT '产品类型 0新手宝，1优选产品，2散标产品',
  `product_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品编号',
  `product_money` double NOT NULL COMMENT '产品金额',
  `left_product_money` double NOT NULL COMMENT '产品剩余可投金额',
  `bid_min_limit` double NOT NULL COMMENT '最低投资金额，即起投金额',
  `bid_max_limit` double NOT NULL COMMENT '最高投资金额，即最多能投多少金额',
  `product_status` int(11) NOT NULL COMMENT '产品状态（0未满标，1已满标，2满标已生成收益计划）',
  `product_full_time` datetime NULL DEFAULT NULL COMMENT '产品投资满标时间',
  `product_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品描述',
  `version` int(11) NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1310700 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_loan_info
-- ----------------------------
INSERT INTO `b_loan_info` VALUES (1, '个人信用消费借款1', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 0, 100, 100, 2, '2022-06-16 00:00:00', '个人消费借款，信用良好，购车消费，精英人士', 4);
INSERT INTO `b_loan_info` VALUES (2, '个人信用消费借款2', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 99696, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (3, '个人信用消费借款3', 4.9, 6, '2017-07-24', 2, '20170722', 100, 0, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `b_loan_info` VALUES (4, '个人信用消费借款4', 4.9, 6, '2017-07-24', 2, '20170722', 100, 0, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `b_loan_info` VALUES (6, '个人信用消费借款', 4.9, 1, '2017-07-24', 2, '20170722', 100, 0, 100, 100, 2, '2017-07-16 16:54:06', '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `b_loan_info` VALUES (7, '个人信用', 4.9, 6, '2017-07-24', 2, '20170722', 200, 0, 1, 100, 2, '2017-08-20 15:05:02', '个人消费借款，信用良好，购车消费，精英人士', 199);
INSERT INTO `b_loan_info` VALUES (8, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, '2017-02-19 11:12:12', '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (9, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (13, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (14, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (15, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (16, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (17, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (18, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (19, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (20, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (28, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (29, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (30, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (31, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (32, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (33, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (34, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (35, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (36, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (37, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (38, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (39, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (40, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (41, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (42, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (43, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (59, '个人信用消费借款', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (1310694, '满月宝', 5.6, 1, '2017-07-26', 1, '20170726', 1000000, 98600, 100, 100, 0, NULL, '短期信贷金融消费产品', 14);
INSERT INTO `b_loan_info` VALUES (1310695, '季度宝', 5.8, 1, '2017-07-26', 1, '20170726', 1000000, 99700, 100, 100, 0, NULL, '短期信贷金融消费产品', 3);
INSERT INTO `b_loan_info` VALUES (1310696, '双季宝', 6.5, 1, '2017-07-26', 1, '20170726', 1000000, 100000, 100, 100, 0, NULL, '短期信贷金融消费产品', 0);
INSERT INTO `b_loan_info` VALUES (1310697, '年度宝', 8.5, 1, '2017-07-26', 1, '20170726', 1000000, 100000, 100, 100, 0, NULL, '短期信贷金融消费产品', 0);
INSERT INTO `b_loan_info` VALUES (1310699, '新手宝', 15, 7, '2017-07-26', 0, '20170726', 100000, 78101, 100, 5000, 0, NULL, '短期信贷金融消费产品', 23);

-- ----------------------------
-- Table structure for b_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `b_recharge_record`;
CREATE TABLE `b_recharge_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户id',
  `recharge_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值订单号',
  `recharge_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值订单状态（0充值中，1充值成功，2充值失败）',
  `recharge_money` double NOT NULL COMMENT '充值金额',
  `recharge_time` datetime NOT NULL COMMENT '充值时间',
  `recharge_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 99 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充值记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_recharge_record
-- ----------------------------
INSERT INTO `b_recharge_record` VALUES (87, 23, '20220620100031473', '2', 520, '2022-06-20 10:00:31', '快钱充值');
INSERT INTO `b_recharge_record` VALUES (88, 23, '20220620103522768', '1', 520, '2022-06-20 10:35:22', '快钱充值');
INSERT INTO `b_recharge_record` VALUES (89, 23, '20220620103726601', '1', 250, '2022-06-20 10:37:26', '支付宝充值');
INSERT INTO `b_recharge_record` VALUES (90, 23, '20220620104301103', '1', 330, '2022-06-20 10:43:01', '快钱充值');
INSERT INTO `b_recharge_record` VALUES (91, 23, '20220620104445879', '1', 500, '2022-06-20 10:44:45', '快钱充值');
INSERT INTO `b_recharge_record` VALUES (92, 23, '20220620112050775', '1', 500, '2022-06-20 11:20:50', '快钱充值');
INSERT INTO `b_recharge_record` VALUES (93, 23, '20220620112231753', '1', 250, '2022-06-20 11:22:31', '支付宝充值');
INSERT INTO `b_recharge_record` VALUES (94, 23, '20220620191838393', '2', 200, '2022-06-20 19:18:38', '快钱充值');
INSERT INTO `b_recharge_record` VALUES (95, 23, '20220620192316155', '2', 200, '2022-06-20 19:23:16', '快钱充值');
INSERT INTO `b_recharge_record` VALUES (96, 23, '20220620193242387', '1', 50000, '2022-06-20 19:32:42', '支付宝充值');
INSERT INTO `b_recharge_record` VALUES (97, 23, '20220703171627700', '0', 200, '2022-07-03 17:16:27', '支付宝充值');
INSERT INTO `b_recharge_record` VALUES (98, 23, '20220703183353259', '0', 200, '2022-07-03 18:33:53', '快钱充值');

-- ----------------------------
-- Table structure for u_finance_account
-- ----------------------------
DROP TABLE IF EXISTS `u_finance_account`;
CREATE TABLE `u_finance_account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '用户ID',
  `available_money` double(15, 2) NOT NULL COMMENT '用户可用资金',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户财务资金账户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_finance_account
-- ----------------------------
INSERT INTO `u_finance_account` VALUES (1, 1, 992048.61);
INSERT INTO `u_finance_account` VALUES (2, 5, 999999800.00);
INSERT INTO `u_finance_account` VALUES (3, 17, 5000.00);
INSERT INTO `u_finance_account` VALUES (4, 23, 47950.00);
INSERT INTO `u_finance_account` VALUES (5, 18, 0.00);
INSERT INTO `u_finance_account` VALUES (11, 11, 20242.00);
INSERT INTO `u_finance_account` VALUES (12, 12, 30484.00);
INSERT INTO `u_finance_account` VALUES (13, 13, 40725.00);
INSERT INTO `u_finance_account` VALUES (14, 14, 50967.00);

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '注册手机号码',
  `login_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码，密码长度最大16位',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户身份证号码',
  `add_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最近登录时间',
  `header_image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像文件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES (1, '13700000000', 'e10adc3949ba59abbe56e057f20f883e', '张无忌', '222222222222222222', '2017-08-20 12:40:28', '2022-06-18 21:20:35', NULL);
INSERT INTO `u_user` VALUES (5, '13700000001', '003d81296cbed643579b24d1cf6c907c', '张三丰', '111111111111111111', '2017-08-20 12:40:32', '2017-08-20 11:30:22', NULL);
INSERT INTO `u_user` VALUES (6, '13700000002', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (7, '13700000003', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (8, '13700000004', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (9, '13700000005', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (10, '13700000006', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (11, '13700000007', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (12, '13700000008', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (13, '13700000009', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (14, '13700000010', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (15, '13700000011', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (16, '13700000012', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (17, '13700000013', 'e10adc3949ba59abbe56e057f20f883e', '', '', '2017-08-03 15:05:25', '2022-06-14 20:51:34', NULL);
INSERT INTO `u_user` VALUES (18, '13700000014', 'e10adc3949ba59abbe56e057f20f883e', '刘燕春', '350122197908109053', '2017-08-03 15:06:46', '2017-08-03 15:06:46', NULL);
INSERT INTO `u_user` VALUES (19, '13700000015', '003d81296cbed643579b24d1cf6c907c', NULL, NULL, '2017-08-07 10:02:27', '2017-08-07 10:02:27', NULL);
INSERT INTO `u_user` VALUES (21, '13700000016', '003d81296cbed643579b24d1cf6c907c', NULL, NULL, '2017-08-07 10:13:34', '2017-08-07 10:13:34', NULL);
INSERT INTO `u_user` VALUES (22, '13700000017', '003d81296cbed643579b24d1cf6c907c', NULL, NULL, '2017-08-07 10:57:00', '2017-08-07 10:57:00', NULL);
INSERT INTO `u_user` VALUES (23, '17607088005', 'f58b1cfacec42a4dbd8816c8fd531661', '王建宇', '361102198201057714', '2022-06-14 08:59:58', '2022-07-03 18:30:28', NULL);

SET FOREIGN_KEY_CHECKS = 1;
