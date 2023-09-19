package org.aviasales.controller;

import org.aviasales.dto.FlightSearchDTO;
import org.aviasales.entity.Flight;
import org.aviasales.entity.Page;
import org.aviasales.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/rest/api/flight")
public class FlightController {

    private static final Logger logger = Logger.getLogger(FlightController.class.getName());
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/get-flight-list")
    public ResponseEntity<Page<Flight>> getFlightList(@RequestParam int page, @RequestParam int size) {
        try {
            Page<Flight> flightList = flightService.getFlightList(page, size);
            return new ResponseEntity<>( flightList, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/get-filter-flight-list")
    public ResponseEntity<Page<Flight>> getFilterFlightList(@RequestBody FlightSearchDTO flightSearchDTO) {
        try {
            Page<Flight> flightList = flightService.getFilterFlightList(flightSearchDTO);
            return new ResponseEntity<>( flightList, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
