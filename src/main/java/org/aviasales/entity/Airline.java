package org.aviasales.entity;

/**
 * This class represent entity of an Airline Company
 */
public class Airline {
    private long airlineId;             // Airline Id
    private String nameCompany;                // Airline Name
    private String codeCompany;                // Airline Code
    private String description;         // Airline Description

    public Airline(long airlineId, String nameCompany, String codeCompany, String description) {
        this.airlineId = airlineId;
        this.nameCompany = nameCompany;
        this.codeCompany = codeCompany;
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

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getCodeCompany() {
        return codeCompany;
    }

    public void setCodeCompany(String codeCompany) {
        this.codeCompany = codeCompany;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
