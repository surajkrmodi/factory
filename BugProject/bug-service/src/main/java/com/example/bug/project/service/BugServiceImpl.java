package com.example.bug.project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.example.bug.project.entity.Bug;
import com.example.bug.project.entity.Project;
import com.example.bug.project.repository.BugRepository;
import org.springframework.data.repository.support.PageableExecutionUtils;

@Service
public class BugServiceImpl implements IBugService {

	@Autowired
	BugRepository bugRepository;

	@Autowired
	IEmailService iEmailService;


	@Override
	public String save(Bug bug) {
		bug.setCreatedDate(LocalDateTime.now());
		Bug saved = bugRepository.save(bug);
		return saved.getId();
	}

	@Override
	public List<Bug> findAll() {

		return bugRepository.findAll();
	}

	@Override
	public Optional<Bug> find(String id) {

		return bugRepository.findById(id);
	}

	// TODO performance testing
	@Override
	public void updateBug(Bug bug) {
		bugRepository.save(bug);
		iEmailService.sendBugUpdate(bug.getEmail(), bug.getName());

	}

	@Override
	public Page<Bug> filterBug(String name, int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Bug> pagedResult = bugRepository.findByNameContaining(name, paging);

		return pagedResult;
	}

	@Override
	public Page<Bug> getAllBugsByProjectId(String projectId, int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		return bugRepository.findByProjectIdContaining(projectId, paging);
	}

	@Override
	public Page<Bug> findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		Page<Bug> pagedResult = bugRepository.findAll(paging);

		return pagedResult;
	}

	@Override
	public Page<Bug> filterBugByProjectIdAndName(String projectId, String name,int pageNo,int pageSize) {
		Pageable paging = PageRequest.of(pageNo,pageSize);
		return bugRepository.findByProjectIdAndNameIgnoreCaseContaining(projectId, name, paging);
	}

}
