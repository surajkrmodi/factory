package com.example.bug.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.example.bug.project.entity.Bug;
import com.example.bug.project.entity.Project;
import com.example.bug.project.service.IProjectService;

@ExtendWith(MockitoExtension.class)
class ProjectControllerTest {

	@InjectMocks
	private ProjectController projectController;

	@Mock
	IProjectService iProjectServiceImpl;

	@Test
	void testCreateProject() {
		Project project = new Project();
		when(iProjectServiceImpl.save(project)).thenReturn("Hello");
		String id = projectController.createProject(project);
		assertNotNull(id);
	}

	@Test
	void testGetAllProjects() {
		List<Project> response = new ArrayList<Project>();
		response.add(new Project());
		when(iProjectServiceImpl.findAll()).thenReturn(response);
		List<Project> responseReturned = projectController.getAllProjects();
		assertIterableEquals(response, responseReturned);
	}

	@Test
	void testFilterProjects() {
		Page<Project> pageProject = new PageImpl<>(new ArrayList<Project>());
		when(iProjectServiceImpl.filterProject("Suraj", 0, 0)).thenReturn(pageProject);
		Page<Project> pageProjectReturned = projectController.filterProjects("Suraj", 0, 0);
		assertEquals(pageProject, pageProjectReturned);
	}

	@Test
	void testFindProjectById() {
		Optional<Project> project = Optional.ofNullable(new Project());
		String id = "1478523698745";
		when(iProjectServiceImpl.findById(id)).thenReturn(project);
		Optional<Project> returnedProject = projectController.findProjectById(id);
		assertEquals(project, returnedProject);
	}

	@Test
	void testGetPaginatedProjects() {
		Page<Project> pageProject = new PageImpl<>(new ArrayList<Project>());
		when(iProjectServiceImpl.findPaginated(0, 1)).thenReturn(pageProject);
		Page<Project> pageProjectReturned = projectController.getPaginatedProjects(0, 1);
		assertEquals(pageProject, pageProjectReturned);
	}
	@Test
	void testUpdateProject() {
		Project project = new Project();
		project.setName("project");
		project.setId("HelloIsMyId");
		doNothing().when(iProjectServiceImpl).updateProject(project);
		projectController.updateProject(project, project.getId());
		verify(iProjectServiceImpl,times(1)).updateProject(project);
		
		
	}

}
