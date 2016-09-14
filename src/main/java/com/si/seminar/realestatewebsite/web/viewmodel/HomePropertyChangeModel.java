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
    private Integer yearOfConstruction;
    private String selectedCentralHeating;
    private String selectedAirConditioned;
    private String selectedYardIncluded;
    private String selectedGarageIncluded;
    private String selectedElevatorIncluded;
    private Integer numberOfRooms;
    private Integer numberOfBeds;
    private String selectedParkingIncluded;
    private String selectedPoolIncluded;
    private String advertisementType;

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

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(Integer yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public String getSelectedCentralHeating() {
        return selectedCentralHeating;
    }

    public void setSelectedCentralHeating(String selectedCentralHeating) {
        this.selectedCentralHeating = selectedCentralHeating;
    }

    public String getSelectedAirConditioned() {
        return selectedAirConditioned;
    }

    public void setSelectedAirConditioned(String selectedAirConditioned) {
        this.selectedAirConditioned = selectedAirConditioned;
    }

    public String getSelectedYardIncluded() {
        return selectedYardIncluded;
    }

    public void setSelectedYardIncluded(String selectedYardIncluded) {
        this.selectedYardIncluded = selectedYardIncluded;
    }

    public String getSelectedGarageIncluded() {
        return selectedGarageIncluded;
    }

    public void setSelectedGarageIncluded(String selectedGarageIncluded) {
        this.selectedGarageIncluded = selectedGarageIncluded;
    }

    public String getSelectedElevatorIncluded() {
        return selectedElevatorIncluded;
    }

    public void setSelectedElevatorIncluded(String selectedElevatorIncluded) {
        this.selectedElevatorIncluded = selectedElevatorIncluded;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getSelectedParkingIncluded() {
        return selectedParkingIncluded;
    }

    public void setSelectedParkingIncluded(String selectedParkingIncluded) {
        this.selectedParkingIncluded = selectedParkingIncluded;
    }

    public String getSelectedPoolIncluded() {
        return selectedPoolIncluded;
    }

    public void setSelectedPoolIncluded(String selectedPoolIncluded) {
        this.selectedPoolIncluded = selectedPoolIncluded;
    }

    public String getAdvertisementType() {
        return advertisementType;
    }

    public void setAdvertisementType(String advertisementType) {
        this.advertisementType = advertisementType;
    }
}
