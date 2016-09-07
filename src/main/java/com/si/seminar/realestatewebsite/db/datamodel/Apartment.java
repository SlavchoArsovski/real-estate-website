package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Apartment DB model.
 */
@Entity
@DiscriminatorValue("APARTMENT")
public class Apartment extends RealEstate {

    @Column(name = "YEAR_OF_CONSTRUCTION")
    private Integer yearOfConstruction;

    @Column(name = "CENTRAL_HEATING_INCLUDED")
    private Boolean centralHeatingIncluded;

    @Column(name = "AIR_CONDITIONED")
    private Boolean airConditioned;

    @Column(name = "FLOOR_NUMBER")
    private Integer floorNumber;

    @Column(name = "NUMBER_OF_ROOMS")
    private Integer numberOfRooms;

    @Column(name = "PARKING_INCLUDED")
    private Boolean parkingIncluded;

    @Column(name = "ELEVATOR_INCLUDED")
    private Boolean elevatorIncluded;

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(Integer yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public Boolean isCentralHeatingIncluded() {
        return centralHeatingIncluded;
    }

    public void setCentralHeatingIncluded(Boolean centralHeatingIncluded) {
        this.centralHeatingIncluded = centralHeatingIncluded;
    }

    public Boolean isAirConditioned() {
        return airConditioned;
    }

    public void setAirConditioned(Boolean airConditioned) {
        this.airConditioned = airConditioned;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Boolean isParkingIncluded() {
        return parkingIncluded;
    }

    public void setParkingIncluded(Boolean parkingIncluded) {
        this.parkingIncluded = parkingIncluded;
    }

    public Boolean isElevatorIncluded() {
        return elevatorIncluded;
    }

    public void setElevatorIncluded(Boolean elevatorIncluded) {
        this.elevatorIncluded = elevatorIncluded;
    }
}
