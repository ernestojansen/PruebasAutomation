package POMpractice.tests;

import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.RegisterPage;

public class RegisterTest extends BaseTest {

@Test
public void registerNewUser() {
	
	RegisterPage registerPage = new RegisterPage(driver);
	
	registerPage.goToRegisterPage();
	
	registerPage.registerUser("Jhon","jduh@test.com");
	
	
		
	}
}
