package com.balde.metier;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {
	
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	MathApplication mathApplication = new MathApplication();
	
	//@Mock annotation is used to create the mock object to be injected
	@Mock
	CalculatorService calcservice;

	@Test
	public void testAdd() {
		//add the behavior of calc service to add two numbers
		when(calcservice.add(10.0, 20.0)).thenReturn(30.00);
		
		//add the behavior of calc service to subtract two numbers
		when(calcservice.subtract(20.0, 10.0)).thenReturn(10.00);
		
		//test the add functionality
		assertEquals(mathApplication.add(10.0,20.0), 30.00,0);
		
		//test the subtract functionality
		assertEquals(mathApplication.subtract(20.0, 10.0), 10.0,0);
		
		//default call count is 1 
	    verify(calcservice).subtract(20.0, 10.0);
	      
		//verify the behavior
		verify(calcservice, times(1)).add(10.0, 20.0);
	}

//	@Test
//	public void testSetCalculatorService() {
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testSubtract() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testMultiply() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDivide() {
//		fail("Not yet implemented");
//	}

}
