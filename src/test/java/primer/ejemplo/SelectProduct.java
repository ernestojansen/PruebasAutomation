package primer.ejemplo;

import org.junit.Assert;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectProduct {
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	 @Test
	 public void signIn() {
	    WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
				
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		submitButton.click();
		
		WebElement product = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
		product.click();
		String textoEsperado = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
		String textoActual = driver.findElement(By.cssSelector("div[data-test='inventory-item-desc']")).getText();
		Assert.assertEquals("¡El texto no coincide!",textoEsperado, textoActual);
		System.out.println("Texto actual: " + textoActual);
		}
	 
	 @Test
	 public void addProductToCart() {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
					
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		submitButton.click();
		
		WebElement firstProduct = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
		firstProduct.click();
		WebElement secondProduct = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
		secondProduct.click();
		
		WebElement cartBadge = driver.findElement(By.xpath("//span[@data-test='shopping-cart-badge']"));
		String cartCount = cartBadge.getText();
		
		assertEquals("El carrito no muestra los productos seleccionados","2",cartCount);
			
	 }
	 @Test
	 public void dropDownTest() {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
					
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		submitButton.click();
		
		// Localizar el dropdown
		WebElement dropDownElement = driver.findElement(By.cssSelector("select[data-test='product-sort-container']"));
		dropDownElement.click();
		// Crear objeto Select
		Select selectItem = new Select(dropDownElement);
		// Seleccionar opción por el texto visible
		selectItem.selectByVisibleText("Price (low to high)");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement submit = wait.until(
		ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Sauce Labs Onesie']"))
		);
		submit.click();
		
		String currentURL = driver.getCurrentUrl();
		assertTrue("La URL no contiene 'inventory'", currentURL.contains("https://www.saucedemo.com/inventory-item.html?id=2"));
	 }
	
	 
	   @After
	    public void tearDown() throws Exception {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
	
}
