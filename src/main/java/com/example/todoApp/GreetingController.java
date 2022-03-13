package com.example.todoApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
//    public ModelAndView home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    public ModelAndView greeting(Map<String, Object> model) {
//        model.addAttribute("name", name);
        return new ModelAndView("layouts/greeting", model);
    }

}
