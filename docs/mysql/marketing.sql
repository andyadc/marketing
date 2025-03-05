## User points account
SET NAMES utf8mb4;
CREATE database if NOT EXISTS `marketing` default character set utf8mb4;
use `marketing`;

# ------------------------------------------------------------
DROP TABLE IF EXISTS `award`;
CREATE TABLE `award`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `award_id`     int             NOT NULL COMMENT '抽奖奖品ID - 内部流转使用',
    `award_key`    varchar(32)     NOT NULL COMMENT '奖品对接标识 - 每一个都是一个对应的发奖策略',
    `award_config` varchar(64)     NOT NULL COMMENT '奖品配置信息',
    `award_desc`   varchar(256)    NOT NULL COMMENT '奖品内容描述',
    `create_time`  datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_award_id` (`award_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='奖品表';

LOCK TABLES `award` WRITE;

INSERT INTO `award` (`award_id`, `award_key`, `award_config`, `award_desc`, `create_time`, `update_time`)
VALUES (101, 'user_credit_random', '1,100', '用户积分【优先透彻规则范围，如果没有则走配置】', now(), now()),
       (102, 'openai_use_count', '5', 'OpenAI 增加使用次数', now(), now()),
       (103, 'openai_use_count', '10', 'OpenAI 增加使用次数', now(), now()),
       (104, 'openai_use_count', '20', 'OpenAI 增加使用次数', now(), now()),
       (105, 'openai_model', 'gpt-4', 'OpenAI 增加模型', now(), now()),
       (106, 'openai_model', 'dall-e-2', 'OpenAI 增加模型', now(), now()),
       (107, 'openai_model', 'dall-e-3', 'OpenAI 增加模型', now(), now()),
       (108, 'openai_use_count', '100', 'OpenAI 增加使用次数', now(), now()),
       (109, 'openai_model', 'gpt-4,dall-e-2,dall-e-3', 'OpenAI 增加模型', now(), now()),
       (100, 'user_credit_blacklist', '1', '黑名单积分', now(), now());

UNLOCK TABLES;
# ------------------------------------------------------------

DROP TABLE IF EXISTS `draw_activity`;

CREATE TABLE `draw_activity`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `activity_id`    int unsigned    NOT NULL COMMENT '活动ID',
    `activity_name`  varchar(64)     NOT NULL COMMENT '活动名称',
    `activity_desc`  varchar(128)    NOT NULL COMMENT '活动描述',
    `begin_datetime` datetime        NOT NULL COMMENT '开始时间',
    `end_datetime`   datetime        NOT NULL COMMENT '结束时间',
    `strategy_id`    int unsigned    NOT NULL COMMENT '抽奖策略ID',
    `state`          varchar(8)      NOT NULL DEFAULT 'create' COMMENT '活动状态',
    `create_time`    datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_activity_id` (`activity_id`),
    UNIQUE KEY `uk_strategy_id` (`strategy_id`),
    INDEX `idx_begin_date_time` (`begin_datetime`),
    INDEX `idx_end_date_time` (`end_datetime`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖活动表';

LOCK TABLES `draw_activity` WRITE;

INSERT INTO `draw_activity`
(`activity_id`, `activity_name`, `activity_desc`, `begin_datetime`, `end_datetime`, `strategy_id`, `state`)
VALUES (100301, '测试活动', '测试活动', '2024-03-09 10:15:10', '2034-03-09 10:15:10', 100006, 'open'),
       (100401, 'OpenAi抽奖活动', '签到&支付有奖返利', '2024-10-06 12:09:34', '2026-10-06 12:09:34', 10007, 'open');

UNLOCK TABLES;
# ------------------------------------------------------------

DROP TABLE IF EXISTS `draw_activity_sku`;

CREATE TABLE `draw_activity_sku`
(
    `id`                  bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `sku_id`              int unsigned    NOT NULL COMMENT '商品sku - 把每一个组合当做一个商品',
    `activity_id`         int unsigned    NOT NULL COMMENT '活动ID',
    `activity_count_id`   int unsigned    NOT NULL COMMENT '活动个人参与次数ID',
    `stock_count`         int unsigned    NOT NULL COMMENT '商品库存',
    `stock_count_surplus` int unsigned    NOT NULL COMMENT '剩余库存',
    `product_amount`      decimal(11, 2)  NOT NULL COMMENT '商品金额【积分】',
    `create_time`         datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_sku` (`sku_id`),
    INDEX `idx_activity_id_activity_count_id` (`activity_id`, `activity_count_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='活动sku表';

LOCK TABLES `draw_activity_sku` WRITE;

INSERT INTO `draw_activity_sku`
(`sku_id`, `activity_id`, `activity_count_id`, `stock_count`, `stock_count_surplus`, `product_amount`)
VALUES (9011, 100301, 11101, 100000, 99887, 200.00),
       (9012, 100301, 11102, 100000, 99885, 100.00),
       (9013, 100301, 11103, 100000, 99884, 20.00),
       (9014, 100301, 11104, 100000, 99866, 5.00),
       (9901, 100401, 22201, 100000, 100000, 5.00),
       (9902, 100401, 22202, 100000, 100000, 10.00),
       (9903, 100401, 22203, 100000, 100000, 20.00);

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `draw_activity_stage`;

CREATE TABLE `draw_activity_stage`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `channel`     varchar(8)      NOT NULL COMMENT '渠道',
    `source`      varchar(8)      NOT NULL COMMENT '来源',
    `activity_id` int unsigned    NOT NULL COMMENT '活动ID',
    `state`       varchar(8)      NOT NULL DEFAULT 'create' COMMENT '上架状态；create、active、expire',
    `create_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_activity_id` (`activity_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='活动展台-上架活动';

LOCK TABLES `draw_activity_stage` WRITE;

INSERT INTO `draw_activity_stage` (`channel`, `source`, `activity_id`, `state`)
VALUES ('c01', 's01', 100401, 'active');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `daily_behavior_rebate`;

CREATE TABLE `daily_behavior_rebate`
(
    `id`            bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `behavior_type` varchar(16)     NOT NULL COMMENT '行为类型（sign 签到、openai_pay 支付）',
    `rebate_desc`   varchar(128)    NOT NULL COMMENT '返利描述',
    `rebate_type`   varchar(16)     NOT NULL COMMENT '返利类型（sku 活动库存充值商品、integral 用户活动积分）',
    `rebate_config` varchar(32)     NOT NULL COMMENT '返利配置',
    `state`         varchar(12)     NOT NULL COMMENT '状态（open 开启、close 关闭）',
    `create_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    INDEX `idx_behavior_type` (`behavior_type`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='日常行为返利活动配置';

LOCK TABLES `daily_behavior_rebate` WRITE;

INSERT INTO `daily_behavior_rebate`
(`behavior_type`, `rebate_desc`, `rebate_type`, `rebate_config`, `state`)
VALUES ('sign', '签到返利-积分', 'integral', '10', 'open'),
       ('sign', '签到返利-sku额度', 'sku', '9901', 'open'),
       ('openai_pay', '支付返利-积分', 'sku', '9901', 'open'),
       ('openai_pay', '支付返利-sku额度', 'integral', '10', 'open');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_behavior_rebate_order`;

CREATE TABLE `user_behavior_rebate_order`
(
    `id`              bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`         varchar(128)    NOT NULL COMMENT '用户ID',
    `order_id`        varchar(36)     NOT NULL COMMENT '订单ID',
    `behavior_type`   varchar(16)     NOT NULL COMMENT '行为类型（sign 签到、openai_pay 支付）',
    `rebate_desc`     varchar(128)    NOT NULL COMMENT '返利描述',
    `rebate_type`     varchar(16)     NOT NULL COMMENT '返利类型（sku 活动库存充值商品、integral 用户活动积分）',
    `rebate_config`   varchar(32)     NOT NULL COMMENT '返利配置【sku值，积分值】',
    `out_business_no` varchar(128)    NOT NULL COMMENT '业务仿重ID - 外部透传，方便查询使用',
    `biz_id`          varchar(128)    NOT NULL COMMENT '业务ID - 拼接的唯一值。拼接 out_business_no + 自身枚举',
    `create_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_id` (`order_id`),
    UNIQUE KEY `uk_biz_id` (`biz_id`),
    INDEX `idx_user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户行为返利流水订单表';

LOCK TABLES `user_behavior_rebate_order` WRITE;

INSERT INTO `user_behavior_rebate_order`
(`user_id`, `order_id`, `behavior_type`, `rebate_desc`, `rebate_type`, `rebate_config`, `out_business_no`, `biz_id`)
VALUES ('liergou2', '274252392446', 'sign', '签到返利-sku额度', 'sku', '9011', '20240504', 'liergou2_sku_20240504'),
       ('liergou2', '687741770429', 'sign', '签到返利-积分', 'integral', '10', '20240504', 'liergou2_integral_20240504'),
       ('user003', '317965139211', 'sign', '签到返利-sku额度', 'sku', '9011', '20240525', 'user003_sku_20240525'),
       ('user003', '429627541291', 'sign', '签到返利-积分', 'integral', '10', '20240525', 'user003_integral_20240525'),
       ('xfg-test02', '902127021986', 'openai_pay', '支付返利-积分', 'sku', '9901', '418301185073',
        'xfg-test02_sku_418301185073'),
       ('xfg-test02', '706520752751', 'openai_pay', '支付返利-sku额度', 'integral', '10', '418301185073',
        'xfg-test02_integral_418301185073'),
       ('xfg-test02', '033153182361', 'openai_pay', '支付返利-积分', 'sku', '9901', '515019067766',
        'xfg-test02_sku_515019067766'),
       ('xfg-test02', '348124238678', 'openai_pay', '支付返利-sku额度', 'integral', '10', '515019067766',
        'xfg-test02_integral_515019067766');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `draw_activity_account`;

CREATE TABLE `draw_activity_account`
(
    `id`                  bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`             varchar(128)    NOT NULL COMMENT '用户ID',
    `activity_id`         int unsigned    NOT NULL COMMENT '活动ID',
    `total_count`         int unsigned    NOT NULL COMMENT '总次数',
    `total_count_surplus` int unsigned    NOT NULL COMMENT '总次数-剩余',
    `day_count`           int unsigned    NOT NULL COMMENT '日次数',
    `day_count_surplus`   int unsigned    NOT NULL COMMENT '日次数-剩余',
    `month_count`         int unsigned    NOT NULL COMMENT '月次数',
    `month_count_surplus` int unsigned    NOT NULL COMMENT '月次数-剩余',
    `create_time`         datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_id_activity_id` (`user_id`, `activity_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖活动账户表';

LOCK TABLES `draw_activity_account` WRITE;

INSERT INTO `draw_activity_account`
(`user_id`, `activity_id`, `total_count`, `total_count_surplus`, `day_count`,
 `day_count_surplus`, `month_count`, `month_count_surplus`)
VALUES ('xiaofuge', 100301, 1188, 1078, 1188, 1078, 1188, 1078),
       ('12345', 100301, 10, 10, 10, 10, 10, 10),
       ('liergou', 100301, 20, 6, 20, 6, 20, 6),
       ('liergou2', 100301, 100, 86, 100, 86, 100, 86),
       ('user003', 100301, 100, 98, 100, 98, 100, 98),
       ('xiaofuge26', 100301, 1, 1, 1, 1, 1, 1),
       ('xfg', 100401, 102, 96, 102, 96, 102, 96),
       ('oxfA9w8-23yvwTmo2ombz0E4zJv4', 100401, 110, 105, 110, 105, 110, 105),
       ('xfg-test02', 100401, 2, 2, 2, 2, 2, 2);

UNLOCK TABLES;
# ------------------------------------------------------------

CREATE TABLE `draw_activity_account_day`
(
    `id`                bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`           varchar(128)    NOT NULL COMMENT '用户ID',
    `activity_id`       int unsigned    NOT NULL COMMENT '活动ID',
    `day`               varchar(10)     NOT NULL COMMENT '日期（yyyy-mm-dd）',
    `day_count`         int unsigned    NOT NULL COMMENT '日次数',
    `day_count_surplus` int unsigned    NOT NULL COMMENT '日次数-剩余',
    `create_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_id_activity_id_day` (`user_id`, `activity_id`, `day`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖活动账户表-日次数';

LOCK TABLES `draw_activity_account_day` WRITE;

INSERT INTO `draw_activity_account_day`
    (`user_id`, `activity_id`, `day`, `day_count`, `day_count_surplus`)
VALUES ('adc1', 100301, '2025-05-04', 10, 9),
       ('adc2', 100301, '2025-05-04', 20, 5),
       ('user001', 100301, '2025-05-24', 100, 96),
       ('user002', 100301, '2025-05-27', 100, 97),
       ('user003', 100301, '2025-05-30', 100, 98),
       ('jjwadc1', 100301, '2025-06-22', 3, 0),
       ('jjwadc2', 100301, '2025-06-22', 6, 0),
       ('fengzi01', 100301, '2025-06-22', 59, 44),
       ('fengzi02', 100301, '2025-06-22', 57, 54);

UNLOCK TABLES;
# ------------------------------------------------------------

DROP TABLE IF EXISTS `draw_activity_account_month`;

CREATE TABLE `draw_activity_account_month`
(
    `id`                  int unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`             varchar(128) NOT NULL COMMENT '用户ID',
    `activity_id`         int unsigned NOT NULL COMMENT '活动ID',
    `month`               varchar(7)   NOT NULL COMMENT '月（yyyy-mm）',
    `month_count`         int unsigned NOT NULL COMMENT '月次数',
    `month_count_surplus` int unsigned NOT NULL COMMENT '月次数-剩余',
    `create_time`         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_id_activity_id_month` (`user_id`, `activity_id`, `month`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖活动账户表-月次数';

LOCK TABLES `draw_activity_account_month` WRITE;

INSERT INTO `draw_activity_account_month`
(`user_id`, `activity_id`, `month`, `month_count`, `month_count_surplus`)
VALUES ('adc1', 100301, '2024-05', 140, 79),
       ('adc2', 100301, '2024-05', 20, 6),
       ('user001', 100301, '2024-05', 100, 86),
       ('user002', 100301, '2024-05', 100, 98),
       ('user003', 100301, '2024-06', 1188, 1143),
       ('jjwadc1', 100301, '2024-07', 1188, 1124),
       ('jjwadc2', 100401, '2024-10', 102, 96),
       ('fengzi01', 100401, '2024-10', 110, 105),
       ('fengzi02', 100301, '2024-10', 1188, 1187);

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `draw_activity_count`;

CREATE TABLE `draw_activity_count`
(
    `id`                bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `activity_count_id` int unsigned    NOT NULL COMMENT '活动次数编号',
    `total_count`       int unsigned    NOT NULL COMMENT '总次数',
    `day_count`         int unsigned    NOT NULL COMMENT '日次数',
    `month_count`       int unsigned    NOT NULL COMMENT '月次数',
    `create_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_activity_count_id` (`activity_count_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖活动次数配置表';

LOCK TABLES `draw_activity_count` WRITE;

INSERT INTO `draw_activity_count`
    (`activity_count_id`, `total_count`, `day_count`, `month_count`)
VALUES (11101, 150, 150, 150),
       (11102, 50, 50, 50),
       (11103, 5, 5, 5),
       (11104, 1, 1, 1),
       (22201, 1, 1, 1),
       (22202, 5, 5, 5),
       (22203, 10, 10, 10);

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_award_record`;

CREATE TABLE `user_award_record`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`     varchar(128)    NOT NULL COMMENT '用户ID',
    `activity_id` int unsigned    NOT NULL COMMENT '活动ID',
    `strategy_id` int unsigned    NOT NULL COMMENT '抽奖策略ID',
    `order_id`    varchar(36)     NOT NULL COMMENT '抽奖订单ID【作为幂等使用】',
    `award_id`    int unsigned    NOT NULL COMMENT '奖品ID',
    `award_title` varchar(128)    NOT NULL COMMENT '奖品标题（名称）',
    `award_time`  datetime        NOT NULL COMMENT '中奖时间',
    `award_state` varchar(16)     NOT NULL DEFAULT 'create' COMMENT '奖品状态；create-创建、completed-发奖完成',
    `create_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_id` (`order_id`),
    INDEX `idx_user_id` (`user_id`),
    INDEX `idx_activity_id` (`activity_id`),
    INDEX `idx_award_id` (`award_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户中奖记录表';

LOCK TABLES `user_award_record` WRITE;

INSERT INTO `user_award_record` (`user_id`, `activity_id`, `strategy_id`, `order_id`, `award_id`, `award_title`,
                                 `award_time`, `award_state`)
VALUES ('xfg', 100401, 10007, '896971572454', 110, '1次使用次数', '2024-10-06 12:26:28', 'create'),
       ('xfg', 100401, 10007, '726058573393', 101, '随机积分', '2024-10-06 12:27:32', 'completed'),
       ('xfg', 100401, 10007, '255567446036', 101, '随机积分', '2024-10-06 12:28:07', 'completed'),
       ('xfg', 100401, 10007, '907702562339', 101, '随机积分', '2024-10-06 12:30:31', 'completed'),
       ('xfg', 100401, 10007, '919655980330', 110, '1次使用次数', '2024-10-06 12:31:10', 'create'),
       ('xfg', 100401, 10007, '052515846031', 110, '1次使用次数', '2024-10-06 16:10:23', 'create');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `draw_activity_order`;

CREATE TABLE `draw_activity_order`
(
    `id`              bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`         varchar(128)    NOT NULL COMMENT '用户ID',
    `sku`             int unsigned    NOT NULL COMMENT '商品sku',
    `activity_id`     int unsigned    NOT NULL COMMENT '活动ID',
    `activity_name`   varchar(64)     NOT NULL COMMENT '活动名称',
    `strategy_id`     int unsigned    NOT NULL COMMENT '抽奖策略ID',
    `order_id`        varchar(36)     NOT NULL COMMENT '订单ID',
    `order_time`      datetime        NOT NULL COMMENT '下单时间',
    `total_count`     int             NOT NULL COMMENT '总次数',
    `day_count`       int             NOT NULL COMMENT '日次数',
    `month_count`     int             NOT NULL COMMENT '月次数',
    `pay_amount`      decimal(11, 2)           DEFAULT NULL COMMENT '支付金额【积分】',
    `state`           varchar(16)     NOT NULL DEFAULT 'complete' COMMENT '订单状态（complete）',
    `out_business_no` varchar(64)     NOT NULL COMMENT '业务防重ID - 外部透传的，确保幂等',
    `create_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_id` (`order_id`),
    UNIQUE KEY `uk_out_business_no` (`out_business_no`),
    INDEX `idx_user_id_activity_id` (`user_id`, `activity_id`, `state`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖活动单';

LOCK TABLES `draw_activity_order` WRITE;

INSERT INTO `draw_activity_order`
(`user_id`, `sku`, `activity_id`, `activity_name`, `strategy_id`, `order_id`,
 `order_time`, `total_count`, `day_count`, `month_count`, `pay_amount`, `state`, `out_business_no`)
VALUES ('xfg', 9014, 100301, '测试活动', 100006, '641340633741', '2024-10-06 12:22:14', 1, 1, 1, 0.00, 'completed',
        'xfg_sku_20241006'),
       ('xfg', 9901, 100401, 'OpenAi抽奖活动', 10007, '709187540625', '2024-10-20 16:11:53', 1, 1, 1, 0.00, 'completed',
        'xfg_sku_100101001010001'),
       ('xfg', 9901, 100401, 'OpenAi抽奖活动', 10007, '165680275659', '2024-10-20 16:38:45', 1, 1, 1, 0.00, 'completed',
        'xfg_sku_178799200110');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `rule_tree`;

CREATE TABLE `rule_tree`
(
    `id`                 bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `tree_id`            varchar(32)     NOT NULL COMMENT '规则树ID',
    `tree_name`          varchar(64)     NOT NULL COMMENT '规则树名称',
    `tree_desc`          varchar(128)             DEFAULT NULL COMMENT '规则树描述',
    `tree_node_rule_key` varchar(32)     NOT NULL COMMENT '规则树根入口规则',
    `create_time`        datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`        datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_tree_id` (`tree_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='规则表-树';

LOCK TABLES `rule_tree` WRITE;

INSERT INTO `rule_tree`
    (`tree_id`, `tree_name`, `tree_desc`, `tree_node_rule_key`)
VALUES ('tree_lock_1', '规则树', '规则树', 'rule_lock'),
       ('tree_luck_award', '规则树-兜底奖励', '规则树-兜底奖励', 'rule_stock'),
       ('tree_lock_2', '规则树', '规则树', 'rule_lock'),
       ('tree_lock_3', '规则树', '规则树', 'rule_lock');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `rule_tree_node`;

CREATE TABLE `rule_tree_node`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `tree_id`     varchar(32)     NOT NULL COMMENT '规则树ID',
    `rule_key`    varchar(32)     NOT NULL COMMENT '规则Key',
    `rule_desc`   varchar(64)     NOT NULL COMMENT '规则描述',
    `rule_value`  varchar(128)             DEFAULT NULL COMMENT '规则比值',
    `create_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='规则表-树节点';

LOCK TABLES `rule_tree_node` WRITE;

INSERT INTO `rule_tree_node`
    (`tree_id`, `rule_key`, `rule_desc`, `rule_value`)
VALUES ('tree_lock_1', 'rule_lock', '限定用户已完成N次抽奖后解锁', '1'),
       ('tree_lock_1', 'rule_luck_award', '兜底奖品随机积分', '101:1,100'),
       ('tree_lock_1', 'rule_stock', '库存扣减规则', NULL),
       ('tree_luck_award', 'rule_stock', '库存扣减规则', NULL),
       ('tree_luck_award', 'rule_luck_award', '兜底奖品随机积分', '101:1,100'),
       ('tree_lock_2', 'rule_lock', '限定用户已完成N次抽奖后解锁', '2'),
       ('tree_lock_2', 'rule_luck_award', '兜底奖品随机积分', '101:1,100'),
       ('tree_lock_2', 'rule_stock', '库存扣减规则', NULL),
       ('tree_lock_3', 'rule_lock', '限定用户已完成N次抽奖后解锁', '3'),
       ('tree_lock_3', 'rule_luck_award', '兜底奖品随机积分', '101:1,100'),
       ('tree_lock_3', 'rule_stock', '库存扣减规则', NULL);

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `rule_tree_node_line`;

CREATE TABLE `rule_tree_node_line`
(
    `id`               bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `tree_id`          varchar(32)     NOT NULL COMMENT '规则树ID',
    `rule_node_from`   varchar(32)     NOT NULL COMMENT '规则Key节点 From',
    `rule_node_to`     varchar(32)     NOT NULL COMMENT '规则Key节点 To',
    `rule_limit_type`  varchar(8)      NOT NULL COMMENT '限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围];',
    `rule_limit_value` varchar(32)     NOT NULL COMMENT '限定值（到下个节点）',
    `create_time`      datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='规则表-树节点连线';

LOCK TABLES `rule_tree_node_line` WRITE;

INSERT INTO `rule_tree_node_line`
(`tree_id`, `rule_node_from`, `rule_node_to`, `rule_limit_type`, `rule_limit_value`)
VALUES ('tree_lock_1', 'rule_lock', 'rule_stock', 'EQUAL', 'ALLOW'),
       ('tree_lock_1', 'rule_lock', 'rule_luck_award', 'EQUAL', 'TAKE_OVER'),
       ('tree_lock_1', 'rule_stock', 'rule_luck_award', 'EQUAL', 'ALLOW'),
       ('tree_luck_award', 'rule_stock', 'rule_luck_award', 'EQUAL', 'ALLOW'),
       ('tree_lock_2', 'rule_lock', 'rule_stock', 'EQUAL', 'ALLOW'),
       ('tree_lock_2', 'rule_lock', 'rule_luck_award', 'EQUAL', 'TAKE_OVER'),
       ('tree_lock_2', 'rule_stock', 'rule_luck_award', 'EQUAL', 'ALLOW'),
       ('tree_lock_3', 'rule_lock', 'rule_luck_award', 'EQUAL', 'ALLOW'),
       ('tree_lock_3', 'rule_lock', 'rule_luck_award', 'EQUAL', 'TAKE_OVER'),
       ('tree_lock_3', 'rule_stock', 'rule_luck_award', 'EQUAL', 'ALLOW');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `strategy`;

CREATE TABLE `strategy`
(
    `id`            bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `strategy_id`   int unsigned    NOT NULL COMMENT '抽奖策略ID',
    `strategy_desc` varchar(128)    NOT NULL COMMENT '抽奖策略描述',
    `rule_models`   varchar(256)             DEFAULT NULL COMMENT '规则模型，rule配置的模型同步到此表，便于使用',
    `create_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_strategy_id` (`strategy_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖策略';

LOCK TABLES `strategy` WRITE;

INSERT INTO `strategy`
    (`strategy_id`, `strategy_desc`, `rule_models`)
VALUES (100001, '抽奖策略', 'rule_blacklist,rule_weight'),
       (100003, '抽奖策略-验证lock', NULL),
       (100002, '抽奖策略-非完整1概率', NULL),
       (100004, '抽奖策略-随机抽奖', NULL),
       (100005, '抽奖策略-测试概率计算', NULL),
       (100006, '抽奖策略-规则树', 'rule_blacklist,rule_weight'),
       (10007, '抽奖策略-规则树', NULL);

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `strategy_award`;

CREATE TABLE `strategy_award`
(
    `id`                  bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `strategy_id`         int unsigned    NOT NULL COMMENT '抽奖策略ID',
    `award_id`            int unsigned    NOT NULL COMMENT '抽奖奖品ID',
    `award_title`         varchar(128)    NOT NULL COMMENT '抽奖奖品标题',
    `award_subtitle`      varchar(128)             DEFAULT NULL COMMENT '抽奖奖品副标题',
    `award_count`         int unsigned    NOT NULL DEFAULT '0' COMMENT '奖品库存总量',
    `award_count_surplus` int unsigned    NOT NULL DEFAULT '0' COMMENT '奖品库存剩余',
    `award_rate`          decimal(7, 4)   NOT NULL COMMENT '奖品中奖概率',
    `rule_models`         varchar(256)             DEFAULT NULL COMMENT '规则模型，rule配置的模型同步到此表，便于使用',
    `sort`                int unsigned    NOT NULL DEFAULT '0' COMMENT '排序',
    `create_time`         datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`         datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    INDEX `idx_strategy_id_award_id` (`strategy_id`, `award_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖策略奖品概率';

LOCK TABLES `strategy_award` WRITE;

INSERT INTO `strategy_award`
(`strategy_id`, `award_id`, `award_title`, `award_subtitle`,
 `award_count`, `award_count_surplus`, `award_rate`, `rule_models`, `sort`)
VALUES (100001, 101, '随机积分', NULL, 80000, 79998, 0.3000, 'tree_luck_award', 1),
       (100001, 102, '5次使用', NULL, 10000, 9999, 0.2000, 'tree_luck_award', 2),
       (100001, 103, '10次使用', NULL, 5000, 4998, 0.2000, 'tree_luck_award', 3),
       (100001, 104, '20次使用', NULL, 4000, 3999, 0.1000, 'tree_luck_award', 4),
       (100001, 105, '增加gpt-4对话模型', NULL, 600, 600, 0.1000, 'tree_luck_award', 5),
       (100001, 106, '增加dall-e-2画图模型', NULL, 200, 200, 0.0500, 'tree_luck_award', 6),
       (100001, 107, '增加dall-e-3画图模型', '抽奖1次后解锁', 200, 200, 0.0400, 'tree_luck_award', 7),
       (100001, 108, '增加100次使用', '抽奖2次后解锁', 199, 199, 0.0099, 'tree_luck_award', 8),
       (100001, 109, '解锁全部模型', '抽奖6次后解锁', 1, 1, 0.0001, 'tree_luck_award', 9),
       (100002, 101, '随机积分', NULL, 1, 1, 0.5000, 'tree_luck_award', 1),
       (100002, 102, '5次使用', NULL, 1, 1, 0.1000, 'tree_luck_award', 2),
       (100002, 106, '增加dall-e-2画图模型', NULL, 1, 1, 0.0100, 'tree_luck_award', 3),
       (100003, 107, '增加dall-e-3画图模型', '抽奖1次后解锁', 200, 200, 0.0400, 'tree_luck_award', 7),
       (100003, 108, '增加100次使用', '抽奖2次后解锁', 199, 199, 0.0099, 'tree_luck_award', 8),
       (100003, 109, '解锁全部模型', '抽奖6次后解锁', 1, 1, 0.0001, 'tree_luck_award', 9),
       (100004, 109, '解锁全部模型', '抽奖6次后解锁', 1, 1, 1.0000, 'tree_luck_award', 9),
       (100005, 101, '随机积分', NULL, 80000, 80000, 0.0300, 'tree_luck_award', 1),
       (100005, 102, '随机积分', NULL, 80000, 80000, 0.0300, 'tree_luck_award', 1),
       (100005, 103, '随机积分', NULL, 80000, 80000, 0.0300, 'tree_luck_award', 1),
       (100005, 104, '随机积分', NULL, 80000, 80000, 0.0300, 'tree_luck_award', 1),
       (100005, 105, '随机积分', NULL, 80000, 80000, 0.0010, 'tree_luck_award', 1),
       (100006, 101, '随机积分', NULL, 10000, 9982, 0.7900, 'tree_luck_award', 1),
       (100006, 102, 'OpenAI会员卡', NULL, 100, 15, 0.0300, 'tree_luck_award', 2),
       (100006, 103, '支付优惠券', NULL, 100, 38, 0.0300, 'tree_luck_award', 3),
       (100006, 104, '小米台灯', NULL, 100, 28, 0.0300, 'tree_luck_award', 4),
       (100006, 105, '小米su7周体验', '抽奖3次后解锁', 100, 37, 0.0300, 'tree_lock_3', 5),
       (100006, 106, '轻奢办公椅', '抽奖2次后解锁', 100, 22, 0.0300, 'tree_lock_2', 6),
       (100006, 107, '小霸王游戏机', '抽奖1次后解锁', 100, 21, 0.0300, 'tree_lock_1', 7),
       (100006, 108, '暴走玩偶', NULL, 100, 25, 0.0003, 'tree_luck_award', 8),
       (10007, 101, '随机积分', NULL, 1000000, 1000000, 0.1000, 'tree_luck_award', 1),
       (10007, 110, '1次使用次数', NULL, 1000000, 1000000, 0.8000, 'tree_luck_award', 2),
       (10007, 111, '5次使用次数', NULL, 1000000, 1000000, 0.0800, 'tree_luck_award', 3),
       (10007, 112, '10次使用次数', NULL, 1000000, 1000000, 0.0100, 'tree_luck_award', 4),
       (10007, 113, '50次使用次数', '抽奖3次后解锁', 1000000, 1000000, 0.0002, 'tree_lock_3', 5),
       (10007, 114, '20次使用次数', '抽奖2次后解锁', 1000000, 1000000, 0.0040, 'tree_lock_2', 6),
       (10007, 115, '25次使用次数', '抽奖1次后解锁', 1000000, 1000000, 0.0008, 'tree_lock_1', 7),
       (10007, 116, '15次使用次数', NULL, 1000000, 1000000, 0.0050, 'tree_luck_award', 8);

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `strategy_rule`;

CREATE TABLE `strategy_rule`
(
    `id`          bigint unsigned  NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `strategy_id` int unsigned     NOT NULL COMMENT '抽奖策略ID',
    `award_id`    int unsigned              DEFAULT NULL COMMENT '抽奖奖品ID【规则类型为策略，则不需要奖品ID】',
    `rule_type`   tinyint unsigned NOT NULL DEFAULT '0' COMMENT '抽象规则类型；1-策略规则、2-奖品规则',
    `rule_model`  varchar(16)      NOT NULL COMMENT '抽奖规则类型【rule_random - 随机值计算、rule_lock - 抽奖几次后解锁、rule_luck_award - 幸运奖(兜底奖品)】',
    `rule_value`  varchar(256)     NOT NULL COMMENT '抽奖规则比值',
    `rule_desc`   varchar(128)     NOT NULL COMMENT '抽奖规则描述',
    `create_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_strategy_id_rule_model` (`strategy_id`, `rule_model`),
    INDEX `idx_strategy_id_award_id` (`strategy_id`, `award_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='抽奖策略规则';

LOCK TABLES `strategy_rule` WRITE;

INSERT INTO `strategy_rule`
(`strategy_id`, `award_id`, `rule_type`, `rule_model`, `rule_value`, `rule_desc`)
VALUES (100001, NULL, 1, 'rule_weight', '60:102,103,104,105 200:106,107 1000:105', '消耗6000分，必中奖范围'),
       (100001, NULL, 1, 'rule_blacklist', '101:user001,user002,user003', '黑名单抽奖，积分兜底'),
       (100006, NULL, 1, 'rule_weight', '10:102,103 70:106,107 1000:104,105', '消耗6000分，必中奖范围'),
       (100006, NULL, 1, 'rule_blacklist', '101:user001,user002,user003', '黑名单抽奖，积分兜底');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_credit_account`;

CREATE TABLE `user_credit_account`
(
    `id`               bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`          varchar(128)    NOT NULL COMMENT '用户ID',
    `total_amount`     decimal(11, 2)  NOT NULL COMMENT '总积分，显示总账户值，记得一个人获得的总积分',
    `available_amount` decimal(11, 2)  NOT NULL COMMENT '可用积分，每次扣减的值',
    `account_status`   varchar(8)      NOT NULL COMMENT '账户状态【open - 可用，close - 冻结】',
    `create_time`      datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户积分账户';

LOCK TABLES `user_credit_account` WRITE;

INSERT INTO `user_credit_account`
    (`user_id`, `total_amount`, `available_amount`, `account_status`)
VALUES ('xiaofuge', 207.21, 187.21, 'open'),
       ('user003', 0.96, 0.96, 'open'),
       ('xiaofuge26', 10.00, 10.00, 'open'),
       ('xfg', 197.80, 197.80, 'open'),
       ('oxfA9w8-23yvwTmo2ombz0E4zJv4', 157.90, 127.90, 'open'),
       ('xfg-test02', 20.00, 20.00, 'open');

UNLOCK TABLES;

# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_draw_order`;

CREATE TABLE `user_draw_order`
(
    `id`            bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`       varchar(128)    NOT NULL COMMENT '用户ID',
    `activity_id`   int unsigned    NOT NULL COMMENT '活动ID',
    `activity_name` varchar(64)     NOT NULL COMMENT '活动名称',
    `strategy_id`   int unsigned    NOT NULL COMMENT '抽奖策略ID',
    `order_id`      varchar(36)     NOT NULL COMMENT '订单ID',
    `order_time`    datetime        NOT NULL COMMENT '下单时间',
    `order_state`   varchar(16)     NOT NULL DEFAULT 'create' COMMENT '订单状态；create-创建、used-已使用、cancel-已作废',
    `create_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_order_id` (`order_id`),
    INDEX `idx_user_id_activity_id` (`user_id`, `activity_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户抽奖订单表';

LOCK TABLES `user_draw_order` WRITE;

INSERT INTO `user_draw_order`
(`user_id`, `activity_id`, `activity_name`, `strategy_id`, `order_id`, `order_time`, `order_state`)
VALUES ('xfg', 100401, 'OpenAi抽奖活动', 10007, '896971572454', '2024-10-06 12:26:27', 'used'),
       ('xfg', 100401, 'OpenAi抽奖活动', 10007, '726058573393', '2024-10-06 12:27:31', 'used'),
       ('xfg', 100401, 'OpenAi抽奖活动', 10007, '255567446036', '2024-10-06 12:28:06', 'used'),
       ('xfg', 100401, 'OpenAi抽奖活动', 10007, '907702562339', '2024-10-06 12:30:30', 'used'),
       ('xfg', 100401, 'OpenAi抽奖活动', 10007, '919655980330', '2024-10-06 12:31:09', 'used'),
       ('xfg', 100401, 'OpenAi抽奖活动', 10007, '052515846031', '2024-10-06 16:10:22', 'used');

UNLOCK TABLES;
