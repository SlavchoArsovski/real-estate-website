package com.si.seminar.realestatewebsite.services;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;

import java.util.List;

/**
 * Real Estate Service.
 */
public interface RealEstateService {

    List<RealEstate> getRealEstatesFromSearchParams(SearchModel searchModel, int pageNumber);
}
