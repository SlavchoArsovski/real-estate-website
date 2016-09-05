package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sarsovsk on 06.09.2016.
 */
@Entity
@DiscriminatorValue("ROOM")
public class Room extends RealEstate {

    @Column(name = "NUMBER_OF_BEDS")
    private int numberOfBeds;

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
}
