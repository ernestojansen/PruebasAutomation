package POMpractice.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.AccountCreatedPage;
import POMpractice.pages.RegisterPage;
import POMpractice.pages.SignupFormPage;
import POMpractice.utils.DataGenerator;

public class SignUpFormTest extends BaseTest {
	
	@Test
	public void signUpFormNewUser() {
		
		//Generar datos dinámicos
		String nameSignUp = DataGenerator.generateName();
		String emailSignUp = DataGenerator.generateEmail();
		String passwordSingUp = DataGenerator.generatePassword();
		
		//Primera página (Register)
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.goToRegisterPage();
		registerPage.registerUser(nameSignUp,emailSignUp);
		
		//Segunda página (Sign Up Form)
		SignupFormPage signupPage = new SignupFormPage(driver);
		
		signupPage.selectCountry("United States");
		
		signupPage.signUpUser(passwordSingUp, nameSignUp, "Doe", "Billinghurst 1444", "Florida", "Miami", "1234", "1234567");
		
		//Tercera página (Account Created)
		
		AccountCreatedPage accountPage = new AccountCreatedPage(driver);
		
		assertEquals("ACCOUNT CREATED!",accountPage.getAccountCreatedText() );
		
		accountPage.clickContinue();
		
			
		}
	
}
