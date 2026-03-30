package POMpractice.tests;


import static org.junit.Assert.*;

import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.HomePage;

public class HomeTest extends BaseTest{
	
	@Test
	public void selectProduct() {
		HomePage homePage = new HomePage(driver);
		
		homePage.goToHomePage();
		homePage.scrollToProduct();
		homePage.addProduct();
		
		String actualMessage = homePage.getMessage();
		
		assertEquals("Your product has been added to cart.", actualMessage);

	}
	
}
