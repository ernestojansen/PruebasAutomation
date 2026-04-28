package POMpractice.tests;

import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.RegisterPage;
import POMpractice.utils.DataGenerator;

public class RegisterTest extends BaseTest {

@Test
public void registerNewUser() {
	
	RegisterPage registerPage = new RegisterPage(driver);
	
	registerPage.goToRegisterPage();
	
	String nameGenerated = DataGenerator.generateName();
	String emailGenerated = DataGenerator.generateEmail();
	
	registerPage.registerUser(nameGenerated, emailGenerated);
	
	}
}
