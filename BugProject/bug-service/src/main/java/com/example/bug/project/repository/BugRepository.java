package com.example.bug.project.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.util.Streamable;

import com.example.bug.project.entity.Bug;

public interface BugRepository extends MongoRepository<Bug, String> {

	Page<Bug> findByProjectIdContaining(String projectId, Pageable paging);

	Page<Bug> findByProjectIdAndNameIgnoreCaseContaining(String projectId, String name, Pageable paging);

	Page<Bug> findByNameContaining(String name, Pageable paging);

}
