package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        //Read Data From the properties File
		
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
		
		Sheet sheet=book.getSheet("org");
		
		Row row=sheet.getRow(1);
		Cell cell=row.getCell(2);
		String orgnizationPrefix=cell.getStringCellValue()+number;
		
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
	  
       
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().window().maximize();
       driver.get(url);
       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
       driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
       driver.findElement(By.xpath("//input[@id='submitButton']")).click();
       
       driver.findElement(By.xpath("//a[text()='Organizations']")).click();
       
       driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
       
       driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgnizationPrefix);
       driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("hyderabad");
       
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
       
//       Verify Header Message Expected Result
       
      String headerText= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
      if(headerText.contains(orgnizationPrefix)) {
    	  System.out.println(orgnizationPrefix+" is created"+"====PASS");
      }
      else {
    	  System.out.println("Header is verified"+"====FAIL");
      }
       
//       Verify orgname info Expected result
      
      String actOrgName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
      
      if(actOrgName.equals(orgnizationPrefix)) {
    	  System.out.println(orgnizationPrefix+" is Created===PASS");
      }
      else {
    	  System.out.println(orgnizationPrefix+" is not Created===FAIL");
      }
       
	   
		
		//Step 5: Log OUT
      driver.quit();

	}

}
