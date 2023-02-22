package Library_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class UtilityClass
{
	//AutomationTE:@Ranika
	//Date://17/02/2023
	//Day:Friday
	//Title:Fetch data fromproperty file
	@Test
	public static String getDatafromPF(String key) throws IOException 
	{
		
		//to reach upto property file
		FileInputStream file=new FileInputStream("C:\\Users\\Ranika\\eclipse-workspace\\1_Oct_Maven\\PropFile.properties");
		
		//create object of property class
		Properties Prop=new Properties();
		
		//to open property file
		Prop.load(file);
		
		//to fetch data from proprty file
		String Value1=Prop.getProperty(key);
		
		return Value1;
	}
	    //AutomationTE:@Ranika
		//Date://17/02/2023
		//Day:Friday
		//Title:Fetch data EXCELSheet file
	@Test
	public static String  getdatafromExcelsheet(int RowIndex,int CellIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Ranika\\eclipse-workspace\\1_Oct_Maven\\TestData\\1_oct_morning (Autosaved).xlsx");
		
		Sheet Sh=WorkbookFactory.create(file).getSheet("Sheet9");
		
		String Value2 =Sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		return Value2;
	}
	
@Test
public static void CaptureScreenshot(WebDriver driver) throws IOException 
{
	File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	System.out.println(Source);
	
	File Destination=new File("C:\\Users\\Ranika\\eclipse-workspace\\1_Oct_Maven\\Screenshot.jpg");
	
	FileHandler.copy(Source,Destination);
	

}

}
