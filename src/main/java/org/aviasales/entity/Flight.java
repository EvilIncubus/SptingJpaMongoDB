package org.aviasales.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private String destination;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = ("dd:MM:yyyy hh:mm:ss"))
    private LocalDateTime departureDateTime;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = ("dd:MM:yyyy hh:mm:ss"))
    private LocalDateTime arrivalDateTime;
    private String flightDuration;                      // Flight duration

    public Flight(long flightId, String flightNumber, Airplane airplane, List<Seat> seats, String departureLocation, String destination, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, String flightDuration) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.airplane = airplane;
        this.seats = seats;
        this.departureLocation = departureLocation;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.flightDuration = flightDuration;
    }

    public Flight() {
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }
}
