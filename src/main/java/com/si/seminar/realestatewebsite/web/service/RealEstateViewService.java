package com.si.seminar.realestatewebsite.web.service;

import com.google.common.collect.Lists;
import com.si.seminar.realestatewebsite.configuration.spring.ExposedMessageSource;
import com.si.seminar.realestatewebsite.db.datamodel.AdvertisementType;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;
import com.si.seminar.realestatewebsite.services.RealEstateService;
import com.si.seminar.realestatewebsite.web.mapper.RealEstateMapper;
import com.si.seminar.realestatewebsite.web.viewmodel.HomePropertyChangeModel;
import com.si.seminar.realestatewebsite.web.viewmodel.HomeViewModel;
import com.si.seminar.realestatewebsite.web.viewmodel.RealEstateViewModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Real Estate View Service.
 * Contains methods which are preparing the data for the view.
 */
@Service
public class RealEstateViewService {

    @Autowired
    private RealEstateService realEstateService;

    @Autowired
    private RealEstateMapper realEstateMapper;

    @Autowired
    private ExposedMessageSource messageSource;


    public HomeViewModel getInitialViewModel(AdvertisementType advertismentType, Locale locale) {

        SearchModel searchModel = new SearchModel
                .Builder(RealEstateType.HOUSE)
                .advertismentType(advertismentType)
                .build();

        List<RealEstate> realEstatesFromSearchParams = Lists.newArrayList();
//                realEstateService.getRealEstatesFromSearchParams(searchModel, 0);

        List<RealEstateViewModel> viewModels =
                realEstatesFromSearchParams
                        .stream()
                        .map(realEstate -> {
                            return realEstateMapper.mapRealEstateToRealEstateViewModel(realEstate);
                        })
                        .collect(Collectors.toList());


        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setRealEstates(viewModels);
        homeViewModel.setRealEstateTypesDropdown(realEstateMapper.mapRealEstateTypes(locale));
        homeViewModel.setSelectedRealEstateType(RealEstateType.HOUSE.name());
        homeViewModel.setCitiesDropdown(realEstateMapper.mapCities(locale));
        homeViewModel.setSelectedCity("ALL");
        homeViewModel.setCentralHeatingDropdown(realEstateMapper.mapYesNoOptions(locale, "centralHeating"));
        homeViewModel.setSelectedCentralHeating("NO_SELECTION");
        homeViewModel.setAirConditionedDropdown(realEstateMapper.mapYesNoOptions(locale, "airConditioned"));
        homeViewModel.setSelectedAirConditioned("NO_SELECTION");
        homeViewModel.setYardIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "yard"));
        homeViewModel.setSelectedYardIncluded("NO_SELECTION");
        homeViewModel.setGarageIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "garage"));
        homeViewModel.setSelectedGarageIncluded("NO_SELECTION");
        homeViewModel.setElevatorIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "elevator"));
        homeViewModel.setSelectedElevatorIncluded("NO_SELECTION");
        homeViewModel.setPoolIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "pool"));
        homeViewModel.setSelectedPoolIncluded("NO_SELECTION");
        homeViewModel.setParkingIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "parking"));
        homeViewModel.setSelectedParkingIncluded("NO_SELECTION");
        homeViewModel.setMessages(messageSource.getAllMessages(locale));

        return homeViewModel;
    }

    public HomeViewModel getViewModelAfterPropertyChange(
            HomePropertyChangeModel homePropertyChangeModel,
            AdvertisementType advertisementType,
            Locale locale) {

        SearchModel searchModel =
                buildSearchModelFromPropertyChangeModel(homePropertyChangeModel, advertisementType);

        List<RealEstate> realEstatesFromSearchParams = Lists.newArrayList();
//                realEstateService.getRealEstatesFromSearchParams(searchModel, 0);

        List<RealEstateViewModel> realEstateViewModels =
                realEstatesFromSearchParams
                        .stream()
                        .map(realEstate -> {
                            return realEstateMapper.mapRealEstateToRealEstateViewModel(realEstate);
                        })
                        .collect(Collectors.toList());

        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setRealEstates(realEstateViewModels);

        homeViewModel.setCitiesDropdown(realEstateMapper.mapCities(locale));
        homeViewModel.setRealEstateTypesDropdown(realEstateMapper.mapRealEstateTypes(locale));
        homeViewModel.setCentralHeatingDropdown(realEstateMapper.mapYesNoOptions(locale, "centralHeating"));
        homeViewModel.setAirConditionedDropdown(realEstateMapper.mapYesNoOptions(locale, "airConditioned"));
        homeViewModel.setYardIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "yard"));
        homeViewModel.setGarageIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "garage"));
        homeViewModel.setElevatorIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "elevator"));
        homeViewModel.setPoolIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "pool"));
        homeViewModel.setParkingIncludedDropdown(realEstateMapper.mapYesNoOptions(locale, "parking"));
        homeViewModel.setMessages(messageSource.getAllMessages(locale));
        realEstateMapper.mapPropertyChangeModelToViewMode(homeViewModel, homePropertyChangeModel);

        return homeViewModel;

    }

    private SearchModel buildSearchModelFromPropertyChangeModel(
            HomePropertyChangeModel homePropertyChangeModel,
            AdvertisementType advertisementType) {

        SearchModel.Builder builder = new SearchModel
                .Builder(RealEstateType.valueOf(homePropertyChangeModel.getSelectedRealEstateType()))
                .advertismentType(advertisementType)
                .priceFrom(homePropertyChangeModel.getPriceFrom())
                .priceTo(homePropertyChangeModel.getPriceTo())
                .squareMetersTo(homePropertyChangeModel.getSquareMetersTo())
                .squareMetersFrom(homePropertyChangeModel.getSquareMetersFrom())
                .yearOfConstruction(homePropertyChangeModel.getYearOfConstruction())
                .numberOfRooms(homePropertyChangeModel.getNumberOfRooms())
                .numberOfBeds(homePropertyChangeModel.getNumberOfBeds());

        if (!StringUtils.equals("ALL", homePropertyChangeModel.getSelectedCity())) {
            builder.city(homePropertyChangeModel.getSelectedCity());
        }

        String selectedCentralHeating = homePropertyChangeModel.getSelectedCentralHeating();
        if (StringUtils.isNoneEmpty(selectedCentralHeating)) {
            boolean isCentralHeatingIncluded =
                    StringUtils.equals("YES", selectedCentralHeating);
            builder.centralHeatingIncluded(isCentralHeatingIncluded);
        }

        String selectedAirConditioned = homePropertyChangeModel.getSelectedAirConditioned();
        if (StringUtils.isNoneEmpty(selectedAirConditioned)) {
            boolean isAirConditioned =
                    StringUtils.equals("YES", selectedAirConditioned);
            builder.centralHeatingIncluded(isAirConditioned);
        }

        String selectedGarageIncluded = homePropertyChangeModel.getSelectedGarageIncluded();
        if (StringUtils.isNoneEmpty(selectedGarageIncluded)) {
            boolean isGarageIncluded =
                    StringUtils.equals("YES", selectedGarageIncluded);
            builder.centralHeatingIncluded(isGarageIncluded);
        }

        String selectedYardIncluded = homePropertyChangeModel.getSelectedYardIncluded();
        if (StringUtils.isNoneEmpty(selectedYardIncluded)) {
            boolean isYardIncluded =
                    StringUtils.equals("YES", selectedYardIncluded);
            builder.centralHeatingIncluded(isYardIncluded);
        }

        String selectedParkingIncluded = homePropertyChangeModel.getSelectedParkingIncluded();
        if (StringUtils.isNoneEmpty(selectedParkingIncluded)) {
            boolean isParkingIncluded =
                    StringUtils.equals("YES", selectedParkingIncluded);
            builder.centralHeatingIncluded(isParkingIncluded);
        }

        String selectedPoolIncluded = homePropertyChangeModel.getSelectedPoolIncluded();
        if (StringUtils.isNoneEmpty(selectedPoolIncluded)) {
            boolean isPoolIncluded =
                    StringUtils.equals("YES", selectedPoolIncluded);
            builder.centralHeatingIncluded(isPoolIncluded);
        }

        return builder.build();
    }
}
