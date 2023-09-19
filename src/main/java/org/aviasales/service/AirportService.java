package org.aviasales.service;

import org.aviasales.dto.SearchAirportDTO;
import org.aviasales.entity.Airport;
import org.aviasales.entity.Page;

public interface AirportService {
    Page<Airport> getSearchListAirport(SearchAirportDTO searchAirportDTO);
}
