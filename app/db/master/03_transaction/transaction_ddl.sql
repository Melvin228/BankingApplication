CREATE TABLE `transaction` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(30) NOT NULL,
    `status` VARCHAR(30) NOT NULL,
    `source_acc_id` BIGINT NOT NULL,
    `to_acc_id`BIGINT NOT NULL,
    `amount` DECIMAL(15,2) NOT NULL,
    `remark` VARCHAR(30) DEFAULT NULL,
    `created_by` BIGINT(255) DEFAULT NULL,
    `created_date` DATETIME NOT NULL,
    `last_modified_by` BIGINT DEFAULT NULL,
    `last_modified_date` DATETIME NOT NULL,
    `version` BIGINT NOT NULL,
     FOREIGN KEY (`source_acc_id`) REFERENCES `account`(`id`),
     FOREIGN KEY (`to_acc_id`) REFERENCES `account`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
