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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    private int pageSize = 5;

    public HomeViewModel getInitialViewModel(AdvertisementType advertisementType) {

        SearchModel searchModel = new SearchModel
                .Builder(RealEstateType.HOUSE)
                .advertismentType(advertisementType)
                .build();

        int pageNumber = 0;

        List<RealEstate> realEstatesFromSearchParams =
                realEstateService.getRealEstatesFromSearchParams(searchModel, pageNumber);

        int count =
                realEstateService.getRealEstatesCountFromSearchParams(searchModel);
        int numberOfPages = getNumberOfPages(count);

        List<RealEstateViewModel> viewModels =
                realEstatesFromSearchParams
                        .stream()
                        .map(realEstate -> {
                            return realEstateMapper.mapRealEstateToRealEstateViewModel(realEstate);
                        })
                        .collect(Collectors.toList());


        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setRealEstates(viewModels);
        homeViewModel.setRealEstateListPageNumber(pageNumber + 1);
        homeViewModel.setRealEstateListNumberOfPages(numberOfPages);
        homeViewModel.setRealEstateTypesDropdown(realEstateMapper.mapRealEstateTypes());
        homeViewModel.setSelectedRealEstateType(RealEstateType.HOUSE.name());
        homeViewModel.setCitiesDropdown(realEstateMapper.mapCities());
        homeViewModel.setSelectedCity("ALL");
        homeViewModel.setCentralHeatingDropdown(realEstateMapper.mapYesNoOptions("centralHeating"));
        homeViewModel.setSelectedCentralHeating("NO_SELECTION");
        homeViewModel.setAirConditionedDropdown(realEstateMapper.mapYesNoOptions("airConditioned"));
        homeViewModel.setSelectedAirConditioned("NO_SELECTION");
        homeViewModel.setYardIncludedDropdown(realEstateMapper.mapYesNoOptions("yard"));
        homeViewModel.setSelectedYardIncluded("NO_SELECTION");
        homeViewModel.setGarageIncludedDropdown(realEstateMapper.mapYesNoOptions("garage"));
        homeViewModel.setSelectedGarageIncluded("NO_SELECTION");
        homeViewModel.setElevatorIncludedDropdown(realEstateMapper.mapYesNoOptions("elevator"));
        homeViewModel.setSelectedElevatorIncluded("NO_SELECTION");
        homeViewModel.setPoolIncludedDropdown(realEstateMapper.mapYesNoOptions("pool"));
        homeViewModel.setSelectedPoolIncluded("NO_SELECTION");
        homeViewModel.setParkingIncludedDropdown(realEstateMapper.mapYesNoOptions("parking"));
        homeViewModel.setSelectedParkingIncluded("NO_SELECTION");
        homeViewModel.setMessages(messageSource.getAllMessages());
        homeViewModel.setAdvertisementType(advertisementType.name());

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(RealEstateType.HOUSE.name());
        homeViewModel.setValidProperties(validProperties);

        return homeViewModel;
    }

    private int getNumberOfPages(int count) {
        int numberOfPages;
        if (count < pageSize) {
            numberOfPages = 1;
        } else {
            numberOfPages = count / pageSize;

            if (count % pageSize != 0) {
                numberOfPages++;
            }
        }
        return numberOfPages;
    }

    /**
     * Get view model after property change.
     *
     * @param homePropertyChangeModel the home property change model.
     * @return home view model.
     */
    public HomeViewModel getViewModelAfterPropertyChange(
            HomePropertyChangeModel homePropertyChangeModel,
            int pageNumber) {

        SearchModel searchModel =
                buildSearchModelFromPropertyChangeModel(homePropertyChangeModel);

        List<RealEstate> realEstatesFromSearchParams =
                realEstateService.getRealEstatesFromSearchParams(searchModel, pageNumber - 1);

        int count =
                realEstateService.getRealEstatesCountFromSearchParams(searchModel);
        int numberOfPages = getNumberOfPages(count);

        List<RealEstateViewModel> realEstateViewModels =
                realEstatesFromSearchParams
                        .stream()
                        .map(realEstate -> {
                            return realEstateMapper.mapRealEstateToRealEstateViewModel(realEstate);
                        })
                        .collect(Collectors.toList());

        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setRealEstates(realEstateViewModels);
        homeViewModel.setRealEstateListPageNumber(pageNumber);
        homeViewModel.setRealEstateListNumberOfPages(numberOfPages);
        homeViewModel.setCitiesDropdown(realEstateMapper.mapCities());
        homeViewModel.setRealEstateTypesDropdown(realEstateMapper.mapRealEstateTypes());
        homeViewModel.setCentralHeatingDropdown(realEstateMapper.mapYesNoOptions("centralHeating"));
        homeViewModel.setAirConditionedDropdown(realEstateMapper.mapYesNoOptions("airConditioned"));
        homeViewModel.setYardIncludedDropdown(realEstateMapper.mapYesNoOptions("yard"));
        homeViewModel.setGarageIncludedDropdown(realEstateMapper.mapYesNoOptions("garage"));
        homeViewModel.setElevatorIncludedDropdown(realEstateMapper.mapYesNoOptions("elevator"));
        homeViewModel.setPoolIncludedDropdown(realEstateMapper.mapYesNoOptions("pool"));
        homeViewModel.setParkingIncludedDropdown(realEstateMapper.mapYesNoOptions("parking"));
        homeViewModel.setMessages(messageSource.getAllMessages());

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(homePropertyChangeModel.getSelectedRealEstateType());
        homeViewModel.setValidProperties(validProperties);
        realEstateMapper.mapPropertyChangeModelToViewModel(homeViewModel, homePropertyChangeModel);

        return homeViewModel;

    }

    private SearchModel buildSearchModelFromPropertyChangeModel(HomePropertyChangeModel homePropertyChangeModel) {

        RealEstateType realEstateType =
                RealEstateType.valueOf(homePropertyChangeModel.getSelectedRealEstateType());

        SearchModel.Builder builder = new SearchModel
                .Builder(realEstateType)
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
        if (StringUtils.isNoneEmpty(selectedPoolIncluded) && !StringUtils.equals(selectedPoolIncluded, "NO_SELECTION")) {
            boolean isPoolIncluded =
                    StringUtils.equals("YES", selectedPoolIncluded);
            builder.poolIncluded(isPoolIncluded);
        }

        String selectedElevator = homePropertyChangeModel.getSelectedElevatorIncluded();
        if (StringUtils.isNoneEmpty(selectedElevator) && !StringUtils.equals(selectedElevator, "NO_SELECTION")) {
            boolean isElevatorIncluded =
                    StringUtils.equals("YES", selectedElevator);
            builder.elevatorIncluded(isElevatorIncluded);
        }

        return builder.build();
    }

    public AdvertisementViewModel getInitialAdvertisementViewModel(RealEstateType realEstateType) {

        AdvertisementViewModel advertisementViewModel = new AdvertisementViewModel();
        advertisementViewModel.setRealEstateTypes(realEstateMapper.mapRealEstateTypes());
        advertisementViewModel.setSelectedRealEstateType(realEstateType.name());

        Map<String, String> cities = realEstateMapper.mapCities();
        cities.remove("ALL");
        advertisementViewModel.setCities(cities);
        advertisementViewModel.setAdvertisementTypes(realEstateMapper.mapAdvertisementTypes());
        advertisementViewModel.setSelectedCity(City.Skopje.name());

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(realEstateType.name());
        advertisementViewModel.setValidProperties(validProperties);

        return advertisementViewModel;
    }

    public void saveAdvertisement(AdvertisementViewModel advertisementViewModel) {

        RealEstate realEstate =
                realEstateMapper.mapAdvertisementViewModelToRealEstate(advertisementViewModel);

        if (!advertisementViewModel.getRealEstateImage().isEmpty()) {

            String contentType = advertisementViewModel.getRealEstateImage().getContentType();

            Pattern imageTypePattern = Pattern.compile("image/(.+)");
            Matcher matcher = imageTypePattern.matcher(contentType);

            if (!matcher.matches()) {
                throw new RuntimeException("incorrect image format");
            }

            String imageType = matcher.group(1);

            realEstate.setImageType(imageType);
        }

        realEstateService.saveRealEstate(realEstate);

        boolean imageUploaded = !advertisementViewModel.getRealEstateImage().isEmpty();

        if (imageUploaded) {
            realEstateService.saveRealEstateImage(advertisementViewModel.getRealEstateImage(), realEstate.getId());
        }
    }
}
