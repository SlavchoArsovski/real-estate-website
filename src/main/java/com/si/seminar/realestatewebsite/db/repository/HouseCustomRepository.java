package com.si.seminar.realestatewebsite.db.repository;

import com.si.seminar.realestatewebsite.db.datamodel.House;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;

import java.util.List;

/**
 * House Custom Repository.
 */
public interface HouseCustomRepository {

    List<House> getAllHousesFromSearchModel(SearchModel searchModel, int pageIndex, int pageSize);
}
