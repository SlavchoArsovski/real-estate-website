package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.web.mapper.RealEstateMapper;
import com.si.seminar.realestatewebsite.web.service.RealEstateViewService;
import com.si.seminar.realestatewebsite.web.viewmodel.AdvertisementViewModel;
import com.si.seminar.realestatewebsite.web.viewmodel.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

/**
 * Controller for add advertisement page.
 */
@Controller
@RequestMapping("/addAdvertisement")
public class AddAdvertisementController {

    public static final String ADD_ADVERTISEMENT_VIEW_NAME = "addAdvertisement";
    public static final String VIEW_BEAN = "viewBean";

    @Autowired
    private RealEstateMapper realEstateMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addAdvertisement(Locale locale) {

        ModelAndView modelAndView = new ModelAndView(ADD_ADVERTISEMENT_VIEW_NAME);

        AdvertisementViewModel attributeValue = new AdvertisementViewModel();
        attributeValue.setRealEstateTypes(realEstateMapper.mapRealEstateTypes(locale));
        attributeValue.setSelectedRealEstateType(RealEstateType.HOUSE.name());
        attributeValue.setCities(realEstateMapper.mapCities(locale));
        attributeValue.setSelectedCity(City.Skopje.name());

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(RealEstateType.HOUSE.name());
        attributeValue.setValidProperties(validProperties);

        modelAndView.addObject("viewBean", attributeValue);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, params = {"realEstateChange"})
    public ModelAndView saveAdvertisement(
            @RequestParam(name = "selectedRealEstateType") RealEstateType selectedRealEstateType,
            Locale locale) {

        ModelAndView modelAndView = new ModelAndView(ADD_ADVERTISEMENT_VIEW_NAME);

        AdvertisementViewModel attributeValue = new AdvertisementViewModel();
        attributeValue.setRealEstateTypes(realEstateMapper.mapRealEstateTypes(locale));
        attributeValue.setSelectedRealEstateType(selectedRealEstateType.name());
        attributeValue.setCities(realEstateMapper.mapCities(locale));
        attributeValue.setSelectedCity(City.Skopje.name());

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(selectedRealEstateType.name());
        attributeValue.setValidProperties(validProperties);

        modelAndView.addObject("viewBean", attributeValue);
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.POST)
    public void saveAdvertisement(@ModelAttribute AdvertisementViewModel advertisementViewModel) {

        System.out.println("test");
    }
}
