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
	
	@Test
	public void numberOfProducts() {
		HomePage homePage = new HomePage(driver);
		
		homePage.goToHomePage();
		homePage.scrollToBrandOption();
		String actualNumber = homePage.getPoloCount();
		
		AssertEquals("(6)", actualNumber);
		
		


	}

	private void AssertEquals(String string, String actualNumber) {
		// TODO Auto-generated method stub
		
	}
	


}

