package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import util.TestUtil;

public class TestBase {
	
	
	public static WebDriver driver; 
	public static Properties prop;
	
	 
	public TestBase () throws IOException { 
		try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("D:\\QA\\SeleniumWorkSpace\\My_MavenProject_01\\src\\main\\java\\config\\config.properties");
            prop.load(ip);

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void initialization() { 
		String browserName = prop.getProperty("browser"); 
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\QA\\SeleniumJars\\geckodriver.exe");
			 driver = new FirefoxDriver();
			} else if (browserName.equals("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				System.setProperty("webdriver.chrome.driver", "D:\\QA\\SeleniumJars\\chromedriver.exe");
				 driver = new ChromeDriver(options);
			} else {
				driver = new SafariDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); 
		
		driver.get(prop.getProperty("url")); 
	}


	
	
}
