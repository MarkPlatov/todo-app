package com.example.todoApp;

import com.example.todoApp.domain.Task;
import com.example.todoApp.repos.TaskRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController {

    private final TaskRepo taskRepo;

    public HomeController(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping("/")
    public ModelAndView home(Map<String, Object> model) {
        return getHomeModelAndView(model, taskRepo.findAll());
    }


    @GetMapping("find")
    public ModelAndView findByTag(
            @RequestParam String tag,
            Map<String, Object> model
    ) {
        if (tag == null || tag.isEmpty()) {
            return redirectToRoot();
        }
        Iterable<Task> tasks;
        tasks = taskRepo.findByTag(tag);

        return getHomeModelAndView(model, tasks);
    }


    @PostMapping("create")
    public ModelAndView create(
            @RequestParam String text,
            @RequestParam String tag
    ) {
        if (text == null || text.isEmpty()) {
            return redirectToRoot();
        }
        Task task = new Task(text, tag);
        taskRepo.save(task);

        return redirectToRoot();
    }


    @PostMapping("delete")
    public ModelAndView delete(@RequestParam Integer id) {
        Task task = taskRepo.findById(id);
        if (task != null) {
            taskRepo.delete(task);
        }
        return redirectToRoot();
    }

    @PostMapping("edit")
    public ModelAndView edit(
            @RequestParam Integer id,
            @RequestParam String text,
            @RequestParam String tag) {
        Task task = taskRepo.findById(id);
        if (task != null) {
            task.setText(text);
            task.setTag(tag);
            taskRepo.save(task);
        }
        return redirectToRoot();
    }





    private ModelAndView getHomeModelAndView(
            Map<String, Object> model,
            Iterable<Task> tasks) {
        model.put("tasks", tasks);
        model.put("route", "home");
        return new ModelAndView("layouts/home", model);
    }

    private ModelAndView redirectToRoot() {
        return new ModelAndView("redirect:/");
    }

}