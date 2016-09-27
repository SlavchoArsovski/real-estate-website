package com.si.seminar.realestatewebsite.web.viewmodel;

import com.google.common.collect.Maps;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Advertisement Detail View Model.
 */
public class AdvertisementDetailViewModel {

    private Long realEstateId;
    private String realEstateImageType;
    private Map<String, String> advertisementProperties = Maps.newLinkedHashMap();

    public Long getRealEstateId() {
        return realEstateId;
    }

    public void setRealEstateId(Long realEstateId) {
        this.realEstateId = realEstateId;
    }

    public String getRealEstateImageType() {
        return realEstateImageType;
    }

    public void setRealEstateImageType(String realEstateImageType) {
        this.realEstateImageType = realEstateImageType;
    }

    public Map<String, String> getAdvertisementProperties() {
        return advertisementProperties;
    }

    public void setAdvertisementProperties(Map<String, String> advertisementProperties) {
        this.advertisementProperties = advertisementProperties;
    }

    public void addAdvertisementProperty(String key, String value) {
        advertisementProperties.put(key, value);
    }
}

