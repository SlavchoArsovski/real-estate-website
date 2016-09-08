package com.si.seminar.realestatewebsite.db.datamodel;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * House DB model.
 */
@Entity
@DiscriminatorValue("HOUSE_VILLA")
public class House extends RealEstate {

    @Column(name = "YEAR_OF_CONSTRUCTION")
    private Integer yearOfConstruction;

    @Column(name = "CENTRAL_HEATING_INCLUDED")
    private Boolean centralHeatingIncluded;

    @Column(name = "AIR_CONDITIONED")
    private Boolean airConditioned;

    @Column(name = "NUMBER_OF_FLOORS")
    private Integer numberOfFloors;

    @Column(name = "YARD_INCLUDED")
    private Boolean yardIncluded;

    @Column(name = "GARAGE_INCLUDED")
    private Boolean garageIncluded;

    @Column(name = "POOL_INCLUDED")
    private Boolean poolIncluded;

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

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Boolean isYardIncluded() {
        return yardIncluded;
    }

    public void setYardIncluded(Boolean yardIncluded) {
        this.yardIncluded = yardIncluded;
    }

    public Boolean isGarageIncluded() {
        return garageIncluded;
    }

    public void setGarageIncluded(Boolean garageIncluded) {
        this.garageIncluded = garageIncluded;
    }

    public Boolean isPoolIncluded() {
        return poolIncluded;
    }

    public void setPoolIncluded(Boolean poolIncluded) {
        this.poolIncluded = poolIncluded;
    }
}
