package com.si.seminar.realestatewebsite.web.controller;

import com.si.seminar.realestatewebsite.web.utils.MessageResolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Login controller.
 */
@Controller
public class LoginController {

    public static final String LABEL_INVALID_CREDENTIALS =
            "realestatewebsite.fe.messages.login.label.invalidCredentials";
    public static final String LABEL_SUCCESSFUL_LOGOUT =
            "realestatewebsite.fe.messages.login.label.successfulLogout";

    @Autowired
    private MessageResolverService messageResolverService;

    /**
     * Handles login page.
     *
     * @param error  the error occurred message.
     * @param logout the logut message.
     * @return model and view.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            String invalidCredentialMessage =
                    messageResolverService.getResourceMessage(LABEL_INVALID_CREDENTIALS);
            model.addObject("error", invalidCredentialMessage);
        }

        if (logout != null) {
            String logoutSuccessMessage = messageResolverService.getResourceMessage(LABEL_SUCCESSFUL_LOGOUT);
            model.addObject("msg", logoutSuccessMessage);
        }
        model.setViewName("login");

        return model;

    }

    /**
     * Handles access denied page.
     *
     * @return model and view.
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDenied() {

        ModelAndView model = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }

        model.setViewName("403");
        return model;

    }


}
