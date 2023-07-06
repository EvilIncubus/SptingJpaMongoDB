package org.aviasales.controller;

import org.aviasales.dto.FlightManagementDTO;
import org.aviasales.entity.FlightManagement;
import org.aviasales.entity.Page;
import org.aviasales.service.FlightManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            flightManagementService.createFlightManagement(createFlightDTO);
            return new ResponseEntity<>("Successful Created", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/create-flight/{page}/{size}")
    public ResponseEntity<Page<FlightManagement>> createBottle(@PathVariable int page, @PathVariable int size) {
        try {
            Page<FlightManagement> flightManagementPage = flightManagementService.getListFlightManagement(page, size);
            return new ResponseEntity<>(flightManagementPage, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
