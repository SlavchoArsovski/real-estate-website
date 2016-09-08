package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.*;
import com.si.seminar.realestatewebsite.db.repository.ApartmentRepository;
import com.si.seminar.realestatewebsite.db.repository.HouseRepository;
import com.si.seminar.realestatewebsite.db.repository.RealEstateRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller for home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public static final String HOME_VIEW_NAME = "home";

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {

        return HOME_VIEW_NAME;
    }

    @RequestMapping(value = "/getAllHouses", method = RequestMethod.GET)
    @ResponseBody

    public List<House> getAllHouses() {

        SearchModel searchModel = new SearchModel
                .Builder(RealEstateType.HOUSE_VILLA)
                .garageIncluded(Boolean.TRUE)
                .yardIncluded(Boolean.TRUE)
                .airConditioned(Boolean.TRUE)
                .poolIncluded(Boolean.FALSE)
                .yearOfConstruction(2002)
                .centralHeatingIncluded(Boolean.FALSE)
                .build();

        List<House> all = houseRepository.getAllHousesFromSearchModel(searchModel, 0, 0);

        return all;
    }

    @RequestMapping(value = "/getAllApartments", method = RequestMethod.GET)
    @ResponseBody
    public List<Apartment> getAllApartments() {

        List<Apartment> all = apartmentRepository.findAll();

        return all;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
