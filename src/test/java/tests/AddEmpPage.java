package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AddEmpPage {
	WebDriver driver;
  
  @BeforeMethod
  public void setUp() {
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }
 
  public void login()  {
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("password")).sendKeys("admin123");

	  driver.findElement(By.xpath("//*[text()=' Login ']")).click();
  }
  @Test
  public void addEmpDetails()  {
	  login();
	  driver.findElement(By.xpath("(//*[text()='PIM'])[1]")).click();
	  String pimUrl=driver.getCurrentUrl();
	  System.out.println(pimUrl);
	  Assert.assertTrue(pimUrl.contains("pim"));
	  
	  driver.findElement(By.xpath(" //label[text()='Employee Name']/following::input[1]")).sendKeys("Aparna");
  }

  @AfterMethod
  public void tearDown()  {
	  driver.quit();
	  
  }

}
