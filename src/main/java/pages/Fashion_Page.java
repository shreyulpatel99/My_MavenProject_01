package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Fashion_Page extends TestBase {
	
	@FindBy (xpath = "//div[@class='b-visualnav__title']")
	List<WebElement> fashionCategories;
	
	public Fashion_Page() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyFashionTitle () { 
	System.out.println(driver.getTitle()+"----------");
	return driver.getTitle(); 
	
	}
	
	public void verifyCategories() {
		List<WebElement> fashionCategoriesList = fashionCategories;
		System.out.println(fashionCategoriesList.size());
		for (int i=0; i<fashionCategoriesList.size(); i++) {
			System.out.println(fashionCategoriesList.get(i).getText());	
		}
	}
}