package org.aviasales.service.impl;

import org.aviasales.dao.FlightDao;
import org.aviasales.entity.Flight;
import org.aviasales.entity.Page;
import org.aviasales.service.FlightService;

public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;

    public FlightServiceImpl(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public Page<Flight> getFlightList(int page, int size) {
        return new Page<>(flightDao.getAll(size, (page - 1) * size), flightDao.countFlight(), page, size);
    }
}
