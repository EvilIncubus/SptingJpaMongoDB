CREATE TABLE aviasales_db.user
(
    user_id      BIGINT auto_increment NOT NULL,
    email        VARCHAR(50)           NULL,
    password     VARCHAR(100)          NULL,
    created_date DATETIME              NULL,
    CONSTRAINT seat PRIMARY KEY (user_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
