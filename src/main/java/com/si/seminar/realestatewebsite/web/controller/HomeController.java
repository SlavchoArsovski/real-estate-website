package com.si.seminar.realestatewebsite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for home page.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    public static final String HOME_VIEW_NAME = "home";

    @RequestMapping(method = RequestMethod.GET)
    public String home() {

        return HOME_VIEW_NAME;

    }
}
