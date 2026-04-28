package POMpractice.base;

import POMpractice.utils.ScreenshotUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
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
	
	// Watcher que detecta fallos
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
	@Rule
	public TestWatcher watcher = new TestWatcher() {
		
		@Override
		protected void failed(Throwable e, Description description) {
			if (driver != null) {
				ScreenshotUtils.takeScreenshot(driver, description.getMethodName());
			}
		}
		@Override
		protected void finished(Description description) {
			if (driver != null) {
				driver.quit();
			}
		}
	};

	/*@After
	public void tearDown() {
	   if (driver != null) {
		driver.quit(); 
    	}
	} */
}