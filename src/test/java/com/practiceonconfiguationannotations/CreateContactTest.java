package com.practiceonconfiguationannotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest {
	@BeforeSuite
	public void configBS() {
		System.out.println("Execute Before Suite");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("Execute before Class");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("Execute Before Method");
	}
	@Test
	public void createContact() {
		System.out.println("Execute CreateContact");
	
	}
	@Test
	public void createContactWithDate() {
		System.out.println("Execute create contact with Date");
	}
	@AfterMethod
	public void configAM() {
		System.out.println("Execute After Method");
	}
	@AfterClass
	public void configAC() {
		System.out.println("Execute After Class");
	}
   @AfterSuite
   public void configAS() {
	   System.out.println("Execute After suite");
   }
}
