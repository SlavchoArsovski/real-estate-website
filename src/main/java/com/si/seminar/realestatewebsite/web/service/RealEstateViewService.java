package com.si.seminar.realestatewebsite.web.service;

import com.si.seminar.realestatewebsite.configuration.spring.ExposedMessageSource;
import com.si.seminar.realestatewebsite.db.datamodel.AdvertisementType;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;
import com.si.seminar.realestatewebsite.services.RealEstateService;
import com.si.seminar.realestatewebsite.web.mapper.RealEstateMapper;
import com.si.seminar.realestatewebsite.web.viewmodel.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
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


    public HomeViewModel getInitialViewModel(AdvertisementType advertisementType, Locale locale) {

        SearchModel searchModel = new SearchModel
                .Builder(RealEstateType.HOUSE)
                .advertismentType(advertisementType)
                .build();

        List<RealEstate> realEstatesFromSearchParams =
                realEstateService.getRealEstatesFromSearchParams(searchModel, 0);

        int count =
                realEstateService.getRealEstatesCountFromSearchParams(searchModel);

        List<RealEstateViewModel> viewModels =
                realEstatesFromSearchParams
                        .stream()
                        .map(realEstate -> {
                            return realEstateMapper.mapRealEstateToRealEstateViewModel(realEstate);
                        })
                        .collect(Collectors.toList());


        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setRealEstates(viewModels);
        homeViewModel.setRealEstateCount(count);
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
        homeViewModel.setAdvertisementType(advertisementType.name());

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(RealEstateType.HOUSE.name());
        homeViewModel.setValidProperties(validProperties);

        return homeViewModel;
    }

    /**
     * Get view model after property change.
     *
     * @param homePropertyChangeModel the home property change model.
     * @param locale                  the locale.
     * @return home view model.
     */
    public HomeViewModel getViewModelAfterPropertyChange(HomePropertyChangeModel homePropertyChangeModel, Locale locale) {

        SearchModel searchModel =
                buildSearchModelFromPropertyChangeModel(homePropertyChangeModel);

        List<RealEstate> realEstatesFromSearchParams =
                realEstateService.getRealEstatesFromSearchParams(searchModel, 0);

        int count =
                realEstateService.getRealEstatesCountFromSearchParams(searchModel);

        List<RealEstateViewModel> realEstateViewModels =
                realEstatesFromSearchParams
                        .stream()
                        .map(realEstate -> {
                            return realEstateMapper.mapRealEstateToRealEstateViewModel(realEstate);
                        })
                        .collect(Collectors.toList());

        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setRealEstates(realEstateViewModels);
        homeViewModel.setRealEstateCount(count);
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

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(homePropertyChangeModel.getSelectedRealEstateType());
        homeViewModel.setValidProperties(validProperties);
        realEstateMapper.mapPropertyChangeModelToViewModel(homeViewModel, homePropertyChangeModel);

        return homeViewModel;

    }

    private SearchModel buildSearchModelFromPropertyChangeModel(HomePropertyChangeModel homePropertyChangeModel) {

        SearchModel.Builder builder = new SearchModel
                .Builder(RealEstateType.valueOf(homePropertyChangeModel.getSelectedRealEstateType()))
                .advertismentType(AdvertisementType.valueOf(homePropertyChangeModel.getAdvertisementType()))
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
        if (StringUtils.isNoneEmpty(selectedCentralHeating) && !StringUtils.equals(selectedCentralHeating, "NO_SELECTION")) {
            boolean isCentralHeatingIncluded =
                    StringUtils.equals("YES", selectedCentralHeating);
            builder.centralHeatingIncluded(isCentralHeatingIncluded);
        }

        String selectedAirConditioned = homePropertyChangeModel.getSelectedAirConditioned();
        if (StringUtils.isNoneEmpty(selectedAirConditioned) && !StringUtils.equals(selectedAirConditioned, "NO_SELECTION")) {
            boolean isAirConditioned =
                    StringUtils.equals("YES", selectedAirConditioned);
            builder.airConditioned(isAirConditioned);
        }

        String selectedGarageIncluded = homePropertyChangeModel.getSelectedGarageIncluded();
        if (StringUtils.isNoneEmpty(selectedGarageIncluded) && !StringUtils.equals(selectedGarageIncluded, "NO_SELECTION")) {
            boolean isGarageIncluded =
                    StringUtils.equals("YES", selectedGarageIncluded);
            builder.garageIncluded(isGarageIncluded);
        }

        String selectedYardIncluded = homePropertyChangeModel.getSelectedYardIncluded();
        if (StringUtils.isNoneEmpty(selectedYardIncluded) && !StringUtils.equals(selectedYardIncluded, "NO_SELECTION")) {
            boolean isYardIncluded =
                    StringUtils.equals("YES", selectedYardIncluded);
            builder.yardIncluded(isYardIncluded);
        }

        String selectedParkingIncluded = homePropertyChangeModel.getSelectedParkingIncluded();
        if (StringUtils.isNoneEmpty(selectedParkingIncluded) && !StringUtils.equals(selectedParkingIncluded, "NO_SELECTION")) {
            boolean isParkingIncluded =
                    StringUtils.equals("YES", selectedParkingIncluded);
            builder.parkingIncluded(isParkingIncluded);
        }

        String selectedPoolIncluded = homePropertyChangeModel.getSelectedPoolIncluded();
        if (StringUtils.isNoneEmpty(selectedPoolIncluded) && !StringUtils.equals(selectedParkingIncluded, "NO_SELECTION")) {
            boolean isPoolIncluded =
                    StringUtils.equals("YES", selectedPoolIncluded);
            builder.poolIncluded(isPoolIncluded);
        }

        return builder.build();
    }

    public AdvertisementViewModel getInitialAdvertisementViewModel(RealEstateType realEstateType, Locale locale) {

        AdvertisementViewModel advertisementViewModel = new AdvertisementViewModel();
        advertisementViewModel.setRealEstateTypes(realEstateMapper.mapRealEstateTypes(locale));
        advertisementViewModel.setSelectedRealEstateType(realEstateType.name());

        Map<String, String> cities = realEstateMapper.mapCities(locale);
        cities.remove("ALL");
        advertisementViewModel.setCities(cities);
        advertisementViewModel.setAdvertisementTypes(realEstateMapper.mapAdvertisementTypes(locale));
        advertisementViewModel.setSelectedCity(City.Skopje.name());

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(realEstateType.name());
        advertisementViewModel.setValidProperties(validProperties);

        return advertisementViewModel;
    }

    public void saveAdvertisement(AdvertisementViewModel advertisementViewModel) {

        RealEstate realEstate =
                realEstateMapper.mapAdvertisementViewModelToRealEstate(advertisementViewModel);

        realEstateService.saveRealEstate(realEstate);

    }
}
