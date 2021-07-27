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

import com.example.bug.project.entity.Bug;
import com.example.bug.project.entity.Project;
import com.example.bug.project.service.IBugService;

@CrossOrigin
@RestController
public class BugController {

	@Autowired
	IBugService iBugService;

	@PostMapping("/api/bug")
	public String createBug(@Valid @RequestBody Bug bug) {
		return iBugService.save(bug);
	}

	@GetMapping("/api/bug")
	public List<Bug> getAllBugs() {
		return iBugService.findAll();
	}

	@GetMapping("/api/bug/{id}")
	public Optional<Bug> findBugById(String id) {
		return iBugService.find(id);
	}

	@GetMapping("/api/bug/filter/{name}")
	public Page<Bug> filterBug(@PathVariable String name, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize) {
		return iBugService.filterBug(name, pageNo, pageSize);

	}

	@GetMapping("/api/bug/paging")
	public Page<Bug> getPaginatedBugs(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize) {

		return iBugService.findPaginated(pageNo, pageSize);
	}

	@PutMapping("/api/bug/id/{id}")
	public void updateBug(@Valid @RequestBody Bug bug, @PathVariable String id) {
		bug.setId(id);
		iBugService.updateBug(bug);
	}

	@GetMapping("/api/bug/projectid/{projectId}")
	public Page<Bug> getAllBugsByProjectId(@PathVariable("projectId") String projectId,@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize) {
		return iBugService.getAllBugsByProjectId(projectId,pageNo,pageSize);
	}

	@GetMapping("/api/bug/filter3/{projectId}/{name}")
	public Page<Bug> filterBugByProjectIdAndName(@PathVariable(name = "projectId") String projectId,
			@PathVariable(name = "name") String name,@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "5") int pageSize) {
		return iBugService.filterBugByProjectIdAndName(projectId, name,pageNo,pageSize);
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
