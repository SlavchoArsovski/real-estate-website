package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  AgriculturalField DB model.
 */
@Entity
@DiscriminatorValue("AGRICULTURAL_FIELD")
public class AgriculturalField extends RealEstate {
}
