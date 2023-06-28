package org.aviasales.entity;

import java.util.List;

/**
 * This class represent entity of an Airline Company
 */
public class Airline {
    private long airlineId;             // Airline Id
    private String name;                // Airline Name
    private String code;                // Airline Code
    private String description;         // Airline Description
    private List<Flight> flights;       // Flight list, Airline Company

    // Constructor, getters, and setters
}
