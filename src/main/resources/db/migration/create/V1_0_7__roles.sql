CREATE TABLE aviasales_db.user_role
(
    user_role_id BIGINT auto_increment NOT NULL,
    role         VARCHAR(30)           NULL,
    user_id      BIGINT                NULL,
    CONSTRAINT user_role PRIMARY KEY (user_role_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
