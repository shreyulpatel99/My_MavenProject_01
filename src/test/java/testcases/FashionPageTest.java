package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
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
	static final Logger logger = Logger.getLogger(LoginPageTest.class);

	public FashionPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException { 
		logger.info("initialization is in process");
		
		initialization();
		 loginPage = new Login_Page();
		 fashionPage = new Fashion_Page();
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 fashionPage =  homePage.clickOnFashionLink();
	}
	
	
	@Test (priority = 1)
	public void verifyFashionPageTitleTest () {
		logger.info("Starting test case");
		Assert.assertEquals(fashionPage.verifyFashionTitle(), "Fashion products for sale | eBay");
		logger.info("Ending test case");

	}
	
	@Test (priority = 2)
	public void verifyFashionCategoriesListTest () {
		logger.info("Starting test case");
		fashionPage.verifyCategories(); 
		logger.info("Ending test case");

	}
	

	@AfterMethod 
	public void tearDown(){
		driver.quit(); 
	}

}
