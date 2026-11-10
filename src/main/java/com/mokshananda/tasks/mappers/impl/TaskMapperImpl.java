package com.mokshananda.tasks.mappers.impl;

import com.mokshananda.tasks.domain.dto.TaskDto;
import com.mokshananda.tasks.domain.entities.Task;
import com.mokshananda.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task fromDto(TaskDto taskDto) {
        return new Task(
                taskDto.id(),
                null,
                null,
                null,
                taskDto.priority(),
                taskDto.status(),
                taskDto.dueDate(),
                taskDto.description(),
                taskDto.title()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getPriority(),
                task.getStatus()
                );

    }
}
