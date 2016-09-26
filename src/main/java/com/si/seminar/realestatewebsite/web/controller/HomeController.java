package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.AdvertisementType;
import com.si.seminar.realestatewebsite.web.service.RealEstateViewService;
import com.si.seminar.realestatewebsite.web.viewmodel.HomePropertyChangeModel;
import com.si.seminar.realestatewebsite.web.viewmodel.HomeViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView home(
            @RequestParam(name = "advertisementType", required = false, defaultValue = "SALE") AdvertisementType advertisementType,
            Locale locale) {

        ModelAndView modelAndView = new ModelAndView(HOME_VIEW_NAME);

        HomeViewModel initialViewModel = viewService.getInitialViewModel(advertisementType, locale);
        modelAndView.addObject(VIEW_BEAN, initialViewModel);

        return modelAndView;
    }


    /**
     * Initially initializes the JSON model.
     *
     * @return HomeViewModel model as JSON.
     */
    @ResponseBody
    @RequestMapping(
            value = "/propertyChanged",
            method = RequestMethod.GET,
            params = {"advertisementType"})
    public HomeViewModel initializeJSONModel(
            @RequestParam(name = "advertisementType") AdvertisementType advertisementType,
            Locale locale) {

        HomeViewModel initialViewModel = viewService.getInitialViewModel(advertisementType, locale);
        return initialViewModel;
    }

    @RequestMapping(
            value = "/propertyChanged",
            method = RequestMethod.POST,
            params = {"changedProperty"})
    @ResponseBody
    public HomeViewModel propertyChanged(
            @ModelAttribute HomePropertyChangeModel homePropertyChangeModel,
            @RequestParam(name = "changedProperty") String changedProperty,
            Locale locale) {

        int pageNumber = 1;
        HomeViewModel viewModel =
                viewService.getViewModelAfterPropertyChange(
                        homePropertyChangeModel,
                        pageNumber,
                        locale);

        return viewModel;
    }

    @RequestMapping(
            value = "/pageNumberChanged",
            method = RequestMethod.POST,
            params = {"pageNumber"})
    @ResponseBody
    public HomeViewModel pageNumberChange(
            @ModelAttribute HomePropertyChangeModel homePropertyChangeModel,
            @RequestParam(name = "pageNumber") int pageNumber,
            Locale locale) {

        HomeViewModel viewModel =
                viewService.getViewModelAfterPropertyChange(
                        homePropertyChangeModel,
                        pageNumber,
                        locale);

        return viewModel;
    }
}
