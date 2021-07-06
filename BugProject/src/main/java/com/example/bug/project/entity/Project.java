package com.example.bug.project.entity;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Project {

	private String id;
	private String name;
	private String description;
	private LocalDate createdDate;
	private LocalDate completedDate;

}
