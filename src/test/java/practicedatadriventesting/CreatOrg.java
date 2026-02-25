package practicedatadriventesting;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreatOrg {

	 
	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		WebDriver driver=null;
		FileInputStream fs=new FileInputStream("C:\\Users\\G Bhavyasri\\OneDrive\\Desktop\\commondata.properties");
		
		Properties prop=new Properties();
		prop.load(fs);
		
		String browser=prop.getProperty("browser");
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		 
		 Scanner sc=new Scanner(System.in);
		 System.out.println("Enter the browser");
		String b=sc.next();
		if(b.equals("firefox")) {
			driver =new FirefoxDriver();
		}
		else if(b.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(b.equals("edge")) {
			driver=new EdgeDriver();
		}
      driver.get(url);
      Thread.sleep(2000);
      driver.findElement(By.name("user_name")).sendKeys(username);
      Thread.sleep(2000);
      driver.findElement(By.name("user_password")).sendKeys(password);
      Thread.sleep(2000);
      driver.findElement(By.id("submitButton")).click();
//      Thread.sleep(6000);
      driver.findElement(By.linkText("Organizations")).click();
      
      driver.quit();
    
	}

}
