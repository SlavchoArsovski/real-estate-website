package com.si.seminar.realestatewebsite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for success screen page.
 */
@Controller
@RequestMapping("/successScreen")
public class SuccessController {

    public static final String SUCCESS_VIEW_NAME = "successScreen";
    public static final String VIEW_BEAN = "viewBean";

    /**
     * Handles success page.
     *
     * @param message the message.
     * @return ModelAndView.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView successScreen(@ModelAttribute("msg") String message) {

        ModelAndView modelAndView = new ModelAndView(SUCCESS_VIEW_NAME);
        modelAndView.addObject("successMessage", message);

        return modelAndView;
    }
}
