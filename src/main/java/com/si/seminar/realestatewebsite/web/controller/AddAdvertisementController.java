package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.web.mapper.RealEstateMapper;
import com.si.seminar.realestatewebsite.web.service.RealEstateViewService;
import com.si.seminar.realestatewebsite.web.validator.AdvertisementValidator;
import com.si.seminar.realestatewebsite.web.viewmodel.AdvertisementViewModel;
import com.si.seminar.realestatewebsite.web.viewmodel.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Controller for add advertisement page.
 */
@Controller
@RequestMapping("/addAdvertisement")
public class AddAdvertisementController {

    public static final String ADD_ADVERTISEMENT_VIEW_NAME = "addAdvertisement";
    public static final String VIEW_BEAN = "viewBean";

    @Autowired
    private RealEstateViewService realEstateViewService;

    @Autowired
    private RealEstateMapper realEstateMapper;

    @Autowired
    private AdvertisementValidator advertisementValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(advertisementValidator);
    }

    /**
     * Controller for add advertisement page.
     *
     * @param locale the locale.
     * @return {@link ModelAndView}.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addAdvertisement(Locale locale) {

        ModelAndView modelAndView = new ModelAndView(ADD_ADVERTISEMENT_VIEW_NAME);

        AdvertisementViewModel initialAdvertisementViewModel =
                realEstateViewService.getInitialAdvertisementViewModel(RealEstateType.HOUSE, locale);

        modelAndView.addObject(VIEW_BEAN, initialAdvertisementViewModel);

        return modelAndView;
    }

    /**
     * Handles real estate change.
     *
     * @param selectedRealEstateType the selected real estate type.
     * @param locale                 the locale.
     * @return {@link ModelAndView}.
     */
    @RequestMapping(method = RequestMethod.POST, params = {"realEstateChange"})
    public ModelAndView changeRealEstateType(
            @RequestParam(name = "selectedRealEstateType") RealEstateType selectedRealEstateType,
            Locale locale) {

        ModelAndView modelAndView = new ModelAndView(ADD_ADVERTISEMENT_VIEW_NAME);

        AdvertisementViewModel initialAdvertisementViewModel =
                realEstateViewService.getInitialAdvertisementViewModel(selectedRealEstateType, locale);

        modelAndView.addObject(VIEW_BEAN, initialAdvertisementViewModel);

        return modelAndView;
    }

    /**
     * Handles submit advertisement form.
     *
     * @param advertisementViewModel the {@link AdvertisementViewModel}.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView saveAdvertisement(
            @ModelAttribute @Validated AdvertisementViewModel advertisementViewModel,
            BindingResult result,
            final RedirectAttributes redirectAttributes,
            Locale locale) {

        boolean noErrors = !result.hasErrors();

        if (noErrors) {
            realEstateViewService.saveAdvertisement(advertisementViewModel);
            redirectAttributes.addFlashAttribute("msg", "Successfully added advertisement");
            return new ModelAndView("redirect:successScreen");
        }

        advertisementViewModel.setRealEstateTypes(realEstateMapper.mapRealEstateTypes(locale));
        Map<String, String> cities = realEstateMapper.mapCities(locale);
        cities.remove("ALL");
        advertisementViewModel.setCities(cities);
        advertisementViewModel.setAdvertisementTypes(realEstateMapper.mapAdvertisementTypes(locale));

        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(advertisementViewModel.getSelectedRealEstateType());
        advertisementViewModel.setValidProperties(validProperties);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(VIEW_BEAN, advertisementViewModel);

        return modelAndView;
    }
}
