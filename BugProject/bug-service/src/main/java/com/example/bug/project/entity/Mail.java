package com.example.bug.project.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {
	private String mailFrom;

	private String mailTo;
	private String mailSubject;

	private String mailContent;

}
