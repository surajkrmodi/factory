package com.example.bug.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	
	
	@PostMapping("/api/project")
	void createProject(@RequestBody project) {
		
		
	}

}
