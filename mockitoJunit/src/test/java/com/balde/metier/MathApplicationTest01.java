package com.balde.metier;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

public class MathApplicationTest01 {
	
	private MathApplication mathApplication;
	private MathApplication mathApplication01;
	private CalculatorService calcService;
	private CalculatorService calcServiceTmp;

	@Before
	public void setUp() throws Exception {
		this.mathApplication = new MathApplication();
		this.calcService = mock(CalculatorService.class);
		mathApplication.setCalculatorService(calcService);
		
		this.mathApplication01 = new MathApplication();
		Calculator calculator = new Calculator();
		this.calcServiceTmp = spy(calculator);
		mathApplication01.setCalculatorService(calcServiceTmp);
	}
	

	@Test
	public void testAdd() {
		//add the behavior to add numbers
		when(calcService.add(20.0, 10.0)).thenReturn(30.0);
		
		//subtract the behavior to subtract numbers
		when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);
		
		//test the subtract functionality
		assertEquals(this.mathApplication.subtract(20.0, 10.0), 10.0,0);
		
		//test the add functionality
		assertEquals(this.mathApplication.add(20.0, 10.0), 30.0,0);
		
		//verify call to calcService is made or not
		//following will make sure that add is first called then subtract is called.
		verify(calcService).add(20.0, 10.0);
		verify(calcService,timeout(1)).subtract(20.0, 10.0);
		
//		reset(calcService);
//		assertEquals(this.mathApplication.add(20.0, 10.0), 30.0,0);
	}
	
	@Test
	public void testSubs() {
		assertEquals(" 1 ",this.mathApplication01.subtract(20.0, 10.0), 10.0,0);
		assertEquals(" 2 ",this.mathApplication01.subtract(30.0, 10.0), 20.0,0);
		
		
	}
}
