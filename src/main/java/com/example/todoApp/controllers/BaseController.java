package com.example.todoApp.controllers;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class BaseController {
    final static String VIEW_NAME = "layouts/app";

    <T> ModelAndView getDefaultModelAndView(
            Map<String, Object> model,
            Iterable<T> data,
            String dataName,
            String route) {
        model.put(dataName, data);
        return getDefaultModelAndView(model, route);
    }

    ModelAndView getDefaultModelAndView(
            Map<String, Object> model,
            String route) {
        model.put("route", route);
        return new ModelAndView(VIEW_NAME, model);
    }

}
