package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
FileInputStream fis1=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\commondata.properties");
		
		Properties prop=new Properties();
		prop.load(fis1);
		
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
//		Generating the Randome Number
		
		int n=1000;
		Random random=new Random();
		int number=random.nextInt(n);
//		Reading the data from the Excel File
		
		FileInputStream fis2=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\TestData.xlsx");
		
		Workbook book=WorkbookFactory.create(fis2);
		
		Sheet sheet=book.getSheet("Contact");
		
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(2);
		String lastName=cell.getStringCellValue()+number;
		
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
       Date dateObj=new Date();
        
       SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
       String startDate=sim.format(dateObj);
       
       
      Calendar cal= sim.getCalendar();
      cal.add(Calendar.DAY_OF_MONTH,30);
      
      String endDate=sim.format(cal.getTime());
       
	  
       
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
       driver.get(url);
       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
       driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
       driver.findElement(By.xpath("//input[@id='submitButton']")).click();
       
       driver.findElement(By.xpath("//a[text()='Contacts']")).click();
       
       driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
       
       driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
       driver.findElement(By.xpath("//input[@name='support_start_date']")).clear();
       driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(startDate);
       
       driver.findElement(By.xpath("//input[@name='support_end_date']")).clear();
       driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(endDate);
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
       
//       Verify Header Message Expected Result
       
     
       
//       Verify orgname info Expected result
      
      String actLastName=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
      
      if(actLastName.equals(lastName)) {
    	  System.out.println(lastName+" is Created===PASS");
      }
      else {
    	  System.out.println(lastName+" is not Created===FAIL");
      }
       
      String actualStartDate=driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
      
      if(actualStartDate.equals(startDate)) {
    	  System.out.println(startDate+" is Verified");
      }
      else {
    	  System.out.println(startDate+" is not Verified");
      }
	   
      String actualEndDate=driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();	
      if(actualEndDate.equals(endDate)) {
    	  System.out.println(endDate+" is Verified");
      }
      else {
    	  System.out.println(endDate+" is not Verified");
      }
	   
		//Step 5: Log OUT
      driver.quit();


	}

}
