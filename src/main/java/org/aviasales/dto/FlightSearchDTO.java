package org.aviasales.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlightSearchDTO {
    private String flightFrom;
    private String flightTo;
    private LocalDate dateToFlight;
    private int page;
    private int size;

    public FlightSearchDTO(String flightFrom, String flightTo, LocalDate dateToFlight, int page, int size) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.dateToFlight = dateToFlight;
        this.page = page;
        this.size = size;
    }

    public FlightSearchDTO() {
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public void setFlightFrom(String flightFrom) {
        this.flightFrom = flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

    public void setFlightTo(String flightTo) {
        this.flightTo = flightTo;
    }

    public LocalDate getDateToFlight() {
        return dateToFlight;
    }

    public void setDateToFlight(LocalDate dateToFlight) {
        this.dateToFlight = dateToFlight;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
