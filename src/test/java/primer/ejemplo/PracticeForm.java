package primer.ejemplo;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeForm {

	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setUp() {
	    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://demoqa.com/automation-practice-form");
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	    @Test
		 public void registrationForm() {
	    	WebElement firstName = driver.findElement(By.id("firstName"));
	    	WebElement lastName = driver.findElement(By.id("lastName"));
	    	WebElement eMail = driver.findElement(By.id("userEmail"));
	    	WebElement radioButton = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
	    	WebElement mobileNumber = driver.findElement(By.id("userNumber"));
	    	// 1. Llenado campo de fecha
	    	WebElement dateInput = driver.findElement(By.id("dateOfBirthInput"));
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].value='31 Aug 1987';", dateInput);
	    	
	    	WebElement hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
	    	
	    	firstName.sendKeys("Ernesto");
	    	lastName.sendKeys("Jansen");
	    	eMail.sendKeys("ernestojansen@tester.com");
	    	radioButton.click();
	    	mobileNumber.sendKeys("1236547890");
	    	hobbiesCheckbox.click();
	    	
	    	
	    	
	    }
			
		   @After
		    public void tearDown() throws Exception {
		        if (driver != null) {
		            driver.quit();
		        }
		    }
		
	
	
}
