CREATE TABLE `comment`
(
    `id`         BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `order_id`   BIGINT                NOT NULL,
    `title`      varchar(255)          NOT NULL,
    `content`    varchar(255)          NOT NULL,
    `created_at` TIMESTAMP             NOT NULL DEFAULT CURRENT_TIMESTAMP
);
