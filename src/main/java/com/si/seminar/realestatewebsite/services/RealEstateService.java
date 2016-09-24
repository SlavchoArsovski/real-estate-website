package com.si.seminar.realestatewebsite.services;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;

import java.util.List;

/**
 * Real Estate Service.
 */
public interface RealEstateService {

    /**
     * Get Real Estates From Search Parameters.
     *
     * @param searchModel the search model.
     * @param pageNumber the page number.
     *
     * @return List of {@link RealEstate} that matched the given criteria.
     */
    List<RealEstate> getRealEstatesFromSearchParams(SearchModel searchModel, int pageNumber);

    /**
     * Gets number of Real Estates found From Search Parameters.
     *
     * @param searchModel the search model.
     *
     * @return count of total real estates found.
     */
    int getRealEstatesCountFromSearchParams(SearchModel searchModel);

    /**
     * Saves the given real estate type.
     *
     * @param realEstate the real estate to be persisted.
     */
    void saveRealEstate(RealEstate realEstate);
}
