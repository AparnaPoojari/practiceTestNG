package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	WebDriver driver;
	WebDriverWait wait;

	By pimEle=By.xpath("(//*[text()='PIM'])[1]");
	By empInfo =By.xpath("//*[text()='Employee Information']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	public Boolean clickPIMAndVerifyEmployeeInfo() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ FIX

		driver.findElement(pimEle).click();
		return driver.findElement(empInfo).isDisplayed();
		
	}

	
}
