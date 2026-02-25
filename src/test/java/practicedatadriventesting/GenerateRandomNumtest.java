package practicedatadriventesting;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenerateRandomNumtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Random random=new Random();
      int randomNumber= random.nextInt(1000);
      System.out.println(randomNumber);
      
      WebDriver driver=new ChromeDriver();
      
      FirefoxDriver driver2=(FirefoxDriver)driver;
	}

}
