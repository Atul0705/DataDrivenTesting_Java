package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	// Locators
	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By loginButton = By.id("submit");
	By errorMessage = By.id("error");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}

	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}
}
