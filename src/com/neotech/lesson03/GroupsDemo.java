package com.neotech.lesson03;

import org.testng.annotations.Test;

public class GroupsDemo {
	
	@Test(groups = "smoke")
	public void test1() {
		System.out.println("This is test 1 in GroupsDemo");
	}
	
	@Test(groups = {"smoke","regression","sprint5"})
	public void test2() {
		System.out.println("This is test 2 in GroupsDemo");
	}
	
	@Test(groups = "sprint6")
	public void test3() {
		System.out.println("This is test 3 in GroupsDemo");
	}
	
	@Test(groups = {"smoke","broken"})
	public void test4() {
		System.out.println("This is test 4 in GroupsDemo");
	}
	
}
