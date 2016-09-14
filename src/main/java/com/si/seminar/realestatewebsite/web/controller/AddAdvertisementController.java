package com.si.seminar.realestatewebsite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for add advertisement page.
 */
@Controller
@RequestMapping("/addAdvertisement")
public class AddAdvertisementController {

    public static final String ADD_ADVERTISEMENT_VIEW_NAME = "addAdvertisement";
    public static final String VIEW_BEAN = "viewBean";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addAdvertisement() {

        ModelAndView modelAndView = new ModelAndView(ADD_ADVERTISEMENT_VIEW_NAME);
        return modelAndView;
    }
}
