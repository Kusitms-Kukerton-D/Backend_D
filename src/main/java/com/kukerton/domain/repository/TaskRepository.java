package com.kukerton.domain.repository;

import com.kukerton.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByCategory(String category);
}
