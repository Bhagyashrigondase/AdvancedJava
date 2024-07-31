package com.app.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findAllByCity(String city);
	Task findAllById(Long id);

}
