package com.papaskripto.tm.service;

import com.papaskripto.tm.data.entity.TaskEntity;
import com.papaskripto.tm.data.repository.TaskRepository;
import com.papaskripto.tm.web.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listAllTasks () {
        List<TaskEntity> taskEntities = this.taskRepository.findAll ();
        List<Task> tasks = new ArrayList<>(taskEntities.size ());
        taskEntities.forEach(task -> tasks.add(getTaskFromEntity (task)));
        return tasks;
    }

    public Task getTaskById (UUID id) {
        Optional<TaskEntity> taskEntity = this.taskRepository.findById (id);
        if (taskEntity.isEmpty ()) {
            return null;
        } else {
            return this.getTaskFromEntity(taskEntity.get());
        }
    }

    public Task addTask (Task task) {
        TaskEntity taskEntity = this.getTaskEntityFromTask (task);
        taskEntity = this.taskRepository.save(taskEntity);
        return this.getTaskFromEntity (taskEntity);
    }

    public Task updateTask (Task task) {
        TaskEntity taskEntity = this.getTaskEntityFromTask(task);
        taskEntity = this.taskRepository.save(taskEntity);
        return this.getTaskFromEntity(taskEntity);
    }

    public void deleteTask (UUID id) {
        this.taskRepository.deleteById(id);
    }

    private Task getTaskFromEntity (TaskEntity taskEntity) {
        return new Task(taskEntity.getTaskId(), taskEntity.getTaskName());
    }

    private TaskEntity getTaskEntityFromTask (Task task) {
        return new TaskEntity (task.getId(), task.getName());
    }
}
