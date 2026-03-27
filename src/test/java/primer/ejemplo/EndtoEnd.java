package primer.ejemplo;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndtoEnd {

	WebDriver driver;
	WebDriverWait wait;
	
	
	@Before
	public void setUp() {
		    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.saucedemo.com/");
		    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // <-- AQUÍ SE INICIALIZA
	}

	@Test @Ignore
	public void loginSuccessful () {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
				
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement productImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-test='title']"))
		);
		if(productImage.isDisplayed()) {
		System.out.println("Login exitoso");
			}
		}
	
	@Test @Ignore
	public void selectProduct () {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		submitButton.click();
		
		WebElement product = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", product);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement selectProduct = wait.until(
		ExpectedConditions.elementToBeClickable(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"))
		);
		selectProduct.click();
		System.out.println("Producto agregado al carrito");
		
		}
	
	@Test @Ignore
	public void selectCart () {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		submitButton.click();
		
		WebElement product = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
		JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
		scrollDown.executeScript("arguments[0].scrollIntoView(true);", product);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement selectProduct = wait.until(
		ExpectedConditions.elementToBeClickable(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"))
		);
		selectProduct.click();
		
		WebElement cart = driver.findElement(By.id("shopping_cart_container"));
		JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
		scrollUp.executeScript("arguments[0].scrollIntoView(true);", cart);
		WebDriverWait waitCart = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cartButton = waitCart.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test='shopping-cart-link']")));
		cartButton.click();
		
		WebElement articleDescription = driver.findElement(By.xpath("//div[@data-test ='inventory-item-desc']"));
		
		if(articleDescription.isDisplayed()) {
			System.out.println("Descripción mostrada correctamente");
		}
	}
	
	@Test @Ignore
	public void checkoutButton () {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		submitButton.click();
		
		WebElement product = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
		JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
		scrollDown.executeScript("arguments[0].scrollIntoView(true);", product);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement selectProduct = wait.until(
		ExpectedConditions.elementToBeClickable(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"))
		);
		selectProduct.click();
		
		WebElement cart = driver.findElement(By.id("shopping_cart_container"));
		JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
		scrollUp.executeScript("arguments[0].scrollIntoView(true);", cart);
		WebDriverWait waitCart = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cartButton = waitCart.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test='shopping-cart-link']")));
		cartButton.click();
		
		WebElement checkButton = driver.findElement(By.id("checkout"));
		checkButton.click();
		
		}
		
	@Test
	/*    public void checkoutInfo () {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		userField.sendKeys("standard_user");
		passField.sendKeys("secret_sauce");
		submitButton.click();
		
		WebElement product = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
		JavascriptExecutor scrollDown = (JavascriptExecutor) driver;
		scrollDown.executeScript("arguments[0].scrollIntoView(true);", product);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement selectProduct = wait.until(
		ExpectedConditions.elementToBeClickable(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"))
		);
		selectProduct.click();
		
		WebElement cart = driver.findElement(By.id("shopping_cart_container"));
		JavascriptExecutor scrollUp = (JavascriptExecutor) driver;
		scrollUp.executeScript("arguments[0].scrollIntoView(true);", cart);
		WebDriverWait waitCart = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cartButton = waitCart.until(
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-test='shopping-cart-link']")));
		cartButton.click();
		
		//WebElement checkoutButton = driver.findElement(By.id("checkout"));
		WebElement check = waitCart.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
		check.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement lastName = driver.findElement(By.id("last-name"));
		WebElement postalCode = driver.findElement(By.id("postal-code"));
		firstName.sendKeys("Joe");
		lastName.sendKeys("Tester");
		postalCode.sendKeys("1234");
		
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();
		
		WebDriverWait waitCheck = new WebDriverWait(driver, Duration.ofSeconds(15));
		 WebElement header = waitCheck.until(
		 ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Overview']")));
		 String expectedHeader = "Checkout: Overview";
		 String actualHeader = header.getText();

		 assertEquals("El header no coincide", expectedHeader, actualHeader);
		 
		 WebElement finishButton = driver.findElement(By.id("finish"));
		 finishButton.click();
		 
		 WebDriverWait waitFinish = new WebDriverWait(driver, Duration.ofSeconds(15));
		 waitFinish.until(ExpectedConditions.textToBePresentInElementLocated(
		     By.xpath("//h2[text()='Thank you for your order!']"), 
		     "Thank you for your order!"
		 ));
		  }
	
	
	@After 
	public void tearDown() throws Exception { 
	if (driver != null) 
	{ driver.quit(); 
	} 
} 
}*/

	 public void checkoutFlow() {
        // Login
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement passField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));

        userField.sendKeys("visual_user");
        passField.sendKeys("secret_sauce");
        submitButton.click();

        // Seleccionar producto
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

        WebElement selectProduct = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-test.allthethings()-t-shirt-(red)")));
        selectProduct.click();

        // Ir al carrito
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("shopping_cart_container")));
        cart.click();

        // Click en checkout
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkoutButton.click();

        // Completar datos de checkout
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement postalCode = driver.findElement(By.id("postal-code"));

        firstName.sendKeys("Joe");
        lastName.sendKeys("Tester");
        postalCode.sendKeys("1234");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        // Validar que llegamos a Checkout: Overview
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[text()='Checkout: Overview']")));
        assertEquals("El header no coincide", "Checkout: Overview", header.getText());

        // Finalizar compra con espera
        WebElement finishButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
        finishButton.click();

        // Validar mensaje final de confirmación
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Thank you for your order!']")));
        assertEquals("El mensaje final no coincide", "Thank you for your order!", confirmationMessage.getText());
    }

    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
	