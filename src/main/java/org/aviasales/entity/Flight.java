package org.aviasales.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * This class represent entity of Flight
 */
public class Flight {
    private long flightId;                                 // Flight Id
    private String flightNumber;                          // number for current flight
    private Airplane airplane;                            // airplane for current flight
    private List<Seat> seats;
    private String departureLocation;                     // Departure Location
    private String destination;                           // Destination Location
    private LocalDateTime departureDateTime;              // Departure Flight date and time
    private LocalDateTime arrivalDateTime;                // Arriving Flight date and time
    private Duration flightDuration;                      // Flight duration

    // Constructor, getters, and setters
}
