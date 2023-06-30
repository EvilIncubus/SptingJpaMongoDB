package org.aviasales.dto;

import org.aviasales.entity.FlightManagement;

public class FlightManagementDTO {

    private FlightManagement flightManagement;
    private int businessSeats;
    private int economySeats;
    private double priceBusinessSeat;
    private double priceEconomySeat;

    public FlightManagementDTO(FlightManagement flightManagement, int businessSeats, int economySeats, double priceBusinessSeat, double priceEconomySeat) {
        this.flightManagement = flightManagement;
        this.businessSeats = businessSeats;
        this.economySeats = economySeats;
        this.priceBusinessSeat = priceBusinessSeat;
        this.priceEconomySeat = priceEconomySeat;
    }

    public FlightManagementDTO() {
    }

    public FlightManagement getFlightManagement() {
        return flightManagement;
    }

    public void setFlightManagement(FlightManagement flightManagement) {
        this.flightManagement = flightManagement;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public double getPriceBusinessSeat() {
        return priceBusinessSeat;
    }

    public void setPriceBusinessSeat(double priceBusinessSeat) {
        this.priceBusinessSeat = priceBusinessSeat;
    }

    public double getPriceEconomySeat() {
        return priceEconomySeat;
    }

    public void setPriceEconomySeat(double priceEconomySeat) {
        this.priceEconomySeat = priceEconomySeat;
    }
}
