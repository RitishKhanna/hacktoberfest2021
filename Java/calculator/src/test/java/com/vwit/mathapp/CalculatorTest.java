package com.vwit.mathapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// This is Test class so it is in 'src/tes/java'
// using Junit
@DisplayName("This is to Perform Test on Calculator Api")
public class CalculatorTest {
	
	private Calculator c;
	
	@BeforeEach
	public void setUp() {
		c = new Calculator();
	}

	@Test
	@DisplayName("This is to Test Add Function")
	public void testSuccessAdd() {
		int expected = 8;
		//Calculator c = new Calculator(); // now not needed to create object again and again instead to this we will use @BeforeEach
		int actual = c.add(3, 2);
		assertEquals(expected, actual); //this is static method of Assertion class imported using "import static org.junit.jupiter.api.Assertions.*;" line 3
	}

	@Test
	@DisplayName("This is to Test Divide Exception Function 1")
	public void testExceptionDivide() {
		//Calculator c = new Calculator();
		c.divide(4, 0);
	}

	@Test
	@DisplayName("This is to Test Divide Exception Function 2")
	public void testExceptionDivide1() {
		//Calculator c = new Calculator();
		assertThrows(ArithmeticException.class, () -> c.divide(4, 0));
	}

	@Test
	@DisplayName("This is to Test Divide Function")
	public void testSuccessDivide() {
		int expected = 2;
		//Calculator c = new Calculator();
		int actual = c.divide(4, 2);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("This is to Test Substract Function")
	public void testSuccessSubstract() {
		int expected = -6;
		//Calculator c = new Calculator();
		int actual = c.substract(-4, 2);
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("This is to Test Multiply Function")
	public void testSuccessMultiply() {
		int expected = 8;
		//Calculator c = new Calculator();
		int actual = c.multiply(4, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void TestPass() {
		// in junit no news is good news and that's why this test pass
	}

	@Test
	@DisplayName("This Test is failling forcefully")
	public void TestFail1() {
		fail("This Test is forcefully failed");
	}

	@Test
	@DisplayName("This Test is disabled till the time bug 3.A is not fixed")
	@Disabled
	public void TestFail2() {
		fail("This Test is skipped");
	}

}
