package com.si.seminar.realestatewebsite.web.viewmodel;

import com.google.common.collect.Lists;

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
    private Integer yearOfConstruction;
    private boolean centralHeatingIncluded;
    private boolean airConditioned;
    private boolean yardIncluded;
    private boolean garageIncluded;
    private boolean elevatorIncluded;
    private Integer numberOfFloors;
    private Integer numberOfBeds;
    private Integer numberOfOffices;
    private boolean parkingIncluded;

    private List<RealEstateViewModel> realEstates = Lists.newArrayList();

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

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(Integer yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public boolean isCentralHeatingIncluded() {
        return centralHeatingIncluded;
    }

    public void setCentralHeatingIncluded(boolean centralHeatingIncluded) {
        this.centralHeatingIncluded = centralHeatingIncluded;
    }

    public boolean isAirConditioned() {
        return airConditioned;
    }

    public void setAirConditionedIncluded(boolean airConditioned) {
        this.airConditioned = airConditioned;
    }

    public boolean isYardIncluded() {
        return yardIncluded;
    }

    public void setYardIncluded(boolean yardIncluded) {
        this.yardIncluded = yardIncluded;
    }

    public boolean isGarageIncluded() {
        return garageIncluded;
    }

    public void setGarageIncluded(boolean garageIncluded) {
        this.garageIncluded = garageIncluded;
    }

    public boolean isElevatorIncluded() {
        return elevatorIncluded;
    }

    public void setElevatorIncluded(boolean elevatorIncluded) {
        this.elevatorIncluded = elevatorIncluded;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Integer getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(Integer numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

    public boolean isParkingIncluded() {
        return parkingIncluded;
    }

    public void setParkingIncluded(boolean parkingIncluded) {
        this.parkingIncluded = parkingIncluded;
    }

    public List<RealEstateViewModel> getRealEstates() {
        return realEstates;
    }

    public void setRealEstates(List<RealEstateViewModel> realEstates) {
        this.realEstates = realEstates;
    }
}
