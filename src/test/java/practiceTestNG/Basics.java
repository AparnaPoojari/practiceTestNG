//test commit
package practiceTestNG;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Basics {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


	}
	@Test(priority=0)
	public void ValidLogin() {
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[text()=' Login ']")).click();
		String afterLoginUrl = driver.getCurrentUrl();
		Assert.assertTrue(afterLoginUrl.contains("dashboard"));
		System.out.println("successful login");

	}
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}

}
