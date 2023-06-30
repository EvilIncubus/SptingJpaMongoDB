package org.aviasales.controller;

import org.aviasales.dto.FlightManagementDTO;
import org.aviasales.service.FlightManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/rest/api/flight")
public class FlightManagementController {

    private final FlightManagementService flightManagementService;
    private final static Logger logger = Logger.getLogger(FlightManagementController.class.getName());

    public FlightManagementController(FlightManagementService flightManagementService) {
        this.flightManagementService = flightManagementService;
    }

    @PostMapping("/create-flight")
    public ResponseEntity<String> createBottle(@RequestBody FlightManagementDTO createFlightDTO) {
        try {
            flightManagementService.createFlight(createFlightDTO);
            return new ResponseEntity<>("Successful Created", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
