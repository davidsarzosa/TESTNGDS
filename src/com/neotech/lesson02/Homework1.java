package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;
import utils.ConfigsReader;

//   1. Open chrome browser
//  2. Go to "https://hrm.neotechacademy.com/"
//  3. Enter valid username
//  4. Leave password field empty
//  5. Verify error message with text "Password cannot be empty" is displayed
public class Homework1 extends CommonMethods {
//  1. Open chrome browser
//  2. Go to "https://hrm.neotechacademy.com/"
//  3. Enter valid username
//  4. Leave password field empty
//  5. Verify error message with text "Password cannot be empty" is displayed.

	// I have two Test methods in this class -> loginValidation() &
	// negativeLoginTest()
	// openAndNavigate() will be executed before every Test method -> 2 times
	// quitBrowser() will be executed after every Test method -> 2 times

	@Test
	public void negativeLoginTest() {
		// We are writing our Selenium Test

		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), "");
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(2);

		String expected = "Password cannot be empty";
		String actual = driver.findElement(By.id("txtPassword-error")).getText();

		if (actual.equals(expected)) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test failed!");
		}
	}

	@Test
	public void loginValidation() {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(5);
	}

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

}