package practice.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProgramWithPOM {
	@FindBy(name="user_name")
	WebElement ele1;
	@FindBy(name="user_password")
	WebElement ele2;
	@FindBy(id="submitButton")
	WebElement ele3;
	
	@Test
	public void test1() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		ProgramWithPOM p=PageFactory.initElements(driver,ProgramWithPOM.class);
		p.ele1.sendKeys("admin");
		p.ele2.sendKeys("admin");
		driver.navigate().refresh();
		p.ele1.sendKeys("admin");
		p.ele2.sendKeys("admin");
		p.ele3.click();
	
	}

}
