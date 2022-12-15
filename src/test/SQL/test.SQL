CREATE DATABASE `attendance` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `attendance`;

CREATE TABLE `user` (
                        `user` varchar(100) NOT NULL,
                        `password` varchar(100) DEFAULT NULL,
                        `user_type` int(11) DEFAULT NULL,
                        PRIMARY KEY (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `userinformation` (
                                   `account` varchar(100) NOT NULL,
                                   `name` varchar(100) DEFAULT NULL,
                                   `department` varchar(100) DEFAULT NULL,
                                   `degree` varchar(100) DEFAULT NULL,
                                   `sex` tinyint(4) DEFAULT NULL,
                                   `work` varchar(100) DEFAULT NULL,
                                   PRIMARY KEY (`account`),
                                   CONSTRAINT `userinformation_FK` FOREIGN KEY (`account`) REFERENCES `user` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `record` (
                          `account` varchar(100) NOT NULL,
                          `comeTime` bigint(20) DEFAULT '-28800001',
                          `exitTime` bigint(20) DEFAULT '-28800001',
                          `status` int(11) DEFAULT NULL,
                          `Date` bigint(20) DEFAULT NULL,
                          KEY `record_FK` (`account`),
                          CONSTRAINT `record_FK` FOREIGN KEY (`account`) REFERENCES `user` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `regulation` (
                              `account` varchar(100) NOT NULL,
                              `comeTime` bigint(20) DEFAULT '0',
                              `ExitTime` bigint(20) DEFAULT '0',
                              PRIMARY KEY (`account`),
                              CONSTRAINT `Regulation_FK` FOREIGN KEY (`account`) REFERENCES `user` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create or replace
    algorithm = UNDEFINED view `attendance`.`editregulation` as
select
    `attendance`.`regulation`.`account` as `account`,
    `attendance`.`userinformation`.`name` as `name`,
    `attendance`.`regulation`.`comeTime` as `cometime`,
    `attendance`.`regulation`.`ExitTime` as `exitTime`
from
    (`attendance`.`regulation`
        join `attendance`.`userinformation` on
        ((`attendance`.`regulation`.`account` = `attendance`.`userinformation`.`account`)));

create or replace
    algorithm = UNDEFINED view `attendance`.`edituser` as
select
    `attendance`.`userinformation`.`account` as `account`,
    `attendance`.`user`.`user_type` as `user_type`,
    `attendance`.`userinformation`.`name` as `name`,
    `attendance`.`userinformation`.`department` as `department`,
    'work' as `work`,
    `attendance`.`userinformation`.`sex` as `sex`,
    'degree' as `degree`
from
    (`attendance`.`user`
        join `attendance`.`userinformation` on
        ((`attendance`.`user`.`user` = `attendance`.`userinformation`.`account`)));

create or replace
    algorithm = UNDEFINED view `attendance`.`recordview` as
select
    `attendance`.`record`.`account` as `account`,
    `attendance`.`record`.`Date` as `date`,
    `attendance`.`userinformation`.`name` as `name`,
    `attendance`.`record`.`comeTime` as `cometime`,
    `attendance`.`record`.`exitTime` as `exitTime`
from
    (`attendance`.`userinformation`
        join `attendance`.`record` on
        ((`attendance`.`record`.`account` = `attendance`.`userinformation`.`account`)));

INSERT user VALUES ('user','123456','2');
INSERT userinformation(account) VALUES ('user');