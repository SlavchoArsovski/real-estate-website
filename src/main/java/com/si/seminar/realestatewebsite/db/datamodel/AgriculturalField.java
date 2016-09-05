package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sarsovsk on 06.09.2016.
 */
@Entity
@DiscriminatorValue("AGRICULTURAL_FIELD")
public class AgriculturalField extends RealEstate {

    @Column(name = "YEAR_OF_CONSTRUCTION")
    private int yearOfConstruction;

    @Column(name = "CENTRAL_HEATING_INCLUDED")
    private boolean centralHeatingIncluded;

    @Column(name = "AIR_CONDITIONED")
    private boolean airConditioned;

    @Column(name = "NUMBER_OF_OFFICES")
    private int numberOfOffices;

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

    public int getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(int numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }
}
