package com.mokshananda.tasks.mappers.impl;

import com.mokshananda.tasks.domain.dto.TaskListDto;
import com.mokshananda.tasks.domain.entities.TaskList;
import com.mokshananda.tasks.domain.entities.TaskStatus;
import com.mokshananda.tasks.domain.entities.Task; // Asegúrate de importar tu clase Task
import com.mokshananda.tasks.mappers.TaskListMapper;
import com.mokshananda.tasks.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        // CORRECCIÓN: Se eliminó el "or.Else" roto y se cerró correctamente el constructor
        return new TaskList(
                taskListDto.id(),
                null,
                null,
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList()
                        ).orElse(null),
                taskListDto.description(),
                taskListDto.title()
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        if (taskList == null) {
            return null;
        }

        // CORRECCIÓN: Uso correcto de puntos en los getters (.getTasks()) y separación por comas
        List<Task> tasks = taskList.getTasks();

        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(tasks).map(List::size).orElse(0),
                calculateTaskListProgress(tasks),
                Optional.ofNullable(tasks)
                        .map(t -> t.stream().map(taskMapper::toDto).toList())
                        .orElse(null)
        );
    }

    // CORRECCIÓN: El método debe estar FUERA de toDto, corregidos los typos (.filter, .count())
    private Double calculateTaskListProgress(List<Task> tasks) {
        if (null == tasks || tasks.isEmpty()) {
            return 0.0;
        }

        long closedTaskCount = tasks.stream()
                .filter(task -> TaskStatus.CLOSED == task.getStatus())
                .count();

        return (double) closedTaskCount / tasks.size();
    }
}
