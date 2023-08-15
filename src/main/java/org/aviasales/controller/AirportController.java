package org.aviasales.controller;
import org.aviasales.dto.SearchAirportDTO;
import org.aviasales.entity.Airport;
import org.aviasales.entity.Page;
import org.aviasales.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rest/api/airport")
public class AirportController {
    private final AirportService airportService;
    private static final Logger logger = Logger.getLogger(AirportController.class.getName());

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/get-search-airport-list")
    public ResponseEntity<Page<Airport>> getSearchAirportList(@RequestBody SearchAirportDTO searchAirportDTO) {
        try {
            Page<Airport> airportList = airportService.getSearchListAirport(searchAirportDTO);
            return new ResponseEntity<>( airportList, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info(e.toString());
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}