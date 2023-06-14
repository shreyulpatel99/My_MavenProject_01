package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AddToCart_Page;
import pages.Home_Page;
import pages.Login_Page;

public class AddToCartPageTest extends TestBase  {

	Login_Page loginPage; 
	Home_Page homePage; 
	AddToCart_Page atcPage; 
	
	public AddToCartPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException { 
		initialization();
		 loginPage = new Login_Page();
		 atcPage = new AddToCart_Page(); 
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority = 1)
	public void AddFirstItemToCart () { 
		atcPage.SelectFirstItem();
	
	}
	
	
	@Test (priority = 2)
	public void DeliveryPageTest () throws InterruptedException {
		atcPage.SelectFirstItem();
		Thread.sleep(7000);
		atcPage.deliveryTab();
	}
	
	
	@AfterMethod 
	public void tearDown() {
		driver.quit(); 
	}
	

}
