package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Garage DB model.
 */
@Entity
@DiscriminatorValue("GARAGE")
public class Garage extends RealEstate {
}
