package com.example.bug.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/api/project")
	public List<Project> getAllUsers() {
		return projectServiceImpl.findAll();

	}

}
