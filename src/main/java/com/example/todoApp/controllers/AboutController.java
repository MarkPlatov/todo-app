package com.example.todoApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AboutController extends BaseController{
    private static final String ROUTE = "about";
    private static final String DATA_NAME = "aboutData";

    @GetMapping("/about")
    public ModelAndView about(Map<String, Object> model) {
        return getDefaultModelAndView(model, ROUTE);
    }
}
