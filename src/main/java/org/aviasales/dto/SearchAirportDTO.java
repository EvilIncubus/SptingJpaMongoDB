package org.aviasales.dto;

public class SearchAirportDTO {
    private String airportName;
    private int page;
    private int size;

    public SearchAirportDTO(String airportName, int page, int size) {
        this.airportName = airportName;
        this.page = page;
        this.size = size;
    }

    public SearchAirportDTO() {
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
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
