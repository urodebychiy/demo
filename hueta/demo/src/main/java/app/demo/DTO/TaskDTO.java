package app.demo.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {
    private Long id;
    private String taskName;
    private LocalDate creationDate;
    private LocalDate updateDate;
}
