#create data base supermarket_db
CREATE DATABASE supermarket_db;

#use database supermarket_db
USE supermarket_db;

#create table

#create 'account_tb' table
CREATE TABLE IF NOT EXISTS `account_tb` (
   	`id` int(11), 
   	`user_name` varchar(200),
    `password` varchar(200)
);
#create 'employeeinfo_tb' table
CREATE TABLE IF NOT EXISTS `employeeinfo_tb` (
	`id` int(11) PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(50),
	`ages` varchar(3),
	`sex` varchar(10),
	`birth_date` varchar(20),
	`hire_date` varchar(20),
	`salary` varchar(11)
	
);

#create 'work_time_tb' table
CREATE TABLE IF NOT EXISTS `work_time_tb` (
	`id` int(11),
	`begin_date` varchar(20),
	`end_date` varchar(20),
	`session_count` varchar(10),
	`salary` varchar(20)
);

#create 'bill_tb' table 
CREATE TABLE IF NOT EXISTS `bill_tb` (
	`code_bill` int(11) PRIMARY KEY AUTO_INCREMENT,
	`id` int(11),
	`code` int(11),
	`amount` varchar(10),
	`time` varchar(20)
);

#create 'import_bill_tb' table
CREATE TABLE IF NOT EXISTS `import_bill_tb` (
	`code_import` int(11) PRIMARY KEY AUTO_INCREMENT,
	`id_nha_cung_cap` int(11),
	`code` int(11),
	`amount` varchar(10),
	`time` varchar(20)
);

#create 'nha_cung_cap_tb' table
CREATE TABLE IF NOT EXISTS `nha_cung_cap_tb` (
	`id` int(11) PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(200),
	`address` varchar(200),
	`mail` varchar(200),
	`phone_no` varchar(20)
);

#create 'goods_tb' table
CREATE TABLE IF NOT EXISTS `goods_tb` (
	`code` int(11) PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(200),
	`price` varchar(11),
	`producer` varchar(200),
	`produce_date` varchar(20),
	`expire_date` varchar(20),
	`remain_amount` varchar(11),
	`sold_amount` varchar(11)

);





#set primary key for table

ALTER TABLE `work_time_tb`
ADD PRIMARY KEY(`id`, `begin_date`);

ALTER TABLE `account_tb`
ADD PRIMARY KEY (`id`);

ALTER TABLE `account_tb`
ADD UNIQUE (`user_name`);

ALTER TABLE `account_tb`
ADD FOREIGN KEY (`id`)
REFERENCES `employeeinfo_tb` (`id`);

ALTER TABLE `work_time_tb`
ADD FOREIGN KEY (`id`)
REFERENCES `employeeinfo_tb` (`id`);

ALTER TABLE `bill_tb`
ADD FOREIGN KEY (`code`)
REFERENCES `goods_tb` (`code`);

ALTER TABLE `bill_tb`
ADD FOREIGN KEY (`id`)
REFERENCES `employeeinfo_tb` (`id`);

ALTER TABLE `import_bill_tb`
ADD FOREIGN KEY (`code`)
REFERENCES `goods_tb` (`code`);

ALTER TABLE `import_bill_tb`
ADD FOREIGN KEY (`id_nha_cung_cap`)
REFERENCES `nha_cung_cap_tb` (`id`);

####

#insert into `employeeinfo_tb` table
INSERT INTO `employeeinfo_tb` (`id`, `name`, `ages`, `sex`, `birth_date`, `hire_date`, `salary`) 
VALUES (NULL, 'Nguyen Dinh Minh', '20', 'Nam', '28-09-1996', '20-11-2017', '300000'),
	   (NULL, 'Nguyen Dinh Thang', '19', 'Nam', '20-10-1997', '21-11-2017', '350000');

#insert into `goods_tb` table
INSERT INTO `goods_tb` (`code`, `name`, `price`, `producer`, `produce_date`, `expire_date`, `remain_amount`, `sold_amount`) 
VALUES (NULL, 'pepsi', '10000', 'pesi Ltd', '20-11-2016', '20-11-2017', '0', '10'),
	   (NULL, 'coca', '11000', 'coca Ltd', '20-11-2016', '20-11-2018', '2', '100');

#insert into `account_tb` table
INSERT INTO `account_tb` (`id`, `user_name`, `password`) 
VALUES ('1', 'minh1996bk', 'husterk59'), 
	   ('2', 'thangyk97', 'husterk60');

#insert into `work_time_tb` table
INSERT INTO `work_time_tb` (`id`, `begin_date`, `end_date`, `session_count`, `salary`) VALUES ('1', '20-11-2017', '20-12-2017', '19', '300000'),
	   ('1', '21-12-2017', '20-01-2018', '25', '500000'),
	   ('1', '21-01-2018', 'now', '10', '500000'),
	   ('2', '21-11-2017', '21-12-2017', '24', '400000'),
	   ('2', '22-11-2017', 'now', '1', '500000');

#insert into `bill_tb` table
INSERT INTO `bill_tb` (`id`, `code`, `amount`, `time`) 
VALUES ('1', '1', '1', '21-11-2017'),
	   ('1', '2', '3', '23-11-2017'),
	   ('2', '1', '3', '27-11-2017');

#insert into `nha_cung_cap` table
INSERT INTO `nha_cung_cap_tb` (`id`, `name`, `address`, `mail`, `phone_no`)
VALUES (NULL, 'Pepsi Ltd', 'America', 'pepsi@mail.com', '001234567'),
	   (NULL, 'Coca Ltd', 'America', 'coca-cola@mail.com', '013423740');

#insert into `import_bill_tb` table
INSERT INTO `import_bill_tb` (`code_import`, `id_nha_cung_cap`, `code`, `amount`, `time`)
VALUES (NULL, 1, 1, '10', '20-10-2017'),
	   (NULL, 2, 2, '200', '02-11-2017');
