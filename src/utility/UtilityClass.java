package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	static WebDriver driver;
	public static void captureScreenshot() throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\yogesh\\eclipse-workspace\\Cybage\\Screenshots\\home.png");
		FileHandler.copy(source, Dest);
		
	}
}
