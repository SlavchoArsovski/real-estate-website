package com.si.seminar.realestatewebsite.db.datamodel;

import java.math.BigDecimal;

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
    }

    public RealEstateType getRealEstateType() {
        return realEstateType;
    }

    public Integer getSquareMetersFrom() {
        return squareMetersFrom;
    }

    public Integer getSquareMetersTo() {
        return squareMetersTo;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getAddress() {
        return address;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public Boolean getCentralHeatingIncluded() {
        return centralHeatingIncluded;
    }

    public Boolean getAirConditioned() {
        return airConditioned;
    }

    public Boolean getYardIncluded() {
        return yardIncluded;
    }

    public Boolean getGarageIncluded() {
        return garageIncluded;
    }

    public Boolean getPoolIncluded() {
        return poolIncluded;
    }

    public Boolean getParkingIncluded() {
        return parkingIncluded;
    }

    public Boolean getElevatorIncluded() {
        return elevatorIncluded;
    }
}
