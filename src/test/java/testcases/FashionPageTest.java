package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Fashion_Page;
import pages.Home_Page;
import pages.Login_Page;

public class FashionPageTest extends TestBase {
	
	Login_Page loginPage; 
	Home_Page homePage; 
	Fashion_Page fashionPage;

	public FashionPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException { 
		initialization();
		 loginPage = new Login_Page();
		 fashionPage = new Fashion_Page();
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 fashionPage =  homePage.clickOnFashionLink();
	}
	
	
	@Test (priority = 1)
	public void verifyFashionPageTitleTest () {
		Assert.assertEquals(fashionPage.verifyFashionTitle(), "Fashion products for sale | eBay");
	}
	
	@Test (priority = 2)
	public void verifyFashionCategoriesListTest () {
		fashionPage.verifyCategories(); 
	}
	

	@AfterMethod 
	public void tearDown(){
		driver.quit(); 
	}

}
