package practice.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProgramWithOutPOM {
	public static void main(String [] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		WebElement ele1=driver.findElement(By.xpath("//input[@name='user_name']"));
	      WebElement ele2= driver.findElement(By.xpath("//input[@name='user_password']"));
	      WebElement button= driver.findElement(By.xpath("//input[@id='submitButton']"));
	      ele1.sendKeys("admin");
	      ele2.sendKeys("admin");
	      driver.navigate().refresh();
	      ele1.sendKeys("admin");
	      ele2.sendKeys("admin");
	      button.click();
	      
	}

}
