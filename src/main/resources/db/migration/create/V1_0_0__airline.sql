CREATE TABLE aviasales_db.airline
(
    airline_id   BIGINT auto_increment NOT NULL,
    name_company varchar(100)          NULL,
    code_company varchar(100)          NULL,
    description  varchar(100)          NULL,
    CONSTRAINT airline PRIMARY KEY (airline_id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;
