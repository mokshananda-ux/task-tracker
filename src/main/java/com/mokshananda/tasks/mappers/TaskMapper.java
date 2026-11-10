package com.mokshananda.tasks.mappers;

import com.mokshananda.tasks.domain.dto.TaskDto;
import com.mokshananda.tasks.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto dto);

    TaskDto toDto(Task task);

}
