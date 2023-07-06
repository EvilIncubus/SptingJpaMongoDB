package org.aviasales.dao;

import org.aviasales.entity.FlightManagement;

import java.util.List;

public interface FlightManagementDao extends Dao<FlightManagement>{
    List<FlightManagement> getFlightManagementList(int size, int offset);

    Integer countFlightManagement();
}
