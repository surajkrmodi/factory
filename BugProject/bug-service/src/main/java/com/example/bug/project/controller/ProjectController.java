package com.example.bug.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bug.project.entity.Project;
import com.example.bug.project.service.IProjectService;

@CrossOrigin
@RestController
public class ProjectController {

	@Autowired
	private IProjectService iProjectServiceImpl;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/api/project")
	public String createProject(@Valid @RequestBody Project project) {
		return iProjectServiceImpl.save(project);
	}

	@GetMapping("/api/project/filter/{name}")
	public Page<Project> filterProjects(@PathVariable String name, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize) {
		return iProjectServiceImpl.filterProject(name, pageNo, pageSize);

	}

	@GetMapping("/api/project/id/{id}")
	public Optional<Project> findProjectById(@PathVariable String id) {
		return iProjectServiceImpl.findById(id);
	}

	@GetMapping("/api/project")
	public List<Project> getAllProjects() {

		return iProjectServiceImpl.findAll();
	}

	@PutMapping("/api/project/{id}")
	public void updateProject(@Valid @RequestBody Project project, @PathVariable String id) {
		project.setId(id);
		iProjectServiceImpl.updateProject(project);
	}

	@GetMapping("/api/project/paging")
	public Page<Project> getPaginatedProjects(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "40") int pageSize) {

		return iProjectServiceImpl.findPaginated(pageNo, pageSize);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
