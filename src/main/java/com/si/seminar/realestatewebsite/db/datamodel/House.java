package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sarsovsk on 06.09.2016.
 */
@Entity
@DiscriminatorValue("HOUSE")
public class House extends RealEstate {

    @Column(name = "YEAR_OF_CONSTRUCTION")
    private int yearOfConstruction;

    @Column(name = "CENTRAL_HEATING_INCLUDED")
    private boolean centralHeatingIncluded;

    @Column(name = "AIR_CONDITIONED")
    private boolean airConditioned;

    @Column(name = "NUMBER_OF_FLOORS")
    private int numberOfFloors;

    @Column(name = "YARD_INCLUDED")
    private boolean yardIncluded;

    @Column(name = "GARAGE_INCLUDED")
    private boolean garageIncluded;

    @Column(name = "POOL_INCLUDED")
    private boolean poolIncluded;

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

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public boolean isYardIncluded() {
        return yardIncluded;
    }

    public void setYardIncluded(boolean yardIncluded) {
        this.yardIncluded = yardIncluded;
    }

    public boolean isGarageIncluded() {
        return garageIncluded;
    }

    public void setGarageIncluded(boolean garageIncluded) {
        this.garageIncluded = garageIncluded;
    }

    public boolean isPoolIncluded() {
        return poolIncluded;
    }

    public void setPoolIncluded(boolean poolIncluded) {
        this.poolIncluded = poolIncluded;
    }
}
