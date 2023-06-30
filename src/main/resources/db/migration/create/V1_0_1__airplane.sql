CREATE TABLE aviasales_db.airplane
(
    airplane_id     BIGINT auto_increment NOT NULL,
    plane_number    VARCHAR(20)           NULL,
    airline_id      BIGINT                NULL,
    number_of_seats INT                   NULL,
    CONSTRAINT flight PRIMARY KEY (airplane_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
