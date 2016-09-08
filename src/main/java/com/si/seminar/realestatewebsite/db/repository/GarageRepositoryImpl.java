package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.Garage;

/**
 * Implementation of {@link RealEstateRepositoryImpl}.
 */
public class GarageRepositoryImpl extends RealEstateRepositoryImpl<Garage> {

    @Override
    protected Class getType() {
        return Garage.class;
    }

}
