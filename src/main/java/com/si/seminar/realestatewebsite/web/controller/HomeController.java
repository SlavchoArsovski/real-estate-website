package com.si.seminar.realestatewebsite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sarsovsk on 21.08.2016.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "home";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "home";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody TestViewModel sayHello() {

        TestViewModel testViewModel = new TestViewModel();
        testViewModel.setName("name");
        testViewModel.setValue("value");
        return testViewModel;
    }
}
