CREATE TABLE `account` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `balance` DECIMAL(15,2) NOT NULL,
    `user_id` BIGINT NOT NULL,
    `account_number` VARCHAR(30) UNIQUE NOT NULL,
    `type` VARCHAR(30) DEFAULT NULL,
    `created_by` BIGINT(255) DEFAULT NULL,
    `created_date` DATETIME NOT NULL,
    `last_modified_by` BIGINT DEFAULT NULL,
    `last_modified_date` DATETIME NOT NULL,
    `version` BIGINT NOT NULL,
     FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX idx_account_accountNumber ON `account`(`account_number`);