package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OutStationCab extends BasePage {
	
	public OutStationCab(WebDriver driver) {
		super(driver);
	}
	//public WebDriver driver;
	String str;
	
	@FindBy (xpath="//li[@class='menu_Cabs']")
	public WebElement cab_Button;
	
	@FindBy (xpath="(//input[@class='csw_inputField cswInputText'])[1]")
	public WebElement from_Button;
	
	@FindBy (xpath="(//p[@class='searchedResult font14 darkText'])")
	public List<WebElement> fromTabs;
	
	@FindBy (xpath="//*[text() = 'To']")
	public WebElement to_Button;
	
	@FindBy (xpath="//*[@placeholder = 'To']")
	public WebElement toSearchBar;
	
	@FindBy (xpath="//span[contains (text(), 'Manali, Himachal Pradesh, India')]")
	public WebElement toTabs;
	
	@FindBy(xpath="//div[@aria-label='Sat Mar 09 2024']")
	public WebElement cli_date;
	
	@FindBy(xpath="//div[@class='applyBtn']")
	public WebElement cli_time;
	
	@FindBy(xpath="//a[@data-cy='OutstationOneWayWidget_64']")
	public WebElement cli_search;
	
	@FindBy(xpath="//label[normalize-space()='SUV']")
	public WebElement cli_SUV;
	
	@FindBy(xpath="(//div[@class='makeFlex rowReverse alignEnd appendBottom5']//p)[1]")
	public WebElement get_price;
	
	public void sendKeys(WebElement elm, String str) 
	{
		elm.sendKeys(str);
	}
	public void getTextofList(List<WebElement> elm, String text) 
	{
		for (int i=0;i<=elm.size();i++) 
		{
			 str = elm.get(i).getText();
			 if(str.equals(text)) 
			 {
				 elm.get(i).click();;
				 break;
			 }
		}
	}
	
	public String getText(WebElement elm) 
	{
		return elm.getText();
	}
	public void click(WebElement elm) 
	{
		elm.click();
	}
}
