package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Saved_Page extends TestBase {
	
	@FindBy (linkText = "eBay")
	WebElement eBay; 

	public Saved_Page() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void verifySavedPage (String element) {
		driver.findElement(By.xpath("//span[contains(text(),'"+element+"')]"));
	}
	
	public Home_Page backtoHomePage () throws IOException { 
	   eBay.click();
	   return new Home_Page(); 
	}
	
}
