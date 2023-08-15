package org.aviasales.entity;

public class Airport {
    private long airportId;
    private String airportCode;
    private String airportName;

    public Airport(long airportId, String airportCode, String airportName) {
        this.airportId = airportId;
        this.airportCode = airportCode;
        this.airportName = airportName;
    }

    public Airport() {
    }

    public long getAirportId() {
        return airportId;
    }

    public void setAirportId(long airportId) {
        this.airportId = airportId;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
