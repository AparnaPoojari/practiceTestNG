package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;


	public class LoginBaseTest extends BaseTest {

	    protected String username = "Admin";
	    protected String password = "admin123";

	    @BeforeMethod
	    public void prereqLogin() {
	        LoginPage lp = new LoginPage(driver);
	        lp.login(username, password);
	    }
	}
