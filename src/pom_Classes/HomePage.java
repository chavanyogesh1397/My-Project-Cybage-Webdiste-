package pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath = "(//a[text()='CAREERS'])[3]") private WebElement CareerLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyCareerLink()
	{
		boolean actResult = CareerLink.isDisplayed();
		return actResult;
	}
}
