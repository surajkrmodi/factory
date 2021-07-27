package com.example.bug.project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;

import com.example.bug.project.entity.Bug;
import com.example.bug.project.repository.BugRepository;

@ExtendWith(MockitoExtension.class)
class BugServiceImplTest {

	@InjectMocks
	private BugServiceImpl bugServiceimpl;

	@Mock
	BugRepository bugRepository;

	@Mock
	MongoTemplate mongoTemplate;
	
	@Mock
	IEmailService iEmailService;

	@Test
	void testSave() {
		Bug bug = new Bug();
		bug.setId("hello");
		when(bugRepository.save(bug)).thenReturn(bug);
		String bugReturned = bugServiceimpl.save(bug);
		assertEquals(bugReturned, bug.getId());
	}

	@Test
	void testFindAll() {
		List<Bug> bugList = new ArrayList<>();
		when(bugRepository.findAll()).thenReturn(bugList);
		List<Bug> bugListReturned = bugServiceimpl.findAll();
		assertIterableEquals(bugList, bugListReturned);

	}

	@Test
	void testFind() {
		Optional<Bug> bug = Optional.ofNullable(new Bug());
		String id = "4485461dwjdgvwdjv";
		when(bugRepository.findById(id)).thenReturn(bug);
		Optional<Bug> bugReturned = bugServiceimpl.find(id);
		assertEquals(bug, bugReturned);

	}

	@Test
	void testFilterBug() {
		Page<Bug> page = new PageImpl<>(new ArrayList<Bug>());
		when(bugRepository.findByNameContaining("Suraj", PageRequest.of(0, 1))).thenReturn(page);
		Page<Bug> returnedBug = bugServiceimpl.filterBug("Suraj", 0, 1);
		assertEquals(returnedBug, page);
	}

	@Test
	void testGetAllBugsByProjectId() {
		Page<Bug> page = new PageImpl<>(new ArrayList<Bug>());
		when(bugRepository.findByProjectIdContaining("ThisIsId", PageRequest.of(0, 1))).thenReturn(page);
		Page<Bug> returnedBug = bugServiceimpl.getAllBugsByProjectId("ThisIsId", 0, 1);
		assertEquals(returnedBug, page);
	}
	@Test
	void testUpdateBug() {
		Bug bug = new Bug();
		bug.setEmail("modisuraj62@gmail.com");
		bug.setName("project");
		bug.setId("HelloIsMyId");
		when(bugRepository.save(bug)).thenReturn(bug);
		doNothing().when(iEmailService).sendBugUpdate(bug.getEmail(), bug.getName());
		bugServiceimpl.updateBug(bug);
		verify(bugRepository,times(1)).save(bug);
		verify(iEmailService,times(1)).sendBugUpdate(bug.getEmail(), bug.getName());
	}

	@Test
	void testFindPaginated() {
		Page<Bug> page = new PageImpl<>(new ArrayList<Bug>());
		when(bugRepository.findAll(PageRequest.of(0, 1))).thenReturn(page);
		Page<Bug> returnedBug = bugServiceimpl.findPaginated(0, 1);
		assertEquals(returnedBug, page);
	}
	@Test
	void testfilterBugByProjectIdAndName() {
		Page<Bug> page = new PageImpl<>(new ArrayList<Bug>());
		when(bugRepository.findByProjectIdAndNameIgnoreCaseContaining("ThisIsProjectId","Suraj",PageRequest.of(0, 1))).thenReturn(page);
		Page<Bug> returnedBug = bugServiceimpl.filterBugByProjectIdAndName("ThisIsProjectId","Suraj",0, 1);
		assertEquals(returnedBug, page);
	}


}
