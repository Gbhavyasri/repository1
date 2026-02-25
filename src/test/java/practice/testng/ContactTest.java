package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	@Test(priority = -1)
	public void createContactTest() {
		System.out.println("Execute create contact");
	}
	@Test(priority = 2)
	public void modifyContactTest() {
		System.out.println("execute modify contact");
	}
	@Test(priority = 3)
	public void deleteContact() {
		System.out.println("Delete the Contact");
	}

}
