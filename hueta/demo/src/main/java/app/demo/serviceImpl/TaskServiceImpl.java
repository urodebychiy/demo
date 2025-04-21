package app.demo.serviceImpl;

import app.demo.DTO.TaskDTO;
import app.demo.mapper.TaskMapper;
import app.demo.model.entity.Task;
import app.demo.repository.TaskRepository;
import app.demo.service.TakService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TakService {
    private final TaskRepository taskRepository;
    private final TaskMapper mapper;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = mapper.toEntity(taskDTO);
        task = taskRepository.save(task);
        return mapper.toDTO(task);
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found"));
        task.setTaskName(taskDTO.getTaskName());
        task.setCreationDate(taskDTO.getCreationDate());
        task.setUpdateDate(taskDTO.getUpdateDate());
        Task taskUpdated = taskRepository.save(task);
        return mapper.toDTO(taskUpdated);
    }

     public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return mapper.toDTO(tasks);
    }

    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Task not found"));
        return mapper.toDTO(task);
    }
}
