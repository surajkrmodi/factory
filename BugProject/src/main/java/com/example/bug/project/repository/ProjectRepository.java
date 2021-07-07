package com.example.bug.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bug.project.entity.Project;

//@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

}
