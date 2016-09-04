package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Controller for home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    public static final String HOME_VIEW_NAME = "home";

    @Autowired
    private RealEstateRepository realEstateRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {

        List<RealEstate> all = realEstateRepository.findAll();
        RealEstate findById = realEstateRepository.findById(1000L);

        System.out.println("size" + all.size());
        return HOME_VIEW_NAME;
    }
}
