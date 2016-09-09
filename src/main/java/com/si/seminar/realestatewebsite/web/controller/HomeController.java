package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.web.service.RealEstateViewService;
import com.si.seminar.realestatewebsite.web.viewmodel.HomeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Controller for home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    public static final String HOME_VIEW_NAME = "home";
    public static final String VIEW_BEAN = "viewBean";

    @Autowired
    private RealEstateViewService viewService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(Locale locale) {

        ModelAndView modelAndView = new ModelAndView(HOME_VIEW_NAME);

        HomeViewModel initialViewModel = viewService.getInitialViewModel(locale);
        modelAndView.addObject(VIEW_BEAN, initialViewModel);

        return modelAndView;
    }
}
