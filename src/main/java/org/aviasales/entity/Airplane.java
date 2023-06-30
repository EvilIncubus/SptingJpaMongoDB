package org.aviasales.entity;

import java.util.List;
import java.util.Map;

public class Airplane {

    private long airplaneId;
    private String planeNumber;
    private Airline airline;
    private int numberOfSeats;

    public Airplane(long airplaneId, String planeNumber, Airline airline, int numberOfSeats) {
        this.airplaneId = airplaneId;
        this.planeNumber = planeNumber;
        this.airline = airline;
        this.numberOfSeats = numberOfSeats;
    }

    public Airplane() {
    }

    public long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
