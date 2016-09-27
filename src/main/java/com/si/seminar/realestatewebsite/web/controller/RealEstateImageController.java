package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.services.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Handles requests for image download.
 */
@Controller
public class RealEstateImageController {

    @Autowired
    private RealEstateService realEstateService;

    @ResponseBody
    @RequestMapping(value = "/realEstateImage/{id}", method = RequestMethod.GET)
    public byte[] getRealEstateImage(
            @PathVariable("id") Long imageId,
            @RequestParam("type") String type) {

        return realEstateService.getRealEstateImage(imageId, type);
    }
}
