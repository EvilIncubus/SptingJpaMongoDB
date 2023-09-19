package org.aviasales.dao.rowmapper;

import org.aviasales.entity.Airline;
import org.aviasales.entity.Airplane;
import org.aviasales.entity.Flight;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

public class FlightRowMapper implements RowMapper<Flight> {
    @Override
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        Flight flight = new Flight();
        flight.setFlightId(rs.getLong("flight_id"));
        flight.setFlightNumber(rs.getString("flight_number"));
        Airplane airplane = new Airplane();
        airplane.setAirplaneId(rs.getLong("airplane_id"));
        Airline airline = new Airline();
        airline.setAirlineId(rs.getLong("airline_id"));
        airline.setDescription(rs.getString("description"));
        airline.setCodeCompany(rs.getString("code_company"));
        airline.setNameCompany(rs.getString("name_company"));
        airplane.setAirline(airline);
        airplane.setNumberOfSeats(rs.getInt("number_of_seats"));
        airplane.setPlaneNumber(rs.getString("plane_number"));
        flight.setAirplane(airplane);
        flight.setDepartureLocation(rs.getString("departure_location"));
        flight.setDestination(rs.getString("destination"));
        flight.setDepartureDateTime(rs.getTimestamp("departure_date_time").toLocalDateTime());
        flight.setArrivalDateTime(rs.getTimestamp("arrival_date_time").toLocalDateTime());
        flight.setFlightDuration(Duration.parse(rs.getString("duration_id")));
        return flight;
    }
}
