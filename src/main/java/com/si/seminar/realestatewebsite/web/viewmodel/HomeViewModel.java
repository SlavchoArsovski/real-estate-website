package com.si.seminar.realestatewebsite.web.viewmodel;

import java.util.List;

/**
 * Home view model.
 */
public class HomeViewModel {

    List<RealEstateViewModel> realEstates;

    public List<RealEstateViewModel> getRealEstates() {
        return realEstates;
    }

    public void setRealEstates(List<RealEstateViewModel> realEstates) {
        this.realEstates = realEstates;
    }
}
