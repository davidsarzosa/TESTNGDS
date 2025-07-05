package com.neotech.lesson02;

import org.testng.annotations.Test;

public class EnableAndDisable {

	// we do not need a main method because testNG is taking care
	// of the main method already 
	
	

	@Test(priority =1)
	public void firstMethod() {
		System.out.println("FirstTest");
			
	}
	@Test(priority =2 )
	public void secondMethod() {
		System.out.println("SecondTest");
		
	}
	@Test(enabled =  false)
	public void thirthMethod() {
		System.out.println("ThirdTest");
	}
	
	@Test(priority = 10)
		public void fourthMethod() {
			System.out.println("FourthTest");
		}
	}

