/**
 * 
 */
package com.example.springdemo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;



/**
 * @author surmodi
 *
 */
@SpringBootTest
public class UserServiceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.example.springdemo.UserService#save()}.
	 */
	@Test
	public void testSave() {
		UserService userService = new UserService();
		userService.save();
	}

	/**
	 * Test method for {@link com.example.springdemo.UserService#get()}.
	 */
	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

}
