package com.sapient.training;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
		String saveId = userServiceImpl.save(user);
		assertNotNull(user.getId());
		assertEquals("sgusgwjdbvwjdb", saveId);
	}

}
