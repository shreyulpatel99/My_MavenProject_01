package testcases;

import java.io.IOException;

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
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException { 
		initialization();
		 loginPage = new Login_Page();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() { 
		String title = loginPage.validateLoginPageTitle(); 
		Assert.assertEquals(title, "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}

	
	@Test (priority = 2)
	public void loginTest () throws IOException { 
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}

}
