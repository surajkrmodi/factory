package com.example.bug.project.email.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.bug.project.email.bean.Mail;
import com.example.bug.project.email.services.IMailService;

@ExtendWith(MockitoExtension.class)
class EmailControllerTest {

	@InjectMocks
	private EmailController emailController;

	@Mock
	IMailService mailServiceImpl;

	@Test
	void sendMailTest() {
		Mail mail = new Mail();
		doNothing().when(mailServiceImpl).sendEmail(mail);
		emailController.sendMail(mail);
		verify(mailServiceImpl, times(1)).sendEmail(mail);
	}

}
