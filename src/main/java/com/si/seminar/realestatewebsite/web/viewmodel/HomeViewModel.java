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
    private Map<String, String> centralHeatingDropdown;
    private String selectedCentralHeating;
    private Map<String, String> airConditionedDropdown;
    private String selectedAirConditioned;
    private Map<String, String> yardIncludedDropdown;
    private String selectedYardIncluded;
    private Map<String, String> garageIncludedDropdown;
    private String selectedGarageIncluded;
    private Map<String, String> elevatorIncludedDropdown;
    private String selectedElevatorIncluded;
    private Integer numberOfRooms;
    private Integer numberOfBeds;
    private Map<String, String> parkingIncludedDropdown;
    private String selectedParkingIncluded;
    private Map<String, String> poolIncludedDropdown;
    private String selectedPoolIncluded;
    private List<String> validProperties = Lists.newArrayList();
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

    public Map<String, String> getCentralHeatingDropdown() {
        return centralHeatingDropdown;
    }

    public void setCentralHeatingDropdown(Map<String, String> centralHeatingDropdown) {
        this.centralHeatingDropdown = centralHeatingDropdown;
    }

    public String getSelectedCentralHeating() {
        return selectedCentralHeating;
    }

    public void setSelectedCentralHeating(String selectedCentralHeating) {
        this.selectedCentralHeating = selectedCentralHeating;
    }

    public Map<String, String> getAirConditionedDropdown() {
        return airConditionedDropdown;
    }

    public void setAirConditionedDropdown(Map<String, String> airConditionedDropdown) {
        this.airConditionedDropdown = airConditionedDropdown;
    }

    public String getSelectedAirConditioned() {
        return selectedAirConditioned;
    }

    public void setSelectedAirConditioned(String selectedAirConditioned) {
        this.selectedAirConditioned = selectedAirConditioned;
    }

    public Map<String, String> getYardIncludedDropdown() {
        return yardIncludedDropdown;
    }

    public void setYardIncludedDropdown(Map<String, String> yardIncludedDropdown) {
        this.yardIncludedDropdown = yardIncludedDropdown;
    }

    public String getSelectedYardIncluded() {
        return selectedYardIncluded;
    }

    public void setSelectedYardIncluded(String selectedYardIncluded) {
        this.selectedYardIncluded = selectedYardIncluded;
    }

    public Map<String, String> getGarageIncludedDropdown() {
        return garageIncludedDropdown;
    }

    public void setGarageIncludedDropdown(Map<String, String> garageIncludedDropdown) {
        this.garageIncludedDropdown = garageIncludedDropdown;
    }

    public String getSelectedGarageIncluded() {
        return selectedGarageIncluded;
    }

    public void setSelectedGarageIncluded(String selectedGarageIncluded) {
        this.selectedGarageIncluded = selectedGarageIncluded;
    }

    public Map<String, String> getElevatorIncludedDropdown() {
        return elevatorIncludedDropdown;
    }

    public void setElevatorIncludedDropdown(Map<String, String> elevatorIncludedDropdown) {
        this.elevatorIncludedDropdown = elevatorIncludedDropdown;
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

    public Map<String, String> getParkingIncludedDropdown() {
        return parkingIncludedDropdown;
    }

    public void setParkingIncludedDropdown(Map<String, String> parkingIncludedDropdown) {
        this.parkingIncludedDropdown = parkingIncludedDropdown;
    }

    public String getSelectedParkingIncluded() {
        return selectedParkingIncluded;
    }

    public void setSelectedParkingIncluded(String selectedParkingIncluded) {
        this.selectedParkingIncluded = selectedParkingIncluded;
    }

    public Map<String, String> getPoolIncludedDropdown() {
        return poolIncludedDropdown;
    }

    public void setPoolIncludedDropdown(Map<String, String> poolIncludedDropdown) {
        this.poolIncludedDropdown = poolIncludedDropdown;
    }

    public String getSelectedPoolIncluded() {
        return selectedPoolIncluded;
    }

    public void setSelectedPoolIncluded(String selectedPoolIncluded) {
        this.selectedPoolIncluded = selectedPoolIncluded;
    }

    public List<String> getValidProperties() {
        return validProperties;
    }

    public void setValidProperties(List<String> validProperties) {
        this.validProperties = validProperties;
    }

    public List<RealEstateViewModel> getRealEstates() {
        return realEstates;
    }

    public void setRealEstates(List<RealEstateViewModel> realEstates) {
        this.realEstates = realEstates;
    }
}
