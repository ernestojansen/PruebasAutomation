package POMpractice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

WebDriver driver;
WebDriverWait wait;
	
    String url = "https://www.automationexercise.com/products";
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void goToProductsPage() {
		driver.get(url);
	}
	
	By searchBar = By.id("search_product");
	By submitSearch = By.id("submit_search");
	By nameOfSearchProduct = By.xpath("//div[@class='productinfo text-center']//p[contains(text(), 'Stylish')]");
	By viewProductButton = By.xpath("//a[contains(@href,'/product_details')]");
	By productName = By.xpath("//div[@class='product-information']/h2");
	
	public void searchProduct(String product) {
		driver.findElement(searchBar).sendKeys(product);
		driver.findElement(submitSearch).click();
	}
	
	public void scrollToSearch(By locator) {
		WebDriverWait waitProduct = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement elementSearch = waitProduct.until(
				ExpectedConditions.visibilityOfElementLocated(locator));
		
		JavascriptExecutor jsSearch = (JavascriptExecutor) driver;
		jsSearch.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementSearch);
	}
	
	public void scrollToProduct() {
		scrollToSearch(nameOfSearchProduct); 
	}
	
	public boolean isProductDisplayed() {
		return driver.findElement(nameOfSearchProduct).isDisplayed(); 
	}

	public void clickViewProductButton() {
		driver.findElement(viewProductButton).click();
	}
	
	public String getProductName() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();

}
	
}