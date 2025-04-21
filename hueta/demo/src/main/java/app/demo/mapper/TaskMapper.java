package app.demo.mapper;

import app.demo.DTO.TaskDTO;
import app.demo.model.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {
    public TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setCreationDate(task.getCreationDate());
        dto.setUpdateDate(task.getUpdateDate());
        return dto;
    }

    public Task toEntity(TaskDTO dto) {
        Task entity = new Task();
        entity.setId(dto.getId());
        entity.setTaskName(dto.getTaskName());
        entity.setCreationDate(dto.getCreationDate());
        entity.setUpdateDate(dto.getUpdateDate());
        return entity;
    }


    public List<TaskDTO> toDTO(List<Task> entity) {
        return entity.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
