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
    UNIQUE KEY `uq_award_id` (`award_id`)
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
