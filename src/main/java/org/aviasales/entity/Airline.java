package org.aviasales.entity;

/**
 * This class represent entity of an Airline Company
 */
public class Airline {
    private long airlineId;             // Airline Id
    private String name_company;                // Airline Name
    private String code_company;                // Airline Code
    private String description;         // Airline Description

    public Airline(long airlineId, String name_company, String code_company, String description) {
        this.airlineId = airlineId;
        this.name_company = name_company;
        this.code_company = code_company;
        this.description = description;
    }

    public Airline() {
    }

    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(long airlineId) {
        this.airlineId = airlineId;
    }

    public String getName_company() {
        return name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getCode_company() {
        return code_company;
    }

    public void setCode_company(String code_company) {
        this.code_company = code_company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
