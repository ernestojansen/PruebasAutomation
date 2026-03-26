package POMpractice.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void loginWithValidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.goToLoginPage();
		loginPage.enterUsername("prueba111@gmail.com");
		loginPage.enterPassword("password1234");
		loginPage.clickLogin();
	}
	
	@Test
	public void loginWithInvalidCredentials() {
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.goToLoginPage();
		loginPage.enterUsername("tester002@gmail.com");
		loginPage.enterPassword("password1234");
		loginPage.clickLogin();
		
		assertEquals("Your email or password is incorrect!", loginPage.getErrorMessage());
	}

}
