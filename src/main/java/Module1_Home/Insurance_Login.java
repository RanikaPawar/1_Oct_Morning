package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Login 
{
//POM 1
	
	//1.Data memember/gobal variable should be drclared globally with acess level private by using @findBy annnotation
	
	 @FindBy(id="email") private WebElement Email;
	 
	@FindBy(xpath="//input[@id='password']")private WebElement Password;
	
	@FindBy(xpath="//input[@name='submit']")private WebElement Loginbtn;
	
	
	//2.initialize within a constructor with acess level public by using PageFactory
	
	public Insurance_Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//3. utilize within a method with acess level public
	public void EnterEmail( String EmailAddress) 
	{
		Email.sendKeys(EmailAddress);
	}
	public void EnterPassword(String Pass) 
	{
		Password.sendKeys(Pass);
	}
	public void ClickLoginBtn() 
	{
		Loginbtn.click();
	}
}
