package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestBase;
import util.TestUtil;

public class Login_Page extends TestBase {
	
	
	//Page Factory : 
	@FindBy(name= "userid") //path 
	WebElement username; //veriable name 
	
	@FindBy(name = "pass") 
	WebElement password; 	
	
	@FindBy (name ="sgnBt")
	WebElement signInButton;
	
	@FindBy (linkText = "Sign in")
	WebElement signInLink; 

	@FindBy (name ="signin-continue-btn")
	WebElement continueButton; 
	
	
	//Initializing the Page Objects: 
	public Login_Page() throws IOException {
		PageFactory.initElements(driver, this); //here this is pointing toward current class object. 
		//so in the above line driver will be used by all this findby that we have initialized
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Home_Page login (String un, String pw) throws IOException { 
		signInLink.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		username.sendKeys(un);
		continueButton.click(); 
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		password.sendKeys(pw); 
		signInButton.click();
		
		return new Home_Page(); 
	}
	
	

}
