package com.example.bug.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bug.project.entity.Project;
import com.example.bug.project.repository.ProjectRepository;

@Service
public class ProjectServiceImpl {

	@Autowired
	ProjectRepository projectRepository;
	
	public String save(Project project) {
		
		Project saved = projectRepository.save(project);
		
		return saved.getId();
	}

}
