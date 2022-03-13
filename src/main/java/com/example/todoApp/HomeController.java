package com.example.todoApp;

import com.example.todoApp.domain.Task;
import com.example.todoApp.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/")
//    public ModelAndView home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    public ModelAndView home(Map<String, Object> model) {
        return getHomeModelAndView(model, taskRepo.findAll());
    }

    @PostMapping("create")
    public ModelAndView create(
            @RequestParam String text,
            @RequestParam String tag,
            Map<String, Object> model
    ) {
        Task task = new Task(text, tag);
        taskRepo.save(task);

        return getHomeModelAndView(model, taskRepo.findAll());
    }

    @PostMapping("find")
    public ModelAndView find(
            @RequestParam String filter,
            Map<String, Object> model
    ) {
        Iterable<Task> tasks;
        if (filter == null || filter.isEmpty()) {
            tasks = taskRepo.findAll();
        } else {
            tasks = taskRepo.findByTag(filter);
        }
        return getHomeModelAndView(model, tasks);
    }

    @PostMapping("delete")
    public ModelAndView delete(
            @RequestParam Integer id,
            Map<String, Object> model
    ) {
        Task task = taskRepo.findById(id);
        System.out.println("Trying to del. id = " + id);
        if (task != null) {
            taskRepo.delete(taskRepo.findById(id));
        }
        return getHomeModelAndView(model, taskRepo.findAll());
    }

    private ModelAndView getHomeModelAndView(Map<String, Object> model, Iterable<Task> tasks) {
        model.put("tasks", tasks);
        model.put("route", "home");
        return new ModelAndView("layouts/home", model);
    }

}