package com.si.seminar.realestatewebsite.web.service;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.services.RealEstateService;
import com.si.seminar.realestatewebsite.web.mapper.AdvertisementDetailMapper;
import com.si.seminar.realestatewebsite.web.viewmodel.AdvertisementDetailViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Advertisement view service.
 */
@Service
public class AdvertisementViewService {

    @Autowired
    private RealEstateService realEstateService;

    @Autowired
    private AdvertisementDetailMapper mapper;

    @Autowired
    private AdvertisementDetailMapper advertisementDetailMapper;

    public AdvertisementDetailViewModel getAdvertisementDetailViewModel(
            Long realEstateId,
            RealEstateType realEstateType,
            Locale locale) {

        RealEstate realEstate =
                realEstateService.getRealEstateByIdAndType(realEstateId, realEstateType);

        return mapper.mapRealEstateToAdvertisementModel(realEstate, locale);
    }
}
