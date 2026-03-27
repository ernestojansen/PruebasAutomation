package primer.ejemplo;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	
	@Test
	public void testGooglePage() {
		
	WebElement searchbox = driver.findElement(By.name("q"));
	
	searchbox.clear();
	
	searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
	
	searchbox.submit();
	
	//Implicit Wait
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//Explicit Wait
	//WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(5));
	//ewait.until(ExpectedConditions.titleContains("Google Search"));
	
	System.out.println("Título actual: " + driver.getTitle());
	
	 assertTrue(driver.getTitle().toLowerCase().contains("quality-stream"));
	}
	

	@After
	public void tearDown() {
		
	driver.quit();	
	}
	}


