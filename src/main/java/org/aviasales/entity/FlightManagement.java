package org.aviasales.entity;

import java.util.List;

/**
 * This class represent entity of FlightManagement for Admin panel
 */
public class FlightManagement {
    private long flightManagementId;
    private Flight flightTo;
    private Flight flightFrom;

    public FlightManagement(long flightManagementId, Flight flightTo, Flight flightFrom) {
        this.flightManagementId = flightManagementId;
        this.flightTo = flightTo;
        this.flightFrom = flightFrom;
    }

    public long getFlightManagementId() {
        return flightManagementId;
    }

    public void setFlightManagementId(long flightManagementId) {
        this.flightManagementId = flightManagementId;
    }

    public Flight getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(Flight flightTo) {
        this.flightTo = flightTo;
    }

    public Flight getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(Flight flightFrom) {
        this.flightFrom = flightFrom;
    }
}
