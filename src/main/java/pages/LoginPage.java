package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	By username_field = By.name("username");
	By paswrd_field =By.name("password");
	By LoginBtn= By.xpath("//*[text()=' Login ']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		}
	public void login(String user,String pass) {
		driver.findElement(username_field).sendKeys(user);
		driver.findElement(paswrd_field).sendKeys(pass);
		driver.findElement(LoginBtn).click();
	}

}
