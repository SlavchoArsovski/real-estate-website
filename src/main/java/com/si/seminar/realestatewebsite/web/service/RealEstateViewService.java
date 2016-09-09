package com.si.seminar.realestatewebsite.web.service;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;
import com.si.seminar.realestatewebsite.services.RealEstateService;
import com.si.seminar.realestatewebsite.web.mapper.RealEstateMapper;
import com.si.seminar.realestatewebsite.web.viewmodel.HomeViewModel;
import com.si.seminar.realestatewebsite.web.viewmodel.RealEstateViewModel;
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

    public HomeViewModel getInitialViewModel(Locale locale) {

        SearchModel searchModel = new SearchModel
                .Builder(RealEstateType.HOUSE)
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
        homeViewModel.setSelectedRealEstateType("ALL");
        homeViewModel.setCitiesDropdown(realEstateMapper.mapCities(locale));
        homeViewModel.setSelectedCity("ALL");

        return homeViewModel;
    }

}
