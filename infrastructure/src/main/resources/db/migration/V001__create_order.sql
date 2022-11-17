CREATE TABLE `t_order`
(
    `id`           BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `customer_id`  BIGINT         NOT NULL,
    `order_status` VARCHAR(255)   NOT NULL,
    `total_price`  DECIMAL(12, 2) NOT NULL,
    `created_at`   TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP
);
