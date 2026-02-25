package practice.testng;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {
   @Test
   public void amazonTest() {
	   WebDriver driver=new ChromeDriver();
	   driver.get("http://amazon.com");
	   
//	   Step 1: Create an object to EventFiringWebDriver
	   
	   EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
//	   Step 2 :use the getScreenShotAs() method to get file type of screenshot
	   File srcFile=edriver.getScreenshotAs(OutputType.FILE);
	   
//	  step 3 : Store Screenshot in local drive 
	   FileUtils.copyFile(srcFile, new File("./Screenshot/test.png"));
	   
   }
}
