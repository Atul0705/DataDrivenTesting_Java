package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.LoginPage;
import utils.readXLdata;

import java.time.Duration;

public class testcase {
	WebDriver driver;
	LoginPage loginPage;
	Homepage homepage;
	@BeforeMethod
	public void setUp() {
		// Set up Chrome driver
		//System.setProperty("webdriver.chrome.driver", "C:\\Python310\\Scripts\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		loginPage = new LoginPage(driver);
		homepage = new Homepage(driver);
	}




	@Test(dataProviderClass = readXLdata.class,dataProvider = "loginData")
	public void LoginTest(String username, String password, String key) throws InterruptedException {
		loginPage.setUsername(username);
		Thread.sleep(1000);
		loginPage.setPassword(password);
		Thread.sleep(1000);
		loginPage.clickLoginButton();
		Thread.sleep(1000);
		if(key =="valid")
			homepage.verifylogin();


		else if(key == "inun" || key == "nun" || key == "npwd") {
			String msg = loginPage.getErrorMessage();
			System.out.println(msg);
		}
		else if(key == "inpw")
		{
			String msg = loginPage.getErrorMessage();
			System.out.println(msg);
		}

	}

	//	    @Test(priority=2,dataProvider = "loginData")
	//	    public void negativeUsernameTest(String username, String password, String key) {
	//	    	if( key == "inun"){
	//	        loginPage.setUsername(username);
	//	        loginPage.setPassword(password);
	//	        loginPage.clickLoginButton();
	//	        Assert.assertEquals("Your username is invalid!", loginPage.getErrorMessage()); 
	//	       }
	//	    }
	//
	//	    @Test(priority=3,dataProvider = "loginData")
	//	    public void negativePasswordTest(String username, String password, String key) {
	//	    	if(key == "inpw"){
	//	        loginPage.setUsername(username);
	//	        loginPage.setPassword(password);
	//	        loginPage.clickLoginButton();
	//	        Assert.assertEquals("Your password is invalid!", loginPage.getErrorMessage());
	//		}
	//	        
	//	    }

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


