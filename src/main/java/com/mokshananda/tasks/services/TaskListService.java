package com.mokshananda.tasks.services;

import com.mokshananda.tasks.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
}
