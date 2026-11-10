package com.mokshananda.tasks.repositories;

import com.mokshananda.tasks.domain.entities.Task;
import com.mokshananda.tasks.domain.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<TaskList, UUID> {
    List<TaskList> findByTaskListId(UUID taskListId);
    Optional<Task> findByTaskListIdAndID(UUID taskListId, UUID id);
}
