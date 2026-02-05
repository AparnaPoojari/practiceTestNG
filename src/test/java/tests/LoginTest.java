package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	@BeforeMethod
	  public void beforeMethod() {
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  }
	WebDriver driver;
	@DataProvider(name="LoginData")
	public Object[][] login(){
		return new Object[][] {
			{"admin","admin123"},
			{"admin","wrong123"}
		};
	}
	
  @Test(dataProvider="LoginData")
  public void testLogin(String name,String pass) throws InterruptedException {
driver.findElement(By.name("username")).sendKeys(name);
driver.findElement(By.name("password")).sendKeys(pass);
Thread.sleep(3000);
driver.findElement(By.xpath("//*[text()=' Login ']")).click();
String currentUrl=driver.getCurrentUrl();
Assert.assertTrue(currentUrl.contains("dashboard"));
  }
  
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
