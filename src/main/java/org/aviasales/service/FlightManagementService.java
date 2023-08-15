package org.aviasales.service;

import org.aviasales.dto.FlightManagementDTO;
import org.aviasales.entity.Airplane;
import org.aviasales.entity.FlightManagement;
import org.aviasales.entity.Page;

import java.util.List;

public interface FlightManagementService {
    void createFlightManagement(FlightManagementDTO flightManagementDTO);
    Page<FlightManagement> getListFlightManagement(int page, int size);

    Page<Airplane> getAirplanes();
}
