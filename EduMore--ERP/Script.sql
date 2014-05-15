--<ScriptOptions statementTerminator=";"/>

ALTER TABLE `database`.`enquiry_details` DROP PRIMARY KEY;

ALTER TABLE `database`.`course_details` DROP PRIMARY KEY;

ALTER TABLE `database`.`admin_login_details` DROP PRIMARY KEY;

ALTER TABLE `database`.`counsellor_login_details` DROP PRIMARY KEY;

ALTER TABLE `database`.`address_details` DROP PRIMARY KEY;

ALTER TABLE `database`.`enquiry_details` DROP INDEX `database`.`enquiry_id`;

ALTER TABLE `database`.`enquiry_details` DROP INDEX `database`.`FK_enquiry_details`;

ALTER TABLE `database`.`enquiry_details` DROP INDEX `database`.`enquiry_details_ibfk_2`;

ALTER TABLE `database`.`course_details` DROP INDEX `database`.`FK_course_details`;

ALTER TABLE `database`.`address_details` DROP INDEX `database`.`enquiry_id`;

DROP TABLE `database`.`enquiry_details`;

DROP TABLE `database`.`address_details`;

DROP TABLE `database`.`admin_login_details`;

DROP TABLE `database`.`counsellor_login_details`;

DROP TABLE `database`.`course_details`;

CREATE TABLE `database`.`enquiry_details` (
	`enquiry_id` BIGINT UNSIGNED NOT NULL,
	`first_name` VARCHAR(50) NOT NULL,
	`middle_name` VARCHAR(50),
	`last_name` VARCHAR(50),
	`residence_number` VARCHAR(20),
	`mobile_number` VARCHAR(20),
	`email_id` VARCHAR(50),
	`date_of_birth` VARCHAR(50),
	`gender` VARCHAR(6),
	`father_first_name` VARCHAR(25),
	`father_middle_name` VARCHAR(50),
	`father_last_name` VARCHAR(50),
	`father_mobile_number` VARCHAR(20),
	`father_residence_number` VARCHAR(20),
	`current_address` BIGINT UNSIGNED,
	`permanent_address` BIGINT UNSIGNED,
	`counsellor_id` BIGINT UNSIGNED NOT NULL,
	`enquiry_number` BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (`enquiry_id`)
);

CREATE TABLE `database`.`address_details` (
	`address_id` BIGINT UNSIGNED NOT NULL,
	`house_number` VARCHAR(30),
	`building_name` VARCHAR(30),
	`street` VARCHAR(60),
	`area` VARCHAR(90),
	`city` VARCHAR(30),
	`state` VARCHAR(30),
	`country` VARCHAR(30) DEFAULT India,
	`pincode` VARCHAR(20),
	`enquiry_number` BIGINT UNSIGNED NOT NULL,
	`address_type` VARCHAR(10),
	PRIMARY KEY (`address_id`)
);

CREATE TABLE `database`.`admin_login_details` (
	`admin_id` BIGINT UNSIGNED NOT NULL,
	`admin_username` VARCHAR(20),
	`admin_password` VARCHAR(20),
	PRIMARY KEY (`admin_id`)
);

CREATE TABLE `database`.`counsellor_login_details` (
	`counsellor_id` BIGINT UNSIGNED NOT NULL,
	`counsellor_username` VARCHAR(20),
	`counsellor_password` VARCHAR(20),
	PRIMARY KEY (`counsellor_id`)
);

CREATE TABLE `database`.`course_details` (
	`course_id` BIGINT UNSIGNED NOT NULL,
	`course_name` VARCHAR(60),
	`course_duration` INTEGER UNSIGNED,
	`admin_id` BIGINT UNSIGNED DEFAULT 0 NOT NULL,
	PRIMARY KEY (`course_id`)
);

CREATE INDEX `enquiry_id` ON `database`.`enquiry_details` (`enquiry_id` ASC);

CREATE INDEX `FK_enquiry_details` ON `database`.`enquiry_details` (`counsellor_id` ASC);

CREATE INDEX `enquiry_details_ibfk_2` ON `database`.`enquiry_details` (`current_address` ASC);

CREATE INDEX `FK_course_details` ON `database`.`course_details` (`admin_id` ASC);

CREATE INDEX `enquiry_id` ON `database`.`address_details` (`enquiry_number` ASC);

