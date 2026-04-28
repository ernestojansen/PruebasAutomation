package POMpractice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage {
	
	WebDriver driver;
	
	public AccountCreatedPage (WebDriver driver) {
		this.driver = driver;
	}
	
	By accountCreatedMessage = By.cssSelector("h2[data-qa='account-created']");
	By continueButton = By.cssSelector("a[data-qa='continue-button']");
	
	public String getAccountCreatedText() {
		WebDriverWait waitAccount = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement messageAccount = waitAccount.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMessage));
		return messageAccount.getText();
	}
	
	public void clickContinue() {
		driver.findElement(continueButton).click();
		
	}
}
