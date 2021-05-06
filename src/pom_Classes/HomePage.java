package pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
	@FindBy(xpath = "(//a[text()='CAREERS'])[1]") private WebElement CareerLink;
	@FindBy(xpath = "//button[text()='No, thanks']") private WebElement declineCookies;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCareerLink()
	{
		boolean actResult = CareerLink.isDisplayed();
		return actResult;
	}
	
	public void clickCareerLink()
	{
		declineCookies.click();
		CareerLink.click();
	}
}
