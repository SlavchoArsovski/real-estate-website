package com.si.seminar.realestatewebsite.services;

import com.si.seminar.realestatewebsite.db.datamodel.*;
import com.si.seminar.realestatewebsite.db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        List<RealEstate> realEstates;
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
                throw new RuntimeException("Not supported real estate type");
        }

        return realEstates;
    }

    @Override
    public int getRealEstatesCountFromSearchParams(SearchModel searchModel) {

        int count;
        RealEstateType selectedRealEstateType = searchModel.getRealEstateType();

        switch (selectedRealEstateType) {
            case HOUSE:
                count = houseRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case APARTMENT:
                count = apartmentRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case OFFICE_SPACE:
                count = officeSpaceRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case ROOM:
                count = roomRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case GARAGE:
                count = garageRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case GROUND:
                count = groundRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            case AGRICULTURAL_FIELD:
                count = agriculturalFieldRepository.getRealEstatesCountFromSearchModel(searchModel);
                break;
            default:
                throw new RuntimeException("Not supported real estate type");
        }

        return count;
    }

    @Override
    public void saveRealEstate(RealEstate realEstate) {

        realEstate.setCreatedOn(new Date());

        switch (realEstate.getRealEstateType()) {
            case HOUSE:
                houseRepository.save((House) realEstate);
                break;
            case APARTMENT:
                apartmentRepository.save((Apartment) realEstate);
                break;
            case OFFICE_SPACE:
                officeSpaceRepository.save((OfficeSpace) realEstate);
                break;
            case ROOM:
                roomRepository.save((Room) realEstate);
                break;
            case GARAGE:
                garageRepository.save((Garage) realEstate);
                break;
            case GROUND:
                groundRepository.save((Ground) realEstate);
                break;
            case AGRICULTURAL_FIELD:
                agriculturalFieldRepository.save((AgriculturalField) realEstate);
                break;
            default:
                throw new RuntimeException("Not supported real estate type");
        }


    }
}
