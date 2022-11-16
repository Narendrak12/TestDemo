package Org.demo.Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	
	   WebDriver driver;
	   
	   @BeforeClass
	   public void setupApplicatoin() throws InterruptedException {
		   
		   Reporter.log("---Browser session started---",true);
		   String Baseurl ="https://www.zoopla.co.uk/";
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions() ;
	         driver = new ChromeDriver(options);
	         driver.get(Baseurl);
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	         driver.manage().window().maximize();
	         Thread.sleep(1000);
		   
	   }
	   @AfterClass
	   public void closeapplication() {
		   driver.quit();
			Reporter.log("=====Browser Session End=====", true);
		   
	   }
}
