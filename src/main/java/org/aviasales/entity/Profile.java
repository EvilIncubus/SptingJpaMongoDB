package org.aviasales.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Profile {
    private int profileId;
    private String firstName;
    private String lastName;
    private String phone;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = ("yyyy-MM-dd"))
    private LocalDate dateOfBirth;

    public Profile(int profileId, String firstName, String lastName, String phone, LocalDate dateOfBirth) {
        this.profileId = profileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public Profile() {
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
