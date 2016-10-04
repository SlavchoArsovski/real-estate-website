package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.web.mapper.RealEstateMapper;
import com.si.seminar.realestatewebsite.web.service.RealEstateViewService;
import com.si.seminar.realestatewebsite.web.utils.MessageResolverService;
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
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
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
    public static final String VIEW_BEAN = "advertisementForm";
    public static final String SUCCESSFULLY_ADDED_ADVERTISEMENT_MESSAGE_KEY =
            "realestatewebsite.fe.messages.general.successfullyAddedAdvertisement";

    @Autowired
    private RealEstateViewService realEstateViewService;

    @Autowired
    private RealEstateMapper realEstateMapper;

    @Autowired
    private AdvertisementValidator advertisementValidator;

    @Autowired
    private MessageResolverService messageResolverService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {

        binder.setValidator(advertisementValidator);

        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
    }

    /**
     * Controller for add advertisement page.
     *
     * @return {@link ModelAndView}.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String addAdvertisement(Model model) {

        AdvertisementViewModel initialAdvertisementViewModel =
                realEstateViewService.getInitialAdvertisementViewModel(RealEstateType.HOUSE);

        model.addAttribute(VIEW_BEAN, initialAdvertisementViewModel);

        return ADD_ADVERTISEMENT_VIEW_NAME;
    }

    /**
     * Handles real estate change.
     *
     * @param selectedRealEstateType the selected real estate type.
     * @return {@link ModelAndView}.
     */
    @RequestMapping(method = RequestMethod.POST, params = {"realEstateChange"})
    public String changeRealEstateType(
            @RequestParam(name = "selectedRealEstateType") RealEstateType selectedRealEstateType,
            Model model) {

        AdvertisementViewModel initialAdvertisementViewModel =
                realEstateViewService.getInitialAdvertisementViewModel(selectedRealEstateType);

        model.addAttribute(VIEW_BEAN, initialAdvertisementViewModel);

        return ADD_ADVERTISEMENT_VIEW_NAME;
    }

    /**
     * Handles submit advertisement form.
     *
     * @param advertisementViewModel the {@link AdvertisementViewModel}.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveAdvertisement(
            @ModelAttribute("advertisementForm") @Validated AdvertisementViewModel advertisementViewModel,
            BindingResult result,
            Model model,
            final RedirectAttributes redirectAttributes) {

        boolean noErrors = !result.hasErrors();

        if (noErrors) {

            realEstateViewService.saveAdvertisement(advertisementViewModel);

            String successMessage =
                    messageResolverService
                            .getResourceMessage(SUCCESSFULLY_ADDED_ADVERTISEMENT_MESSAGE_KEY);
            redirectAttributes.addFlashAttribute("msg", successMessage);

            return "redirect:successScreen";
        }

        advertisementViewModel.setRealEstateTypes(realEstateMapper.mapRealEstateTypes());
        Map<String, String> cities = realEstateMapper.mapCities();
        cities.remove("ALL");
        advertisementViewModel.setCities(cities);
        advertisementViewModel.setAdvertisementTypes(realEstateMapper.mapAdvertisementTypes());

        String selectedRealEstateType = advertisementViewModel.getSelectedRealEstateType();
        List<String> validProperties =
                realEstateMapper.mapValidPropertiesFromRealEstateType(selectedRealEstateType);
        advertisementViewModel.setValidProperties(validProperties);

        model.addAttribute(VIEW_BEAN, advertisementViewModel);

        return ADD_ADVERTISEMENT_VIEW_NAME;
    }
}
