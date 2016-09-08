package com.si.seminar.realestatewebsite.services;

import com.google.common.collect.Lists;
import com.si.seminar.realestatewebsite.db.datamodel.OfficeSpace;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;
import com.si.seminar.realestatewebsite.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link RealEstateService}.
 */
@Service
public class RealEstateServiceImpl implements RealEstateService {

    @Value("${realEstateWebsite.home.realEstatesListComponent.pagesize}")
    private int pageSize;

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private GroundRepository groundRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GarageRepository garageRepository;

    @Autowired
    private OfficeSpaceRepository officeSpaceRepository;

    @Autowired
    private AgriculturalFieldRepository agriculturalFieldRepository;

    @SuppressWarnings("unchecked")
    @Override
    public List<RealEstate> getRealEstatesFromSearchParams(
            SearchModel searchModel,
            int pageNumber) {

        List<RealEstate> realEstates = Lists.newArrayList();
        RealEstateType selectedRealEstateType = searchModel.getRealEstateType();

        switch (selectedRealEstateType) {
            case HOUSE:
                realEstates = (List<RealEstate>) (List<?>)
                        houseRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case APARTMENT:
                realEstates = (List<RealEstate>) (List<?>)
                        apartmentRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case OFFICE_SPACE:
                realEstates = (List<RealEstate>) (List<?>)
                        officeSpaceRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case ROOM:
                realEstates = (List<RealEstate>) (List<?>)
                        roomRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case GARAGE:
                realEstates = (List<RealEstate>) (List<?>)
                        garageRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case GROUND:
                realEstates = (List<RealEstate>) (List<?>)
                        groundRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            case AGRICULTURAL_FIELD:
                realEstates = (List<RealEstate>) (List<?>)
                        agriculturalFieldRepository.getAllRealEstatesFromSearchModel(searchModel, pageNumber, pageSize);
                break;
            default:
                // TODO: find all
        }

        return realEstates;
    }
}
