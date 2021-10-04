package com.vwit.mathapp;

// This is Test class so it is in 'src/tes/java'
public class CalculatorTestTraditional {
	
	public void testSuccessAdd() {
		Calculator c = new Calculator();
		System.out.println("Addition Test " + c.add(1, 1));
	}
	
	public void testSuccessDivide() {
		Calculator c = new Calculator();
		System.out.println("Division Test " + c.divide(4, 2));
	}
	
	public void testExceptionDivide() {
		Calculator c = new Calculator();
		System.out.println("Division Test " + c.divide(4, 0));
	}

	public static void main(String[] args) {
		CalculatorTestTraditional test = new CalculatorTestTraditional();
		
		test.testSuccessAdd();
		
		test.testSuccessDivide();
		
		try {
			test.testExceptionDivide();
		}
		catch (ArithmeticException e) {
			System.out.println("Exception Occured");
		}
		
	}

}
