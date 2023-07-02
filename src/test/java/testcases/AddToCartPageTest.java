package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddToCart_Page;
import pages.Home_Page;
import pages.Login_Page;

public class AddToCartPageTest extends TestBase  {

	Login_Page loginPage; 
	Home_Page homePage; 
	AddToCart_Page atcPage; 
	static final Logger logger = Logger.getLogger(LoginPageTest.class);
	
	public AddToCartPageTest() throws IOException {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException { 
		logger.info("initialization is in process");
		
		initialization();
		 loginPage = new Login_Page();
		 atcPage = new AddToCart_Page(); 
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 
	}
	
	@Test (priority = 1)
	public void AddFirstItemToCart () { 
		logger.info("Starting test case");
		atcPage.SelectFirstItem();
		logger.info("Ending test case");

	
	}
	
	
	@Test (priority = 2)
	public void DeliveryPageTest () throws InterruptedException {
		logger.info("Starting test case");
		atcPage.SelectFirstItem();
		Thread.sleep(7000);
		atcPage.deliveryTab();
		logger.info("Ending test case");

	}
	
	
	@AfterMethod 
	public void tearDown() {
		driver.quit(); 
	}
	

}
