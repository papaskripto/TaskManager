package com.papaskripto.tm.web.api;

import com.papaskripto.tm.service.TaskService;
import com.papaskripto.tm.web.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/api/tasks")
public class TaskApiController {

    private final TaskService taskService;

    public TaskApiController (TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll () {
        return taskService.listAllTasks();
    }

    @GetMapping ("/{id}")
    public Task getTask (@PathVariable (name = "id") UUID id) {
        return this.taskService.getTaskById(id);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Task addTask (@RequestBody Task task) {
        return this.taskService.addTask(task);
    }

    @PutMapping ("/{id}")
    public Task updateTask (@PathVariable (name = "id") UUID id, @RequestBody Task task) {
        return this.taskService.updateTask(task);
    }

    @DeleteMapping ("/{id}")
    public void deleteTask (@PathVariable (name = "id") UUID id) {
        this.taskService.deleteTask(id);
    }
}
