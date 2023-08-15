package org.aviasales.dao.rowmapper;

import org.aviasales.entity.Flight;
import org.aviasales.entity.FlightManagement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightManagementRowMapper implements RowMapper<FlightManagement> {
    @Override
    public FlightManagement mapRow(ResultSet rs, int rowNum) throws SQLException {
        FlightManagement fm = new FlightManagement();
        fm.setFlightManagementId(rs.getLong("flight_management_id"));

        Flight originFlight = new Flight();
        originFlight.setFlightId(rs.getLong("origin_flight_flight_id"));
        originFlight.setFlightNumber(rs.getString("origin_flight_flight_number"));
        originFlight.setDepartureLocation(rs.getString("origin_flight_departure_destination"));
        originFlight.setDestination(rs.getString("origin_flight_destination"));
        originFlight.setDepartureDateTime(rs.getTimestamp("origin_flight_departure_date_time").toLocalDateTime());
        originFlight.setArrivalDateTime(rs.getTimestamp("origin_flight_arrival_date_time").toLocalDateTime());
        fm.setOriginFlight(originFlight);

        Flight destinationFlight = new Flight();
        destinationFlight.setFlightId(rs.getLong("destination_flight_flight_id"));
        destinationFlight.setFlightNumber(rs.getString("destination_flight_flight_number"));
        destinationFlight.setDepartureLocation(rs.getString("destination_flight_departure_destination"));
        destinationFlight.setDestination(rs.getString("destination_flight_destination"));
        destinationFlight.setDepartureDateTime(rs.getTimestamp("destination_flight_departure_date_time").toLocalDateTime());
        destinationFlight.setArrivalDateTime(rs.getTimestamp("destination_flight_arrival_date_time").toLocalDateTime());
        fm.setDestinationFlight(destinationFlight);



        return fm;
    }
}
