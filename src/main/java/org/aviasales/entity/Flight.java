package org.aviasales.entity;

import java.time.LocalDateTime;

public class Flight {
    private int flightId;
    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivingDate;
    private String flightDuration;
    private double ticketPrice;
    private short amountAvailablePlaces;
    private String planeModel;
    private int airlineId;
}
