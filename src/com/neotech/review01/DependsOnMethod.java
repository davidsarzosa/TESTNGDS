package com.neotech.review01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethod {

	@Test
	public void firstTest() {
		System.out.println("first test is running");
		Assert.assertEquals("a", "b", "This test is falling intentianally ");
	}

	@Test(dependsOnMethods = "firstTest") // this test depends on the successful of the first test
	public void secondTest() {
		System.out.println("Second test is running");
	}

	// First test will be executed first.
	// First test will fail.
	// Second test will be skipped because it depends on the first test.
	// Results: // First test: FAILED, // Second test: SKIPPED

}
