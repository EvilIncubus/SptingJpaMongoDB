package org.aviasales.entity;

import java.util.List;

/**
 * Pentru rezervarea tichetelor
 * obiect intermediar
 * obiectul leaga bersoana cu locul din avion
 */
public class Booking {
    private long bookingId;
    private Trip trip;
    private List<Passenger> passengerList;
    private BookingStatus bookingStatus;
}
