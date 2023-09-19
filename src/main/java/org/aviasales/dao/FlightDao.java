package org.aviasales.dao;

import org.aviasales.dto.FlightSearchDTO;
import org.aviasales.entity.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightDao extends Dao<Flight>{
    List<Flight> getFlightList(int size, int offset);
    Integer countFlight();
    List<LocalDateTime> getListOfDateForFlights(String location);
    List<Flight> getListOfFlightWithDepartureLocation(String location);

    List<Flight> getFilterFlightList(FlightSearchDTO flightSearchDTO, int size, int page);

    Integer countFilterFlight(FlightSearchDTO flightSearchDTO);
}
