package practicedatadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrhanizationTaskUsingJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		 JSONParser parser=new JSONParser();
			Object obj= parser.parse(new FileReader("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\appCommonData.json"));
			
//			Step 2: Convert java object to the JSONObject using downCasting
			JSONObject map=(JSONObject)obj;
//			Step 3: get the value from the json file using key
			String url=(String) map.get("url");
			String browser= map.get("browser").toString();
			String username=(String) map.get("username").toString();
			String password=(String) map.get("password").toString();
			String timeOut=(String) map.get("timeOut").toString();
			
			
			
			Scanner sc=new Scanner(System.in);
			 System.out.println("Enter the browser");
			String b=sc.next();
			if(b.equals("firefox")) {
				driver=new FirefoxDriver();
			}
			else if(b.equals("chrome")) {
				driver=new ChromeDriver();
			}
			else if(b.equals("edge")) {
				driver=new EdgeDriver();
			}
//			Reading the TestScript data from the Excel File
			FileInputStream fis1=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\data\\TestData.xlsx");
			
			Workbook book2=WorkbookFactory.create(fis1);
			
			Sheet sheet2=book2.getSheet("Sheet1");
			
			Row row2=sheet2.getRow(1);
		    Random random=new Random();
		      int randomNumber= random.nextInt(1000);
			String organization=row2.getCell(2).toString()+randomNumber;
			
			
			book2.close();
			
			
			
			driver.manage().window().maximize();
	      driver.get(url);
	      Thread.sleep(2000);
	      driver.findElement(By.name("user_name")).sendKeys(username);
	      Thread.sleep(2000);
	      driver.findElement(By.name("user_password")).sendKeys(password);
	      Thread.sleep(2000);
	      driver.findElement(By.id("submitButton")).click();
	      driver.findElement(By.linkText("Organizations")).click();
	      
	      driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(organization);
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("Hyderabad");
	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	   
	     Actions action=new Actions(driver);
	    WebElement ele1= driver.findElement(By.xpath("//td[@class='small']//descendant::img[@src='themes/softed/images/user.PNG']"));
	     action.moveToElement(ele1).perform();
	     Thread.sleep(2000);
	    WebElement ele2 =driver.findElement(By.xpath("//a[text()='Sign Out']"));
	     action.click(ele2).perform();
	     
	     driver.quit();
	     System.out.println("Organization Created Successfully!!!!");
		
	}

}
