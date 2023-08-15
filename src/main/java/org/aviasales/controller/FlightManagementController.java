package org.aviasales.controller;

import jakarta.websocket.server.PathParam;
import org.aviasales.dto.FlightManagementDTO;
import org.aviasales.entity.Airplane;
import org.aviasales.entity.FlightManagement;
import org.aviasales.entity.Page;
import org.aviasales.service.FlightManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rest/api/flight")
public class FlightManagementController {

    private final FlightManagementService flightManagementService;
    private static final Logger logger = Logger.getLogger(FlightManagementController.class.getName());

    public FlightManagementController(FlightManagementService flightManagementService) {
        this.flightManagementService = flightManagementService;
    }

    @PostMapping("/create-flight")
    public ResponseEntity<String> createFlightManagementDTO(@RequestBody FlightManagementDTO flightManagementDTO) {
        try {
            flightManagementService.createFlightManagement(flightManagementDTO);
            return new ResponseEntity<>("Successful Created", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-flight-list")
    public ResponseEntity<Page<FlightManagement>> getFlightManagementList(@RequestParam int page, @RequestParam int size) {
        try {
            Page<FlightManagement> flightManagementPage = flightManagementService.getListFlightManagement(page, size);
            return new ResponseEntity<>(flightManagementPage, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-airplane-list")
    public ResponseEntity<Page<Airplane>> getAirplaneList() {
        try {
            Page<Airplane> airplanes = flightManagementService.getAirplanes();
            return new ResponseEntity<>(airplanes, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
