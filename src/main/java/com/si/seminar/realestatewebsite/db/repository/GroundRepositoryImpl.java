package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.Ground;

/**
 * Implementation of {@link RealEstateRepositoryImpl}.
 */
public class GroundRepositoryImpl extends RealEstateRepositoryImpl<Ground> {

    @Override
    protected Class getType() {
        return Ground.class;
    }

}
