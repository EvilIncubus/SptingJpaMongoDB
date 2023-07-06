package org.aviasales.service;

import org.aviasales.dto.FlightManagementDTO;
import org.aviasales.entity.FlightManagement;
import org.aviasales.entity.Page;

public interface FlightManagementService {
    void createFlightManagement(FlightManagementDTO flightManagementDTO);
    Page<FlightManagement> getListFlightManagement(int page, int size);
}
