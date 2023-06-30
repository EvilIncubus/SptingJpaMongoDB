CREATE TABLE aviasales_db.flight_management
(
    flight_management_id BIGINT auto_increment NOT NULL,
    flight_from_id       BIGINT                NULL,
    fright_to_id         BIGINT                NULL,
    CONSTRAINT flight PRIMARY KEY (flight_management_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
