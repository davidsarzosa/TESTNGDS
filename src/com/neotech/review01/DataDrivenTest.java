package com.neotech.review01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtility;

public class DataDrivenTest {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This method runs just before each test method");
	}

	@Test(dataProvider = "data1")
	public void loginTest(String name, String company, String position) {
		System.out.println("Login is running ");
		System.out.println("Name:" + name + " ,Company " + company);
		System.out.println("Position " + position);
	}

	@DataProvider(name = "data1")
	public Object[][] createData() {
		return new Object[][] { { "Mario", "Montufar", "Teacher" }, { "Ligia", "DaliFlowers", "Sales" },
				{ "Maelito", "Casa", "Student" } };
	}

	@Test(dataProvider = "data2")
	public Object[][] createFromExcel() {
		String filePath = System.getProperty("user.dir") + "\\testdata\\Excel .xlsx";
		String sheerName = "Position";
	
		return ExcelUtility.excelIntoArray(filePath, sheerName);
		
	}

}