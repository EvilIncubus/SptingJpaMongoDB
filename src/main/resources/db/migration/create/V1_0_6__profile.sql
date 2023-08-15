CREATE TABLE aviasales_db.profile
(
    profile_id    BIGINT auto_increment NOT NULL,
    user_id       BIGINT                NULL,
    first_name    VARCHAR(30)           NULL,
    last_name     VARCHAR(30)           NULL,
    phone           VARCHAR(20)            NULL,
    date_of_birth DATE                  NULL,
    address       VARCHAR(50)           NULL,
    CONSTRAINT profile PRIMARY KEY (profile_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
