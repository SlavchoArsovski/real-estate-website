package com.si.seminar.realestatewebsite.web.viewmodel;

import java.util.List;
import java.util.Map;

/**
 * Home view model.
 */
public class HomeViewModel {

    private Map<String, String> realEstateTypesDropdown;
    private String selectedRealEstateType;
    private Map<String, String> citiesDropdown;
    private String selectedCity;

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

    public Map<String, String> getCitiesDropdown() {
        return citiesDropdown;
    }

    public void setCitiesDropdown(Map<String, String> citiesDropdown) {
        this.citiesDropdown = citiesDropdown;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }
}
