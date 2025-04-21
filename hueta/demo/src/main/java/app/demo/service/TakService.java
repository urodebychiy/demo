package app.demo.service;

import app.demo.DTO.TaskDTO;

import java.util.List;

public interface TakService {
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    void deleteTask(Long id);
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(Long id);
}
