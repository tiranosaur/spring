CREATE TABLE roles
(
    `id`   INT          AUTO_INCREMENT,
    `name` VARCHAR(128) NOT NULL,
    PRIMARY KEY (`id`)
);
INSERT INTO roles (`name`)VALUES('admin');
INSERT INTO roles (`name`)VALUES('customer');

CREATE TABLE user_role
(
    `user_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    FOREIGN KEY (`user_id`) REFERENCES users (`id`),
    FOREIGN KEY (`role_id`) REFERENCES roles (`id`)
);
INSERT INTO user_role (`user_id`, `role_id`)VALUES (1, 1), (1, 2), (2, 2);