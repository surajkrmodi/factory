package tdd;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	Calculator c;
	@Before
	public void  init() {
		c = new Calculator();// Arrange
	}

	@Test
	public void test() {
		int result = c.add(2, 3); // Act
		assertEquals(5, result);// Assert
	}

	@Test
	public void testSubtract() {
		int result = c.subtract(2, 3); // Act
		assertEquals(-1, result);// Assert
	}
	@Test
	public void testSubtractif() {
		int result = c.subtract(-2, 3); // Act
		assertEquals(-5, result);// Assert
	}
	@Test
	public void divide() {
		int result = c.divide(3, 3); // Act
		assertEquals(1, result);// Assert
	}
	/**
	 * 
	 */
	
	@Test(expected = ArithmeticException.class)
	public void dividebyzero() {
		 c.divide(3, 0); // Act
		
	}
	@After
	public void cleanup() {
		System.out.println("After all");
	}


	}

