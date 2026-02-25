package practice.basics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestForAutoHealing {
	
	
	
   
    
    @FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton1"),@FindBy(xpath="//input[@value='Login']")})
	private WebElement loginBtn;
	
	@Test
	public void test1() {
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		SampleTestForAutoHealing s= PageFactory.initElements(driver,SampleTestForAutoHealing.class);
		s.usernameEdt.sendKeys("admin");
		s.passwordEdt.sendKeys("admin");
		s.loginBtn.click();
	}

}
