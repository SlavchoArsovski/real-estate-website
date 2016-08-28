package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.*;

/**
 * Created by sarsovsk on 29.08.2016.
 */
@Entity
@Table(name = "REAL_ESTATE")
@Access(AccessType.FIELD)
public class RealEstate {

    @Id
    @Column(name = "REAL_ESTATE_ID", nullable = false, unique = true)
    private Long realEstateId;

    @Column(name = "DESCRIPTION")
    private String description;

    public Long getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(Long realEstateId) {
        this.realEstateId = realEstateId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
