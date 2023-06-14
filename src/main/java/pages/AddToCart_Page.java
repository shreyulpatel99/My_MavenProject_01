package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import util.TestUtil;

public class AddToCart_Page extends TestBase {
	
	TestUtil testUtil;
	public static Properties data;

	@FindBy (className = "ux-call-to-action__cell" )
	WebElement AddToCartButton; 
	
	@FindBy (id = "state")
	WebElement states; 
	
	public AddToCart_Page() throws IOException {
		testUtil = new TestUtil();
		PageFactory.initElements(driver, this);
		try {
            data = new Properties();
            FileInputStream ip = new FileInputStream("D:\\QA\\SeleniumWorkSpace\\My_MavenProject_01\\src\\main\\java\\data\\deliveryData");
            data.load(ip);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
	}

	
	public void SelectFirstItem () { 
		driver.findElement(By.className("hl-item__displayPrice")).click();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		AddToCartButton.click();
	}
	
	
	public void deliveryTab () {
		driver.findElement(By.name("address1")).sendKeys(data.getProperty("address"));
		driver.findElement(By.name("city")).sendKeys(data.getProperty("city"));
		driver.findElement(By.name("phoneFlagComp1")).sendKeys(data.getProperty("phoneno"));
		driver.findElement(By.name("zip")).sendKeys(data.getProperty("zipcode"));
		testUtil.Selection("state", states, "ON");
		driver.findElement(By.id("sbtBtn")).click(); //go to checkout
		
	}

}
