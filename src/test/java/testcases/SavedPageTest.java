package testcases;


import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Home_Page;
import pages.Login_Page;
import pages.Saved_Page;

public class SavedPageTest extends TestBase {

	Login_Page loginPage; 
	Home_Page homePage;
	Saved_Page savedPage; 
	
	public SavedPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException { 
		initialization();
		 loginPage = new Login_Page();
		 savedPage = new Saved_Page(); 
		 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 savedPage = homePage.clickOnSavedLink();
	}
	
	@Test (priority = 1)
	public void verifySavedPageTest () { 
		savedPage.verifySavedPage("Search");
		savedPage.verifySavedPage("Members");
	}
	
	@Test (priority = 2)
	public void backToHomePageTest () throws IOException { 
		savedPage.backtoHomePage(); 
	}
	
	@AfterMethod 
	public void tearDown(){
		driver.quit(); 
	}
	
}
