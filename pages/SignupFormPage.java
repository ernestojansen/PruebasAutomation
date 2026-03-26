package POMpractice.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupFormPage {

	WebDriver driver;
	
    String url = "https://www.automationexercise.com/signup";
	
	public SignupFormPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToSignupFormPage() {
		driver.get(url);
	}
	By formSignUpTitle = By.xpath("//b[text()='Enter Account Information']");
	By maleGender = By.id("id_gender1");
	By passField = By.id("password");
	By firstNameField = By.id("first_name");
	By lastNameField = By.id("last_name");
	By addressField = By.id("address1");
	By countryDropdown = By.id("country");
	By stateField = By.id("state");
	By cityField = By.id("city");
	By zipcodeField = By.id("zipcode");
	By mobileNumberField = By.id("mobile_number");
	By createAccountButton = By.cssSelector("button[data-qa='create-account']");
	
	
	public void signUpUser(String uPass, String fN, String lN, String uAddress, String stateName, String cityName, String zipCode, String mobileNumber) {
		
		driver.findElement(maleGender).click();
		
		driver.findElement(passField).sendKeys(uPass);
		driver.findElement(firstNameField).sendKeys(fN);
		driver.findElement(lastNameField).sendKeys(lN);
		driver.findElement(zipcodeField).sendKeys(zipCode);
		driver.findElement(mobileNumberField).sendKeys(mobileNumber);
		
	
		WebElement address = driver.findElement(addressField);
		scrollToElement(address);
		address.sendKeys(uAddress);
	
		WebElement state = driver.findElement(stateField);
		scrollToElement(state);
		state.sendKeys(stateName);
		
		WebElement city = driver.findElement(cityField);
		scrollToElement(city);
		city.sendKeys(cityName);
		
		WebElement zip = driver.findElement(zipcodeField);
		scrollToElement(zip);
		zip.sendKeys(zipCode);
	
		WebElement mobile = driver.findElement(mobileNumberField);
		scrollToElement(mobile);
		mobile.sendKeys(mobileNumber);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	WebElement createAccount = wait.until(
			ExpectedConditions.elementToBeClickable(createAccountButton));
	scrollToElement(createAccount);
	createAccount.click();
//		driver.findElement(createAccountButton).click();
	}
		
		public void selectCountry(String country) {
			WebElement dropdown = driver.findElement(countryDropdown);
			Select select = new Select (dropdown);
			select.selectByVisibleText(country);
		}
		
		public void scrollToElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);",element);
		}
		
		
}
	
