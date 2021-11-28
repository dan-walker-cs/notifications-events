use my_db;

DROP TABLE IF EXISTS `email_notification`;

CREATE TABLE `email_notification` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(45) NOT NULL,
    `to` VARCHAR(128) NOT NULL,
    `cc` text,
    `subject` VARCHAR(1000) NOT NULL,
    `body` text NOT NULL,
    `sent_dt` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
