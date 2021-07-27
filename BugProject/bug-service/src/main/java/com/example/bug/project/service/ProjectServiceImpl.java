package com.example.bug.project.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.bug.project.entity.Bug;
import com.example.bug.project.entity.Project;
import com.example.bug.project.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String save(Project project) {
		project.setCreatedDate(LocalDate.now());
		Project saved = projectRepository.save(project);

		return saved.getId();
	}

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public void updateProject(Project project) {
		projectRepository.save(project);
	}

	@Override
	public Page<Project> findPaginated(int pageNo, int pageSize) {

		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Project> pagedResult = projectRepository.findAll(paging);

		return pagedResult;
	}

	@Override
	public Page<Project> filterProject(String name, int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Project> pagedResult = projectRepository.findByNameContaining(name, paging);

		return pagedResult;
	}

	@Override
	public Optional<Project> findById(String id) {
		return projectRepository.findById(id);
	}

}
