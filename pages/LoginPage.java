package POMpractice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	String url = "https://www.automationexercise.com/login";
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToLoginPage() {
		driver.get(url);
	}
	
	By email = By.name("email");
	By password = By.name("password");
	By loginButton = By.cssSelector("button[data-qa='login-button']");
	By errorMessage = By.xpath("//p[text()='Your email or password is incorrect!']");
	
	
	public void enterUsername(String user) {
		driver.findElement(email).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public String getErrorMessage() {
		WebDriverWait waitMessage = new WebDriverWait(driver, Duration.ofSeconds(25));
		
		WebElement error = waitMessage.until(
				ExpectedConditions.visibilityOfElementLocated(errorMessage));
		
		return error.getText();
	}
}

