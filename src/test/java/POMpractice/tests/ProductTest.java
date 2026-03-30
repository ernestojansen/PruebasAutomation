package POMpractice.tests;

import org.junit.Assert;
import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.ProductsPage;

public class ProductTest extends BaseTest {
	
	@Test
	public void searchForProducts() {
		ProductsPage productsPage = new ProductsPage(driver);
		
		productsPage.goToProductsPage();
		productsPage.searchProduct("Stylish Dress");
		productsPage.scrollToProduct();
		
		Assert.assertTrue(productsPage.isProductDisplayed());

	}
	
	@Test
	public void viewProduct() {
		ProductsPage productsPage = new ProductsPage(driver);
		
		productsPage.goToProductsPage();
		productsPage.searchProduct("Stylish Dress");
		productsPage.scrollToProduct();
		productsPage.clickViewProductButton();
		
		Assert.assertTrue(productsPage.getProductName().contains("Stylish"));
		
	}
}
