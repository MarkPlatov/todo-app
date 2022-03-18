package com.example.todoApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController extends BaseController{
    private static final String ROUTE = "home";
    private static final String DATA_NAME = "homeData";

    @GetMapping("/")
    public ModelAndView home(Map<String, Object> model) {
        return getDefaultModelAndView(model, ROUTE);
    }

}
