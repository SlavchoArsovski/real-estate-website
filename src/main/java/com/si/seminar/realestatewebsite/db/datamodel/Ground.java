package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Ground DB model.
 */
@Entity
@DiscriminatorValue("GROUND")
public class Ground extends RealEstate {
}
