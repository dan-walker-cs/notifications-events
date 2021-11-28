use my_db;

DROP TABLE IF EXISTS `email_notifications`;

CREATE TABLE `email_notification` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL,
    `to` VARCHAR(128) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
