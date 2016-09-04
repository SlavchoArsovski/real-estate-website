package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.*;

/**
 * Real Estate.
 */
@Entity
@Table(name = "REAL_ESTATE")
@Access(AccessType.FIELD)
public class RealEstate {

    @Id
    @Column(name = "REAL_ESTATE_ID", nullable = false, unique = true)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    public Long getRealEstateId() {
        return id;
    }

    public void setRealEstateId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
