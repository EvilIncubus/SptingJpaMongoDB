CREATE TABLE aviasales_db.airport
(
    airport_id   BIGINT auto_increment NOT NULL,
    airport_code VARCHAR(4)            NULL,
    airport_name VARCHAR(30)            NULL,
    CONSTRAINT airport PRIMARY KEY (airport_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;