package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Room DB model.
 */
@Entity
@DiscriminatorValue("ROOM")
public class Room extends RealEstate {

    @Column(name = "NUMBER_OF_BEDS")
    private Integer numberOfBeds;

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
}
