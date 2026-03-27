package POMpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	
WebDriver driver;
	
	String url = "https://www.automationexercise.com/login";
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToRegisterPage() {
		driver.get(url);
	}

	By signUpName = By.cssSelector("input[type='text']");
	By signUpEmail = By.cssSelector("input[data-qa='signup-email']");
	By signUpButton = By.cssSelector("button[data-qa='signup-button']");
	
	public void registerUser(String sName, String smailName) {
	
		driver.findElement(signUpName).sendKeys(sName);
		driver.findElement(signUpEmail).sendKeys(smailName);
		driver.findElement(signUpButton).click();
	}
	
}
