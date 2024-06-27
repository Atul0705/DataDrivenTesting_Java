package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Homepage {
	
	public WebDriver driver;
	
	String expected_msg = "Logged In Successfully | Practice Test Automation";
	
	//public By logout_button = By.xpath("//a[.='Log out']");
	
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifylogin()
	{
		String actual_msg = driver.getTitle();
		Assert.assertEquals(actual_msg,expected_msg);
	}
	

	}


