package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Home_Page;
import pages.Login_Page;

public class LoginPageTest extends TestBase{
	Login_Page loginPage; 
	Home_Page homePage; 
	 static final Logger logger = Logger.getLogger(LoginPageTest.class);
	
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException { 
		logger.info("initialization is in process");
		initialization();
		 loginPage = new Login_Page();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() { 
		logger.info("Starting test case");
		String title = loginPage.validateLoginPageTitle(); 
		Assert.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
		logger.info("Ending test case");
	}

	
	@Test (priority = 2)
	public void loginTest () throws IOException { 
		logger.info("Starting test case");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("Ending test case");

	}

	
	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

}
