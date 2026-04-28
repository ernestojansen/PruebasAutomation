package POMpractice.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.CartPage;

public class CartTest extends BaseTest {
	
	@Test
	public void checkCart() {
		CartPage cartPage = new CartPage(driver);
		
		cartPage.goToCartPage();
		
		String emptyMessage = cartPage.getCartEmptyMessage();
		
		assertEquals("Cart is empty!", emptyMessage);

	}

}
