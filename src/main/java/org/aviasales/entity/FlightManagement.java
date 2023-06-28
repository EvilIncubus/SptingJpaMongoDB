package org.aviasales.entity;

import java.util.List;

/**
 * This class represent entity of FlightManagement for Admin panel
 */
public class FlightManagement {
    private long flightManagementId;
    private Flight flightTo;
    private Flight flightFrom;

    public void addFlight(Flight flight) {
        // Add the flight to the list
    }

    public void removeFlight(Flight flight) {
        // Remove the flight from the list
    }

    public List<Flight> getFlights() {
        // Return the list of flights
        return null;
    }

    // Other methods for managing flights (e.g., updateFlight, getFlightById, etc.)
}
