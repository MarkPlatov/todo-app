package com.example.todoApp.controllers;

import com.example.todoApp.repos.TaskRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController extends BaseController{

    public HomeController() {
        route = "home";
        dataName = "homeData";
    }

    @GetMapping("/")
    public ModelAndView home(Map<String, Object> model) {
        return getDefaultModelAndView(model);
    }

}
