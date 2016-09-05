package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sarsovsk on 06.09.2016.
 */
@Entity
@DiscriminatorValue("APARTMENT")
public class Apartment extends RealEstate {

    @Column(name = "YEAR_OF_CONSTRUCTION")
    private int yearOfConstruction;

    @Column(name = "CENTRAL_HEATING_INCLUDED")
    private boolean centralHeatingIncluded;

    @Column(name = "AIR_CONDITIONED")
    private boolean airConditioned;

    @Column(name = "FLOOR_NUMBER")
    private int floorNumber;

    @Column(name = "NUMBER_OF_ROOMS")
    private int numberOfRooms;

    @Column(name = "PARKING_INCLUDED")
    private boolean parkingIncluded;

    @Column(name = "ELEVATOR_INCLUDED")
    private boolean elevatorIncluded;

    public int getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public boolean isCentralHeatingIncluded() {
        return centralHeatingIncluded;
    }

    public void setCentralHeatingIncluded(boolean centralHeatingIncluded) {
        this.centralHeatingIncluded = centralHeatingIncluded;
    }

    public boolean isAirConditioned() {
        return airConditioned;
    }

    public void setAirConditioned(boolean airConditioned) {
        this.airConditioned = airConditioned;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public boolean isParkingIncluded() {
        return parkingIncluded;
    }

    public void setParkingIncluded(boolean parkingIncluded) {
        this.parkingIncluded = parkingIncluded;
    }

    public boolean isElevatorIncluded() {
        return elevatorIncluded;
    }

    public void setElevatorIncluded(boolean elevatorIncluded) {
        this.elevatorIncluded = elevatorIncluded;
    }
}
