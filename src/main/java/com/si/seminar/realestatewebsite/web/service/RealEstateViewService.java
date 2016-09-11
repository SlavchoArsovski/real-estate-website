package com.si.seminar.realestatewebsite.web.service;

import com.google.common.collect.Lists;
import com.si.seminar.realestatewebsite.db.datamodel.*;
import com.si.seminar.realestatewebsite.services.RealEstateService;
import com.si.seminar.realestatewebsite.web.mapper.RealEstateMapper;
import com.si.seminar.realestatewebsite.web.viewmodel.City;
import com.si.seminar.realestatewebsite.web.viewmodel.HomePropertyChangeModel;
import com.si.seminar.realestatewebsite.web.viewmodel.HomeViewModel;
import com.si.seminar.realestatewebsite.web.viewmodel.RealEstateViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public HomeViewModel getInitialViewModel(AdvertisementType advertismentType, Locale locale) {

        SearchModel searchModel = new SearchModel
                .Builder(RealEstateType.HOUSE)
                .advertismentType(advertismentType)
                .build();

        List<RealEstate> realEstatesFromSearchParams =
                realEstateService.getRealEstatesFromSearchParams(searchModel, 0);

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

        return homeViewModel;
    }

    public HomeViewModel getViewModelAfterPropertyChange(
            HomePropertyChangeModel homePropertyChangeModel,
            AdvertisementType advertismentType,
            Locale locale) {

        String selectedCity =
                homePropertyChangeModel.getSelectedCity().equals("ALL")
                        ? null
                        : homePropertyChangeModel.getSelectedCity();

        SearchModel searchModel = new SearchModel
                .Builder(RealEstateType.valueOf(homePropertyChangeModel.getSelectedRealEstateType()))
                .advertismentType(advertismentType)
                .priceFrom(homePropertyChangeModel.getPriceFrom())
                .priceTo(homePropertyChangeModel.getPriceTo())
                .squareMetersTo(homePropertyChangeModel.getSquareMetersTo())
                .squareMetersFrom(homePropertyChangeModel.getSquareMetersFrom())
                .city(selectedCity)
                .build();


        List<RealEstate> realEstatesFromSearchParams =
                realEstateService.getRealEstatesFromSearchParams(searchModel, 0);

        List<RealEstateViewModel> viewModels =
                realEstatesFromSearchParams
                        .stream()
                        .map(realEstate -> {
                            return realEstateMapper.mapRealEstateToRealEstateViewModel(realEstate);
                        })
                        .collect(Collectors.toList());

        HomeViewModel homeViewModel = new HomeViewModel();
        homeViewModel.setPriceFrom(homePropertyChangeModel.getPriceFrom());
        homeViewModel.setPriceTo(homePropertyChangeModel.getPriceTo());
        homeViewModel.setRealEstates(viewModels);
        homeViewModel.setRealEstateTypesDropdown(realEstateMapper.mapRealEstateTypes(locale));
        homeViewModel.setSelectedRealEstateType(homePropertyChangeModel.getSelectedRealEstateType());
        homeViewModel.setCitiesDropdown(realEstateMapper.mapCities(locale));
        homeViewModel.setSelectedCity(homePropertyChangeModel.getSelectedCity());
        homeViewModel.setSquareMetersFrom(homePropertyChangeModel.getSquareMetersFrom());
        homeViewModel.setSquareMetersTo(homePropertyChangeModel.getSquareMetersTo());

        return homeViewModel;

    }
}
