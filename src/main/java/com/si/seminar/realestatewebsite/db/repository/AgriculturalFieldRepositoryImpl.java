package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.AgriculturalField;

/**
 * Implementation of {@link RealEstateRepositoryImpl}.
 */
public class AgriculturalFieldRepositoryImpl extends RealEstateRepositoryImpl<AgriculturalField> {

    @Override
    protected Class getType() {
        return AgriculturalField.class;
    }

}
