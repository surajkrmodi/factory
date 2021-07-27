package com.example.bug.project.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bug {
	private String id;
	@Size(min = 24, max = 24) // MongoId is of length 24 characters.
	private String projectId;
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3, max = 25)
	private String name;
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3, max = 25)
	private String ownerName;
	@NotBlank(message = "Name is mandatory")
	@Size(min = 5, max = 255)
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime completedDate;
	private BUG_STATUS status;
	private BUG_PRIORITY priority;
	@NotBlank(message = "Name is mandatory")
	@Email(message="InValid Email")
	private String email;

}
