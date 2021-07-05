package com.example.bug.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bug.project.entity.Project;
import com.example.bug.project.service.ProjectServiceImpl;

@RestController

public class ProjectController {

	
	@Autowired
	private ProjectServiceImpl projectServiceImpl;

	@PostMapping("/api/project")
	public String createProject(@RequestBody Project project) {
		return projectServiceImpl.save(project);
	}
}
