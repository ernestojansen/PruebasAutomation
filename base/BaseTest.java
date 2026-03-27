package POMpractice.base;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

	protected WebDriver driver;
	
	@Before
	public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("autofill.profile_enabled", false);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		
		options.setExperimentalOption("prefs", prefs);
		
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	//	driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
	}
	
	

	@After
	public void tearDown() {
		driver.quit(); 
	} 
}
