CREATE TABLE aviasales_db.flight
(
    flight_id           BIGINT auto_increment NOT NULL,
    airplane_id         BIGINT                NULL,
    departure_location  varchar(100)          NULL,
    destination         varchar(100)          NULL,
    departure_date_time DATETIME              NULL,
    arrival_date_time   DATETIME              NULL,
    duration_id         VARCHAR(20)           NULL,
    CONSTRAINT flight PRIMARY KEY (flight_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
