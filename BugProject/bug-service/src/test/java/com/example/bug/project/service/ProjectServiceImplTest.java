package com.example.bug.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
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
import org.springframework.data.domain.PageRequest;

import com.example.bug.project.entity.Project;
import com.example.bug.project.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

	@InjectMocks
	private ProjectServiceImpl projectServiceimpl;

	@Mock
	ProjectRepository projectRepository;

	@Test
	void testSave() {
		Project project = new Project();
		project.setId("hello");
		when(projectRepository.save(project)).thenReturn(project);
		String projectReturned = projectServiceimpl.save(project);
		assertEquals(projectReturned, project.getId());
	}

	@Test
	void testFindAll() {
		List<Project> projectList = new ArrayList<>();
		when(projectRepository.findAll()).thenReturn(projectList);
		List<Project> projectListReturned = projectServiceimpl.findAll();
		assertIterableEquals(projectList, projectListReturned);
	}

	@Test
	void testUpdateProject() {
		Project project = new Project();
		when(projectRepository.save(project)).thenReturn(project);
		projectServiceimpl.updateProject(project);
		verify(projectRepository, times(1)).save(project);
	}

	@Test
	void testFindPaginated() {
		Page<Project> paging = new PageImpl<>(new ArrayList<Project>());
		when(projectRepository.findAll(PageRequest.of(0, 1))).thenReturn(paging);
		Page<Project> returnedPage = projectServiceimpl.findPaginated(0, 1);
		assertEquals(paging, returnedPage);
	}

	@Test
	void testFilterProject() {
		Page<Project> paging = new PageImpl<>(new ArrayList<Project>());
		when(projectRepository.findByNameContaining("Suraj", PageRequest.of(0, 1))).thenReturn(paging);
		Page<Project> returnedPage = projectServiceimpl.filterProject("Suraj", 0, 1);
		assertEquals(paging, returnedPage);
	}

	@Test
	void testFindProjectById() {
		Optional<Project> project = Optional.ofNullable(new Project());
		String id = "1478523698745";
		when(projectRepository.findById(id)).thenReturn(project);
		Optional<Project> returnedProject = projectServiceimpl.findById(id);
		assertEquals(project, returnedProject);
	}

}
