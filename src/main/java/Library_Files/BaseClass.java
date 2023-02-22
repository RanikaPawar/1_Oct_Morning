package Library_Files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	
	
		public WebDriver driver;              //gobally declared
		public void InitializeBrowser() 
		{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ranika\\eclipse-workspace\\1_Oct_Maven\\Browser\\chromedriver.exe");
		
		 driver=new ChromeDriver();        //Upcasting
		
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		driver.manage().window().maximize();
		
		//wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		}

}
