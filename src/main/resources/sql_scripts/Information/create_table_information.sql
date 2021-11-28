use my_db;

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `content` VARCHAR(1000) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
