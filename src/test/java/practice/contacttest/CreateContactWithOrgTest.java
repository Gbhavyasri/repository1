package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//Read Data From the properties File
		
				FileInputStream fis1=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\commondata.properties");
				
				Properties prop=new Properties();
				prop.load(fis1);
				
				String browser=prop.getProperty("browser");
				String url=prop.getProperty("url");
				String username=prop.getProperty("username");
				String password=prop.getProperty("password");
				
//				Generating the Random Number
				
				int n=10000;
				Random random=new Random();
				int number=random.nextInt(n);
//				Reading the data from the Excel File
				
				FileInputStream fis2=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\TestData.xlsx");
				
				Workbook book=WorkbookFactory.create(fis2);
				
				Sheet sheet=book.getSheet("Contact");
				
				Row row=sheet.getRow(9);
				Cell cell=row.getCell(2);
				String orgnizationPrefix=cell.getStringCellValue()+number;
				Cell cell2=row.getCell(3);
				String lastName=cell2.getStringCellValue()+number;
				
				book.close();
				WebDriver driver=null;
		       if(browser.equals("chrome"))		{
		    	   driver=new ChromeDriver();
		       }
		       else if(browser.equals("firefox")) {
		    	   driver=new FirefoxDriver();
		       }
		       else if(browser.equals("edge")) {
		    	   driver=new EdgeDriver();
		       }
		       else {
		    	   driver=new ChromeDriver();
		       }
			  
		       //Step 1: login to the Application
		       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       driver.manage().window().maximize();
		       driver.get(url);
		       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		       driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		       driver.findElement(By.xpath("//input[@id='submitButton']")).click();
//		       Step 2: Navigate to the Organization Module
		       
		       driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		       
//		       Step 3:Click on the Create organization Button
		       driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		       
//		       Step4:Enter all the details and save the organization
		       driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgnizationPrefix);
		       driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("hyderabad");
		       
		       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		       
		       Thread.sleep(2000);
//		       Verify Header Message Expected Result
		       
		      String headerText= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		      if(headerText.contains(orgnizationPrefix)) {
		    	  System.out.println(orgnizationPrefix+" is created"+"====PASS");
		      }
		      else {
		    	  System.out.println("Header is verified"+"====FAIL");
		      }
		       
		     
				
				//Step 5: Navigate to Contact Module
		      driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		       
		      
		    //Step 6: Click on the create contact button
		       driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		       
            //Step 7: Enter all the details & create the new contacts       
		       driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		       
		       driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		       Thread.sleep(2000);
//		        Switch to the child window
		       Set<String> set=driver.getWindowHandles();
		       Iterator<String> it=set.iterator();
		       while(it.hasNext()) {
		    	   String windowId=it.next();
		    	   driver.switchTo().window(windowId);
		    	   String actUrl=driver.getCurrentUrl();
		    	   if(actUrl.contains("module=Accounts")) {
		    		   break;
		    	   }
		       }
		       Thread.sleep(2000);
		       driver.findElement(By.name("search_text")).sendKeys(orgnizationPrefix);
		       driver.findElement(By.name("search")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("//a[text()='"+orgnizationPrefix+"']")).click();//----Dynamic-Xpath------
		       
		       
//		       Switch back to Parent Window
		       
		       Set<String> set1=driver.getWindowHandles();
		       Iterator<String> it1=set.iterator();
		       while(it1.hasNext()) {
		    	   String windowId=it1.next();
		    	   driver.switchTo().window(windowId);
		    	   String actUrl=driver.getCurrentUrl();
		    	   if(actUrl.contains("Contacts&action")) {
		    		   break;
		    	   }
		       }
		       
		       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		       
		       
		       
		       

		       
		     
		       
//		       Verify orgname info Expected result
		      
		      String actualContact=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		      
		      if(actualContact.equals(lastName)) {
		    	  System.out.println(lastName+" is Created===PASS");
		      }
		      else {
		    	  System.out.println(orgnizationPrefix+" is not Created===FAIL");
		      }

		       
		    
		       
		      driver.quit();
		

	}

}
