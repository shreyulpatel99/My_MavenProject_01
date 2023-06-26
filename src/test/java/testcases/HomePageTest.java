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

public class HomePageTest extends TestBase {
	Login_Page loginPage; 
	Home_Page homePage; 
	Fashion_Page fashionPage; 
	
	
	public HomePageTest() throws IOException {
		super();
	}
	
	//test case should be separate -- independent with each other 
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser 
	
	
	@BeforeMethod
	public void setUp() throws IOException { 
		initialization();
		 loginPage = new Login_Page();
		 fashionPage = new Fashion_Page();
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 1)
	public void verifyHomePageTitleTest () { 
		String homePageTitle = homePage.HomePageTitle(); 
		Assert.assertEquals(homePageTitle, "Electronics, Cars, Fashion, Collectibles & More | eBay","Home Page title do nto match");
	}
	
	@Test (priority = 2)
	public void verifyCorrectuserNameTest () {
		Assert.assertEquals(homePage.verifyuserName(), "Shreyul"); 
	}
	
	@Test (priority = 3)
	public void SavedPageTest () throws IOException {
		homePage.clickOnSavedLink(); 
	}
	
	@Test (priority = 4)
	public void FashionPageTest () throws IOException {
		homePage.clickOnFashionLink(); 
		Assert.assertEquals(fashionPage.verifyFashionTitle(), "Fashion products for sale | eBay");
	}
	
	@Test (priority = 5)
	public void verifyProfileNameTest () { 
		homePage.verifyProfileName();
	}
	
	
	@AfterMethod 
	public void tearDown() {
		driver.quit(); 
	}
	

}
