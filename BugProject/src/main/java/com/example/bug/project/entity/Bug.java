package com.example.bug.project.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bug {
	private String id;
	@NotBlank(message = "Project id cannot be empty")
	private String projectId;
	@NotBlank(message = "Name cannot be empty")
	private String name;
	@NotBlank(message = "OwnerName cannot be empty")
	private String ownerName;
	@Size(min = 5, max = 255)
	@NotBlank(message = "Description not empty")
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime completedDate;
	private BUG_STATUS status;
	private BUG_PRIORITY priority;

}
