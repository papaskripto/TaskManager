package com.papaskripto.tm.web.controller;

import com.papaskripto.tm.data.entity.TaskEntity;
import com.papaskripto.tm.data.repository.TaskRepository;
import com.papaskripto.tm.service.TaskService;
import com.papaskripto.tm.web.model.Task;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping ("/tasks")
public class TaskController {

//    private final TaskRepository taskRepository;
//
//    public TaskController (TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }
    private final TaskService taskService;

    public TaskController (TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasksPage (Model model) {
//        List<TaskEntity> taskEntities = this.taskRepository.findAll();
//        List<Task> tasks = new ArrayList<>(taskEntities.size());
//        taskEntities.forEach(task -> tasks.add (new Task(task.getTaskId(), task.getTaskName())));
        model.addAttribute("tasks", this.taskService.listAllTasks());
        return "tasks";
    }
}
