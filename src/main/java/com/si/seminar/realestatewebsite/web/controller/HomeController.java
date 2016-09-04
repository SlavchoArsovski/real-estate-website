package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstate;
import com.si.seminar.realestatewebsite.db.repository.RealEstateRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.applet.AppletContext;
import java.util.List;
import java.util.Locale;

/**
 * Controller for home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public static final String HOME_VIEW_NAME = "home";

    @Autowired
    private RealEstateRepository realEstateRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String home() {

        return HOME_VIEW_NAME;
    }

    @RequestMapping(value = "/getAllRealEstates", method = RequestMethod.GET)
    @ResponseBody
    public List<RealEstate> getAllRealEstates() {

        List<RealEstate> all = realEstateRepository.findAll();

        return all;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
