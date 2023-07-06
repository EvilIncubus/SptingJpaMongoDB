DELIMITER ;;

CREATE PROCEDURE generateSeats()
BEGIN
    DECLARE i int DEFAULT 1;
    DECLARE j int DEFAULT 1;
    WHILE i <= 90
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 0, j, 1, 90, 1);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    WHILE i <= 120
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 1, j, 1, 120, 1);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    SET j = j - 120;
    WHILE i <= 210
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 0, j, 1, 90, 2);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    WHILE i <= 240
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 1, j, 1, 120, 2);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    SET j = j - 120;
    WHILE i <= 390
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 0, j, 1, 90, 1);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    WHILE i <= 420
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 1, j, 1, 120, 1);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    SET j = j - 180;
    WHILE i <= 570
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 0, j, 1, 90, 2);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    WHILE i <= 600
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 1, j, 1, 120, 2);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    SET j = j - 180;
    WHILE i <= 700
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 0, j, 1, 90, 1);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    WHILE i <= 740
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 1, j, 1, 120, 1);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    SET j = j - 140;
    WHILE i <= 840
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 0, j, 1, 90, 2);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    WHILE i <= 880
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 1, j, 1, 120, 2);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    SET j = j - 140;
    WHILE i <= 1060
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 0, j, 1, 90, 1);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    WHILE i <= 1100
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 1, j, 1, 120, 1);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    SET j = j - 220;
    WHILE i <= 1280
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 0, j, 1, 90, 2);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    WHILE i <= 1320
        DO
            INSERT INTO aviasales_db.seat (seat_id, seat_type, place_number, available_place, price_seat, flight_id)
            VALUES (i, 1, j, 1, 120, 2);
            SET i = i + 1;
            SET j = j + 1;
        END WHILE;
    SET j = j - 220;
END;;

DELIMITER ;

CALL generateSeats();
