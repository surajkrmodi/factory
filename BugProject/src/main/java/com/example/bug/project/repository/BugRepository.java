package com.example.bug.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bug.project.entity.Bug;

public interface BugRepository extends CrudRepository<Bug, String>{

}
