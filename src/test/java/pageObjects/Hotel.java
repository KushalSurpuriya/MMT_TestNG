package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hotel extends BasePage{
	public Hotel(WebDriver driver) {
		super(driver);
	}

	WebDriver driver;
	
	@FindBy(xpath="(//a[@class='headerIcons makeFlex hrtlCenter column'])[2]")
	public WebElement cli_hotel;
	
//	@FindBy(xpath="(//a[@class='headerIcons makeFlex hrtlCenter column'])[1]")
//	public WebElement cli_hotel;
	
	@FindBy(xpath="//input[@id='guest']")
	public WebElement cli_guest;
	
	@FindBy(xpath="(//div[@class='gstSlct'])[2]")
	public WebElement cli_adults;
	
	@FindBy(xpath="//li[@data-cy='GuestSelect$$_323']")
	public List<WebElement> get_list;
	
	public void click(WebElement elm) 
	{
		elm.click();
	}
	
	public String getText(WebElement elm) 
	{
		return elm.getText();
	}
}
