package org.aviasales.service;

import org.aviasales.dto.FlightSearchDTO;
import org.aviasales.entity.Flight;
import org.aviasales.entity.Page;

public interface FlightService {
    Page<Flight> getFlightList(int page, int size);

    Page<Flight> getFilterFlightList(FlightSearchDTO flightSearchDTO);
}
