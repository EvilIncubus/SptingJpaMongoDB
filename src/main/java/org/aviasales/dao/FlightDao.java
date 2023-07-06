package org.aviasales.dao;

import org.aviasales.entity.Flight;

import java.util.List;

public interface FlightDao extends Dao<Flight>{

    List<Flight> getFlightList(int size, int offset);

    Integer countFlight();
}
