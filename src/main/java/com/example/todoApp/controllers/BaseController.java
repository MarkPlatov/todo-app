package com.example.todoApp.controllers;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class BaseController {
    final static String VIEW_NAME = "layouts/app";
    static String route;
    static String dataName;

    <T> ModelAndView getDefaultModelAndView(
            Map<String, Object> model,
            Iterable<T> data) {
        model.put(dataName, data);
        return getDefaultModelAndView(model);
    }

    ModelAndView getDefaultModelAndView(
            Map<String, Object> model) {
        model.put("route", route);
        return new ModelAndView(VIEW_NAME, model);
    }

    public static String getRoute() {
        return route;
    }

    public static String getDataName() {
        return dataName;
    }

    public static void setDataName(String dataName) {
        BaseController.dataName = dataName;
    }

    public static void setRoute(String route) {
        BaseController.route = route;
    }
}
