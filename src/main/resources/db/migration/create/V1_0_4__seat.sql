CREATE TABLE aviasales_db.seat
(
    seat_id         BIGINT auto_increment NOT NULL,
    seat_type       INT                   NULL,
    place_number    INT                   NULL,
    available_place BIT(1)                NULL,
    price_seat      DOUBLE                NULL,
    flight_id       BIGINT                NULL,
    CONSTRAINT seat PRIMARY KEY (seat_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
