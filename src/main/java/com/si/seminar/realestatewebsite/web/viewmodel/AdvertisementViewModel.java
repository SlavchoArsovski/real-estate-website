package com.si.seminar.realestatewebsite.web.viewmodel;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Advertisement view model.
 */
public class AdvertisementViewModel {

    private String selectedRealEstateType;
    private Map<String, String> realEstateTypes;
    private String description;
    private String address;
    private String selectedCity;
    private Map<String, String> cities;
    private BigDecimal price;
    private Integer squareMeters;
    private Integer yearOfConstruction;
    private Integer numberOfRooms;
    private Integer numberOfBeds;
    private Integer numberOfFloors;
    private Integer floorNumber;
    private boolean centralHeating;
    private boolean airConditioned;
    private boolean elevator;
    private boolean garage;
    private boolean parking;
    private boolean yard;
    private boolean pool;
    private String selectedAdvertisementType;
    private Map<String, String> advertisementTypes;
    private List<String> validProperties = Lists.newArrayList();

    public String getSelectedRealEstateType() {
        return selectedRealEstateType;
    }

    public void setSelectedRealEstateType(String selectedRealEstateType) {
        this.selectedRealEstateType = selectedRealEstateType;
    }

    public Map<String, String> getRealEstateTypes() {
        return realEstateTypes;
    }

    public void setRealEstateTypes(Map<String, String> realEstateTypes) {
        this.realEstateTypes = realEstateTypes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public void setYearOfConstruction(Integer yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
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

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean isCentralHeating() {
        return centralHeating;
    }

    public void setCentralHeating(boolean centralHeating) {
        this.centralHeating = centralHeating;
    }

    public boolean isAirConditioned() {
        return airConditioned;
    }

    public void setAirConditioned(boolean airConditioned) {
        this.airConditioned = airConditioned;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean isGarage() {
        return garage;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isYard() {
        return yard;
    }

    public void setYard(boolean yard) {
        this.yard = yard;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public String getSelectedAdvertisementType() {
        return selectedAdvertisementType;
    }

    public void setSelectedAdvertisementType(String selectedAdvertisementType) {
        this.selectedAdvertisementType = selectedAdvertisementType;
    }

    public Map<String, String> getAdvertisementTypes() {
        return advertisementTypes;
    }

    public void setAdvertisementTypes(Map<String, String> advertisementTypes) {
        this.advertisementTypes = advertisementTypes;
    }

    public List<String> getValidProperties() {
        return validProperties;
    }

    public void setValidProperties(List<String> validProperties) {
        this.validProperties = validProperties;
    }
}
