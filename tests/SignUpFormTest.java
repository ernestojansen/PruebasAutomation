package POMpractice.tests;

import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.RegisterPage;
import POMpractice.pages.SignupFormPage;

public class SignUpFormTest extends BaseTest {
	
	@Test
	public void signUpFormNewUser() {
		//Primera página
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.goToRegisterPage();
		
		registerPage.registerUser("Jhony","jdioolye@test.com");
		
		//Segunda página
		SignupFormPage signupPage = new SignupFormPage(driver);
		
		
		signupPage.signUpUser("pass1234", "Jhony", "Doe", "Billinghurst 1444", "Florida", "Miami", "1234", "1234567");
		
		signupPage.selectCountry("United States");
		
		
			
		}
	
	

}
