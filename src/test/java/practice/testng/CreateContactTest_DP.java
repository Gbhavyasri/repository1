package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest_DP {

	
	@DataProvider 
	public Object[][] getData() {
		Object[][] data =new Object[3][2];
		data[0][0]="deepak";
		data[0][1]="hr";
		data[1][0]="john";
		data[1][1]="smith";
		data[2][0]="deepak";
		data[2][1]="chahar";
		return data;
	}
	@Test(dataProvider="getData")
	public void createContactTest(String firstName,String lastName) {
		System.out.println(firstName+" "+lastName);
		
	}
}
