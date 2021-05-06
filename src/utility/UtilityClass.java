package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	static WebDriver driver;
	static FileInputStream file;
	public static void captureScreenshot(WebDriver driver, int Tid) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\yogesh\\eclipse-workspace\\Cybage\\Screenshots\\"+Tid+"Home.jpeg");
		FileHandler.copy(source, Dest);
	}
	
	public static String TestData(int row, int cell) throws EncryptedDocumentException, IOException
	{
		file = new FileInputStream("C:\\Users\\yogesh\\eclipse-workspace\\Cybage\\Test Data\\Cybage.xlsx");
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
		
	}
}
