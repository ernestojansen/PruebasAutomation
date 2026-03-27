package primer.ejemplo;
import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginFail {

		WebDriver driver;
		
		
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void wrongCredentials() {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		userField.sendKeys("tester");
		passField.sendKeys("wrongpassword");
		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']"))
			);
	if(errorMessage.isDisplayed()) {
		System.out.println("Falló el Login");
		}
		
	}
	
	@Test
	public void onlyUsername() {
		WebElement userField = driver.findElement(By.xpath("//input[@data-test='username']"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		userField.sendKeys("tester");
		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']"))
			);
	if(errorMessage.isDisplayed()) {
		System.out.println("Falló el Login");
		}	
	}
	
	@Test
	public void onlyPassword() {
		WebElement passField = driver.findElement(By.id("password"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		passField.sendKeys("wrongpassword");
		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']"))
			);
	if(errorMessage.isDisplayed()) {
		System.out.println("Falló el Login");
		}
		
	}
	@After 
	public void tearDown() throws Exception { 
	if (driver != null) 
	{ driver.quit(); 
	} 
	}
}
