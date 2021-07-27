package com.example.bug.project.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
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

import com.example.bug.project.entity.Bug;
import com.example.bug.project.service.IBugService;
import com.example.bug.project.service.IEmailService;

@ExtendWith(MockitoExtension.class)
class BugControllerTest {

	@InjectMocks
	BugController bugController;

	@Mock
	IBugService iBugService;

	@Mock
	IEmailService iEmailService;

	@Test
	void testCreateBug() {
		Bug bug = new Bug();
		when(iBugService.save(bug)).thenReturn("bugSavedid");
		String response = bugController.createBug(bug);
		assertEquals("bugSavedid", response);
	}

	@Test
	void testGetAllBugs() {
		List<Bug> response = new ArrayList<Bug>();
		response.add(new Bug());
		when(iBugService.findAll()).thenReturn(response);
		List<Bug> bugListReturned = bugController.getAllBugs();
		assertEquals(response, bugListReturned);

	}

	@Test
	void testFindBugById() {
		Optional<Bug> bug = Optional.ofNullable(new Bug());
		String id = "6097858768bjsdcb";
		when(iBugService.find(id)).thenReturn(bug);
		Optional<Bug> bugReturned = bugController.findBugById(id);
		assertEquals(bug, bugReturned);
	}

	@Test
	void testFilterBug() {
		List<Bug> listOfBugs = new ArrayList<Bug>();
		Page<Bug> pageBug = new PageImpl<>(listOfBugs);
		String name = "Hello";
		int pageNo = 0;
		int pageSize = 5;
		when(iBugService.filterBug(name, pageNo, pageSize)).thenReturn(pageBug);
		Page<Bug> returnedPageBug = bugController.filterBug(name, pageNo, pageSize);
		assertEquals(pageBug, returnedPageBug);
	}

	@Test
	void testGetPaginatedBug() {
		List<Bug> listOfBugs = new ArrayList<Bug>();
		Page<Bug> pageBug = new PageImpl<>(listOfBugs);
		int pageNo = 0;
		int pageSize = 5;
		when(iBugService.findPaginated(pageNo, pageSize)).thenReturn(pageBug);
		Page<Bug> returnedPageBug = bugController.getPaginatedBugs(pageNo, pageSize);
		assertEquals(pageBug, returnedPageBug);
	}

	@Test
	void testGetAllBugsByProjectId() {
		List<Bug> listOfBugs = new ArrayList<Bug>();
		Page<Bug> pageBug = new PageImpl<>(listOfBugs);
		String name = "Suraj1234567891234567893";
		int pageNo = 0;
		int pageSize = 5;
		when(iBugService.getAllBugsByProjectId(name, pageNo, pageSize)).thenReturn(pageBug);
		Page<Bug> returnedPageBug = bugController.getAllBugsByProjectId(name, pageNo, pageSize);
		assertEquals(pageBug, returnedPageBug);
	}

	@Test
	void testFilterBugByProjectIdAndName() {
		List<Bug> listOfBugs = new ArrayList<Bug>();
		Page<Bug> pageBug = new PageImpl<>(listOfBugs);
		String projectId = "Hello";
		String name = "Suraj1234567891234567893";
		when(iBugService.filterBugByProjectIdAndName(projectId, name,0,1)).thenReturn(pageBug);
		Page<Bug> returnedPageBug = bugController.filterBugByProjectIdAndName(projectId, name,0,1);
		assertEquals(pageBug, returnedPageBug);
	}

	@Test
	void testUpdateBug() {
		Bug bug = new Bug();
		bug.setEmail("modisuraj62@gmail.com");
		bug.setName("project");
		bug.setId("HelloIsMyId");
		doNothing().when(iBugService).updateBug(bug);
		bugController.updateBug(bug, bug.getId());
		verify(iBugService, times(1)).updateBug(bug);

	}

}
