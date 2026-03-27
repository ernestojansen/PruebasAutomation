package primer.ejemplo;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

	WebDriver driver;
	By contactLinkLocator = By.linkText("CONTACT");
	By backToHomeLocator = By.xpath("//img[@src='images/home.gif']");
	
	@Before
	public void setUp() throws Exception { 
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://demo.guru99.com/test/newtours/index.php"); 
		} 
	
	@Test 
	public void verifyLogo() {
	WebElement logo = driver.findElement(By.xpath("//img[@alt='Mercury Tours']"));
	
	if(logo.isDisplayed()) {
		System.out.println("Logo de Mercury Tours encontrado");
	}	else {
			System.out.println("Logo de Mercury Tours no encontrado");	
		}
	}
	
	@Test 
	public void verifiedMessage() throws InterruptedException { 
		driver.findElement(contactLinkLocator).click(); 
		Thread.sleep(5000); 
		driver.findElement(backToHomeLocator).click();
		WebElement featuredLogo = driver.findElement(By.xpath("//img[@alt='Featured Destination: Aruba']"));
		if (featuredLogo.isDisplayed()) {
            System.out.println("Logo de Featured Destination encontrado");
        } else {
            System.out.println("Logo de Featured Destination no encontrado");
	}
	}
	@After 
	public void tearDown() throws Exception { 
	if (driver != null) 
	{ driver.quit(); 
	} 
	}	
}
