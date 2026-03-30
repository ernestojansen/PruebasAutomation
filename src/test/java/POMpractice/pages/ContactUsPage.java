package POMpractice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactUsPage {
	
	WebDriver driver;
	WebDriverWait waitAlert;
	
    String url = "https://www.automationexercise.com/contact_us";
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		this.waitAlert = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void goToContactPage() {
		driver.get(url);
	}
		
		By nameForm = By.xpath("//input[@placeholder='Name']");
		By emailForm = By.xpath("//input[@placeholder='Email']");
		By subjectForm = By.xpath("//input[@placeholder='Subject']");
		By yourMessageForm = By.id("message");
		By chooseFileButton = By.xpath("//input[@name='upload_file']");
		By submitForm = By.xpath("//input[@value='Submit']");
		By submitSuccessfullyMessage = By.xpath("//div[@class='status alert alert-success']");
		
	public void fillForm (String nForm, String eForm, String sForm, String mForm) {
			
			driver.findElement(nameForm).sendKeys(nForm);
			driver.findElement(emailForm).sendKeys(eForm);
			driver.findElement(subjectForm).sendKeys(sForm);
			driver.findElement(yourMessageForm).sendKeys(mForm);	
			
		}
		
	public void clickSubmit() {
		driver.findElement(submitForm).click();	
	}
	
	public void upLoadFile(String filePath) {
		
		driver.findElement(chooseFileButton).sendKeys(filePath);
	}
		
	public String getAlertText() {
		waitAlert.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert().getText();
	}
	
	public void acceptAlert() {
		waitAlert.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();	
		
	}
	
	public void dismissAlert() {
		waitAlert.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}
	
	public String getSuccessMessage() {
		waitAlert.until(ExpectedConditions.visibilityOfElementLocated(submitSuccessfullyMessage));
		return driver.findElement(submitSuccessfullyMessage).getText();
	}

}
