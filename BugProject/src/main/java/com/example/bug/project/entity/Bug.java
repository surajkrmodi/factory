package com.example.bug.project.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bug {
	private String id;
	private String projectId;
	private String name;
	private String ownerName;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime completedDate;
	private BUG_STATUS status;
	private BUG_PRIORITY priority;

}
