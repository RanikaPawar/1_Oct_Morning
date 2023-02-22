package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Broker_Insurance_Webpage
{

	@FindBy(xpath="//h4[text()='saradeg41@gmail.com']")private WebElement Signedinas;
	
	@FindBy(xpath="//input[@class='btn btn-danger']")private WebElement LogoutBtn;
	
	//2. initialize within a constructor with acess public by using PageFactory
	
	public Insurance_Broker_Insurance_Webpage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
	}
	//3. utilize within a method with acess level public
	public String getEmail() 
	{
		String ActualEmailAddress=Signedinas.getText();
		return ActualEmailAddress;
	}
	public void ClickLogoutBtn() 
	{
		LogoutBtn.click();
	}
}
