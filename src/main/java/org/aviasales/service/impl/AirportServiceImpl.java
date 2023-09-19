package org.aviasales.service.impl;

import org.aviasales.dao.AirportDao;
import org.aviasales.dto.SearchAirportDTO;
import org.aviasales.entity.Airport;
import org.aviasales.entity.Page;
import org.aviasales.service.AirportService;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {
    private final AirportDao airportDao;

    public AirportServiceImpl(AirportDao airportDao) {
        this.airportDao = airportDao;
    }

    @Override
    public Page<Airport> getSearchListAirport(SearchAirportDTO searchAirportDTO) {
        return new Page<>(airportDao.getFilterListAirport(searchAirportDTO.getAirportName(), (searchAirportDTO.getPage() - 1) * searchAirportDTO.getSize(), searchAirportDTO.getSize()), 5, searchAirportDTO.getPage(), searchAirportDTO.getSize());
    }
}
