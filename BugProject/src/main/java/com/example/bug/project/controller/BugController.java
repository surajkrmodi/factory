package com.example.bug.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bug.project.entity.Bug;
import com.example.bug.project.service.IBugService;

@RestController
public class BugController {
	
	@Autowired
	IBugService iBugService;

	@PostMapping("/api/bug")
	public String createBug(@RequestBody Bug bug) {
		return iBugService.save(bug);
	}

	@GetMapping("/api/bug")
	public List<Bug> getAllBugs() {
		return iBugService.findAll();
	}

	@GetMapping("/api/bug/{id}")
	public Optional<Bug> findBugById(String id) {
		// TODO Auto-generated method stub
		return iBugService.find(id);
	}

}
