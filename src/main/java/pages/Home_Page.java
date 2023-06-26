package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import util.TestUtil;

public class Home_Page extends TestBase {
	
	TestUtil testUtil; 
	
	@FindBy (xpath = "//b[contains(text(),'Shreyul')]")
	WebElement userNameLabel; 
	
	@FindBy (xpath = "//div[@class='hl-cat-nav']/ul/li") 
	WebElement headerLinks; 
	
	@FindBy (xpath = "//li[@class='saved']")
	WebElement savedLink; 
	
	@FindBy (linkText = "Fashion")
	WebElement fashionLink; 
	
	@FindBy (id = "gh-ug")
	WebElement hoverLink; 
	
	@FindBy (id = "gh-un")
	WebElement profileName; 
	
	@FindBy (id = "gh-uid")
	WebElement userID; 

	public Home_Page() throws IOException {	
		testUtil = new TestUtil();
		PageFactory.initElements(driver, this);
	}
	
	public String HomePageTitle () {
		return driver.getTitle();
	}
	
	public String verifyuserName () { 
		return userNameLabel.getText(); 
	}
	
	public void verifyProfileName () { 
		testUtil.hover(hoverLink);
		System.out.println(profileName.getText());
		System.out.println(userID.getText());
	}
	
	public Saved_Page clickOnSavedLink () throws IOException { 
		savedLink.click();
		return new Saved_Page(); 
	}
	
	public Fashion_Page clickOnFashionLink () throws IOException { 
		fashionLink.click();
		return new Fashion_Page(); 
	}
	
	
	
	

}
