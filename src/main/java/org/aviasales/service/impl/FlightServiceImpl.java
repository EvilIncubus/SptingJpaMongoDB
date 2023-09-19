package org.aviasales.service.impl;

import org.aviasales.dao.FlightDao;
import org.aviasales.dto.FlightSearchDTO;
import org.aviasales.entity.Flight;
import org.aviasales.entity.Page;
import org.aviasales.service.FlightService;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;

    public FlightServiceImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Page<Flight> getFlightList(int page, int size) {
        return new Page<>(flightDao.getAll(size, (page - 1) * size), flightDao.countFlight(), page, size);
    }

    @Override
    public Page<Flight> getFilterFlightList(FlightSearchDTO flightSearchDTO) {
        return new Page<>(flightDao.getFilterFlightList(flightSearchDTO, flightSearchDTO.getSize(), (flightSearchDTO.getPage() - 1) * flightSearchDTO.getSize()), flightDao.countFilterFlight(flightSearchDTO), flightSearchDTO.getPage(),flightSearchDTO.getSize());
    }
}
