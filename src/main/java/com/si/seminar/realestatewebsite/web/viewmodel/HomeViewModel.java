package com.si.seminar.realestatewebsite.web.viewmodel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Home view model.
 */
public class HomeViewModel extends ViewModelWithMessage {

    private Map<String, String> realEstateTypesDropdown;
    private String selectedRealEstateType;
    private Map<String, String> citiesDropdown;
    private String selectedCity;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private Integer squareMetersFrom;
    private Integer squareMetersTo;
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

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(BigDecimal priceTo) {
        this.priceTo = priceTo;
    }

    public Integer getSquareMetersFrom() {
        return squareMetersFrom;
    }

    public void setSquareMetersFrom(Integer squareMetersFrom) {
        this.squareMetersFrom = squareMetersFrom;
    }

    public Integer getSquareMetersTo() {
        return squareMetersTo;
    }

    public void setSquareMetersTo(Integer squareMetersTo) {
        this.squareMetersTo = squareMetersTo;
    }
}
