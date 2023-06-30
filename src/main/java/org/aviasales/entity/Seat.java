package org.aviasales.entity;

public class Seat {
    private long seatId;
    private SeatType seatType;
    private int placeNumber;
    private boolean availablePlace;
    private double priceSeat;
    private long flightId;

    public Seat(long seatId, SeatType seatType, int placeNumber, boolean availablePlace, double priceSeat, long flightId) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.placeNumber = placeNumber;
        this.availablePlace = availablePlace;
        this.priceSeat = priceSeat;
        this.flightId = flightId;
    }

    public Seat() {
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public boolean isAvailablePlace() {
        return availablePlace;
    }

    public void setAvailablePlace(boolean availablePlace) {
        this.availablePlace = availablePlace;
    }

    public double getPriceSeat() {
        return priceSeat;
    }

    public void setPriceSeat(double priceSeat) {
        this.priceSeat = priceSeat;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }
}
