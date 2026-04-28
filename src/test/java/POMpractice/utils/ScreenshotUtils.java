package POMpractice.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;

public class ScreenshotUtils {
	
	public static void takeScreenshot(WebDriver driver, String testName) {
		if (driver == null) {
		System.out.println("Driver is null");
		return;
		}
		
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dir = new File("screenshots");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File dest = new File(dir,testName + "_" + System.currentTimeMillis() + ".png");
			
			System.out.println("Saving screenshot to: " + dest.getAbsolutePath());
			
			Files.copy(src.toPath(), dest.toPath());
			
			System.out.println("Screenshot saved");
			
		} catch (Exception e) {
			System.out.println("Error taking screenshot");
			e.printStackTrace();
		}
	}

}
