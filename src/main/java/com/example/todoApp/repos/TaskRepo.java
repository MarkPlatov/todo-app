package com.example.todoApp.repos;

import com.example.todoApp.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepo extends CrudRepository<Task, Long> {
    List<Task> findByTag(String tag);
    Task findById(Integer id);
}
