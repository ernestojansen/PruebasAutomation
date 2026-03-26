package POMpractice.tests;


import org.junit.Assert;
import org.junit.Test;

import POMpractice.base.BaseTest;
import POMpractice.pages.ContactUsPage;

public class ContactUsTest extends BaseTest{
	
	@Test
	public void endToEndContactUs() {
		ContactUsPage contactUsPage = new ContactUsPage(driver);
		
		contactUsPage.goToContactPage();
		contactUsPage.fillForm("Juan", "tester123@gmail.com", "Information", "This is a test");
		
		String filePath = "C:\\Test\\Test123.txt";
		contactUsPage.upLoadFile(filePath);
		
		contactUsPage.clickSubmit();
		
		String alertText = contactUsPage.getAlertText();
		
		Assert.assertEquals(alertText, "Press OK to proceed!");
		
		contactUsPage.acceptAlert();
		
		String successText = contactUsPage.getSuccessMessage();
		
		Assert.assertEquals(successText, "Success! Your details have been submitted successfully.");
	}

}
