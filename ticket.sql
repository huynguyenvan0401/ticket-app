DROP DATABASE IF EXISTS ticket_management;
CREATE DATABASE IF NOT EXISTS ticket_management;
use ticket_management;

CREATE TABLE `room` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `number` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `ticket_management`.`room` (`id`, `number`, `type`) VALUES ('1', '101', 'Khu Xóm Nhỏ');
INSERT INTO `ticket_management`.`room` (`id`, `number`, `type`) VALUES ('2', '102', 'Khu Nhà Chìm');
INSERT INTO `ticket_management`.`room` (`id`, `number`, `type`) VALUES ('3', '103', 'Khu Đồi Trọc');
INSERT INTO `ticket_management`.`room` (`id`, `number`, `type`) VALUES ('4', '104', 'Khu Vườn Hồng');

CREATE TABLE `car` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` bigint NOT NULL,
  `license_plate` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `ticket_management`.`car` (`id`, `capacity`, `license_plate`) VALUES ('1', '16', '98MH-123456');
INSERT INTO `ticket_management`.`car` (`id`, `capacity`, `license_plate`) VALUES ('2', '16', '98MH-888888');

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `ticket_management`.`role` (`role_name`) VALUES ('USER');
INSERT INTO `ticket_management`.`role` (`role_name`) VALUES ('ADMIN');
INSERT INTO `ticket_management`.`role` (`role_name`) VALUES ('DRIVER');

CREATE TABLE `_user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(255) DEFAULT NULL,
    `first_name` VARCHAR(255) DEFAULT NULL,
    `last_name` VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(255) DEFAULT NULL,
    `car_id` BIGINT DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKo8b9oglcr80ww4l8wq6bqrajl` (`car_id`),
    CONSTRAINT `FKo8b9oglcr80ww4l8wq6bqrajl` FOREIGN KEY (`car_id`)
        REFERENCES `car` (`id`)
)  ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;

INSERT INTO `ticket_management`.`_user`
(`id`, `email`, `first_name`, `last_name`, `password`, `car_id`)
VALUES ('1', 'huy@gmail.com', 'Huy', 'Nguyen', '$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq', '1');

INSERT INTO `ticket_management`.`_user`
(`id`, `email`, `first_name`, `last_name`, `password`, `car_id`)
VALUES ('2', 'huydriver@gmail.com', 'Huy', 'Nguyen', '$2a$10$FFKwmzWpHQJtWuwPEv5NgeT3dUyQxXLsTJYFAPdSTgOBOlsPE5vUq', '1');

CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKniaqoclrvx138sjw9hsollqav` FOREIGN KEY (`user_id`) REFERENCES `_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `ticket_management`.`user_role`(`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `ticket_management`.`user_role`(`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `ticket_management`.`user_role`(`user_id`, `role_id`) VALUES ('1', '3');


CREATE TABLE `people` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `note` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `car_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoi9xscn0n2cm6k9iow9rwstwu` (`car_id`),
  KEY `FK52rcvyx8jrudjcm5mh135ray0` (`room_id`),
  CONSTRAINT `FK52rcvyx8jrudjcm5mh135ray0` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `FKoi9xscn0n2cm6k9iow9rwstwu` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HuyNV21', '2', '0987654137', 'Hút Cần', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('KienNV12', '1', '0974627983', 'Đập Đá', '2');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HieuNV41', '2', '0123976354', 'Đi WC', '3');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HoangNN104', '1', '0233345555', 'Đi tắm', '4');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH41', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH42', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH43', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH44', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH45', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH46', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH47', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH48', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH49', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH412', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH413', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH414', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH415', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH416', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('VietH417', '1', '0827333645', 'Hít thuốc', '1');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HieuNV42', '2', '0123976354', 'Đi WC', '3');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HieuNV43', '2', '0123976354', 'Đi WC', '3');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HieuNV44', '2', '0123976354', 'Đi WC', '3');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HieuNV45', '2', '0123976354', 'Đi WC', '3');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HieuNV46', '2', '0123976354', 'Đi WC', '3');
INSERT INTO `ticket_management`.`people` (`account`, `car_id`, `phone_number`, `note`, `room_id`) VALUES ('HieuNV47', '2', '0123976354', 'Đi WC', '3');

CREATE TABLE `code` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `ticket_management`.`code` (`code`, `description`) VALUES ('abcxyz', 'Travel Checkin');

CREATE TABLE `checkin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `car_id` bigint DEFAULT NULL,
  `code_id` bigint DEFAULT NULL,
  `people_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq6spnr6647cokcc2ltoaspbx6` (`car_id`),
  KEY `FKt6ays8u533dlpfkhl353nsace` (`code_id`),
  KEY `FK2e3dekxnkl9iyalfxbjn6fv7t` (`people_id`),
  CONSTRAINT `FK2e3dekxnkl9iyalfxbjn6fv7t` FOREIGN KEY (`people_id`) REFERENCES `people` (`id`),
  CONSTRAINT `FKq6spnr6647cokcc2ltoaspbx6` FOREIGN KEY (`car_id`) REFERENCES `car` (`id`),
  CONSTRAINT `FKt6ays8u533dlpfkhl353nsace` FOREIGN KEY (`code_id`) REFERENCES `code` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ticket` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ticket_num` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM ticket_management.ticket;









