DROP TABLE IF EXISTS e_employee;

CREATE TABLE e_employee
(
    id    BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    name  VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age   INT(11)     NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
) AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci COMMENT ='【数据表】员工表';

DROP TABLE IF EXISTS e_skill;

CREATE TABLE e_skill
(
    id       BIGINT(20)  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    category VARCHAR(30) NULL DEFAULT NULL COMMENT '类别',
    name     VARCHAR(30) NULL DEFAULT NULL COMMENT '技能',
    PRIMARY KEY (id)
) AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci COMMENT ='【配置表】技能表';

DROP TABLE IF EXISTS e_skill_level;

CREATE TABLE e_skill_level
(
    id          BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    skill_id    BIGINT(20)   NOT NULL COMMENT '技能',
    name        VARCHAR(30)  NULL DEFAULT NULL COMMENT '级别',
    requirement VARCHAR(128) NULL DEFAULT NULL COMMENT '要求',
    PRIMARY KEY (id)
) AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci COMMENT ='【配置表】技能级别表';

DROP TABLE IF EXISTS e_employee_skill;

CREATE TABLE e_employee_skill
(
    id             BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    employee_id    BIGINT(20) NOT NULL COMMENT '员工ID',
    skill_id       BIGINT(20) NOT NULL COMMENT '技能ID',
    skill_level_id BIGINT(20) NOT NULL COMMENT '技能级别ID',
    PRIMARY KEY (id)
) AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci COMMENT ='【关系表】员工技能及技能级别表';