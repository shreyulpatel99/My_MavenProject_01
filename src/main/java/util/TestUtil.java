package util;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class TestUtil extends TestBase{
	
	
	
	public TestUtil() throws IOException {
		
	}

	public static long PAGE_LOAD_TIMEOUT = 20; 
	public static long IMPLICIT_WAIT = 10; 

	public void hover(WebElement name)  { 
		Actions builder = new Actions(driver);
		builder.moveToElement(name).build().perform();
	}
	
	public void Selection (String value, WebElement webelementName, String inputValue) { 
		Select value1 = new Select(webelementName);
		value1.selectByValue(inputValue);
	}
	
}



