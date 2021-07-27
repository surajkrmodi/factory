package com.example.bug.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.bug.project.entity.Project;

public interface IProjectService {

	String save(Project project);

	List<Project> findAll();

	void updateProject(Project project);


	Page<Project> findPaginated(int pageNo, int pageSize);

	Optional<Project> findById(String id);

	Page<Project> filterProject(String name, int pageNo, int pageSize);

}
