package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.db.datamodel.SearchModel;
import com.si.seminar.realestatewebsite.services.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * Controller for home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    public static final String HOME_VIEW_NAME = "home";

    @Autowired
    private RealEstateService realEstateService;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {

        return HOME_VIEW_NAME;
    }

    @RequestMapping(value = "/getAllHouses", method = RequestMethod.GET)
    @ResponseBody

    public List<RealEstate> getAllHouses() {

        SearchModel searchModel = new SearchModel
                .Builder(RealEstateType.HOUSE)
                .city("Skopje")
                .region("Kozle")
                .priceFrom(BigDecimal.valueOf(100000L))
                .priceTo(BigDecimal.valueOf(1000001L))
                .squareMetersFrom(200)
                .squareMetersTo(300)
                .garageIncluded(Boolean.TRUE)
                .yardIncluded(Boolean.TRUE)
                .airConditioned(Boolean.TRUE)
                .yearOfConstruction(2002)
                .centralHeatingIncluded(Boolean.FALSE)
                .build();

        List<RealEstate> realEstates = realEstateService.getRealEstatesFromSearchParams(searchModel, 0);

        return realEstates;
    }

}
