package com.si.seminar.realestatewebsite.db.datamodel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by sarsovsk on 06.09.2016.
 */
@Entity
@DiscriminatorValue("GROUND")
public class Ground extends RealEstate {
}
