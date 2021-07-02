package com.sapient.training;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private JmsTemplate jmsTemplate;
	
	@Test
	void testSave() {
		User user = new  User();
		user.setId("sgusgwjdbvwjdb");
		when(userRepository.save(user)).thenReturn(user);
		
	//	when(jmsTemplate.convertAndSend(user));
		//doNothing().when(user).jmsTemplate.convert();
		String saveId = userServiceImpl.save(user);
		assertNotNull(user.getId());
		assertEquals("sgusgwjdbvwjdb", saveId);
	}

}
