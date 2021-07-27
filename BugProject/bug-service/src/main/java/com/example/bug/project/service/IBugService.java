package com.example.bug.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.bug.project.entity.Bug;
import com.example.bug.project.entity.Project;

public interface IBugService {

	String save(Bug bug);

	List<Bug> findAll();

	Optional<Bug> find(String id);

	void updateBug(Bug bug);

	Page<Bug> filterBug(String name,int pageNo,int pageSize);

	 Page<Bug> findPaginated(int pageNo, int pageSize);

	Page<Bug> getAllBugsByProjectId(String projectId,int pageNo,int pageSize);

	Page<Bug> filterBugByProjectIdAndName(String projectId, String name,int pageNo,int pageSize);

}
