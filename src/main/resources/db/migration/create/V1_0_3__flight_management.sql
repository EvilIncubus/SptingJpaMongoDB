CREATE TABLE aviasales_db.flight_management
(
    flight_management_id BIGINT auto_increment NOT NULL,
    origin_flight_id       BIGINT                NULL,
    destination_flight_id         BIGINT                NULL,
    CONSTRAINT flight_management PRIMARY KEY (flight_management_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
