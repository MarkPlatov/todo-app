package com.example.todoApp.controllers;

import com.example.todoApp.domain.Task;
import com.example.todoApp.repos.TaskRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static com.example.todoApp.helpers.StringHelper.isStringReallyExist;

@Controller
public class TasksController extends BaseController {
    private static final String ROUTE = "tasks";
    private static final String DATA_NAME = "tasks";

    private final TaskRepo taskRepo;

    public TasksController(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping("/tasks")
    public ModelAndView tasks(Map<String, Object> model) {
        return getDefaultModelAndView(model, taskRepo.findAll(), DATA_NAME, ROUTE);
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

        return getDefaultModelAndView(model, tasks, DATA_NAME, ROUTE);
    }


    @PostMapping("create")
    public ModelAndView create(
            @RequestParam String text,
            @RequestParam String tag
    ) {
        if (!isStringReallyExist(text)) {
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
            task.setTag(tag);
            task.setText(text);
            taskRepo.save(task);
        }
        return redirectToRoot();
    }



    private ModelAndView redirectToRoot() {
        return new ModelAndView("redirect:/" + ROUTE);
    }
}