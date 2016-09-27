package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;

import java.util.List;

/**
 * House Custom Repository.
 */
public interface RealEstateCustomRepository<T extends RealEstate> {

    /**
     * Retrieve all real estate that match search parameters in {@link SearchModel}.
     *
     * @param searchModel the search model.
     * @param pageNumber  the page number.
     * @param pageSize    the page size.
     * @return list of real estates found.
     */
    List<T> getAllRealEstatesFromSearchModel(SearchModel searchModel, int pageNumber, int pageSize);

    /**
     * Find count of all real estate that match search parameters in {@link SearchModel}.
     *
     * @param searchModel the search model.
     * @return count of real estates found.
     */
    int getRealEstatesCountFromSearchModel(SearchModel searchModel);
}
