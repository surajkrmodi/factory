package com.example.bug.project.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.bug.project.entity.Project;
import com.example.bug.project.service.ProjectServiceImpl;
@ExtendWith(MockitoExtension.class)
class ProjectControllerTest {

	@InjectMocks
	private ProjectController projectController;
	
	@Mock
	ProjectServiceImpl  projectServiceImpl;
	
	@Test
	void testCreateProject() {
		Project project = new Project();
		when(projectServiceImpl.save(project)).thenReturn("Hello");
//		project.set
		String id = projectController.createProject(project);
		assertNotNull(id);
	}

}
