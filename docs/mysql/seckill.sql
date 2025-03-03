CREATE
    DATABASE IF NOT EXISTS `seckill`
    DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `seckill`;

-- ----------------------------
-- Table structure for seckill_activity
-- ----------------------------

DROP TABLE IF EXISTS `seckill_activity`;

CREATE TABLE `seckill_activity`
(
    `id`            bigint unsigned NOT NULL COMMENT '秒杀活动id',
    `activity_name` varchar(128)    NOT NULL COMMENT '活动名称',
    `start_time`    datetime        NULL     DEFAULT NULL COMMENT '开始时间',
    `end_time`      datetime        NULL     DEFAULT NULL COMMENT '结束时间',
    `status`        int             NOT NULL DEFAULT 0 COMMENT '状态：0：已发布； 1：上线； 2：下线',
    `description`   varchar(255)    NULL     DEFAULT '' COMMENT '活动描述',
    `create_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '秒杀活动';

-- ----------------------------
-- Table structure for seckill_goods
-- ----------------------------
DROP TABLE IF EXISTS `seckill_goods`;

CREATE TABLE `seckill_goods`
(
    `id`              bigint unsigned NOT NULL COMMENT '商品id',
    `goods_name`      varchar(128)    NOT NULL COMMENT '商品名称',
    `activity_id`     bigint unsigned NULL     DEFAULT 0 COMMENT '活动id',
    `start_time`      datetime        NULL     DEFAULT NULL COMMENT '开始时间',
    `end_time`        datetime        NULL     DEFAULT NULL COMMENT '结束时间',
    `original_price`  decimal(10, 2)  NULL     DEFAULT 0.00 COMMENT '商品原价格',
    `activity_price`  decimal(10, 2)  NULL     DEFAULT 0.00 COMMENT '商品秒杀价格',
    `initial_stock`   int             NULL     DEFAULT 0 COMMENT '商品初始库存',
    `available_stock` int             NULL     DEFAULT 0 COMMENT '商品当前可用库存',
    `description`     varchar(255)    NULL     DEFAULT '' COMMENT '商品描述',
    `img_url`         varchar(255)    NULL     DEFAULT '' COMMENT '商品图片',
    `status`          int             NULL     DEFAULT 0 COMMENT '状态，0：已发布； 1：上线； 2：下线',
    `limit_num`       int unsigned    NULL     DEFAULT 1 COMMENT '限购个数',
    `create_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '秒杀商品表';


-- ----------------------------
-- Table structure for seckill_order
-- ----------------------------
DROP TABLE IF EXISTS `seckill_order`;

CREATE TABLE `seckill_order`
(
    `id`             bigint unsigned NOT NULL COMMENT '订单id',
    `user_id`        bigint unsigned NULL     DEFAULT 0 COMMENT '用户id',
    `goods_id`       bigint unsigned NULL     DEFAULT 0 COMMENT '商品id',
    `goods_name`     varchar(128)    NULL     DEFAULT '' COMMENT '商品名称',
    `activity_price` decimal(10, 2)  NULL     DEFAULT 0.00 COMMENT '秒杀价格',
    `quantity`       int unsigned    NULL     DEFAULT 0 COMMENT '下单商品数量',
    `order_price`    decimal(10, 2)  NULL     DEFAULT 0.00 COMMENT '订单总金额',
    `activity_id`    bigint unsigned NULL     DEFAULT 0 COMMENT '活动id',
    `status`         int             NULL     DEFAULT 0 COMMENT '订单状态 1：已创建 2：已支付 0：已取消； -1：已删除',
    `create_time`    datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '秒杀订单表';


-- ----------------------------
-- Table structure for seckill_user
-- ----------------------------
DROP TABLE IF EXISTS `seckill_user`;

CREATE TABLE `seckill_user`
(
    `id`          bigint unsigned NOT NULL COMMENT '用户id',
    `user_name`   varchar(20)     NOT NULL COMMENT '用户名',
    `password`    varchar(64)     NULL     DEFAULT '' COMMENT '密码',
    `status`      int             NOT NULL COMMENT '状态，1：正常；2：冻结',
    `create_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户';

-- ----------------------------
-- Table structure for seckill_reservation_config
-- ----------------------------
DROP TABLE IF EXISTS `seckill_reservation_config`;

CREATE TABLE `seckill_reservation_config`
(
    `id`                         bigint unsigned NOT NULL COMMENT '数据主键',
    `goods_id`                   bigint unsigned NOT NULL COMMENT '商品id',
    `goods_name`                 varchar(100)    NULL     DEFAULT '' COMMENT '商品名称',
    `reserve_max_user_count`     int unsigned    NULL     DEFAULT 0 COMMENT '预约人数上限，不做严格限制',
    `reserve_current_user_count` int unsigned    NULL     DEFAULT 0 COMMENT '当前预约人数，实际可比预约人数上限大，也可比其小，在一定范围内即可',
    `reserve_start_time`         datetime        NULL     DEFAULT NULL COMMENT '预约开始时间',
    `reserve_end_time`           datetime        NULL     DEFAULT NULL COMMENT '预约结束时间',
    `seckill_start_time`         datetime        NULL     DEFAULT NULL COMMENT '秒杀开始时间',
    `seckill_end_time`           datetime        NULL     DEFAULT NULL COMMENT '秒杀结束时间',
    `status`                     int             NOT NULL COMMENT '状态，0：已发布，1：上线；-1：下线',
    `create_time`                datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`                datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uidx_goods_id` (`goods_id`) USING BTREE COMMENT '一个秒杀商品存在一条预约规则信息'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '针对商品配置的预约配置表';

-- ----------------------------
-- Table structure for seckill_reservation_user
-- ----------------------------
DROP TABLE IF EXISTS `seckill_reservation_user`;

CREATE TABLE `seckill_reservation_user`
(
    `id`                bigint unsigned NOT NULL COMMENT '数据主键',
    `reserve_config_id` bigint unsigned NULL     DEFAULT 0 COMMENT '预约配置id',
    `goods_id`          bigint unsigned NULL     DEFAULT 0 COMMENT '商品id',
    `goods_name`        varchar(100)    NULL     DEFAULT '' COMMENT '商品名称',
    `user_id`           bigint unsigned NULL     DEFAULT 0 COMMENT '用户id',
    `reserve_time`      datetime        NULL     DEFAULT NULL COMMENT '预约时间',
    `status`            int             NOT NULL COMMENT '状态，1：正常；0：删除',
    `create_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_user_id` (`user_id`) USING BTREE COMMENT '用户id索引',
    INDEX `idx_goods_id` (`goods_id`) USING BTREE COMMENT '商品id索引'
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户预约商品的记录表';

