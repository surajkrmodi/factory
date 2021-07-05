package com.example.bug.project.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.web.bind.annotation.RequestBody;

class ProjectControllerTest {

	@InjectMocks
	private ProjectController projectController;
	
	//@Mock
	
	@Test
	void testCreateProject() {
		ProjectController project = new ProjectController();
		project.createProject();
	}

}
