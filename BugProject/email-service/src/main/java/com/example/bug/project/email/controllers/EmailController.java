package com.example.bug.project.email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bug.project.email.bean.Mail;
import com.example.bug.project.email.services.IMailService;

@CrossOrigin
@RestController
public class EmailController {

	@Autowired
	private IMailService mailServiceImpl;

	@PostMapping("/api/mail")
	public void sendMail(@RequestBody Mail mail) {
		mailServiceImpl.sendEmail(mail);
	}

}
