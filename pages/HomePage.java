package POMpractice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	String url = "https://www.automationexercise.com/";
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToHomePage() {
		driver.get(url);
	}
	
	By addToCartButton = By.xpath("//a[@data-product-id='1']");
	By successMessage = By.xpath("//p[text()='Your product has been added to cart.']");
	By viewCartButton = By.xpath("//a[.//u[text()='View Cart']]");
	
	public void scrollToElement(By locator) {
		WebDriverWait waitHome = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement elementHome = waitHome.until(
				ExpectedConditions.visibilityOfElementLocated(locator)
				);
		
		JavascriptExecutor jsHome = (JavascriptExecutor) driver;
		jsHome.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementHome);
	}
	
	public void scrollToProduct() {
		scrollToElement(addToCartButton);
	}
	
	
	public void addProduct() {
		WebElement element = driver.findElement(addToCartButton);
		
		Actions actions = new Actions (driver);
		actions.moveToElement(element).perform();
		
		element.click();
		
	}
	
	public void clickViewCartButton() {
		driver.findElement(viewCartButton).click();
	
	}
	
	public String getMessage() {
		WebDriverWait waitMessage = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement message = waitMessage.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		return message.getText();
	}
}

