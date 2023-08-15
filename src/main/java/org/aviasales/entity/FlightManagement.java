package org.aviasales.entity;

/**
 * This class represent entity of FlightManagement for Admin panel
 */
public class FlightManagement {
    private long flightManagementId;
    private Flight originFlight;
    private Flight destinationFlight;

    public FlightManagement(long flightManagementId, Flight originFlight, Flight destinationFlight) {
        this.flightManagementId = flightManagementId;
        this.originFlight = originFlight;
        this.destinationFlight = destinationFlight;
    }

    public FlightManagement() {
    }

    public long getFlightManagementId() {
        return flightManagementId;
    }

    public void setFlightManagementId(long flightManagementId) {
        this.flightManagementId = flightManagementId;
    }

    public Flight getOriginFlight() {
        return originFlight;
    }

    public void setOriginFlight(Flight originFlight) {
        this.originFlight = originFlight;
    }

    public Flight getDestinationFlight() {
        return destinationFlight;
    }

    public void setDestinationFlight(Flight destinationFlight) {
        this.destinationFlight = destinationFlight;
    }
}
