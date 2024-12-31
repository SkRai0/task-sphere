package com.alphacode.task_sphere.repository;

import com.alphacode.task_sphere.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query("SELECT t from Task t WHERE t.project.id = :projectId")
    List<Task> getTasksByProjectId(@Param("projectId") Long id);
}
