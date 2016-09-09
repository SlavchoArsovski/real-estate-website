package com.si.seminar.realestatewebsite.web.viewmodel;

import java.util.List;
import java.util.Map;

/**
 * Home view model.
 */
public class HomeViewModel {

    private Map<String, String> realEstateTypesDropdown;
    private String selectedRealEstateType;

    private List<RealEstateViewModel> realEstates;

    public Map<String, String> getRealEstateTypesDropdown() {
        return realEstateTypesDropdown;
    }

    public void setRealEstateTypesDropdown(Map<String, String> realEstateTypesDropdown) {
        this.realEstateTypesDropdown = realEstateTypesDropdown;
    }

    public String getSelectedRealEstateType() {
        return selectedRealEstateType;
    }

    public void setSelectedRealEstateType(String selectedRealEstateType) {
        this.selectedRealEstateType = selectedRealEstateType;
    }

    public List<RealEstateViewModel> getRealEstates() {
        return realEstates;
    }

    public void setRealEstates(List<RealEstateViewModel> realEstates) {
        this.realEstates = realEstates;
    }
}
