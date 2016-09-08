package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.OfficeSpace;

/**
 * Implementation of {@link RealEstateRepositoryImpl}.
 */
public class OfficeSpaceRepositoryImpl extends RealEstateRepositoryImpl<OfficeSpace> {

    @Override
    protected Class getType() {
        return OfficeSpace.class;
    }

}
