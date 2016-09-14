package com.si.seminar.realestatewebsite.db.datamodel;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Contains search result params.
 */
public class SearchModel {

    // Required parameters
    private final RealEstateType realEstateType;

    // Optional parameters
    private final Integer squareMetersFrom;
    private final Integer squareMetersTo;
    private final String city;
    private final String region;
    private final String address;
    private final BigDecimal priceFrom;
    private final BigDecimal priceTo;
    private final Integer yearOfConstruction;
    private final Boolean centralHeatingIncluded;
    private final Boolean airConditioned;
    private final Boolean yardIncluded;
    private final Boolean garageIncluded;
    private final Boolean poolIncluded;
    private final Boolean parkingIncluded;
    private final Boolean elevatorIncluded;
    private final Integer numberOfRooms;
    private final Integer numberOfBeds;
    private final AdvertisementType advertisementType;

    public static class Builder {

        // Required parameters
        private final RealEstateType realEstateType;

        // Optional parameters
        private Integer squareMetersFrom;
        private Integer squareMetersTo;
        private String city;
        private String region;
        private String address;
        private BigDecimal priceFrom;
        private BigDecimal priceTo;
        private Integer yearOfConstruction;
        private Boolean centralHeatingIncluded;
        private Boolean airConditioned;
        private Boolean yardIncluded;
        private Boolean garageIncluded;
        private Boolean poolIncluded;
        private Boolean parkingIncluded;
        private Boolean elevatorIncluded;
        private Integer numberOfRooms;
        private Integer numberOfBeds;
        private AdvertisementType advertisementType;

        public Builder(RealEstateType realEstateType) {
            this.realEstateType = realEstateType;
        }

        public Builder squareMetersFrom(Integer squareMetersFrom) {
            this.squareMetersFrom = squareMetersFrom;
            return this;
        }

        public Builder squareMetersTo(Integer squareMetersTo) {
            this.squareMetersTo = squareMetersTo;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder priceFrom(BigDecimal priceFrom) {
            this.priceFrom = priceFrom;
            return this;
        }

        public Builder priceTo(BigDecimal priceTo) {
            this.priceTo = priceTo;
            return this;
        }

        public Builder yearOfConstruction(Integer yearOfConstruction) {
            this.yearOfConstruction = yearOfConstruction;
            return this;
        }

        public Builder centralHeatingIncluded(Boolean centralHeatingIncluded) {
            this.centralHeatingIncluded = centralHeatingIncluded;
            return this;
        }

        public Builder airConditioned(Boolean airConditioned) {
            this.airConditioned = airConditioned;
            return this;
        }

        public Builder yardIncluded(Boolean yardIncluded) {
            this.yardIncluded = yardIncluded;
            return this;
        }

        public Builder garageIncluded(Boolean garageIncluded) {
            this.garageIncluded = garageIncluded;
            return this;
        }

        public Builder poolIncluded(Boolean poolIncluded) {
            this.poolIncluded = poolIncluded;
            return this;
        }

        public Builder parkingIncluded(Boolean parkingIncluded) {
            this.parkingIncluded = parkingIncluded;
            return this;
        }

        public Builder elevatorIncluded(Boolean elevatorIncluded) {
            this.elevatorIncluded = elevatorIncluded;
            return this;
        }

        public Builder numberOfRooms(Integer numberOfRooms) {
            this.numberOfRooms = numberOfRooms;
            return this;
        }

        public Builder numberOfBeds(Integer numberOfBeds) {
            this.numberOfBeds = numberOfBeds;
            return this;
        }

        public Builder advertismentType(AdvertisementType advertisementType) {
            this.advertisementType = advertisementType;
            return this;
        }

        public SearchModel build() {
            return new SearchModel(this);
        }
    }

    private SearchModel(Builder builder) {
        this.realEstateType = builder.realEstateType;
        this.squareMetersFrom = builder.squareMetersFrom;
        this.squareMetersTo = builder.squareMetersTo;
        this.city = builder.city;
        this.region = builder.region;
        this.address = builder.address;
        this.priceFrom = builder.priceFrom;
        this.priceTo = builder.priceTo;
        this.yearOfConstruction = builder.yearOfConstruction;
        this.centralHeatingIncluded = builder.centralHeatingIncluded;
        this.airConditioned = builder.airConditioned;
        this.yardIncluded = builder.yardIncluded;
        this.garageIncluded = builder.garageIncluded;
        this.poolIncluded = builder.poolIncluded;
        this.parkingIncluded = builder.parkingIncluded;
        this.elevatorIncluded = builder.elevatorIncluded;
        this.numberOfRooms = builder.numberOfRooms;
        this.numberOfBeds = builder.numberOfBeds;
        this.advertisementType = builder.advertisementType;
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public Optional<Integer> getSquareMetersFrom() {
        return Optional.ofNullable(squareMetersFrom);
    }

    public Optional<Integer> getSquareMetersTo() {
        return Optional.ofNullable(squareMetersTo);
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }

    public Optional<String> getAddress() {
        return Optional.ofNullable(address);
    }

    public Optional<BigDecimal> getPriceFrom() {
        return Optional.ofNullable(priceFrom);
    }

    public Optional<BigDecimal> getPriceTo() {
        return Optional.ofNullable(priceTo);
    }

    public Optional<Integer> getYearOfConstruction() {
        return Optional.ofNullable(yearOfConstruction);
    }

    public Optional<Boolean> getCentralHeatingIncluded() {
        return Optional.ofNullable(centralHeatingIncluded);
    }

    public Optional<Boolean> getAirConditioned() {
        return Optional.ofNullable(airConditioned);
    }

    public Optional<Boolean> getYardIncluded() {
        return Optional.ofNullable(yardIncluded);
    }

    public Optional<Boolean> getGarageIncluded() {
        return Optional.ofNullable(garageIncluded);
    }

    public Optional<Boolean> getPoolIncluded() {
        return Optional.ofNullable(poolIncluded);
    }

    public Optional<Boolean> getParkingIncluded() {
        return Optional.ofNullable(parkingIncluded);
    }

    public Optional<Boolean> getElevatorIncluded() {
        return Optional.ofNullable(elevatorIncluded);
    }

    public Optional<Integer> getNumberOfRooms() {
        return Optional.ofNullable(numberOfRooms);
    }

    public Optional<Integer> getNumberOfBeds() {
        return Optional.ofNullable(numberOfBeds);
    }

    public Optional<AdvertisementType> getAdvertisementType() {
        return Optional.ofNullable(advertisementType);
    }
}
