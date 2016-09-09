package com.si.seminar.realestatewebsite.web.mapper;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.web.viewmodel.RealEstateViewModel;

/**
 * Contains methods for mapping real estate to view models.
 */
public final class RealEstateMapper {

    public static RealEstateViewModel mapRealEstateToRealEstateViewModel(RealEstate realEstate) {

        RealEstateViewModel realEstateViewModel = new RealEstateViewModel();

        realEstateViewModel.setRealEstateType(realEstate.getRealEstateType().name());
        realEstateViewModel.setCity(realEstate.getCity());
        realEstateViewModel.setDescription(realEstate.getDescription());
        realEstateViewModel.setAddress(realEstate.getAddress());
        realEstateViewModel.setRegion(realEstate.getRegion());

        return realEstateViewModel;
    }
}
