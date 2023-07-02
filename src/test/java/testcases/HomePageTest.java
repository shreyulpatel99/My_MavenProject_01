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

public class HomePageTest extends TestBase {
	Login_Page loginPage; 
	Home_Page homePage; 
	Fashion_Page fashionPage;
	static final Logger logger = Logger.getLogger(LoginPageTest.class);
	
	
	public HomePageTest() throws IOException {
		super();
	}
	
	//test case should be separate -- independent with each other 
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser 
	
	
	@BeforeMethod
	public void setUp() throws IOException { 
		logger.info("initialization is in process");
		
		initialization();
		 loginPage = new Login_Page();
		 fashionPage = new Fashion_Page();
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 1)
	public void verifyHomePageTitleTest () { 
		logger.info("Starting test case");
		String homePageTitle = homePage.HomePageTitle(); 
		Assert.assertEquals(homePageTitle, "Electronics, Cars, Fashion, Collectibles & More | eBay","Home Page title do nto match");
		logger.info("Ending test case");

	}
	
	@Test (priority = 2)
	public void verifyCorrectuserNameTest () {
		logger.info("Starting test case");
		Assert.assertEquals(homePage.verifyuserName(), "Shreyul"); 
		logger.info("Ending test case");

	}
	
	@Test (priority = 3)
	public void SavedPageTest () throws IOException {
		logger.info("Starting test case");
		homePage.clickOnSavedLink(); 
		logger.info("Ending test case");

	}
	
	@Test (priority = 4)
	public void FashionPageTest () throws IOException {
		logger.info("Starting test case");
		homePage.clickOnFashionLink(); 
		Assert.assertEquals(fashionPage.verifyFashionTitle(), "Fashion products for sale | eBay");
		logger.info("Ending test case");

	}
	
	@Test (priority = 5)
	public void verifyProfileNameTest () {
		logger.info("Starting test case");
		homePage.verifyProfileName();
		logger.info("Ending test case");

	}
	
	
	@AfterMethod 
	public void tearDown() {
		driver.quit(); 
	}
	

}
