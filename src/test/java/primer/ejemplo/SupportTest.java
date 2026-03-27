package primer.ejemplo; 
import static org.junit.Assert.assertEquals; 
import java.util.List; 
import org.junit.After; 
import org.junit.Before; 
import org.junit.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;


public class SupportTest { 
	private WebDriver driver; 
	By supportLinkLocator = By.linkText("SUPPORT"); 
	
	@Before 
	public void setUp() throws Exception { 
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://demo.guru99.com/test/newtours/index.php"); 
		} 
	@After 
	public void tearDown() throws Exception { 
		if (driver != null) 
		{ driver.quit(); 
		} 
		} 
	@Test 
	public void verifiedMessage() throws InterruptedException { 
		driver.findElement(supportLinkLocator).click(); 
		Thread.sleep(5000); 
		List<WebElement> fonts = driver.findElements(By.tagName("font")); 
		assertEquals("This section of our web site is currently under construction.  ", fonts.get(4).getText()); } 
	}