CREATE TABLE `user` (
    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(255) NOT NULL UNIQUE,
    `email` VARCHAR(255) NOT NULL UNIQUE,
    `phone_number` VARCHAR(255) DEFAULT NULL,
    `created_by` BIGINT(255) DEFAULT NULL,
    `created_date` DATETIME NOT NULL,
    `last_modified_by` BIGINT DEFAULT NULL,
    `last_modified_date` DATETIME NOT NULL,
    `version` BIGINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX idx_user_username ON `user` (`username`);
CREATE INDEX idx_user_email ON `user` (`email`);