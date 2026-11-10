package com.mokshananda.tasks.services.impl;

import com.mokshananda.tasks.domain.entities.TaskList;
import com.mokshananda.tasks.repositories.TaskListRepository;
import com.mokshananda.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }
}
