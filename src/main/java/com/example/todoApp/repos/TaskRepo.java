package com.example.todoApp.repos;

import com.example.todoApp.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Task, Long> {

}
