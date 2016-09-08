package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Office Space DB Model.
 */
@Entity
@DiscriminatorValue("OFFICE_SPACE")
public class OfficeSpace extends RealEstate {

    @Column(name = "YEAR_OF_CONSTRUCTION")
    private Integer yearOfConstruction;

    @Column(name = "CENTRAL_HEATING_INCLUDED")
    private Boolean centralHeatingIncluded;

    @Column(name = "AIR_CONDITIONED")
    private Boolean airConditioned;

    @Column(name = "NUMBER_OF_OFFICES")
    private Integer numberOfOffices;

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

    public Integer getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(Integer numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }
}
