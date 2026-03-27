package primer.ejemplo;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MercuryTours_AutomatedTest {
	
	private WebDriver driver;
	By registerLinkLocator = By.linkText("REGISTER");
	By homeLinkLocator = By.linkText("Home");
	By registerPageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img");
	
	By userNameLocator = By.id("email");
	By passwordLocator = By.name("password");
	By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
	By registerBtnLocator = By.name("submit");
	
	By userLocator = By.name("userName");
	By passLocator = By.name("password");
	By signInBtnLocator = By.name("submit");
	By homePageLocator = By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[1]/font/b");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test 
	public void registerUser() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(5000);
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(userNameLocator).sendKeys("Ernesto");
			driver.findElement(passwordLocator).sendKeys("password");
			driver.findElement(confirmPasswordLocator).sendKeys("password");
			
			driver.findElement(registerBtnLocator).click();
		}
		else {
		System.out.print("Register page was not found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is Ernesto.", fonts.get(5).getText());
			
	}
	
	@Test
	public void signIn() throws InterruptedException {
		driver.findElement(homeLinkLocator).click();
		Thread.sleep(10000);
	if(driver.findElement(userLocator).isDisplayed()) {
		driver.findElement(userLocator).sendKeys("Ernesto");
		driver.findElement(passLocator).sendKeys("password");
		driver.findElement(signInBtnLocator).click();
		Thread.sleep(10000);
List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Thank you for Loggin.", fonts.get(3).getText());
			
		//assertTrue(driver.findElement(homePageLocator).isDisplayed());
	}
	else {
		System.out.print("username textbox was not present");
	}

	}
	
	@Test
	public void failedSignIn() {
	    driver.findElement(homeLinkLocator).click();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(userLocator));

	    driver.findElement(userLocator).sendKeys("thisisatest");
	    driver.findElement(passLocator).sendKeys("wrongpassword");
	    driver.findElement(signInBtnLocator).click();

	    // Esperar a que aparezca el mensaje de error
	    By errorMessageLocator = By.xpath("//span[contains(text(),'Enter your userName and password')]");
	    WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));

	    // Comparar el mensaje mostrado con el esperado
	    String actualMessage = message.getText();
	    String expectedMessage = "Enter your userName and password correct";
	    assertEquals(expectedMessage, actualMessage);
			
	}
	
}


