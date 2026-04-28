package POMpractice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
WebDriver driver;
	
	String url = "https://www.automationexercise.com/view_cart";
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToCartPage() {
		driver.get(url);
	}
	
	By cartMessage = By.cssSelector("#empty_cart > p > b");
	
	public String getCartEmptyMessage() {
		WebDriverWait waitCartMessage = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement cartEmptyMessage = waitCartMessage.until(ExpectedConditions.visibilityOfElementLocated(cartMessage));
		return cartEmptyMessage.getText();

}

}