package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.db.datamodel.RealEstateType;
import com.si.seminar.realestatewebsite.web.service.AdvertisementViewService;
import com.si.seminar.realestatewebsite.web.viewmodel.AdvertisementDetailViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Controller for advertisement detail page.
 */
@Controller
@RequestMapping("/advertisementDetail")
public class AdvertisementDetailController {

    public static final String ADD_ADVERTISEMENT_VIEW_NAME = "advertisementDetail";
    public static final String VIEW_BEAN = "viewBean";

    @Autowired
    private AdvertisementViewService advertisementViewService;

    /**
     * @param realEstateId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView advertisementDetail(
            @RequestParam(name = "realEstateId") Long realEstateId,
            @RequestParam(name = "realEstateType") RealEstateType realEstateType) {

        ModelAndView modelAndView = new ModelAndView(ADD_ADVERTISEMENT_VIEW_NAME);

        AdvertisementDetailViewModel advertisementDetailViewModel =
                advertisementViewService.getAdvertisementDetailViewModel(
                        realEstateId,
                        realEstateType);

        modelAndView.addObject(VIEW_BEAN, advertisementDetailViewModel);

        return modelAndView;
    }
}
