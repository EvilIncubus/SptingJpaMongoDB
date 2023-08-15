package org.aviasales.dao;

import org.aviasales.entity.Airport;

import java.util.List;

public interface AirportDao extends Dao<Airport>{
    List<Airport> getFilterListAirport(String airportName, int page, int size);
}
