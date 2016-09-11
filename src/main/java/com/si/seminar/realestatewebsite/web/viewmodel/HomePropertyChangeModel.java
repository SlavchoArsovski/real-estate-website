package com.si.seminar.realestatewebsite.web.viewmodel;

import java.math.BigDecimal;

/**
 * Home property change model.
 */
public class HomePropertyChangeModel {

    private String selectedRealEstateType;
    private String selectedCity;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private Integer squareMetersFrom;
    private Integer squareMetersTo;

    public String getSelectedRealEstateType() {
        return selectedRealEstateType;
    }

    public void setSelectedRealEstateType(String selectedRealEstateType) {
        this.selectedRealEstateType = selectedRealEstateType;
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
