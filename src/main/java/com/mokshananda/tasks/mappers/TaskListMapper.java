package com.mokshananda.tasks.mappers;

import com.mokshananda.tasks.domain.dto.TaskListDto;
import com.mokshananda.tasks.domain.entities.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
