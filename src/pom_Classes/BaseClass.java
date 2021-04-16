package pom_Classes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass 
{
	public static WebDriver driver;
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Software Testing\\Selenium\\selenium\\Browser Drivers\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.cybage.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
	}
	
	public static void closeBrowser()
	{
		driver.close();
	}
}
